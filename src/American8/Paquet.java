package American8;

import java.util.LinkedList;

public abstract class Paquet {
	
	protected LinkedList<Carte> cartes;
	
	/**
	 * Constructeur de la classe Paquet
	 * @param cartes la liste de Carte repr�sentant le paquet de cartes.
	 */
	public Paquet(LinkedList<Carte> cartes) {
		this.cartes=cartes;
	}
	
	public Paquet() {
		this.cartes= new LinkedList<Carte>();
	}
	
	/**
	 * M�thode qui permet de v�rifier si le paquet est vide
	 * @return boolean true si la pioche est vide, false sinon.
	 */
	public boolean estVide() {
		return this.cartes.isEmpty();
	}
	
	
	public LinkedList<Carte> getCartes(){
		return this.cartes;
	}
	
	public String toString() {
		return this.cartes.toString();
	}

}
