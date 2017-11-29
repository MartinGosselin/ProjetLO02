package American8;

public class Rejouer extends EffetCarte {

	@Override
	public int appliquerEffet(Jeu jeu, Joueur j) {
		return jeu.getJoueurs().indexOf(j)-1;
	}

}
