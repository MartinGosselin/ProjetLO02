package American8;

public class Variante {
	
	public static final int[] jeuPossible = {32,52,54}; 
	private int nbCarte = 0;
	private String nomVariante;
	
	
	/**
	 * 
	 * @param nbCartes nombre de carte de la variante
	 * @param nomVariante nom de la variante
	 */
	public Variante(int nbCarte,String nomVariante) throws NombreCarteNonValideException {
		for(int nb : Variante.jeuPossible ) {
			if(nbCarte == nb) {
				this.nbCarte=nbCarte;
			}
		}
		if(this.nbCarte==0) {
			throw new NombreCarteNonValideException("Ce nombre de cartes ne représente pas un jeu valide.");
		}
		this.nomVariante = nomVariante;
	}
	
	public Variante() {
		this.nomVariante ="Defaut";
	}
	
	
	
	public int getNbCarte() {
		return this.nbCarte;
	}
}
