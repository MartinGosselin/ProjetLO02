package American8;

import java.util.LinkedList;

public abstract class Paquet {
	
	protected LinkedList<Carte> cartes;
	
	/**
	 * Constructeur de la classe Paquet
	 * @param cartes la liste de Carte représentant le paquet de cartes.
	 */
	public Paquet(LinkedList<Carte> cartes) {
		this.cartes=cartes;
	}
	
	public String toString() {
		String ret ="";
		for(Carte carte:this.cartes) {
			ret+=carte.toString();
		}
		
		return ret;
	}

}
