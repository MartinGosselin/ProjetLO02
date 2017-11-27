package American8;

import java.util.LinkedList;

public class StrategieAggressive extends Strategie {

	/**
	 * Méthode permettant de fournir une carte à jouer dans le cadre d'une stratégie de jeu aggressive.
	 * @param carte la carte du dessus du talon
	 * @return Carte la carte à jouer.
	 */
	@Override
	public Carte choisirCarteAJouer(LinkedList<Carte> cartes, Carte carte) {
		LinkedList<Carte> cartesJouable = this.getCartesJouable(cartes, carte);
		return cartes.get(0);
	}
	
	public LinkedList<Carte> getCartesJouable(LinkedList<Carte> cartes, Carte carte){
		//On va faire un traitement de cartes.
		//On va parcourir la liste cartes.
		LinkedList<Carte> cartesJouables = new LinkedList<Carte>();
		//Au premier passage sur cartes, on prend les cartes spéciales et on les ajoutent dans cartesJouables
		
		//AU deuxième passage on garde les cartes qui peuvent être jouer avec carte (celle du dessus du talon)
		
		return cartesJouables;
	}

}
