package Modele;

public class Rejouer extends EffetCarte {

	@Override
	public int appliquerEffet(Jeu jeu, Joueur j) {
		System.out.println(j +" rejoue !");
		return jeu.getJoueurs().indexOf(j)-1;
	}

}
