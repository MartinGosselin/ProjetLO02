package American8;

public class JoueurReel extends Joueur {
	
	/**
	 * Constructeur de la classe Joueur
	 * @param nom Le nom du Joueur
	 * @param numero Le num�ro du joueur dans l'ordre du jeu
	 * @param comptePoint Le compte des points du joueur
	 * @param main La main contenant les cartes du joueur
	 */
	public JoueurReel(String nom,int comptePoint, Main main) {
		super(nom,comptePoint,main);
	}
	
	/**
	 * Fonction qui permet au joueur de choisir la carte qu'il va jouer.
	 * @return La carte que le joueur r�el aura d�cider de jouer
	 */
	public Carte choisirCarteAJouer() {
		return null;
	}

}
