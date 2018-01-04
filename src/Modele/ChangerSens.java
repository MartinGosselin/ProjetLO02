package Modele;

public class ChangerSens extends EffetCarte {
	
	public int appliquerEffet(Jeu jeu,Joueur j) {
		jeu.inverserSensJeu(j);
		return jeu.getJoueurs().indexOf(j);
	}

}
