package American8;

import java.util.ArrayList;
import java.util.LinkedList;

public class StrategiePassive extends Strategie {

	/**
	 * M�thode permettant de fournir une carte � jouer dans le cadre d'une strat�gie de jeu passive.
	 * @param carte la carte du dessus du talon
	 * @return Carte la carte � jouer.
	 */
	@Override
	public Carte choisirCarteAJouer(Variante v,LinkedList<Carte> cartes, Carte carte) {
		LinkedList<Carte> cartesJouables = this.getCartesJouable(v,cartes, carte);
		return cartesJouables.get(0);
	}
	
	
	
	public LinkedList<Carte> getCartesJouable(Variante v,LinkedList<Carte> cartes, Carte carte){
		ArrayList<String> cartesAEffet = v.getCartesAEffet();
		LinkedList<Carte> cartesJouables = new LinkedList<Carte>();
		
		for(int i=0;i<cartes.size();i++) {
			if(cartes.get(i).getValeur()==carte.getValeur() || cartes.get(i).getCouleur()==carte.getCouleur()) {
				cartesJouables.add(cartes.get(i));
			}
		}
		
		
		for(Carte c : cartes) {
			for(String valeur : cartesAEffet) {
				if(c.getValeur()==valeur) {
					cartesJouables.add(c);
				}
			}
		}
		return cartesJouables;
	}

}
