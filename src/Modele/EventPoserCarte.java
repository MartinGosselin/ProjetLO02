package Modele;

import java.util.EventObject;

public class EventPoserCarte extends EventObject {
	
	public Joueur joueur;
	public Carte carte;
	
	

	public EventPoserCarte(Object arg0,Joueur j,Carte c) {
		super(arg0);
		this.joueur=j;
		this.carte=carte;
	}

	

}
