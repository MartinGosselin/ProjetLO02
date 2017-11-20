package American8;

public abstract class Joueur {
	private final String nom;
	private int numero;
	private int comptePoint;
	private Main main;
	
	public Joueur(String nom,int numero,int comptePoint, Main main) {
		this.nom=nom;
		this.numero=numero;
		this.comptePoint=comptePoint;
		this.main = main;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int getComptePoint() {
		return this.comptePoint;
	}
	
	public Main getMain() {
		return this.main;
	}
	
	public void setComptePoint(int comptePoint) {
		this.comptePoint=comptePoint;
	}
	
	public abstract Carte choisirCarteAJouer();
}
