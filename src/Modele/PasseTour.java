package Modele;

public class PasseTour extends EffetCarte {
	
	/**
	 * Fonction qui applique l'effet PasseTour sur le jeu
	 * @param jeu l'instance du jeu en cour
	 * @param j le joueur qui joue la carte
	 */
	public int appliquerEffet(Jeu jeu,Joueur j) {
		int indexProchainJoueur = jeu.getJoueurs().indexOf(j)+1;
		if(indexProchainJoueur>=jeu.getJoueurs().size()) {
			indexProchainJoueur = 0;
		}
		jeu.passeTour(j,jeu.getJoueurs().get(indexProchainJoueur));
		return indexProchainJoueur;
	}

}
