package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Color;

public class American8 {

	private JFrame frame;

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

	/**
	 * Create the application.
	 */
	public American8() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 776, 553);
		frame.getContentPane().add(splitPane);
		
		Panel panelParametre = new Panel();
		splitPane.setLeftComponent(panelParametre);
		
		Box boxParametre = Box.createVerticalBox();
		panelParametre.add(boxParametre);
		
		JLabel labelPseudo = new JLabel("Pseudo");
		boxParametre.add(labelPseudo);
		
		JFormattedTextField textPseudo = new JFormattedTextField();
		boxParametre.add(textPseudo);
		
		JLabel labelVariante = new JLabel("Variante");
		boxParametre.add(labelVariante);
		
		
		String[] data = {"Variante1","Variante2","Variante3"};
		JList listVariante = new JList(data);
		boxParametre.add(listVariante);
		
		JLabel labelNbJoueur = new JLabel("Nombre de joueurs");
		boxParametre.add(labelNbJoueur);
		
		JFormattedTextField textNbJoueurs = new JFormattedTextField();
		boxParametre.add(textNbJoueurs);
		
		JButton boutonValiderJoueurs = new JButton("Valider le nombre de joueurs");
		boxParametre.add(boutonValiderJoueurs);
		
		Box boxStratJoueurs = Box.createVerticalBox();
		boxParametre.add(boxStratJoueurs);
		
		Box boxStratJ1 = Box.createHorizontalBox();
		boxStratJoueurs.add(boxStratJ1);
		
		JLabel labelJ1 = new JLabel("New label");
		boxStratJ1.add(labelJ1);
		
		JSpinner choixStratJ1 = new JSpinner();
		boxStratJ1.add(choixStratJ1);
		
		Box boxStratJ2 = Box.createHorizontalBox();
		boxStratJoueurs.add(boxStratJ2);
		
		JLabel labelJ2 = new JLabel("New label");
		boxStratJ2.add(labelJ2);
		
		JSpinner choixStratJ2 = new JSpinner();
		boxStratJ2.add(choixStratJ2);
		
		Box boxStratJ3 = Box.createHorizontalBox();
		boxStratJoueurs.add(boxStratJ3);
		
		JLabel labelJ3 = new JLabel("New label");
		boxStratJ3.add(labelJ3);
		
		JSpinner choixStratJ3 = new JSpinner();
		boxStratJ3.add(choixStratJ3);
		
		JButton btnCommencerLaPartie = new JButton("Commencer la partie");
		boxParametre.add(btnCommencerLaPartie);
		
		Panel panelJeu = new Panel();
		splitPane.setRightComponent(panelJeu);
		panelJeu.setLayout(null);
		
		Box boxJeu = Box.createVerticalBox();
		boxJeu.setBounds(46, 5, 475, 14);
		panelJeu.add(boxJeu);
		
		Box boxJoueurs = Box.createHorizontalBox();
		boxJeu.add(boxJoueurs);
		
		JLabel labelNBCarteJ1 = new JLabel("J1 2 Cartes");
		boxJoueurs.add(labelNBCarteJ1);
		
		JLabel labelNbCarteJ2 = new JLabel("J2 6 Cartes");
		boxJoueurs.add(labelNbCarteJ2);
		
		JLabel labelNbCarteJ3 = new JLabel("J3 4 Cartes");
		boxJoueurs.add(labelNbCarteJ3);
		
		Box boxTerrainJeu = Box.createHorizontalBox();
		boxTerrainJeu.setBounds(46, 30, 475, 325);
		panelJeu.add(boxTerrainJeu);
		
		Canvas canvasTerrainJeu = new Canvas();
		canvasTerrainJeu.setForeground(Color.GREEN);
		boxTerrainJeu.add(canvasTerrainJeu);
		
		Box boxCartesJoueur = Box.createHorizontalBox();
		boxCartesJoueur.setBounds(46, 444, 475, -54);
		panelJeu.add(boxCartesJoueur);
		
		Canvas canvasCartesJoueur = new Canvas();
		canvasCartesJoueur.setForeground(Color.GREEN);
		boxCartesJoueur.add(canvasCartesJoueur);
	}
}
