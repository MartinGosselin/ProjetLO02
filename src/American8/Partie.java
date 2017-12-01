package American8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Partie {

	public static void main(String[] args) {
		boolean numVarianteValide = false;
		boolean nombreJoueurValide = false;
		boolean strategieJoueurVirtuelValide = false;
		int numVariante = -1;
		int nombreJoueurVirtuel = -1;
		int numStrategieJoueurVirtuel = -1;
		Scanner reader = new Scanner(System.in);
		ArrayList<Variante> variantes = new ArrayList<Variante>();
		variantes.add(Variante.initVariante1());
		variantes.add(Variante.initVariante2());
		ArrayList<JoueurVirtuel> listeJoueurVirtuel = new ArrayList<JoueurVirtuel>();
		Jeu jeu = Jeu.getInstance();

		System.out.println("Veuillez choisir les paramètres de votre partie : ");
		//Initialisation des paramètres du joueur
		System.out.println("Quel est votre nom ? : ");
		String nomJoueur = reader.next();
		JoueurReel joueurReel = new JoueurReel(nomJoueur);

		// Choix de la variante
		System.out.println("Quelle variante souhaitez-vous utiliser (donner son numéro) : ");
		for (int i = 0; i < variantes.size(); i++) {
			System.out.println("Variante numéro " + (i + 1) + " : ");
			System.out.println(variantes.get(i).getDescription());
		}
		while (!numVarianteValide) {
			try {
				numVariante = reader.nextInt() - 1;
				while (!(numVariante < variantes.size()&& numVariante>=0)) {
					System.out.println("Veuillez saisir un numéro valide : ");
					numVariante = reader.nextInt() - 1;
				}
				numVarianteValide = true;
			} catch (InputMismatchException e) {
				System.out.println("Vous devez choisir un NUMERO : ");
				reader = new Scanner(System.in);
			}
		}
		jeu.setVariante(variantes.get(numVariante));

		// Choix et paramatrage des joueurs

		System.out.println("Contre combien de joueur(s) souhaitez vous jouer ? (Maximum 5) : ");
		while (!nombreJoueurValide) {
			try {
				nombreJoueurVirtuel = reader.nextInt();
				while (!(nombreJoueurVirtuel <= 5 && nombreJoueurVirtuel > 0)) {
					System.out.println("Veuillez saisir un nombre de joueur virtuel valide : ");
					nombreJoueurVirtuel = reader.nextInt();
				}
				nombreJoueurValide = true;
			} catch (InputMismatchException e) {
				System.out.println("Vous devez choisir un NOMBRE de joueur(s) (Maximum 5) : ");
				reader = new Scanner(System.in);
			}

		}
		listeJoueurVirtuel = Jeu.initJoueurVirtuel(nombreJoueurVirtuel);
		System.out.println("Vous devez maintenant assigner une stratégie disponible pour chaques joueurs virtuels : ");
		System.out.println("Les choix possibles sont : ");
		for(int i =0;i<Strategie.strats.length;i++) {
			System.out.print("Strategie numero "+(i+1)+" : ");
			System.out.println(Strategie.strats[i]);
		}
		for(JoueurVirtuel j : listeJoueurVirtuel) {
			while(!strategieJoueurVirtuelValide) {
				System.out.println("Quel stratégie voulez vous assigner à : (donner le numéro de la stratégie) ");
				System.out.println(j);
				try {
					numStrategieJoueurVirtuel = reader.nextInt()-1;
					while(!(numStrategieJoueurVirtuel <Strategie.strats.length && numStrategieJoueurVirtuel >=0)) {
						System.out.println("Veuillez saisir un numero de strategie valide : ");
						numStrategieJoueurVirtuel=reader.nextInt()-1;
					}
					j.setStrategie(Strategie.strats[numStrategieJoueurVirtuel]);
					strategieJoueurVirtuelValide = true;
				}
				catch(InputMismatchException e) {
					System.out.println("Vous devez choisir le NUMERO de la strategie que vous souhaitez attribuer : ");
					reader = new Scanner(System.in);
				}
			}
			strategieJoueurVirtuelValide=false;
		}
		
		LinkedList<Joueur> joueurs = new LinkedList<Joueur>();
		joueurs.add(joueurReel);
		joueurs.addAll(listeJoueurVirtuel);
		jeu.setJoueurs(joueurs);
		jeu.initPioche();
		jeu.initTalon();
		
		System.out.println(jeu.getTalon());
		
		Joueur distribueur = jeu.choisirDistribueur();
		System.out.println(distribueur+" distribue les cartes !");
		jeu.distribuerCartes(distribueur, 8);

		System.out.println("Voici votre main !");
		System.out.println(joueurReel.getMain());
		
		System.out.println("La partie va démarrer !");
		
		int indexGagnant = jeu.jouer(distribueur);
		
		System.out.println(jeu.getJoueurs().get(indexGagnant)+" remporte la partie !");
		
		//Cas à gérer
		//Lorsque le talon commence avec un joker
		
		

		reader.close();
	}
}
