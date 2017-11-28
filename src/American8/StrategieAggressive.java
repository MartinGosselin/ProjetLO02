package American8;

import java.util.ArrayList;
import java.util.LinkedList;

public class StrategieAggressive extends Strategie {

	/**
	 * M�thode permettant de fournir une carte � jouer dans le cadre d'une strat�gie de jeu aggressive.
	 * @param carte la carte du dessus du talon
	 * @return Carte la carte � jouer.
	 */
	@Override
	public Carte choisirCarteAJouer(Variante v,LinkedList<Carte> cartes, Carte carte) {
		LinkedList<Carte> cartesJouables = this.getCartesJouable(v,cartes, carte);
		return cartesJouables.get(0);
	}
	
	public LinkedList<Carte> getCartesJouable(Variante v,LinkedList<Carte> cartes, Carte carte){
		//On va faire un traitement de cartes.
		//On va parcourir la liste cartes.
		LinkedList<Carte> cartesJouables = new LinkedList<Carte>();
		
		ArrayList<String> cartesAEffet = v.getCartesAEffet();
		//Au premier passage sur cartes, on prend les cartes sp�ciales et on les ajoutent dans cartesJouables
		for(Carte c : cartes) {
			for(String valeur : cartesAEffet) {
				if(c.getValeur()==valeur) {
					cartesJouables.add(c);
				}
			}
		}
		
		//AU deuxi�me passage on garde les cartes qui peuvent �tre jouer avec carte (celle du dessus du talon)
		
		for(int i=0;i<cartes.size();i++) {
			if(cartes.get(i).getValeur()==carte.getValeur() || cartes.get(i).getCouleur()==carte.getCouleur()) {
				cartesJouables.add(cartes.get(i));
			}
		}
		
		return cartesJouables;
	}

}
