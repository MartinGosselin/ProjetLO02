package American8;
import java.util.LinkedList;

public abstract class Joueur {
	private final String nom;
	private int comptePoint;
	private Main main;

	/**
	 * Constructeur de la classe Joueur
	 * 
	 * @param nom
	 *            Le nom du Joueur
	 * @param numero
	 *            Le num�ro du joueur dans l'ordre du jeu
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


	public String toString() {
		return this.nom;
	}


	// fonction qui permet au joueur de r�cup�rer une carte dans sa main

	public void recupererCarte(Carte carte) {
		this.main.cartes.add(carte);
	}


	// peutJouerCarte(), v�rifie que le joueur poss�de au moins une carte qu'il peut 
	// poser sur la pioche (bonne couleur, bonne valeur ou carte sp�ciale.
	
public LinkedList<Carte> peutJouerCartes(Carte carte) {
	LinkedList<Carte> CartePossibleAJouer= new LinkedList<Carte>();
	for(int i=0; i<=this.main.cartes.size(); i++) {
		if(carte.getValeur()==this.main.cartes.get(i).getValeur())  {
			CartePossibleAJouer.add(this.main.cartes.get(i));
		}
		else if (carte.getCouleur()==this.main.cartes.get(i).getCouleur()) {
			CartePossibleAJouer.add(this.main.cartes.get(i));
		}	
		}
	if (CartePossibleAJouer==null) {
		System.out.println("Vous ne pouvez pas jouer");
	}
	else{
       System.out.println("Quelle carte voulez vous jouer?");
	}
	return CartePossibleAJouer;
	
}

	// poserCarte(), pose la carte choisie sur le talon et l'enl�ve de la main du
	// joueur.
	public void poserCarte(int numeroCarte) {
		Carte carte = this.main.cartes.get(numeroCarte);
		this.main.cartes.remove(carte);
	}

	/**
	 * Fonction qui permet de choisir une carte � jouer. Cette fonction sera
	 * impl�ment� en fonction des diff�rents types de joueurs
	 * 
	 * @return La carte � jouer
	 * @see JoueurReel, JoueurVirtuel
	 */
	public abstract Carte choisirCarteAJouer();

}
