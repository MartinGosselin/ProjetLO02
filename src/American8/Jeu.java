package American8;


import java.util.LinkedList;

public class Jeu {
	
	private static Jeu jeu;
	private Pioche pioche;
	private Talon talon;
	private LinkedList<Joueur> joueurs;
	private Variante variante;
	
	/**
	 * Constructeur de la classe Jeu
	 * @param pioche Pioche associée au jeu
	 * @param talon Talon associé au jeu
	 * @param joueurs Liste des joueurs associés au jeu.
	 */
	private Jeu(Pioche pioche,Talon talon,LinkedList<Joueur> joueurs) {
		this.pioche = pioche;
		this.talon = talon;
		this.joueurs = joueurs;
		this.variante = null;
	}
	
	/**
	 * Constructeur par défaut de la classe Jeu
	 */
	private Jeu() {
		this.pioche=null;
		this.talon=null;
		this.joueurs=null;
		this.variante=null;
	}
	
	/**
	 * Méthode d'access au singleton Jeu.
	 * @return l'instance du singleton Jeu
	 */
	public Jeu getInstance() {
		if(this.jeu==null) {
			this.jeu = new Jeu();
		}
		return this.jeu;
	}
	
	//Jouertour()
	
	//Selectionner un joueur pour être le distribueur.
	
	//Distribu les cartes à partir d'un joueur donné.
	
	//Fonction qui instancie la pioche en fonction du nombre de carte de la variante.
	
	
}
