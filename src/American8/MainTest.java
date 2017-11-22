package American8;

public class MainTest {

	public static void main(String[] args) {
		try {
			Variante variante = new Variante(52,"test");
			Jeu jeu = Jeu.getInstance();
			jeu.setPioche(new Pioche());
			jeu.initPioche();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
