package Modele;

import java.util.LinkedList;

public class Main extends Paquet {
	
	/**
	 * Constructeur de la classe Main
	 * @param cartes la liste de Carte représentant la main du joueur.
	 */
	public Main(LinkedList<Carte> cartes) {
		super(cartes);
	}
	
	public LinkedList<Carte> getCartes() {
		return this.cartes;
	}
	
	
}
