package Modele;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Strategie {
	
	public static Strategie[] strats = {new StrategiePassive(),new StrategieAggressive()};

	/**
	 * Méthode abstraite de la classe Stratégie qui permettra suivant l'implémentation de fournir une carte à joueur en fonction de la stratégie de jeu.
	 */
	public abstract Carte choisirCarteAJouer(Variante v,LinkedList<Carte> cartes, Carte carte);
	
	
	
	public abstract LinkedList<Carte> getCartesJouable(Variante v,LinkedList<Carte> cartes, Carte carte);
	
	public static ArrayList<String> getStrategieNames(){
		ArrayList<String> names = new ArrayList<String>();
		names.add("Passive");
		names.add("Aggresive");
		return names;
	}
	
	public static Strategie getStrategieByName(String name) {
		Strategie strat =null;
		switch(name) {
		case "Passive" :
			strat = new StrategiePassive();
 		case "Aggresive" :
 			strat = new StrategieAggressive();
		}
		return strat;
	}
	
	

}
