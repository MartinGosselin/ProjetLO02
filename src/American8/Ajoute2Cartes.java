package American8;

public class Ajoute2Cartes extends EffetCarte {

	public void appliquerEffet(Jeu jeu, Joueur j) {
		for (int i = 0; i < 2; i++) {
			jeu.getJoueurs().get(jeu.getJoueurs().indexOf(j) + 1).piocher(jeu.getPioche());
		}
	}

}