package Controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JList;

import Modele.Jeu;
import Modele.Variante;
import Vue.American8;

public class ControllerAmerican8 implements Observer {
	
	public American8 vue;
	public Jeu jeu;
	
	public ControllerAmerican8(American8 vue) {
		this.vue=vue;
		this.jeu = Jeu.getInstance();
		//Mise en fonctionnement du observer/observable
		this.jeu.initObserver(this);
		//Remplissage de la liste des variantes dispo en fonction de Variante.getAllVariantes();
		String[] variantesNames = Variante.getAllVariantesNames();
		JList<String> listVariantes = (JList<String>) this.vue.getComponentByName("listVariante");
		listVariantes.setListData(variantesNames);
		
		//R�cup�rer le nombre de bots souhait�s.
		//Instancier le nombre correspondant de label et de textField pour r�cup�rer les strategies correspondantes.
		
		//R�cup�rer le nom du joueur r�el, cr�er une instance de joueur r�el
		//R�cup�rer la variante s�l�ctionn�e
		
		//Cr�er les instances de JoueurVirtuel correspondantes
		//jeu.initJeu(joueurs, variante);
		//On instancie les affichages des nb de cartes des joueurs, du talon et de la pioche et des cartes du joueur.
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	

}
