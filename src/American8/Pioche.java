package American8;

import java.util.ArrayList;

public class Pioche extends Paquet {

	/**
	 * Constructeur de la classe Pioche
	 * @param cartes la liste de Carte représentant la pioche.
	 */
	public Pioche(ArrayList cartes) {
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
	 * Méthode qui permet de vérifier si la pioche vide
	 * @return boolean true si la pioche est vide, false sinon.
	 */
	public boolean estVide() {
		return this.cartes.isEmpty();
	}
}
