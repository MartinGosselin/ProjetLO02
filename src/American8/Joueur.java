package American8;

import java.util.LinkedList;

public abstract class Joueur {
	private final String nom;
	private int comptePoint;
	protected Main main;
	private String handicapCouleur;

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
		this.handicapCouleur = null;
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
	
	public void appliquerHandicapCouleur(String couleur) {
		this.handicapCouleur = couleur;
	}


	public String toString() {
		return this.nom;
	}


	// fonction qui permet au joueur de récupérer une carte de la pioche.

	public void piocher(Pioche pioche) {
		this.main.getCartes().add(pioche.prendreCarte());
	}
	// peutJouerCarte(), vérifie que le joueur possède au moins une carte qu'il peut
	// poser sur la pioche (bonne couleur, bonne valeur ou carte spéciale.

	public boolean peutJouerCartes(Carte carte) {
		LinkedList<Carte> CartePossibleAJouer = new LinkedList<Carte>();
		for (int i = 0; i < this.main.cartes.size(); i++) {
			if (carte.getValeur() == this.main.cartes.get(i).getValeur()) {
				CartePossibleAJouer.add(this.main.cartes.get(i));
			} else if (carte.getCouleur() == this.main.cartes.get(i).getCouleur()) {
				CartePossibleAJouer.add(this.main.cartes.get(i));
			}
		}
		//Bonne initiative mais on doit pas mettre d'affichage dans les fonctions du moteur de jeu parceque sinon ça posera des problèmes pour l'interface graphique plus tard.
		return (CartePossibleAJouer.size()==0);

	}



	// jouerCarte(), pose la carte choisie sur le talon et l'enlève de la main du
	// joueur.
	public void jouerCarte(int numeroCarte) {
		Carte carte = this.main.cartes.get(numeroCarte);
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
