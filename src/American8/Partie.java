package American8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Partie {

	public static void main(String[] args) {
		boolean numVarianteValide = false;
		int numVariante=-1;
		Scanner reader = new Scanner(System.in);
		ArrayList<Variante> variantes = new ArrayList<Variante>();
		variantes.add(Variante.initVariante1());
		variantes.add(Variante.initVariante2());
		Jeu jeu = Jeu.getInstance();
		
		
		
		System.out.println("Veuillez choisir les paramètres de votre partie : ");
		System.out.println("Quelle variante souhaitez-vous utiliser (donner son numéro) : ");
		for (int i =0 ; i<variantes.size();i++) {
			System.out.println("Variante numéro "+(i+1)+" : ");
			System.out.println(variantes.get(i).getDescription());
		}
		
		
		while(!numVarianteValide) {
			try {
				numVariante = reader.nextInt()-1;
				while(numVariante>variantes.size()) {
					System.out.println("Veuillez saisir un numéro valide : ");
					numVariante = reader.nextInt()-1;
				}
				numVarianteValide = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Vous devez choisir un NUMERO : ");
				reader = new Scanner(System.in);
			}
		}
		
		jeu.setVariante(variantes.get(numVariante));
		reader.close();
	}

}
