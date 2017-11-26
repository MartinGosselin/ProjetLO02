package American8;

public class Ajoute4Cartes extends EffetCarte {
	
	public int appliquerEffet(Jeu jeu,Joueur j) {
		for (int i = 0; i < 4; i++) {
			jeu.getJoueurs().get(jeu.getJoueurs().indexOf(j) + 1).piocher(jeu.getPioche());
		}
		return jeu.getJoueurs().indexOf(j);
	}

}
