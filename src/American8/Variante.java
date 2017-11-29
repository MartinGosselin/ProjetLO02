package American8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Variante {

	public static final int[] jeuPossible = { 32, 52, 54 };
	private int nbCartePaquet = 0;
	private String nomVariante;
	private HashMap<String, EffetCarte> effetsCartes;
	private String description;

	/**
	 * 
	 * @param nbCartePaquets
	 *            nombre de carte de la variante
	 * @param nomVariante
	 *            nom de la variante
	 */
	public Variante(int nbCartePaquet, String nomVariante, HashMap<String, EffetCarte> effetsCartes, String description)
			throws NombreCarteNonValideException {
		for (int nb : Variante.jeuPossible) {
			if (nbCartePaquet == nb) {
				this.nbCartePaquet = nbCartePaquet;
			}
		}
		if (this.nbCartePaquet == 0) {
			throw new NombreCarteNonValideException("Ce nombre de cartes ne représente pas un jeu valide.");

		}
		this.nomVariante = nomVariante;
		this.effetsCartes = effetsCartes;
		this.description = description;
	}

	public Variante() {
		this.nomVariante = "Defaut";
	}

	public int getNbCartePaquet() {
		return this.nbCartePaquet;
	}

	public EffetCarte getEffetCarte(String valeur) {
		return this.effetsCartes.get(valeur);
	}
	
	public String getDescription() {
		return this.description;
	}

	public static Variante initVariante1() {
		HashMap<String, EffetCarte> effetsCartes = new HashMap<String, EffetCarte>();
		effetsCartes.put("2", new Ajoute2Cartes());
		effetsCartes.put("3", new AucunEffet());
		effetsCartes.put("4", new AucunEffet());
		effetsCartes.put("5", new AucunEffet());
		effetsCartes.put("6", new AucunEffet());
		effetsCartes.put("7", new AucunEffet());
		effetsCartes.put("8", new ChangerCouleur());
		effetsCartes.put("9", new AucunEffet());
		effetsCartes.put("10", new AucunEffet());
		effetsCartes.put("Valet", new PasseTour());
		effetsCartes.put("Dame", new AucunEffet());
		effetsCartes.put("Roi", new AucunEffet());
		effetsCartes.put("As", new ChangerSens());
		effetsCartes.put("Joker", new Ajoute4Cartes());

		try {
			return new Variante(54, "Classique", effetsCartes,"Variante Classique du 8 américain, Le 2 fait piocher 2 cartes, le 8 change la couleur, le Valet passe le tour, l'As change le sens et le Joker ajoute 4 cartes.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public static Variante initVariante2() {
		HashMap<String, EffetCarte> effetsCartes = new HashMap<String, EffetCarte>();
		effetsCartes.put("2", new AucunEffet());
		effetsCartes.put("3", new AucunEffet());
		effetsCartes.put("4", new AucunEffet());
		effetsCartes.put("5", new AucunEffet());
		effetsCartes.put("6", new AucunEffet());
		effetsCartes.put("7", new PasseTour());
		effetsCartes.put("8", new ChangerCouleur());
		effetsCartes.put("9", new Ajoute2Cartes());
		effetsCartes.put("10", new Rejouer());
		effetsCartes.put("Valet", new ChangerSens());
		effetsCartes.put("Dame", new AucunEffet());
		effetsCartes.put("Roi", new AucunEffet());
		effetsCartes.put("As", new Ajoute4Cartes());
		effetsCartes.put("Joker", new AucunEffet());
		
		try {
			return new Variante(52, "Monclar", effetsCartes,"Variante Monclar du 8 américain,le 7 passe le tour, le 8 change la couleur,le 9 ajoute 2 cartes, le Valet change le sens, l'As ajoute 4 cartes.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<String> getCartesAEffet() {
		ArrayList<String> cartes = new ArrayList<String>();
		for (String valeur : Carte.VALEURS) {
			if (this.effetsCartes.get(valeur) instanceof EffetCarte
					&& !(this.effetsCartes.get(valeur) instanceof AucunEffet)) {
				cartes.add(valeur);
			}
		}
		if (this.effetsCartes.get("Joker") instanceof EffetCarte
				&& !(this.effetsCartes.get("Joker") instanceof AucunEffet)) {
			cartes.add("Joker");
		}
		return cartes;
	}
}
