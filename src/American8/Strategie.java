package American8;

public abstract class Strategie implements StrategieJeu {

	/**
	 * M�thode abstraite de la classe Strat�gie qui permettra suivant l'impl�mentation de fournir une carte � joueur en fonction de la strat�gie de jeu.
	 */
	public abstract Carte choisirCarteAJouer();

}
