package American8;

public class JoueurVirtuel extends Joueur {
	
	private Strategie strat;

	/**
	 * Constructeur de la classe Joueur
	 * @param nom Le nom du Joueur
	 * @param numero Le num�ro du joueur dans l'ordre du jeu
	 * @param comptePoint Le compte des points du joueur
	 * @param main La main contenant les cartes du joueur
	 * @param strat Une instance de strat�gie qui permet de definir le comportement en jeu du joueur virtuel.
	 */
	public JoueurVirtuel(String nom, int numero, int comptePoint, Main main,Strategie strat) {
		super(nom, comptePoint, main);
		this.strat=strat;
	}

	
	/**
	 * Fonction qui permet de d�finir la carte qui sera jou� par le joueur virtuel.
	 * On utilise la fonction choisirCarteAJouer() de l'instance de la classe Strategie en attribut de notre objet.
	 */
	@Override
	public Carte choisirCarteAJouer() {
		return this.strat.choisirCarteAJouer();
	}

}
