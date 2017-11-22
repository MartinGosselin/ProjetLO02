package American8;

import java.util.LinkedList;

public class MainTest {

	public static void main(String[] args) {
		try {
			//Test sur initPioche()
			Variante variante = new Variante(52,"test");
			Jeu jeu = Jeu.getInstance();
			jeu.setVariante(variante);
			jeu.initPioche();
			//System.out.println(jeu.getPioche());
			
			//test sur distribuerCartes()
			JoueurReel j1 = new JoueurReel("j1");
			JoueurReel j2 = new JoueurReel("j2"); 
			JoueurReel j3 = new JoueurReel("j3");
			LinkedList<Joueur> joueurs = new LinkedList<Joueur>();
			joueurs.add(j1);
			joueurs.add(j2);
			joueurs.add(j3);
			jeu.setJoueurs(joueurs);
			System.out.println(jeu.choisirDistribueur());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
