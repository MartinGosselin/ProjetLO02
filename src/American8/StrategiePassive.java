package American8;

import java.util.LinkedList;

public class StrategiePassive extends Strategie {

	/**
	 * Méthode permettant de fournir une carte à jouer dans le cadre d'une stratégie de jeu passive.
	 * @param carte la carte du dessus du talon
	 * @return Carte la carte à jouer.
	 */
	@Override
	public Carte choisirCarteAJouer(LinkedList<Carte> cartes, Carte carte) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public LinkedList<Carte> getCartesJouable(LinkedList<Carte> cartes, Carte carte){
		//Idem que aggressive mais on inverse les passages.
		return null;
	}

}
