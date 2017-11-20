package American8;

import java.util.ArrayList;

public class Talon extends Paquet {
	
	public Talon(ArrayList cartes) {
		super(cartes);
	}
	
	public void deposerCarte(Carte carte) {
		this.cartes.add(carte);
	}
	
	public ArrayList<Carte> retournerTalon(){
		ArrayList<Carte> talon = this.cartes;
		this.cartes= new ArrayList<Carte>();
		return talon;
	}
}
