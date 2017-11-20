package American8;

public class Carte {
	
	
	private String couleur;
	private int valeur;
	
	public static final int[] VALEURS = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	public final static String[] COULEURS = {"Pic", "Coeur", "Carreau", "Trefle"};
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
