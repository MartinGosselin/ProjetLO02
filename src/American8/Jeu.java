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
	 * @param pioche Pioche associ�e au jeu
	 * @param talon Talon associ� au jeu
	 * @param joueurs Liste des joueurs associ�s au jeu.
	 */
	private Jeu(Pioche pioche,Talon talon,LinkedList<Joueur> joueurs) {
		this.pioche = pioche;
		this.talon = talon;
		this.joueurs = joueurs;
		this.variante = null;
	}
	
	/**
	 * Constructeur par d�faut de la classe Jeu
	 */
	private Jeu() {
		this.pioche=null;
		this.talon=null;
		this.joueurs=null;
		this.variante=null;
	}
	
	/**
	 * M�thode d'access au singleton Jeu.
	 * @return l'instance du singleton Jeu
	 */
	public Jeu getInstance() {
		if(this.jeu==null) {
			this.jeu = new Jeu();
		}
		return this.jeu;
	}
	
	public Joueur choisirDistribueur() {
		Random rand=null;
		return this.joueurs.get(rand.nextInt(this.joueurs.size()));
	}
	
	//Distribu les cartes � partir d'un joueur donn�.
	
	//Fonction qui instancie la pioche en fonction du nombre de carte de la variante.
	
	//Jouertour()
	
}
