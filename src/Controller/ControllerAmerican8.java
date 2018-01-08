package Controller;

import java.awt.Component;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
	 * ImageIcon icon= new ImageIcon("AsCarreau.png");
			//208-303
			JLabel labelTest = new JLabel(icon);
	 */

	public ControllerAmerican8(American8 vue) {
		this.vue = vue;
		this.jeu = Jeu.getInstance();
		this.thread = new Thread(this);

		// Mise en fonctionnement du observer/observable
		this.jeu.initObserver(this);
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
				JList<String> listVariantes = (JList<String>) ControllerAmerican8.this.vue.getComponentByName("listVariante");
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
				ControllerAmerican8.this.affichageLabelNbCartes();
				
				JLabel labelPioche = (JLabel) ControllerAmerican8.this.vue.getComponentByName("labelPioche");
				ImageIcon dos = new ImageIcon("Dos.png");
				labelPioche.setIcon(dos);
				
				JLabel labelTalon = (JLabel) ControllerAmerican8.this.vue.getComponentByName("labelTalon");
				ImageIcon carte = ControllerAmerican8.this.jeu.getTalon().getCarteDessus().getImageIcon();
				labelTalon.setIcon(carte);

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
			joueursVirtuels.add(new JoueurVirtuel("Joueur" + (i+1), Strategie.getStrategieByName(strats.get(i))));
		}
		Variante variante = Variante.getVarianteByName(varianteName);
		this.jeu.initJeu(joueur, joueursVirtuels, variante);
	}
	
	public void affichageLabelNbCartes() {
		Box boxNbCartesJoueurs = (Box) this.vue.getComponentByName("boxJoueurs");
		for(int i=0;i<=this.vue.getNbJoueursVirtuels();i++) {
			Box boxJoueur = Box.createVerticalBox();
			boxJoueur.setBorder(new EmptyBorder(10,10,10,10));
			boxJoueur.setName("boxJoueur"+(i+1));
			boxNbCartesJoueurs.add(boxJoueur);
			JLabel labelNomJoueur = new JLabel(this.jeu.getNameJoueurByIndex(i));
			labelNomJoueur.setName("Joueur"+(1+i));
			boxJoueur.add(labelNomJoueur);
			JLabel labelNbCarte = new JLabel(""+this.jeu.getNombreCartesJoueurByIndex(i)+" cartes");
			labelNbCarte.setName("NbCarteJoueur"+(i+1));
			boxJoueur.add(labelNbCarte);
			
			
			
		}
		Panel panelJeu = (Panel) this.vue.getComponentByName("panelJeu");
		panelJeu.repaint();
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("test");
		JLabel label = (JLabel) this.vue.getComponentByName("infoLabel");
		SwingUtilities.updateComponentTreeUI(ControllerAmerican8.this.vue.getFrame());
	}

	@Override
	public void run() {
		this.jeu.startJeu();
	}

}
