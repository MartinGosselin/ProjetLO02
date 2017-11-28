package American8;

import java.util.HashMap;
import java.util.LinkedList;

public class MainTest {

	public static void main(String[] args) {
		try {
			
			HashMap<String,EffetCarte> effetsCartes = new HashMap<String,EffetCarte>();
			effetsCartes.put("2",new Ajoute2Cartes());
			effetsCartes.put("3",new AucunEffet());
			effetsCartes.put("4",new AucunEffet());
			effetsCartes.put("5",new AucunEffet());
			effetsCartes.put("6",new AucunEffet());
			effetsCartes.put("7",new AucunEffet());
			effetsCartes.put("8",new ChangerCouleur());
			effetsCartes.put("9",new AucunEffet());
			effetsCartes.put("10",new AucunEffet());
			effetsCartes.put("Valet",new PasseTour());
			effetsCartes.put("Dame",new AucunEffet());
			effetsCartes.put("Roi",new AucunEffet());
			effetsCartes.put("As",new ChangerSens());
			effetsCartes.put("Joker",new Ajoute4Cartes());
			
			Variante variante = new Variante(32,"test",effetsCartes);
			System.out.println(variante.getCartesAEffet());
			
			Jeu jeu = Jeu.getInstance();
			jeu.setVariante(variante);
			
			jeu.initPioche();
			
			//System.out.println(jeu.getPioche());
			JoueurReel j1 = new JoueurReel("j1");
			JoueurReel j2 = new JoueurReel("j2"); 
			JoueurReel j3 = new JoueurReel("j3");
			JoueurReel j4 = new JoueurReel("j4");
			JoueurReel j5 = new JoueurReel("j5");
			LinkedList<Joueur> joueurs = new LinkedList<Joueur>();
			joueurs.add(j1);
			joueurs.add(j2);
			joueurs.add(j3);
			joueurs.add(j4);
			joueurs.add(j5);
			
			jeu.setJoueurs(joueurs);
			jeu.distribuerCartes(jeu.choisirDistribueur(), 8);
			
			/*
			for(Joueur j:jeu.getJoueurs()) {
				System.out.println(j);
				System.out.println(j.getMain());
			}
			
			
			System.out.println(jeu.getJoueurs());
			System.out.println(jeu.inverserSensJeu(j2));
			System.out.println(jeu.getJoueurs());
			*/
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
