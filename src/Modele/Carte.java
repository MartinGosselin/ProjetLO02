package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Carte {

	private String couleur;
	private String valeur;
	private ImageIcon icon;

	public final static String[] VALEURS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Dame", "Valet", "Roi","As" };
	public final static String[] COULEURS = { "Pic", "Coeur", "Carreau", "Trefle" };
	public static final EffetCarte[] effetCarteExistant = { new PasseTour(), new Ajoute4Cartes(), new PasseTour(),
			new ChangerCouleur(), new Ajoute2Cartes(), new Rejouer() };

	/**
	 * Constructeur de la classe Carte
	 * 
	 * @param couleur
	 *            La couleur de la carte
	 * @param valeur
	 *            La valeur de la carte
	 */
	public Carte(String couleur, String valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
		this.icon = new ImageIcon(""+valeur+couleur+".png");
		
		
	}
	
	public ImageIcon getImageIcon() {
		return this.icon;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public String getValeur() {
		return this.valeur;
	}

	public String toString() {
		return "" + this.valeur + " " + this.couleur;
	}
	
	
	public void loadImage() throws IOException {
		String fileName = valeur+couleur+".png";
		//this.image = ImageIO.read(file);
	}

}
