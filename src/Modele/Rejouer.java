package Modele;

public class Rejouer extends EffetCarte {

	@Override
	public int appliquerEffet(Jeu jeu, Joueur j) {
		jeu.rejouer(j);
		return jeu.getJoueurs().indexOf(j)-1;
	}

}
