package Modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

public abstract class Joueur extends Observable {
	private final String nom;
	private int comptePoint;
	protected Main main;

	/**
	 * Constructeur de la classe Joueur
	 * 
	 * @param nom
	 *            Le nom du Joueur
	 * @param numero
	 *            Le numéro du joueur dans l'ordre du jeu
	 * @param comptePoint
	 *            Le compte des points du joueur
	 * @param main
	 *            La main contenant les cartes du joueur
	 */
	public Joueur(String nom, int comptePoint, Main main) {
		this.nom = nom;
		this.comptePoint = comptePoint;
		this.main = main;
	}

	public String getNom() {
		return this.nom;
	}

	public int getComptePoint() {
		return this.comptePoint;
	}

	public Main getMain() {
		return this.main;
	}

	public void setComptePoint(int comptePoint) {
		this.comptePoint = comptePoint;
	}
	/*
	public void appliquerHandicapCouleur(String couleur) {
		this.handicapCouleur = couleur;
	}
*/

	public String toString() {
		return this.nom;
	}


	// fonction qui permet au joueur de récupérer une carte de la pioche.

	public boolean piocher(Pioche pioche) {
		if(!pioche.estVide()) {
			this.main.getCartes().add(pioche.prendreCarte());
			return true;
		}
		else {
			return false;
		}
		
		
	}
	// peutJouerCarte(), vérifie que le joueur possède au moins une carte qu'il peut
	// poser sur la pioche (bonne couleur, bonne valeur ou carte spéciale.

	public boolean peutJouerCartes(Carte carte, Variante v) {
		ArrayList<String> cartesAEffet = v.getCartesAEffet() ;
		boolean aCarteAEffet = false;
		for (Carte c : this.main.getCartes()) {
			if(cartesAEffet.contains(c.getValeur())) {
				aCarteAEffet = true;
			}
		}
		for (int i = 0; i < this.main.cartes.size(); i++) {
			if (carte.getValeur() == this.main.cartes.get(i).getValeur() || carte.getCouleur() == this.main.cartes.get(i).getCouleur()||aCarteAEffet) {
				return true;
			} 
		}
		return false;

	}


	// poserCarte(), pose la carte choisie sur le talon et l'enlève de la main du joueur.
	public void poserCarte(Carte carte, Talon talon) {
		this.main.cartes.remove(carte);
		talon.addCarte(carte);
	}

	/**
	 * Fonction qui permet de choisir une carte à jouer. Cette fonction sera
	 * implémenté en fonction des diffèrents types de joueurs
	 * 
	 * @return La carte à jouer
	 * @see JoueurReel, JoueurVirtuel
	 */
	public abstract Carte choisirCarteAJouer(Variante v,Carte carte);

}
