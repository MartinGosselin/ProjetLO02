package American8;

import java.util.LinkedList;

public abstract class Strategie {

	/**
	 * M�thode abstraite de la classe Strat�gie qui permettra suivant l'impl�mentation de fournir une carte � joueur en fonction de la strat�gie de jeu.
	 */
	public abstract Carte choisirCarteAJouer(LinkedList<Carte> cartes, Carte carte);
	
	
	
	public abstract LinkedList<Carte> getCartesJouable(LinkedList<Carte> cartes, Carte carte);

}
