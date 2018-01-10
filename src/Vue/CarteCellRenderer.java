package Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import Controller.ControllerAmerican8;
import Modele.Carte;

public class CarteCellRenderer extends JLabel implements ListCellRenderer {
	
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	public CarteCellRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}
	
	@Override
	public Component getListCellRendererComponent(JList arg0, Object value, int index, boolean isSelected,boolean cellHasFocus) {
		Carte carte = (Carte) value;
		/*
		Image carteRescaled = carte.getImageIcon().getImage().getScaledInstance(150,100,Image.SCALE_DEFAULT);
		ImageIcon imageIcon = new ImageIcon(carteRescaled);
		setIcon(carte.getImageIcon());
		*/
		setText(carte.getValeur()+" "+carte.getCouleur());

		
		return this;
	}

}
