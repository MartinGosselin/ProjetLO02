package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import java.awt.Container;

import javax.swing.SwingConstants;

import Controller.ControllerAmerican8;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.getContentPane().setLayout(null);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(2);
		splitPane.setName("splitPane");
		splitPane.setBounds(0, 0, 776, 501);
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
		varianteBox.add(listVariante);

		Box nbJoueurBox = Box.createVerticalBox();
		nbJoueurBox.setName("nbJoueurBox");
		boxParametre.add(nbJoueurBox);

		JLabel labelNbJoueur = new JLabel("Nombre de joueurs");
		labelNbJoueur.setName("labelNbJoueur");
		nbJoueurBox.add(labelNbJoueur);

		SpinnerNumberModel modeleNbJoueurs = new SpinnerNumberModel(1,1,5,1);
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
		boxJeu.setBounds(46, 5, 475, 43);
		boxJeu.setName("boxJeu");
		panelJeu.add(boxJeu);

		Box boxJoueurs = Box.createHorizontalBox();
		boxJoueurs.setName("boxJoueurs");
		boxJeu.add(boxJoueurs);

		Box boxTerrainJeu = Box.createHorizontalBox();
		boxTerrainJeu.setBounds(46, 59, 475, 296);
		boxTerrainJeu.setName("boxTerrainJeu");
		panelJeu.add(boxTerrainJeu);

		Canvas canvasTerrainJeu = new Canvas();
		canvasTerrainJeu.setName("canvasTerrainJeu");
		canvasTerrainJeu.setForeground(Color.GREEN);
		boxTerrainJeu.add(canvasTerrainJeu);

		Box boxCartesJoueur = Box.createHorizontalBox();
		boxCartesJoueur.setBounds(108, 444, 413, -54);
		boxCartesJoueur.setName("boxCartesJoueur");
		panelJeu.add(boxCartesJoueur);
		
		/*
		Canvas canvasCartesJoueur = new Canvas();
		canvasCartesJoueur.setName("canvasCartesJoueur");
		canvasCartesJoueur.setForeground(Color.GREEN);
		boxCartesJoueur.add(canvasCartesJoueur);
		*/
		JLabel infoLabel = new JLabel("Info");
		infoLabel.setName("infoLabel");
		boxCartesJoueur.add(infoLabel);
		
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
