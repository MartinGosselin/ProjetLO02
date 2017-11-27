package American8;

import java.util.LinkedList;

public abstract class Strategie {

	/**
	 * Méthode abstraite de la classe Stratégie qui permettra suivant l'implémentation de fournir une carte à joueur en fonction de la stratégie de jeu.
	 */
	public abstract Carte choisirCarteAJouer(LinkedList<Carte> cartes, Carte carte);
	
	
	
	public abstract LinkedList<Carte> getCartesJouable(LinkedList<Carte> cartes, Carte carte);

}
