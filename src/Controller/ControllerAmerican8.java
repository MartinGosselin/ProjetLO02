package Controller;

import java.awt.Component;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Modele.Carte;
import Modele.EventChangerSens;
import Modele.EventPartieTermine;
import Modele.EventPasseTour;
import Modele.EventPiocher;
import Modele.EventPoserCarte;
import Modele.EventRejouer;
import Modele.Jeu;
import Modele.JoueurReel;
import Modele.JoueurVirtuel;
import Modele.Strategie;
import Modele.Variante;
import Vue.American8;

public class ControllerAmerican8 implements Observer, Runnable {

	public American8 vue;
	public Jeu jeu;
	public Thread thread;

	/*
	 * ImageIcon icon= new ImageIcon("AsCarreau.png"); //208-303 JLabel labelTest =
	 * new JLabel(icon);
	 */

	public ControllerAmerican8(American8 vue) {
		this.vue = vue;
		this.jeu = Jeu.getInstance();
		this.thread = new Thread(this);

		// Mise en fonctionnement du observer/observable
		this.jeu.initObserver(this);
		this.jeu.getJoueurReel().initObserver(this);
		// Remplissage de la liste des variantes dispo en fonction de
		// Variante.getAllVariantes();
		String[] variantesNames = Variante.getAllVariantesNames();
		JList<String> listVariantes = (JList<String>) this.vue.getComponentByName("listVariante");
		listVariantes.setListData(variantesNames);

		// Récupérer le nombre de bots souhaités.
		JButton boutonValiderJoueurs = (JButton) this.vue.getComponentByName("boutonValiderJoueurs");
		boutonValiderJoueurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JSpinner selectNbJoueur = (JSpinner) ControllerAmerican8.this.vue.getComponentByName("selectNbJoueurs");
				Box stratJoueursBox = (Box) ControllerAmerican8.this.vue.getComponentByName("stratJoueursBox");
				stratJoueursBox.removeAll();
				ControllerAmerican8.this.vue.setNbJoueursVirtuels((int) selectNbJoueur.getValue());
				for (int i = 0; i < ControllerAmerican8.this.vue.getNbJoueursVirtuels(); i++) {
					Box stratJoueur = Box.createHorizontalBox();
					stratJoueur.setName("boxJoueur" + (i + 1));
					Label labelJoueur = new Label("Joueur" + (i + 1));
					labelJoueur.setName("labelJoueur" + (i + 1));
					stratJoueur.add(labelJoueur);
					JSpinner spinnerJoueur = new JSpinner(new SpinnerListModel(Strategie.getStrategieNames()));
					spinnerJoueur.setName("spinnerStratJoueur" + (i + 1));
					stratJoueur.add(spinnerJoueur);
					stratJoueursBox.add(stratJoueur);
				}
				ControllerAmerican8.this.vue.refreshComponentMap();
				SwingUtilities.updateComponentTreeUI(ControllerAmerican8.this.vue.getFrame());
			}
		});

		JButton btnCommencerLaPartie = (JButton) this.vue.getComponentByName("btnCommencerLaPartie");
		btnCommencerLaPartie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTextField pseudoTextField = (JTextField) ControllerAmerican8.this.vue.getComponentByName("textPseudo");
				String pseudo = (String) pseudoTextField.getText();
				JList<String> listVariantes = (JList<String>) ControllerAmerican8.this.vue
						.getComponentByName("listVariante");
				String variante = (String) listVariantes.getSelectedValue();
				ArrayList<String> stratJoueurs = new ArrayList<String>();
				for (int i = 1; i <= ControllerAmerican8.this.vue.getNbJoueursVirtuels(); i++) {
					JSpinner spinner = (JSpinner) ControllerAmerican8.this.vue
							.getComponentByName("spinnerStratJoueur" + i);
					stratJoueurs.add((String) spinner.getValue());
				}

				ControllerAmerican8.this.initJeu(pseudo, stratJoueurs, variante);
				ControllerAmerican8.this.thread.start();
				// On bloque les boutons des paramètres.
				JButton btnCommencerLaPartie = (JButton) ControllerAmerican8.this.vue
						.getComponentByName("btnCommencerLaPartie");
				btnCommencerLaPartie.setEnabled(false);
				JButton boutonValiderJoueurs = (JButton) ControllerAmerican8.this.vue
						.getComponentByName("boutonValiderJoueurs");
				boutonValiderJoueurs.setEnabled(false);
				ControllerAmerican8.this.updateAffichageLabelNbCartes();

				JLabel labelPioche = (JLabel) ControllerAmerican8.this.vue.getComponentByName("labelPioche");
				ImageIcon dos = new ImageIcon("Dos.png");
				Image dosRescaled = dos.getImage().getScaledInstance(labelPioche.getWidth(), labelPioche.getHeight(),
						Image.SCALE_DEFAULT);
				ImageIcon imageIcon = new ImageIcon(dosRescaled);
				labelPioche.setIcon(imageIcon);

				ControllerAmerican8.this.updateAffichageTalon();
				ControllerAmerican8.this.updateAffichageCartesJoueurReel();

			}
		});
		// On instancie les affichages des nb de cartes des joueurs, du talon et de la
		// pioche et des cartes du joueur.
	}

	public void initJeu(String nomJoueur, ArrayList<String> strats, String varianteName) {
		// On initialise les composantes du modèle
		JoueurReel joueur = new JoueurReel(nomJoueur);
		ArrayList<JoueurVirtuel> joueursVirtuels = new ArrayList<JoueurVirtuel>();
		for (int i = 0; i < this.vue.getNbJoueursVirtuels(); i++) {
			joueursVirtuels.add(new JoueurVirtuel("Joueur" + (i + 1), Strategie.getStrategieByName(strats.get(i))));
		}
		Variante variante = Variante.getVarianteByName(varianteName);
		this.jeu.initJeu(joueur, joueursVirtuels, variante);
	}

	public void updateAffichageLabelNbCartes() {
		Box boxNbCartesJoueurs = (Box) this.vue.getComponentByName("boxJoueurs");
		boxNbCartesJoueurs.removeAll();
		for (int i = 0; i <= this.vue.getNbJoueursVirtuels(); i++) {
			Box boxJoueur = Box.createVerticalBox();
			boxJoueur.setBorder(new EmptyBorder(10, 10, 10, 10));
			boxJoueur.setName("boxJoueur" + (i + 1));
			boxNbCartesJoueurs.add(boxJoueur);
			JLabel labelNomJoueur = new JLabel(this.jeu.getNameJoueurByIndex(i));
			labelNomJoueur.setName("Joueur" + (1 + i));
			boxJoueur.add(labelNomJoueur);
			JLabel labelNbCarte = new JLabel("" + this.jeu.getNombreCartesJoueurByIndex(i) + " cartes");
			labelNbCarte.setName("NbCarteJoueur" + (i + 1));
			boxJoueur.add(labelNbCarte);
		}
		Panel panelJeu = (Panel) this.vue.getComponentByName("panelJeu");
		panelJeu.repaint();
	}

	public void updateAffichageTalon() {
		JLabel labelTalon = (JLabel) ControllerAmerican8.this.vue.getComponentByName("labelTalon");
		ImageIcon carte = ControllerAmerican8.this.jeu.getTalon().getCarteDessus().getImageIcon();
		Image carteRescaled = carte.getImage().getScaledInstance(labelTalon.getWidth(), labelTalon.getHeight(),
				Image.SCALE_DEFAULT);
		ImageIcon imageIcon = new ImageIcon(carteRescaled);
		labelTalon.setIcon(imageIcon);
	}

	public void updateAffichageCartesJoueurReel() {
		JList<String> listCartesJoueur = (JList<String>) this.vue.getComponentByName("listCartesJoueur");
		LinkedList<Carte> cartesJoueur = this.jeu.getJoueurReel().getMain().getCartes();
		String[] cartes = new String[cartesJoueur.size()];
		for (int i = 0; i < cartes.length; i++) {
			cartes[i] = cartesJoueur.get(i).getValeur() + " " + cartesJoueur.get(i).getCouleur();
		}
		listCartesJoueur.setListData(cartes);
	}

	public void updateAffichageLabelInfo(String message) {
		JLabel labelInfo = (JLabel) this.vue.getComponentByName("labelInfo");
		labelInfo.setText(message);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof EventPoserCarte) {
			EventPoserCarte poserCarte = (EventPoserCarte) arg1;
			this.updateAffichageTalon();
			if (poserCarte.joueur instanceof JoueurReel) {
				this.updateAffichageCartesJoueurReel();
			} else if (poserCarte.joueur instanceof JoueurVirtuel) {
				this.updateAffichageLabelNbCartes();
			}
		}

		if (arg1 instanceof EventChangerSens) {
			EventChangerSens changerSens = (EventChangerSens) arg1;
			this.updateAffichageLabelInfo("Le jeu change de sens !");
		}

		if (arg1 instanceof EventPasseTour) {
			EventPasseTour passeTour = (EventPasseTour) arg1;
			this.updateAffichageLabelInfo(passeTour.joueur + " fait passer le tour de " + passeTour.cible);
		}

		if (arg1 instanceof EventPasseTour) {
			EventPasseTour passeTour = (EventPasseTour) arg1;
			this.updateAffichageLabelInfo(passeTour.joueur + " fait passer le tour de " + passeTour.cible);
		}

		if (arg1 instanceof EventPiocher) {
			EventPiocher piocher = (EventPiocher) arg1;
			this.updateAffichageLabelInfo(piocher.joueur + " pioche " + piocher.nbCarte + " carte(s) !");
			this.updateAffichageLabelNbCartes();
			this.updateAffichageCartesJoueurReel();
		}

		if (arg1 instanceof EventPartieTermine) {
			// TODO
		}
		
		if(arg1 instanceof EventRejouer) {
			EventRejouer rejouer = (EventRejouer) arg1;
			this.updateAffichageLabelInfo(rejouer.joueur+" rejoue un tour !");
		}

		SwingUtilities.updateComponentTreeUI(ControllerAmerican8.this.vue.getFrame());
	}

	@Override
	public void run() {
		this.jeu.startJeu();
	}

}
