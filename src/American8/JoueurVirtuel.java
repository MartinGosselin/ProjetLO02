package American8;

public class JoueurVirtuel extends Joueur {
	
	private Strategie strat;

	public JoueurVirtuel(String nom, int numero, int comptePoint, Main main,Strategie strat) {
		super(nom, numero, comptePoint, main);
		this.strat=strat;
	}

	@Override
	public Carte choisirCarteAJouer() {
		return this.strat.choisirCarteAJouer();
	}

}
