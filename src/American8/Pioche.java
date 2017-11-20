package American8;

import java.util.LinkedList;

public class Pioche extends Paquet {

	/**
	 * Constructeur de la classe Pioche
	 * @param cartes la liste de Carte repr�sentant la pioche.
	 */
	public Pioche(LinkedList cartes) {
		super(cartes);
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
	
	/**
	 * M�thode qui permet de v�rifier si la pioche vide
	 * @return boolean true si la pioche est vide, false sinon.
	 */
	public boolean estVide() {
		return this.cartes.isEmpty();
	}
	
	
	// Fonction pour remplir la pioche.
	
	// Fonction qui renvoie la carte sur le haut du paquet.
}
