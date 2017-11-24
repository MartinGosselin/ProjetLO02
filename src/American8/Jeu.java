package American8;

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
		this.pioche=pioche;
	}
	
	public void setTalon(Talon talon) {
		this.talon=talon;
	}
	
	public void setJoueurs(LinkedList<Joueur> joueurs) {
		this.joueurs=joueurs;
	}
	
	public void setVariante(Variante variante) {
		this.variante=variante;
	}
	
	public LinkedList<Joueur> getJoueurs(){
		return this.joueurs;
	}
	
	public int getNbCartes() {
		return this.variante.getNbCarte();
	}

	/**
	 * méthode qui détermine aléatoirement un joueur et qui le désigne comme
	 * distribueur.
	 * 
	 * @return le joueur désigné.
	 */
	public Joueur choisirDistribueur() {
		Random rand= new Random();
		return this.joueurs.get(rand.nextInt(this.joueurs.size()));
	}

	/**
	 * Fonction qui initialise la pioche en fonction du nombre de carte neccessaire
	 * pour cette variante.
	 */
	public void initPioche() {
		switch (this.variante.getNbCarte()) {
		case 52:
			
			for (String valeur : Carte.VALEURS) {
				for (String couleur : Carte.COULEURS) {
					this.pioche.getCartes().add(new Carte(couleur, valeur));
				}
			}
		}
		this.pioche.melanger();

	}


	/**
	 * Distribue les nbCartes cartes de la pioche entre les différents joueurs à partir du joueur j désigné comme distribueur.
	 * @param j Joueur désigné comme distribueur
	 * @param nbCarte nombre de carte à distribuer par personne.
	 */
	
	public void distribuerCartes(Joueur joueur, int nbCarte) {
		int indexDepart = this.joueurs.indexOf(joueur);
		int compteur = indexDepart;		
		int nbJoueur =this.joueurs.size();
		for(int i =0; i<nbCarte;i++) {
			for(int j=0;j<nbJoueur;j++) {
				compteur++;
				if(compteur==nbJoueur) {
					compteur=0;
				}
				this.joueurs.get(compteur).getMain().addCarte(this.pioche.prendreCarte());
			}
<<<<<<< Updated upstream
		}
	}


=======
		}
	}
>>>>>>> Stashed changes
	// Jouertour()


}
