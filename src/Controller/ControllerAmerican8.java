package Controller;

import java.util.Observable;
import java.util.Observer;

import Modele.Jeu;
import Vue.American8;

public class ControllerAmerican8 implements Observer {
	
	public American8 vue;
	public Jeu jeu;
	
	public ControllerAmerican8(American8 vue) {
		this.vue=vue;
		this.jeu = Jeu.getInstance();
		this.jeu.initObserver(this);
		//Remplissage de la liste des variantes dispo en fonction de Variante.getAllVariantes();
		//Récupérer le nom du joueur réel, créer une instance de joueur réel
		//Récupérer la variante séléctionnée
		//Récupérer le nombre de bots souhaités.
		//Instancier le nombre correspondant de label et de textField pour récupérer les strategies correspondantes.
		//Créer les instances de JoueurVirtuel correspondantes
		//jeu.initJeu(joueurs, variante);
		//On instancie les affichages des nb de cartes des joueurs, du talon et de la pioche et des cartes du joueur.
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	

}
