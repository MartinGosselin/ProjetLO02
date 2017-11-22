package American8;

import java.util.LinkedList;

public class MainTest {

	public static void main(String[] args) {
		try {
			Variante variante = new Variante(52,"test");
			Jeu jeu = Jeu.getInstance();
			jeu.setVariante(variante);
			jeu.initPioche();
			System.out.println(jeu.getPioche());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
