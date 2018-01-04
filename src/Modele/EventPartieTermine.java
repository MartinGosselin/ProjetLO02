package Modele;

import java.util.EventObject;

public class EventPartieTermine extends EventObject {

	public Joueur joueur;
	
	public EventPartieTermine(Object source, Joueur j) {
		super(source);
		this.joueur=j;
	}

}
