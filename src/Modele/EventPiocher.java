package Modele;

import java.util.EventObject;

public class EventPiocher extends EventObject {
	
	public Joueur joueur;
	public int nbCarte;

	public EventPiocher(Object source, Joueur j,int nbCarte) {
		super(source);
		this.joueur=j;
		this.nbCarte=nbCarte;
	}

}
