package American8;

import java.util.ArrayList;

public class Pioche extends Paquet {

	public Pioche(ArrayList cartes) {
		super(cartes);
	}

	public Carte prendreCarte() {
		Carte carte = this.cartes.get(this.cartes.size() - 1);
		this.cartes.remove(this.cartes.size() - 1);
		return carte;

	}
	
	public boolean estVide() {
		return this.cartes.isEmpty();
	}
}
