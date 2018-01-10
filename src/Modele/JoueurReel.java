package Modele;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import Controller.ControllerAmerican8;

public class JoueurReel extends Joueur {
	
	/**
	 * Constructeur de la classe Joueur
	 * @param nom Le nom du Joueur
	 * @param numero Le numéro du joueur dans l'ordre du jeu
	 * @param comptePoint Le compte des points du joueur
	 * @param main La main contenant les cartes du joueur
	 */
	public JoueurReel(String nom,int comptePoint, Main main) {
		super(nom,comptePoint,main);
	}
	
	public JoueurReel(String nom) {
		super(nom,0,new Main(new LinkedList<Carte>()));
	}
	
	/**
	 * Fonction qui permet au joueur de choisir la carte qu'il va jouer.
	 * @return La carte que le joueur réel aura décider de jouer
	 */
	public Carte choisirCarteAJouer(Variante v,Carte carte) {
		this.lancerJoueurReelJoueEvent();
		//Trouver un moyen de mettre en pause le modèle en attendant de récuperer la carte à jouer.
		boolean numCarteValide = false;
		int numCarte = -1;
		ArrayList<Carte> cartesJouables = this.getCartesJouables(v, carte);
		System.out.println("Voici votre main : ");
		System.out.println(this.main);
		System.out.println("La dernière carte posée sur le talon est : "+carte);
		
		System.out.println("Voici les cartes que vous pouvez jouer : ");
		for(int i=0;i<cartesJouables.size();i++) {
			System.out.print("Carte numéro "+(i+1)+" : ");
			System.out.println(cartesJouables.get(i));
		}
		System.out.println("Veuillez donner le numéro de la carte que vous souhaitez jouer :");
		Scanner reader = new Scanner(System.in);
		
		while (!numCarteValide) {
			try {
				numCarte = reader.nextInt()-1;
				while (!(numCarte < cartesJouables.size() && numCarte >= 0)) {
					System.out.println("Veuillez saisir un numero de carte valide : ");
					numCarte = reader.nextInt()-1;
				}
				numCarteValide = true;
			} catch (InputMismatchException e) {
				System.out.println("Vous devez choisir un NUMERO de carte : ");
				reader = new Scanner(System.in);
			}

		}		
		return cartesJouables.get(numCarte);
	}
	
	public void lancerJoueurReelJoueEvent() {
		this.setChanged();
		this.notifyObservers(new EventJoueurReelJoue(this));
	}
	
	public void initObserver(ControllerAmerican8 controller) {
		this.addObserver(controller);
	}
	
	
	/*
	public Carte choisirCarteAJouer(Variante v,Carte carte) {
		boolean numCarteValide = false;
		int numCarte = -1;
		ArrayList<Carte> cartesJouables = this.getCartesJouables(v, carte);
		System.out.println("Voici votre main : ");
		System.out.println(this.main);
		System.out.println("La dernière carte posée sur le talon est : "+carte);
		
		System.out.println("Voici les cartes que vous pouvez jouer : ");
		for(int i=0;i<cartesJouables.size();i++) {
			System.out.print("Carte numéro "+(i+1)+" : ");
			System.out.println(cartesJouables.get(i));
		}
		System.out.println("Veuillez donner le numéro de la carte que vous souhaitez jouer :");
		Scanner reader = new Scanner(System.in);
		
		while (!numCarteValide) {
			try {
				numCarte = reader.nextInt()-1;
				while (!(numCarte < cartesJouables.size() && numCarte >= 0)) {
					System.out.println("Veuillez saisir un numero de carte valide : ");
					numCarte = reader.nextInt()-1;
				}
				numCarteValide = true;
			} catch (InputMismatchException e) {
				System.out.println("Vous devez choisir un NUMERO de carte : ");
				reader = new Scanner(System.in);
			}

		}		
		return cartesJouables.get(numCarte);
	}
	*/
	
	public ArrayList<Carte> getCartesJouables(Variante v,Carte carte){
		ArrayList<Carte> cartesJouables = new ArrayList<Carte>();
		for(int i=0;i<this.getMain().getCartes().size();i++) {
			if(this.getMain().getCartes().get(i).getValeur()==carte.getValeur() || this.getMain().getCartes().get(i).getCouleur()==carte.getCouleur()) {
				cartesJouables.add(this.getMain().getCartes().get(i));
			}
		}
		for(Carte c : this.getMain().getCartes()) {
			for(String valeur : v.getCartesAEffet()) {
				if(c.getValeur()==valeur&&(!cartesJouables.contains(c))) {
					cartesJouables.add(c);
				}
			}
		}
		return cartesJouables;
	}

}
