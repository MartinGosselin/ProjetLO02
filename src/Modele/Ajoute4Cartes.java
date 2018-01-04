package Modele;

public class Ajoute4Cartes extends EffetCarte {
	
	public int appliquerEffet(Jeu jeu,Joueur j) {
		int indexCible = jeu.getJoueurs().indexOf(j) + 1;
		if(indexCible>=jeu.getJoueurs().size()) {
			indexCible = 0;
		}
		
		for (int i = 0; i < 4; i++) {
			jeu.getJoueurs().get(indexCible).piocher(jeu.getPioche());
		}
		System.out.println(j + " fait piocher 4 cartes au joueur suivant");
		return jeu.getJoueurs().indexOf(j);
	}

}
