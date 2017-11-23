package American8;

import java.util.LinkedList;

public class Pioche extends Paquet {

	/**
	 * Constructeur de la classe Pioche
	 * @param cartes la liste de Carte représentant la pioche.
	 */
	public Pioche(LinkedList cartes) {
		super(cartes);
	}
	
	
	public Pioche() {
		super();
	}
	

	/**
	 * 
	 * @return
	 */
	public Carte prendreCarte() {
		Carte carte = this.cartes.get(this.cartes.size() - 1);
		this.cartes.remove(this.cartes.size() - 1);
		return carte;

	}
	
	
	
	
	
	
	// Fonction pour remplir la pioche.
	
	// Fonction qui renvoie la carte sur le haut du paquet.
}
