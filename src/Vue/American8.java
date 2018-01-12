package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import java.awt.Container;

import javax.swing.SwingConstants;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import Controller.ControllerAmerican8;
import Modele.Carte;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;

public class American8 {

	private JFrame frame;
	public ControllerAmerican8 controller;
	private HashMap<String, Component> componentsMap;
	private int nbJoueursVirtuels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					American8 window = new American8();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int getNbJoueursVirtuels() {
		return this.nbJoueursVirtuels;
	}

	public void setNbJoueursVirtuels(int nbJoueursVirtuels) {
		this.nbJoueursVirtuels = nbJoueursVirtuels;
	}

	/**
	 * Create the application.
	 */
	public American8() {
		initialize();
		this.createComponentMap();
		this.controller = new ControllerAmerican8(this);
	}

	public JFrame getFrame() {
		return this.frame;
	}

	private void createComponentMap() {
		this.componentsMap = new HashMap<String, Component>();
		ArrayList<Component> components = American8.getAllComponents(this.frame);
		for (Component comp : components) {
			componentsMap.put(comp.getName(), comp);
		}
	}

	public Component getComponentByName(String name) {
		if (this.componentsMap.containsKey(name)) {
			return (Component) this.componentsMap.get(name);
		}
		return null;
	}

	public void refreshComponentMap() {
		ArrayList<Component> components = American8.getAllComponents(this.frame);
		for (Component comp : components) {
			if (!componentsMap.containsKey(comp.getName())) {
				componentsMap.put(comp.getName(), comp);
			}
		}
	}

	public static ArrayList<Component> getAllComponents(final Container c) {
		Component[] comps = c.getComponents();
		ArrayList<Component> compList = new ArrayList<Component>();
		for (Component comp : comps) {
			compList.add(comp);
			if (comp instanceof Container)
				compList.addAll(getAllComponents((Container) comp));
		}
		return compList;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setName("frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(2);
		splitPane.setName("splitPane");
		splitPane.setBounds(0, 0, 1140, 778);
		frame.getContentPane().add(splitPane);

		Panel panelParametre = new Panel();
		panelParametre.setName("panelParametre");
		splitPane.setLeftComponent(panelParametre);

		Box boxParametre = Box.createVerticalBox();
		boxParametre.setName("boxParametre");
		panelParametre.add(boxParametre);

		Box pseudoBox = Box.createHorizontalBox();
		pseudoBox.setName("pseudoBox");
		boxParametre.add(pseudoBox);

		JLabel labelPseudo = new JLabel("Pseudo");
		labelPseudo.setName("labelPseudo");
		pseudoBox.add(labelPseudo);

		JTextField textPseudo = new JFormattedTextField();
		textPseudo.setName("textPseudo");
		pseudoBox.add(textPseudo);

		Box varianteBox = Box.createVerticalBox();
		varianteBox.setName("varianteBox");
		boxParametre.add(varianteBox);

		JLabel labelVariante = new JLabel("Variante");
		labelVariante.setName("labelVariante");
		varianteBox.add(labelVariante);

		JList listVariante = new JList();
		listVariante.setName("listVariante");
		listVariante.setFixedCellWidth(75);
		varianteBox.add(listVariante);

		Box nbJoueurBox = Box.createVerticalBox();
		nbJoueurBox.setName("nbJoueurBox");
		boxParametre.add(nbJoueurBox);

		JLabel labelNbJoueur = new JLabel("Nombre de joueurs");
		labelNbJoueur.setName("labelNbJoueur");
		nbJoueurBox.add(labelNbJoueur);

		SpinnerNumberModel modeleNbJoueurs = new SpinnerNumberModel(1, 1, 5, 1);
		JSpinner selectNbJoueurs = new JSpinner(modeleNbJoueurs);
		selectNbJoueurs.setName("selectNbJoueurs");
		nbJoueurBox.add(selectNbJoueurs);

		JButton boutonValiderJoueurs = new JButton("Valider le nombre de joueurs");
		boutonValiderJoueurs.setName("boutonValiderJoueurs");
		nbJoueurBox.add(boutonValiderJoueurs);

		Box stratJoueursBox = Box.createVerticalBox();
		stratJoueursBox.setName("stratJoueursBox");
		boxParametre.add(stratJoueursBox);

		JButton btnCommencerLaPartie = new JButton("Commencer la partie");
		btnCommencerLaPartie.setName("btnCommencerLaPartie");
		boxParametre.add(btnCommencerLaPartie);

		Panel panelJeu = new Panel();
		panelJeu.setName("panelJeu");
		splitPane.setRightComponent(panelJeu);
		panelJeu.setLayout(null);

		Box boxJeu = Box.createVerticalBox();
		boxJeu.setBounds(46, 18, 489, 54);
		boxJeu.setName("boxJeu");
		panelJeu.add(boxJeu);

		Box boxJoueurs = Box.createHorizontalBox();
		boxJoueurs.setName("boxJoueurs");
		boxJeu.add(boxJoueurs);
		
		JEditorPane infoPane = new JEditorPane();
		infoPane.setBounds(616, 18, 296, 318);
		infoPane.setDocument(new PlainDocument());
		infoPane.setName("infoPane");
		panelJeu.add(infoPane);

		JPanel panel = new JPanel();
		panel.setBounds(46, 145, 529, 366);
		panelJeu.add(panel);
		panel.setLayout(null);

		JLabel labelPioche = new JLabel();
		labelPioche.setName("labelPioche");
		labelPioche.setBounds(48, 33, 196, 291);
		panel.add(labelPioche);

		JLabel labelTalon = new JLabel();
		labelTalon.setBounds(298, 33, 196, 291);
		panel.add(labelTalon);
		labelTalon.setName("labelTalon");

		Box boxCartesJoueur = Box.createHorizontalBox();
		boxCartesJoueur.setBounds(46, 594, 791, 123);
		boxCartesJoueur.setName("boxCartesJoueur");
		panelJeu.add(boxCartesJoueur);
		
		JList<Carte> listCartesJoueur = new JList<Carte>();
		listCartesJoueur.setCellRenderer(new CarteCellRenderer());
		listCartesJoueur.setName("listCartesJoueur");
		boxCartesJoueur.add(listCartesJoueur);
	}
}
