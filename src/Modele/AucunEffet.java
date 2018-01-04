package Modele;

public class AucunEffet extends EffetCarte {
	
	public int appliquerEffet(Jeu jeu,Joueur j) {
		return jeu.getJoueurs().indexOf(j);
	}

}
