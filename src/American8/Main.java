package American8;

import java.util.LinkedList;

public class Main extends Paquet {
	
	/**
	 * Constructeur de la classe Main
	 * @param cartes la liste de Carte représentant la main du joueur.
	 */
	public Main(LinkedList cartes) {
		super(cartes);
	}
	
	public LinkedList getCartes() {
		return this.cartes;
	}
}
