package jeu;
import java.util.ArrayList;
import java.util.List;
/*
 * une commande possible à effectuer dans chaque zone du jeu
 *  
 * */
public enum Commande { 
	AIDE("?", "? (aide)\n"), 
	Q("QUITTER","QUITTER : permet de quitter le jeu\n"),
	CARTE("CARTE","CARTE : permet de consulter l'avancée de la carte\n"),
	KILL("KILL","KILL : permet de se suicider\n"),
	RAMASSER("RAMASSER","RAMASSER : permet de ramasser les objets\n"),
	MANGER("MANGER","MANGER : permet entre autres d'éviter de mourrir\n"),
	BOUTEILLE("BOUTEILLE","BOUTEILLE : permet de déplacer à la bouteille\n"),
	DEVANTFORET("DEVANTFORET","DEVANTFORET : permet d'aller devant la forêt\n"),
	FORET("F","FORET : permet d'aller dans la forêt\n"),
	BOIS("BOIS","BOIS : permet d'aller devant un morceau de bois\n"),
	COCO("COCO","COCO : permet d'aller devant une noix de coco\n"),
	COBRA("COBRA","COBRA : permet de se rapprocher d'un animal puissant\n"),
	ANANAS("ANANAS","ANANAS : permet d'aller devant des ananas\n"),
	BANANE("BANANE","BANANE : permet d'aller devant des bananes\n"),
	RADEAU("RADEAU","RADEAU : permet d'aller devant le radeau, de le construire ou de l'améliorer\n"),
	PLAGE("P", "PLAGE : permet d'aller  à la plage\n"),
	GROTTE("O", "GROTTE : permet de se rendre dans la grotte");

	private String abreviation;
	private String description;
	private Commande(String c, String d ) { 
		abreviation = c;
		description = d; 
	}
	@Override
	public String toString() { 
		return name();
	}
	/**
	 * Renvoie la listes de toutes les descritpions de commande
	 *@return la liste des descriptions 
	 * */
	
	public static List<String> toutesLesDescriptions() { 
		ArrayList<String> resultat = new ArrayList<String>();
		for(Commande c : values()) {
			resultat.add( c.description);
		}
		return resultat;
	}
	/**
	 *  Renvoie la liste de toutes les abreviations de commande 
	 *@return la liste des abreviations
	 * */
	
	public static List<String> toutesLesAbreviations() { 
		ArrayList<String> resultat = new ArrayList<String>();
		for(Commande c : values()) {
			resultat.add( c.abreviation);
		}
		return resultat;
	}
	/**
	 *  Renvoie la liste de tous les noms de commande 
	 *@return la liste des noms
	 * */
	
	public static List<String> tousLesNoms() { 
		ArrayList<String> resultat = new ArrayList<String>();
		for(Commande c : values()) {
			resultat.add( c.name());
		}
		return resultat;
	}

}
