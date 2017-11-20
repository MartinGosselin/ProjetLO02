package American8;

import java.util.ArrayList;

public class Main extends Paquet {
	
	/**
	 * Constructeur de la classe Main
	 * @param cartes la liste de Carte représentant la main du joueur.
	 */
	public Main(ArrayList cartes) {
		super(cartes);
	}
	
	public ArrayList getCartes() {
		return this.cartes;
	}
}
