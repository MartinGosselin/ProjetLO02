package American8;

import java.util.ArrayList;

public abstract class Paquet {
	
	protected ArrayList<Carte> cartes;
	
	public Paquet(ArrayList<Carte> cartes) {
		this.cartes=cartes;
	}

}
