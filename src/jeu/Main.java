package jeu;

import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Jeu jeu = new Jeu();
		GUI gui = new GUI(jeu);
		gui.new Sound().jouer();
		jeu.setGUI(gui);
		javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
    
	}
}
