package Modele;

import java.util.EventObject;

public class EventRejouer extends EventObject {
	
	public Joueur joueur;

	public EventRejouer(Object arg0, Joueur joueur) {
		super(arg0);
		this.joueur=joueur;
	}

}
