package American8;

import java.util.ArrayList;

public class Jeu {
	
	private static Jeu jeu;
	private Pioche pioche;
	private Talon talon;
	private ArrayList<Joueur> joueurs;
	
	/**
	 * Constructeur de la classe Jeu
	 * @param pioche Pioche associ�e au jeu
	 * @param talon Talon associ� au jeu
	 * @param joueurs Liste des joueurs associ�s au jeu.
	 */
	private Jeu(Pioche pioche,Talon talon,ArrayList<Joueur> joueurs) {
		this.pioche=pioche;
		this.talon = talon;
		this.joueurs = joueurs;
	}
	
	/**
	 * Constructeur par d�faut de la classe Jeu
	 */
	private Jeu() {
		this.pioche=null;
		this.talon=null;
		this.joueurs=null;
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
}
