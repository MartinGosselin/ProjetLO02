package Modele;

public class ChangerSens extends EffetCarte {
	
	public int appliquerEffet(Jeu jeu,Joueur j) {
		jeu.inverserSensJeu(j);
		System.out.println("Et on change de sens !");
		return jeu.getJoueurs().indexOf(j);
	}

}
