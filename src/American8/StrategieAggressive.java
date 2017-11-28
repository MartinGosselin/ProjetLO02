package American8;

import java.util.ArrayList;
import java.util.LinkedList;

public class StrategieAggressive extends Strategie {

	/**
	 * Méthode permettant de fournir une carte à jouer dans le cadre d'une stratégie de jeu aggressive.
	 * @param carte la carte du dessus du talon
	 * @return Carte la carte à jouer.
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
		//Au premier passage sur cartes, on prend les cartes spéciales et on les ajoutent dans cartesJouables
		for(Carte c : cartes) {
			for(String valeur : cartesAEffet) {
				if(c.getValeur()==valeur) {
					cartesJouables.add(c);
				}
			}
		}
		
		//AU deuxième passage on garde les cartes qui peuvent être jouer avec carte (celle du dessus du talon)
		
		for(int i=0;i<cartes.size();i++) {
			if(cartes.get(i).getValeur()==carte.getValeur() || cartes.get(i).getCouleur()==carte.getCouleur()) {
				cartesJouables.add(cartes.get(i));
			}
		}
		
		return cartesJouables;
	}

}
