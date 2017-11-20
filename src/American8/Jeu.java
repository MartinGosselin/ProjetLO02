package American8;

import java.util.ArrayList;

public class Jeu {
	
	private static Jeu jeu;
	private Pioche pioche;
	private Talon talon;
	private ArrayList<Joueur> joueurs;
	
	/**
	 * Constructeur de la classe Jeu
	 * @param pioche Pioche associée au jeu
	 * @param talon Talon associé au jeu
	 * @param joueurs Liste des joueurs associés au jeu.
	 */
	private Jeu(Pioche pioche,Talon talon,ArrayList<Joueur> joueurs) {
		this.pioche=pioche;
		this.talon = talon;
		this.joueurs = joueurs;
	}
	
	/**
	 * Constructeur par défaut de la classe Jeu
	 */
	private Jeu() {
		this.pioche=null;
		this.talon=null;
		this.joueurs=null;
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
}
