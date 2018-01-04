package Modele;

public class Carte {

	private String couleur;
	private String valeur;

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

}
