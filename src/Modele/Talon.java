package Modele;

import java.util.LinkedList;

public class Talon extends Paquet {
	
	/**
	 * Constructeur de la classe Talon
	 * @param cartes la liste des cartes qui repr�sentent le talon du jeu.
	 */
	public Talon(LinkedList cartes) {
		super(cartes);
	}
	
	public Talon() {
		super();
	}
	
	/**
	 * Permet d'ajouter une carte au talon du jeu.
	 * @param carte la carte � ajouter au talon
	 */
	public void deposerCarte(Carte carte) {
		this.cartes.add(carte);
	}
	
	/**
	 * M�thode qui permet de vider le talon du jeu de toutes les cartes qu'il contient.
	 * @return ArrayList<Carte> la liste des cartes du talon qui pourront �tre ajouter � la pioche.
	 */
	public LinkedList<Carte> retournerTalon(){
		LinkedList<Carte> talon = this.cartes;
		this.cartes= new LinkedList<Carte>();
		return talon;
	}
}
