package American8;

public abstract class Strategie implements StrategieJeu {

	/**
	 * Méthode abstraite de la classe Stratégie qui permettra suivant l'implémentation de fournir une carte à joueur en fonction de la stratégie de jeu.
	 */
	public abstract Carte choisirCarteAJouer();

}
