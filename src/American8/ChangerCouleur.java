package American8;

public class ChangerCouleur extends EffetCarte {
	/**
	 * Applique un handicap sur la couleur à jouer pour le joueur suivant.
	 */
	public int appliquerEffet(Jeu jeu,Joueur j) {
		
		int index = jeu.getJoueurs().indexOf(j);
		/*
		jeu.getJoueurs().get(index+1).appliquerHandicapCouleur(couleur));
		*/
		return index;
	}

}
