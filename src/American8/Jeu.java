package American8;

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
		this.pioche = null;
		this.talon = null;
		this.joueurs = null;
		this.variante = null;
	}

	/**
	 * Méthode d'access au singleton Jeu.
	 * 
	 * @return l'instance du singleton Jeu
	 */
	public Jeu getInstance() {
		if (this.jeu == null) {
			this.jeu = new Jeu();
		}
		return this.jeu;
	}

	/**
	 * méthode qui détermine aléatoirement un joueur et qui le désigne comme
	 * distribueur.
	 * 
	 * @return le joueur désigné.
	 */
	public Joueur choisirDistribueur() {
		Random rand = null;
		return this.joueurs.get(rand.nextInt(this.joueurs.size()));
	}

	/**
	 * Fonction qui initialise la pioche en fonction du nombre de carte neccessaire
	 * pour cette variante.
	 */
	public void initPioche() {
		int nbCarte = this.variante.getNbCarte();
		switch (this.variante.getNbCarte()) {
		case 52:
			for (int valeur : Carte.VALEURS) {
				for (String couleur : Carte.COULEURS) {
					this.pioche.getCartes().add(new Carte(couleur, valeur));
				}
			};
		}
<<<<<<< HEAD
	}

	/**
	 * Distribu les nbCartes cartes de la pioche entre les différents joueurs à partir du joueur j désigné comme distribueur.
	 * @param j Joueur désigné comme distribueur
	 * @param nbCarte nombre de carte à distribuer par personne.
	 */
	public void distribuerCartes(Joueur j, int nbCarte) {
		int indexDepart = this.joueurs.indexOf(j);
		int compteur = 0;
		for(int i =0; i<nbCarte;i++) {
			int numero =compteur%indexDepart;
			while(numero != 0) {
				this.joueurs.get(numero).getMain().addCarte(this.pioche.prendreCarte());
				compteur++;
				numero = compteur%indexDepart;
			}
		}
	}

=======
	}

	// Jouertour()

}
