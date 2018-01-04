package Modele;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Strategie {
	
	public static Strategie[] strats = {new StrategiePassive(),new StrategieAggressive()};

	/**
	 * M�thode abstraite de la classe Strat�gie qui permettra suivant l'impl�mentation de fournir une carte � joueur en fonction de la strat�gie de jeu.
	 */
	public abstract Carte choisirCarteAJouer(Variante v,LinkedList<Carte> cartes, Carte carte);
	
	
	
	public abstract LinkedList<Carte> getCartesJouable(Variante v,LinkedList<Carte> cartes, Carte carte);
	
	

}
