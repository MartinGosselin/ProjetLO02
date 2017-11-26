package American8;

public class PasseTour extends EffetCarte {
	
	/**
	 * Fonction qui applique l'effet PasseTour sur le jeu
	 * @param jeu l'instance du jeu en cour
	 * @param j le joueur qui joue la carte
	 */
	public int appliquerEffet(Jeu jeu,Joueur j) {
		return jeu.getJoueurs().indexOf(j)+1;
	}

}
