package American8;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Paquet {

	protected LinkedList<Carte> cartes;

	/**
	 * Constructeur de la classe Paquet
	 * 
	 * @param cartes
	 *            la liste de Carte représentant le paquet de cartes.
	 */
	public Paquet(LinkedList<Carte> cartes) {
		this.cartes = cartes;
	}

	public Paquet() {
		this.cartes = new LinkedList<Carte>();
	}
	
	public static ArrayList<String> getDifferentesValeurs(int nbCartePaquet) {
		ArrayList<String> valeurs = new ArrayList<String>();
		switch (nbCartePaquet) {
		case 52:
			for (String valeur : Carte.VALEURS) {
				valeurs.add(valeur);
			}
		case 32 :
			for(int i=7;i<14;i++) {
				valeurs.add(Carte.VALEURS[i]);
			}
			
		case 54:
			for (String valeur : Carte.VALEURS) {
				valeurs.add(valeur);
			}
			valeurs.add("Joker");
		}
		return valeurs;
	}

	/**
	 * Méthode qui permet de vérifier si le paquet est vide
	 * 
	 * @return boolean true si la pioche est vide, false sinon.
	 */
	public boolean estVide() {
		return this.cartes.isEmpty();
	}

	public LinkedList<Carte> getCartes() {
		return this.cartes;
	}

	public void addCarte(Carte carte) {
		this.cartes.add(carte);
	}

	public String toString() {
		return this.cartes.toString();
	}

	// Fonction qui renvoie la carte sur le haut du paquet.
	public Carte getCarteDessus() {
		return this.cartes.getLast();
	}
}
