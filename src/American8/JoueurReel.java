package American8;

import java.util.LinkedList;

public class JoueurReel extends Joueur {
	
	/**
	 * Constructeur de la classe Joueur
	 * @param nom Le nom du Joueur
	 * @param numero Le numéro du joueur dans l'ordre du jeu
	 * @param comptePoint Le compte des points du joueur
	 * @param main La main contenant les cartes du joueur
	 */
	public JoueurReel(String nom,int comptePoint, Main main) {
		super(nom,comptePoint,main);
	}
	
	public JoueurReel(String nom) {
		super(nom,0,new Main(new LinkedList<Carte>()));
	}
	
	/**
	 * Fonction qui permet au joueur de choisir la carte qu'il va jouer.
	 * @return La carte que le joueur réel aura décider de jouer
	 */
	public Carte choisirCarteAJouer(Variante v,Carte carte) {
		return null;
	}

}
