package American8;

import java.util.ArrayList;

public abstract class Paquet {
	
	protected ArrayList<Carte> cartes;
	
	/**
	 * Constructeur de la classe Paquet
	 * @param cartes la liste de Carte représentant le paquet de cartes.
	 */
	public Paquet(ArrayList<Carte> cartes) {
		this.cartes=cartes;
	}

}
