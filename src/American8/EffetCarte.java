package American8;

public abstract class EffetCarte {

	/**
	 * Applique l'effet de la carte qui est joué
	 * @param jeu l'instance du jeu en cour
	 * @param j le joueur qui pause la carte
	 * @return l'index du prochain joueur qui va jouer
	 */
 public abstract int appliquerEffet(Jeu jeu, Joueur j);
}
