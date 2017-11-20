package American8;

import java.util.ArrayList;

public class Jeu {
	
	private static Jeu jeu;
	private Pioche pioche;
	private Talon talon;
	private ArrayList<Joueur> joueurs;
	
	private Jeu(Pioche pioche,Talon talon,ArrayList<Joueur> joueurs) {
		this.pioche=pioche;
		this.talon = talon;
		this.joueurs = joueurs;
	}
	
	private Jeu() {
		this.pioche=null;
		this.talon=null;
		this.joueurs=null;
	}
	
	
	public Jeu getInstance() {
		if(this.jeu==null) {
			this.jeu = new Jeu();
		}
		return this.jeu;
	}
}
