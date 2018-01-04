package Modele;

public class Ajoute2Cartes extends EffetCarte {

	public int appliquerEffet(Jeu jeu, Joueur j) {
		
		int indexCible = jeu.getJoueurs().indexOf(j) + 1;
		if(indexCible>=jeu.getJoueurs().size()) {
			indexCible = 0;
		}
		
		jeu.piocherCartes(j,jeu.getJoueurs().get(indexCible),2);
		
		
		return jeu.getJoueurs().indexOf(j);
	}

}
