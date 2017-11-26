package American8;

import java.util.HashMap;

public class Variante {
	
	public static final int[] jeuPossible = {32,52,54}; 
	public static final String[] effetCarteExistant = {"ChangerSens","Ajoute4Cartes","PasseTour","ChangerCouleur","Ajouter2Cartes"};
	private int nbCartePaquet = 0;
	private String nomVariante;
	private HashMap<String,String> effetCarteVariante;
	
	
	/**
	 * 
	 * @param nbCartePaquets nombre de carte de la variante
	 * @param nomVariante nom de la variante
	 */
	public Variante(int nbCartePaquet,String nomVariante) throws NombreCarteNonValideException {
		for(int nb : Variante.jeuPossible ) {
			if(nbCartePaquet == nb) {
				this.nbCartePaquet=nbCartePaquet;
			}
		}
		if(this.nbCartePaquet==0) {
			throw new NombreCarteNonValideException("Ce nombre de cartes ne représente pas un jeu valide.");
			
			
		}
		this.nomVariante = nomVariante;
	}
	
	public Variante() {
		this.nomVariante ="Defaut";
	}
	
	public int getNbCartePaquet() {
		return this.nbCartePaquet;
	}
}
