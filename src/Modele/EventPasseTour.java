package Modele;

import java.util.EventObject;

public class EventPasseTour extends EventObject {
	
	public Joueur joueur;
	public Joueur cible;

	public EventPasseTour(Object source,Joueur joueur, Joueur cible) {
		super(source);
		this.joueur=joueur;
		this.cible=cible;
	}

}
