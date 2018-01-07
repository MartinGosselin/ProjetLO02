package Modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

import Controller.ControllerAmerican8;

public class Jeu extends Observable{

	private static Jeu jeu;
	private Pioche pioche;
	private Talon talon;
	private LinkedList<Joueur> joueurs;
	private Variante variante;


	/**
	 * Constructeur de la classe Jeu
	 * 
	 * @param pioche
	 *            Pioche associée au jeu
	 * @param talon
	 *            Talon associé au jeu
	 * @param joueurs
	 *            Liste des joueurs associés au jeu.
	 */
	private Jeu(Pioche pioche, Talon talon, LinkedList<Joueur> joueurs) {
		this.pioche = pioche;
		this.talon = talon;
		this.joueurs = joueurs;
		this.variante = null;
	}

	/**
	 * Constructeur par défaut de la classe Jeu
	 */
	private Jeu() {
		this.pioche = new Pioche();
		this.talon = new Talon();
		this.joueurs = new LinkedList<Joueur>();
		this.variante = new Variante();
	}

	/**
	 * Méthode d'access au singleton Jeu.
	 * 
	 * @return l'instance du singleton Jeu
	 */
	public static Jeu getInstance() {
		if (Jeu.jeu == null) {
			Jeu.jeu = new Jeu();
		}
		return Jeu.jeu;
	}
	
	public String getNameJoueurByIndex(int i) {
		return this.joueurs.get(i).getNom();
	}
	
	public int getNombreCartesJoueurByIndex(int i) {
		return this.joueurs.get(i).getMain().getCartes().size();
	}

	public Pioche getPioche() {
		return this.pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	public void setTalon(Talon talon) {
		this.talon = talon;
	}

	public void setJoueurs(LinkedList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public void setVariante(Variante variante) {
		this.variante = variante;
	}

	public LinkedList<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public int getNbCartes() {
		return this.variante.getNbCartePaquet();
	}

	public Variante getVariante() {
		return this.variante;
	}
	
	public Talon getTalon() {
		return this.talon;
	}
	
	public void initObserver(ControllerAmerican8 controller) {
		this.addObserver(controller);
	}
	
	public void initJeu(JoueurReel joueur,ArrayList<JoueurVirtuel> virtuels,Variante variante) {
		this.variante=variante;
		this.joueurs.addAll(virtuels);
		this.joueurs.add(joueur);
		this.initPioche();
		this.initTalon();
		
	}
	
	public void startJeu() {
		Joueur distribueur = this.choisirDistribueur();
		this.distribuerCartes(distribueur,this.variante.getNbCartesMain());
		this.jouer(distribueur);
	}
	
	
	
	public void rejouer(Joueur j) {
		System.out.println(j+" rejoue !");
		this.lancerRejouerEvent(j);
	}
	
	public void piocherCartes(Joueur j,Joueur cible,int nbCartes) {
		for(int i=0;i<nbCartes;i++) {
			cible.piocher(this.pioche);
		}
		System.out.println(j + " fait piocher "+nbCartes+" cartes à "+cible);
		this.lancerPiocherEvent(cible,nbCartes);
	}

	/**
	 * méthode qui détermine aléatoirement un joueur et qui le désigne comme
	 * distribueur.
	 * 
	 * @return le joueur désigné.
	 */
	public Joueur choisirDistribueur() {
		Random rand = new Random();
		return this.joueurs.get(rand.nextInt(this.joueurs.size()));
	}

	/**
	 * Inverse le sens du jeu à partir d'une joueur de la liste des joueurs
	 * 
	 * @param j
	 *            le joueur qui sert de repaire
	 * @return l'index du prochain joueur à jouer
	 */
	public int inverserSensJeu(Joueur j) {
		Collections.reverse(this.joueurs);
		System.out.println("Et on change de sens !");
		this.lancerChangerSensEvent();
		return this.joueurs.indexOf(j);
	}
	
	public void passeTour(Joueur j,Joueur cible) {
		this.lancerPasseTourEvent(j,cible);
		System.out.println(j +"fait passer son tour à "+cible+"!");
	}

	/**
	 * Fonction qui initialise la pioche en fonction du nombre de carte neccessaire
	 * pour cette variante.
	 */
	public void initPioche() {
		switch (this.variante.getNbCartePaquet()) {
		case 52:
			for (String valeur : Carte.VALEURS) {
				for (String couleur : Carte.COULEURS) {
					this.pioche.getCartes().add(new Carte(couleur, valeur));
				}
			}

		case 32:
			for (int i = 7; i < 13; i++) {
				for (String couleur : Carte.COULEURS) {
					this.pioche.getCartes().add(new Carte(couleur, Carte.VALEURS[i]));
				}
			}

		case 54:
			for (String valeur : Carte.VALEURS) {
				for (String couleur : Carte.COULEURS) {
					this.pioche.getCartes().add(new Carte(couleur, valeur));
				}
			}
			this.pioche.getCartes().add(new Carte("Carreau","Joker" ));
			this.pioche.getCartes().add(new Carte("Pique", "Joker"));

		}
		this.pioche.melanger();

	}

	public void initTalon() {
		this.talon.addCarte(this.pioche.prendreCarte());
	}

	/**
	 * Distribue les nbCartes cartes de la pioche entre les différents joueurs à
	 * partir du joueur j désigné comme distribueur.
	 * 
	 * @param j
	 *            Joueur désigné comme distribueur
	 * @param nbCarte
	 *            nombre de carte à distribuer par personne.
	 */

	public void distribuerCartes(Joueur joueur, int nbCarte) {
		int indexDepart = this.joueurs.indexOf(joueur);
		int compteur = indexDepart;
		int nbJoueur = this.joueurs.size();
		boolean piocheVide = false;
		for (int i = 0; i < nbCarte; i++) {
			for (int j = 0; j < nbJoueur; j++) {
				compteur++;
				if (compteur == nbJoueur) {
					compteur = 0;
				}
				piocheVide = !this.joueurs.get(compteur).piocher(this.pioche);
				if (piocheVide) {
					this.setPioche(new Pioche(this.talon.retournerTalon()));
					this.talon.addCarte(this.pioche.prendreCarte());
					this.joueurs.get(compteur).piocher(this.pioche);
				}
			}
		}
	}

	/**
	 * Active l'effet de la carte joué par le joueur
	 * 
	 * @param j
	 *            le joueur qui a joué la carte
	 * @return l'index du prochain joueur qui jouera
	 */
	public int activerEffetDerniereCarte(Joueur j) {
		return this.variante.getEffetCarte(this.talon.getCarteDessus().getValeur()).appliquerEffet(this, j);
	}

	/**
	 * Méthode qui simule le déroulement du jeu
	 * 
	 * @param j
	 *            le joueur qui a distribué les cartes.
	 */
	public int jouer(Joueur j) {
		int indexDepart = this.joueurs.indexOf(j);
		int compteur = indexDepart;
		int nbJoueur = this.joueurs.size();
		boolean piocheVide = false;
		while (!this.estTermine()) {
			compteur++;
			if (compteur >= nbJoueur) {
				compteur = 0;
			}
			if (this.joueurs.get(compteur).peutJouerCartes(this.talon.getCarteDessus(), this.variante)) {
				this.joueurs.get(compteur).poserCarte(
						this.joueurs.get(compteur).choisirCarteAJouer(this.variante, this.talon.getCarteDessus()),
						this.talon);
				this.lancerPoserCarteEvent(j,this.talon.getCarteDessus());
				System.out.println(this.joueurs.get(compteur)+" pose un "+this.talon.getCarteDessus());
				compteur = this.activerEffetDerniereCarte(this.joueurs.get(compteur));
			} else {
				piocheVide = !this.joueurs.get(compteur).piocher(this.pioche);
				this.lancerPiocherEvent(this.joueurs.get(compteur),1);
				System.out.println(this.joueurs.get(compteur)+" ne pouvait pas poser de carte ! Il pioche !");
				if(piocheVide) {
					this.pioche = new Pioche(this.talon.retournerTalon());
					this.lancerPiocheVideEvent();
					this.talon.addCarte(this.pioche.prendreCarte());
					this.joueurs.get(compteur).piocher(this.pioche);
					this.lancerPiocherEvent(this.joueurs.get(compteur),1);
				}
			}
			try {
				Thread.sleep(3000);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		this.lancerPartieTermineEvent(this.getJoueurs().get(compteur));
		
		return compteur;

	}
	
	public void lancerRejouerEvent(Joueur j) {
		this.setChanged();
		this.notifyObservers(new EventRejouer(this,j));
	}
	
	public void lancerChangerSensEvent() {
		this.setChanged();
		this.notifyObservers(new EventChangerSens(this));
	}
	
	public void lancerPasseTourEvent(Joueur joueur,Joueur cible) {
		this.setChanged();
		this.notifyObservers(new EventPasseTour(this,joueur,cible));
	}
	
	public void lancerPartieTermineEvent(Joueur j) {
		this.setChanged();
		this.notifyObservers(new EventPartieTermine(this,j));
	}
	
	public void lancerPiocheVideEvent() {
		this.setChanged();
		this.notifyObservers(new EventPiocheVide(this));
	}
	
	public void lancerPiocherEvent(Joueur j,int nbCarte) {
		this.setChanged();
		this.notifyObservers(new EventPiocher(this,j,nbCarte));
	}
	
	public void lancerPoserCarteEvent(Joueur j,Carte carte) {
		this.setChanged();
		this.notifyObservers(new EventPoserCarte(this,j,carte));
	}

	public boolean estTermine() {
		for (Joueur j : this.joueurs) {
			if (j.getMain().estVide()) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<JoueurVirtuel> initJoueurVirtuel(int nb) {
		ArrayList<JoueurVirtuel> array = new ArrayList<JoueurVirtuel>();
		for (int i = 1; i <= nb; i++) {
			array.add(new JoueurVirtuel("J" + i));
		}
		return array;
	}

}
