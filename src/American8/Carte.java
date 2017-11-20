package American8;

public class Carte {
	
	private String couleur;
	private int valeur;
	
	/**
	 * Constructeur de la classe Carte
	 * @param couleur La couleur de la carte
	 * @param valeur La valeur de la carte
	 */
	public Carte(String couleur, int valeur) {
		this.couleur=couleur;
		this.valeur=valeur;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public int getValeur() {
		return this.valeur;
	}
	
	
}
