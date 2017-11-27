package American8;

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
	 *            Pioche associ�e au jeu
	 * @param talon
	 *            Talon associ� au jeu
	 * @param joueurs
	 *            Liste des joueurs associ�s au jeu.
	 */
	private Jeu(Pioche pioche, Talon talon, LinkedList<Joueur> joueurs) {
		this.pioche = pioche;
		this.talon = talon;
		this.joueurs = joueurs;
		this.variante = null;
	}

	/**
	 * Constructeur par d�faut de la classe Jeu
	 */
	private Jeu() {
		this.pioche = new Pioche();
		this.talon = new Talon();
		this.joueurs = new LinkedList<Joueur>();
		this.variante = new Variante();
	}

	/**
	 * M�thode d'access au singleton Jeu.
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

	/**
	 * m�thode qui d�termine al�atoirement un joueur et qui le d�signe comme
	 * distribueur.
	 * 
	 * @return le joueur d�sign�.
	 */
	public Joueur choisirDistribueur() {
		Random rand = new Random();
		return this.joueurs.get(rand.nextInt(this.joueurs.size()));
	}

	/**
	 * Inverse le sens du jeu � partir d'une joueur de la liste des joueurs
	 * 
	 * @param j
	 *            le joueur qui sert de repaire
	 * @return l'index du prochain joueur � jouer
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

	/**
	 * Distribue les nbCartes cartes de la pioche entre les diff�rents joueurs �
	 * partir du joueur j d�sign� comme distribueur.
	 * 
	 * @param j
	 *            Joueur d�sign� comme distribueur
	 * @param nbCarte
	 *            nombre de carte � distribuer par personne.
	 */

	public void distribuerCartes(Joueur joueur, int nbCarte) {
		int indexDepart = this.joueurs.indexOf(joueur);
		int compteur = indexDepart;
		int nbJoueur = this.joueurs.size();
		for (int i = 0; i < nbCarte; i++) {
			for (int j = 0; j < nbJoueur; j++) {
				compteur++;
				if (compteur == nbJoueur) {
					compteur = 0;
				}
				this.joueurs.get(compteur).piocher(this.pioche);
			}
		}
	}

	/**
	 * Active l'effet de la carte jou� par le joueur
	 * 
	 * @param j
	 *            le joueur qui a jou� la carte
	 * @return l'index du prochain joueur qui jouera
	 */
	public int activerEffetDerniereCarte(Joueur j) {
		return this.variante.getEffetCarte(this.talon.carteDessus().getValeur()).appliquerEffet(this, j);
	}

	/**
	 * Fonction qui effectue un tour pour tout les joueurs du jeu.
	 * 
	 * @param j
	 *            le joueur qui a distribu� les cartes.
	 */
	public void jouerTour(Joueur j) {
		int indexDepart = this.joueurs.indexOf(j);
		int compteur = indexDepart;
		int nbJoueur = this.joueurs.size();
		for (int i = 0; i < nbJoueur; i++) {
			compteur++;
			if (compteur == nbJoueur) {
				compteur = 0;
			}
			if (this.joueurs.get(compteur).peutJouerCartes(this.talon.carteDessus())) {
				this.joueurs.get(compteur).poserCarte(this.joueurs.get(compteur).choisirCarteAJouer(this.talon.carteDessus()), this.talon);
				compteur = this.activerEffetDerniereCarte(this.joueurs.get(compteur));
			} else {
				// g�rer le cas de la pioche vide
				this.joueurs.get(compteur).piocher(this.pioche);
			}

		}

	}
	
	//Fonction qui sert de condition d'arret.

}
