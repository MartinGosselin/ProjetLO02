package American8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Jeu {

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
		return this.joueurs.indexOf(j);
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
			this.pioche.getCartes().add(new Carte("Joker", "Carreau"));
			this.pioche.getCartes().add(new Carte("Joker", "Pique"));

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
				System.out.println(this.joueurs.get(compteur)+" pose un "+this.talon.getCarteDessus());
				compteur = this.activerEffetDerniereCarte(this.joueurs.get(compteur));
			} else {
				piocheVide = !this.joueurs.get(compteur).piocher(this.pioche);
				System.out.println(this.joueurs.get(compteur)+" ne pouvait pas poser de carte ! Il pioche !");
				if(piocheVide) {
					this.pioche = new Pioche(this.talon.retournerTalon());
					this.joueurs.get(compteur).piocher(this.pioche);
				}
			}
			try {
				Thread.sleep(3000);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			

		}
		return compteur;

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
