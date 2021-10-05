package jeu;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @param gui
 * @param ZoneCourante 
 * */
public class Jeu {
	
    private GUI gui; 
	private Zone ZoneCourante;

    public Jeu() {
        creerCarte();
        gui = null;
        
    }
    /**
     * elle permet de lier la class graphique  au jeu 
     * 
     * @param g une instance de GUI 
     * */
    public void setGUI(GUI g) { 
    	gui = g; 
    	afficherMessageDeBienvenue();
    }
    
    private void creerCarte() {

    	ArrayList<Zone> stockiles = new ArrayList<Zone>();
    	Zone spawn = new Zone("L'île d'Amarak, à la plage", "spawn.png");
    	Zone b1 = new Zone("L'île d'Amarak, devant la bouteille", "b1.png");
    	Zone bvide = new Zone("Bravo ! Le morceau de carte a été ramassé\n   Tu peux utilser la commande CARTE pour la consulter !", "bvide.png");
    	Zone spawnv = new Zone("L'île d'Amarak, à la plage", "spawnv.png");
    	Zone devantf1 = new Zone("L'île d'Amarak, devant la forêt", "devantf1.png");
    	Zone devantf2 = new Zone("L'île d'Amarak, devant la forêt", "devantf2.png");
    	Zone devantf22 = new Zone("L'île d'Amarak, devant la forêt", "devantf2.png");
    	Zone foretfull = new Zone("L'île d'Amarak, dans la forêt", "foretfull.png");
    	Zone devantbois = new Zone("L'île d'Amarak, devant des morceaux de bois", "devantbois.png");
    	Zone devantcoco = new Zone("L'île d'Amarak, devant des noix de coco", "devantcoco.png");
    	Zone cocov = new Zone("Les noix de coco ont été ramassé", "cocov.png");
    	Zone boisv = new Zone("Plusieurs morceaux de bois ont été ramassé", "boisv.png");
    	Zone foretsanscoco = new Zone("L'île d'Amarak, dans la forêt", "foretsanscoco.png");
    	Zone foretsansbois = new Zone("L'île d'Amarak, dans la forêt", "foretsansbois.png");
    	Zone devantboissanscoco = new Zone("L'île d'Amarak, devant des morceaux de bois", "devantboissanscoco.png");
    	Zone devantboistoutvide = new Zone("L'île d'Amarak, lusieurs morceaux de bois ont été ramassé", "devantboistoutvide.png");
    	Zone foretvide = new Zone("L'île d'Amarak, dans la forêt", "foretvide.png");
    	Zone plagefullile2 = new Zone("L'île Sainte, à la plage", "plagefullile2.png");
    	Zone devantbois2 = new Zone("L'île Sainte, devant des morceaux de bois", "devantbois2.png");
    	Zone devantbois2vide = new Zone("Plusieurs morceaux de bois ont été ramassé", "devantbois2vide.png");
    	Zone devantcoco2 = new Zone("L'île Sainte, devant des noix de coco", "devantcoco2.png");
    	Zone devantcoco2vide = new Zone("Plusieurs morceaux de bois ont été ramassé", "devantcoco2vide.png");
    	Zone plage2vide= new Zone("L'île Sainte, à la plage", "plage2vide.png");
    	Zone devantforetvide2 = new Zone("L'île Sainte, devant la forêt", "devantforetvide2.png");
    	Zone foretfull2 = new Zone("L'île Sainte, dans la forêt", "foretfull2.png");
    	Zone b2 = new Zone("L'île Sainte, devant la bouteille", "b2.png");
    	Zone b2vide = new Zone("Bravo ! Le morceau de carte a été ramassé\n   Tu peux utilser la commande CARTE pour la consulter !", "b2vide.png");
    	Zone banane = new Zone("L'île Sainte, devant des bananes", "banane.png");
    	Zone bananev = new Zone("Des bananes ont été récupéré", "bananev.png");
    	Zone foretvide2 = new Zone("L'île Sainte, dans la forêt", "foretvide2.png");
    	Zone devantforet2 = new Zone("L'île Sainte, devant la forêt", "devantforet2.png");
    	Zone plage2vide2 = new Zone("L'île Sainte, à la plage", "plage2vide.png");
    	Zone plage3 = new Zone("L'île Obscure, à la plage", "plage3.png");
    	Zone plage4 = new Zone("L'île Obscure, à la plage", "plage3.png");
    	Zone cobra = new Zone("UN COBRA !!!, FUYEZ VOUS ETES PAS VENU ICI POUR VOUS BATTRE !!!", "cobra.png");
    	Zone cobra2 = new Zone("UN COBRA !!!, FUYEZ VOUS ETES PAS VENU ICI POUR VOUS BATTRE !!!", "cobra.png");
    	Zone devantforet3 = new Zone("L'île Obscure, devant la forêt", "devantforet3.png");
    	Zone foretfull3 = new Zone("L'île Obscure, dans la forêt", "foretfull3.png");
    	Zone b3 = new Zone("L'île Obscure, devant la bouteille\n   Tu peux utilser la commande CARTE pour la consulter !", "b3.png");
    	Zone b3v = new Zone("Bravo ! Le morceau de carte a été ramassé", "b3v.png");
    	Zone ananas = new Zone("L'île Obscure, devant des ananas", "ananas.png");
    	Zone ananasv = new Zone("Des ananas ont été récupéré", "ananasv.png");
    	Zone bois3 = new Zone("L'île Obscure, devant des morceaux de bois", "bois3.png");
    	Zone bois3v = new Zone("Plusieurs morceaux de bois ont été ramassé", "bois3v.png");
    	Zone foret3vide = new Zone("L'île Obscure, dans la forêt", "foret3vide.png");
    	Zone devantforet4 = new Zone("L'île Obscure, devant la forêt", "devantforet3.png");
    	Zone plage5 = new Zone("L'île Mirage, à la plage", "plage4.png");
    	Zone devantgrotte = new Zone("L'île Mirage, devant la grotte", "dgrotte.png");
    	Zone grotte = new Zone("L'île Mirage, dans la grotte", "grotte.png");
    	Zone agrotte = new Zone("L'île Mirage, dans la grotte", "agrotte.png");
    	Zone dcoffre = new Zone("L'île Mirage, devant le coffre", "dcoffre.png");
    	Zone coffreo = new Zone("Félicitations !!!!!!! Mission réussie moussaillon !!", "coffreo.png");

    	stockiles.add(dcoffre);

    	spawn.ajouteSortie(Sortie.BOUTEILLE, b1);
    	spawn.ajouteSortie(Sortie.DEVANTFORET, devantf1);
    	
    	spawnv.ajouteSortie(Sortie.ILESAINTE, plagefullile2);
    	
    	b1.ajouteSortie(Sortie.RAMASSER, bvide);
    	
    	devantf1.ajouteSortie(Sortie.PLAGE, spawn);
    	devantf1.ajouteSortie(Sortie.BOUTEILLE, b1);
    	devantf1.ajouteSortie(Sortie.FORET, foretfull);
    	
    	bvide.ajouteSortie(Sortie.PLAGE, spawnv);
    	bvide.ajouteSortie(Sortie.DEVANTFORET, devantf2);
    	
    	devantf2.ajouteSortie(Sortie.PLAGE, spawnv);
    	devantf2.ajouteSortie(Sortie.FORET, foretfull);
 
    	foretfull.ajouteSortie(Sortie.COCO, devantcoco);
    	
    	devantbois.ajouteSortie(Sortie.FORET, foretfull);
    	devantbois.ajouteSortie(Sortie.RAMASSER, boisv);
    	
    	devantcoco.ajouteSortie(Sortie.RAMASSER, cocov);
    	
    	boisv.ajouteSortie(Sortie.FORET, foretsansbois);
    	
    	cocov.ajouteSortie(Sortie.BOIS, devantboissanscoco);
    	
    	foretsanscoco.ajouteSortie(Sortie.BOIS, devantboissanscoco);
    	
    	devantboissanscoco.ajouteSortie(Sortie.RAMASSER, devantboistoutvide);
    	
    	devantboistoutvide.ajouteSortie(Sortie.FORET, foretvide);
    	
    	foretvide.ajouteSortie(Sortie.DEVANTFORET, devantf22);
    	
    	devantf22.ajouteSortie(Sortie.PLAGE, spawnv);
    	
    	plagefullile2.ajouteSortie(Sortie.BOIS, devantbois2);
    	
    	devantbois2.ajouteSortie(Sortie.RAMASSER, devantbois2vide);
    	
    	devantbois2vide.ajouteSortie(Sortie.COCO, devantcoco2);
    	
    	devantcoco2.ajouteSortie(Sortie.RAMASSER, devantcoco2vide);
    	devantcoco2vide.ajouteSortie(Sortie.PLAGE, plage2vide);
    	devantcoco2vide.ajouteSortie(Sortie.DEVANTFORET, devantforetvide2);
    	
    	plage2vide.ajouteSortie(Sortie.ILEOBSC, devantf1);
    	plage2vide.ajouteSortie(Sortie.DEVANTFORET, devantforetvide2);
    
    	devantforetvide2.ajouteSortie(Sortie.FORET2, foretfull2);
    	
    	foretfull2.ajouteSortie(Sortie.BOUTEILLE, b2);
 	
    	b2.ajouteSortie(Sortie.RAMASSER, b2vide);
    	
    	b2vide.ajouteSortie(Sortie.BANANE, banane);
    	
    	banane.ajouteSortie(Sortie.RAMASSER, bananev);
    	
    	bananev.ajouteSortie(Sortie.FORET2, foretvide2);
    	
    	foretvide2.ajouteSortie(Sortie.DEVANTFORET, devantforet2);
    	
    	devantforet2.ajouteSortie(Sortie.PLAGE, plage2vide2);
    	
    	plage2vide2.ajouteSortie(Sortie.ILEOBSC, plage3);
    	
    	plage3.ajouteSortie(Sortie.COBRA, cobra);
    	plage3.ajouteSortie(Sortie.DEVANTFORET, devantforet3);
    	
    	devantforet3.ajouteSortie(Sortie.COBRA, cobra);
    	cobra.ajouteSortie(Sortie.DEVANTFORET, devantforet3);
    	
    	devantforet3.ajouteSortie(Sortie.FORET2, foretfull3);
    	
    	foretfull3.ajouteSortie(Sortie.BOUTEILLE, b3);
    	
    	b3.ajouteSortie(Sortie.RAMASSER, b3v);
    	
    	b3v.ajouteSortie(Sortie.ANANAS, ananas);
    	
    	ananas.ajouteSortie(Sortie.RAMASSER, ananasv);

    	ananasv.ajouteSortie(Sortie.BOIS, bois3);
    	
    	bois3.ajouteSortie(Sortie.RAMASSER, bois3v);
    	
    	bois3v.ajouteSortie(Sortie.FORET2, foret3vide);
    	
    	foret3vide.ajouteSortie(Sortie.DEVANTFORET, devantforet4);
    	
    	devantforet4.ajouteSortie(Sortie.PLAGE, plage4);
    	devantforet4.ajouteSortie(Sortie.COBRA, cobra2);
    	
    	cobra2.ajouteSortie(Sortie.COBRA, plage4);
    	
    	plage4.ajouteSortie(Sortie.COBRA, cobra2);
    	plage4.ajouteSortie(Sortie.ILEMIRAGE, plage5);
    	
    	plage5.ajouteSortie(Sortie.DEVANTGROTTE, devantgrotte);
    	
    	devantgrotte.ajouteSortie(Sortie.GROTTE, grotte);
    	
    	grotte.ajouteSortie(Sortie.AVANCER, agrotte);
    	
    	agrotte.ajouteSortie(Sortie.DEVANTCOFFRE, dcoffre);
    	
    	dcoffre.ajouteSortie(Sortie.COFFRE, coffreo);
    	
    	ZoneCourante = stockiles.get(0);
        
    }
    /**
     * affiche sa localisation 
     * 
     * */

    private void afficherLocalisation() {
            gui.afficher(ZoneCourante.descriptionLongue());
            gui.afficher();
    }
    /**
     * affiche le message de bienvenue et les insttructions
     * */

    private void afficherMessageDeBienvenue() {
    	gui.afficher("------------------------------------------------------------");
    	gui.afficher();
    	gui.afficher("   Bienvenue à toi dans cette chasse au trésor ! Pour trouver ce fameux trésor, il vous faudra naviguer d'îles en îles!");
    	gui.afficher();
    	gui.afficher("------------------------------------------------------------");
    	gui.afficher();
    	gui.afficher("   Vos missions sont les suivantes : trouver du bois pour construire le radeau, trouver le morceau de carte pour voir l'emplacement de l'île\n   suivante ainsi que de la nourriture pour ne pas mourrir de faim !");
    	gui.afficher();
    	gui.afficher("------------------------------------------------------------");
    	gui.afficher();
    	gui.afficher("   Vous avez  16 minutes pour trouver le trésor soit 1000 secondes !");
    	gui.afficher();
    	gui.afficher("------------------------------------------------------------");
    	gui.afficher();
        gui.afficher("   Tapez '?' pour obtenir de l'aide.");
        gui.afficher();
        gui.afficher("------------------------------------------------------------");
    	gui.afficher();
        afficherLocalisation();
    	gui.afficheImage(ZoneCourante.nomImage());
    }
    /**
     * permet de lire la commande tapée 
     * @param commandeLue la commande lue 
     * */
    
    public void traiterCommande(String commandeLue) {
    	gui.afficher( "> "+ commandeLue + "\n");
        switch (commandeLue.toUpperCase()) {
	        case "?" :
	            afficherAide(); 
	        	break;
	        case "BOUTEILLE" :
	        	allerEn( "BOUTEILLE"); 
	        	break;
	        case "RAMASSER" :
	        	ramasser(ZoneCourante);
	        	allerEn( "RAMASSER");
	        	break;
	        case "DEVANTFORET" :
	        	allerEn("DEVANTFORET"); 
	        	break;
	       case "BOIS":
	    	   ramasser(ZoneCourante);
	        	allerEn("BOIS"); 
	        	break;
	        case "COCO" :
	        	ramasser(ZoneCourante);
	        	allerEn("COCO"); 
	        	break;
	        case "BANANE" :
	        	ramasser(ZoneCourante);
	        	allerEn("BANANE");
	        	break;
	        case "ANANAS" :
	        	ramasser(ZoneCourante);
	        	allerEn("ANANAS");
	        	break;
	        case "QUITTER" :
	        	System.exit(0);
	        	break;
	        case "MANGER" :
	        	gui.manger();
	        	break;
	        case "FORET" :
	        	foret();
	        	break;
	        case "FORET2" :
	        	allerEn("FORET2");
	        	break;
	        case "PLAGE" :
	        	allerEn("PLAGE");
	        	break;
	        case "ILESAINTE" :
	        	ile2();
	        	break;
	        case "ILEOBSC" :
	        	ile3();
	        	break;
	        case "ILEMIRAGE" :
	        	ileFinale();
	        	break;
	        case "AVANCER" :
	        	allerEn("AVANCER");
	        	break;
	        case "DEVANTGROTTE" :
	        	allerEn("DEVANTGROTTE");
	        	break;
	        case "GROTTE" :
	        	allerEn("GROTTE");
	        	break;
	        case "DEVANTCOFFRE" :
	        	allerEn("DEVANTCOFFRE");        	
	        	break;
	        case "COFFRE" :
	        	allerEn("COFFRE");    
	        	coffreOuvert();
	        	break;
	        case "KILL" :
	        	gui.kill();	        	
	        	break;
	        case "CARTE" :
	        	carte();	        	
	        	break;
	        case "COBRA" :
	        	allerEn("COBRA");	
	        	cobra();
	        	break;
	       	default : 
	            gui.afficher("Commande inconnue");
	            break;
        }
    }
    /**
     *quand le coffret s'ouvrir et que le personnage gagne
     * */

    private void coffreOuvert() {
    	gui.titrefin.setText("Vous avez gagné, bravo !!!");
		gui.fin.setVisible(true);
		gui.timer.stop();
	}
    /**
     * affiche une aide quand il est perdu
     * 
     * */

	private void afficherAide() {
        gui.afficher("Etes-vous perdu ?");
        gui.afficher();
        gui.afficher("Les commandes autorisées sont :");
        gui.afficher();
        gui.afficher(Commande.toutesLesDescriptions().toString());
        gui.afficher();
    }
	/**
     * permet d'aller  à une autre direction
     *@param direction  la direction où on veut aller
     * */

    private void allerEn(String direction) {
    	Zone nouvelle = ZoneCourante.obtientSortie(direction);

    	if ( nouvelle == null ) {
        	gui.afficher( "Pas de sortie " + direction);
    		gui.afficher();
    	}
        else {
        	ZoneCourante = nouvelle;
        	gui.afficher(ZoneCourante.descriptionLongue());
        	gui.afficher();
        	gui.afficheImage(ZoneCourante.nomImage());
        }
    }
    
    /**
     * permet au personnage de rammasser 
     * @param z zone dans laquelle le personnage se trouve 
     * */
    
    public void ramasser(Zone z) {

    	switch (z.nomImage()) {
        case "b1.png" :
        	gui.actuInv(0, 0, 1);
        	break;
        case "devantbois.png" :
        	gui.actuInv(3, 0, 0);
        	break;
        case "devantcoco.png" :
        	gui.actuInv(0, 3, 0);
        	break;
        case "devantboissanscoco.png" :
        	gui.actuInv(3, 0, 0);
        	break;
        case "devantbois2.png" :
        	gui.actuInv(5, 0, 0);
        	break;
        case "devantcoco2.png" :
        	gui.actuInv(0, 2, 0);
        	break;
        case "b2.png" :
        	gui.actuInv(0, 0, 1);
        	break;
        case "banane.png" :
        	gui.actuInv(0, 3, 0);
        	break;
        case "b3.png" :
        	gui.actuInv(0, 0, 1);
        	break;
        case "ananas.png" :
        	gui.actuInv(0, 2, 0);
        	break;
        case "bois3.png" :
        	gui.actuInv(7, 0, 0);
        	break;
        case "KILL" :
            gui.kill();
            break;
    }
    	
    }
    /**
     * peremt d'aller à  l'île  2
     * */
   
    public void ile2()
    {
    	if (gui.getNbbois() == 3 && gui.getNbmrc2carte() == 1)
    	{
    		gui.afficher("   Félicitations !! Vous avez trouvé de quoi faire un radeau ainsi que le morceau de carte\n");
    		gui.afficher("   Direction l'île Sainte moussailon !\n");
    		allerEn("ILESAINTE");
    		gui.actuInv(-3, 0, 0);
    	}
    	else
    	{
    		gui.afficher("   Pour pouvoir changer d'île il vous faut impérativement le morceau de carte et du bois !");
    	}
    }
    /**
     * peremt d'aller à  l'île  3
     * */
    
    public void ile3()
    {
    	if (gui.getNbbois() == 5 && gui.getNbmrc2carte() == 2)
    	{
    		gui.afficher("   Félicitations !! Vous avez trouvé de quoi améliorer le radeau ainsi que le morceau de carte\n");
    		gui.afficher("   Direction l'île Obscure...\n");
    		allerEn("ILEOBSC");
    		gui.actuInv(-5, 0, 0);
    	}
    	else
    	{
    		gui.afficher("   Sans le second morceau de carte ça me paraît compliquer de savoir où se trouve la prochaine île..:.");
    	}
    }
    /**
     * peremt d'aller à  l'île Finale 
     * */

    public void ileFinale()
    {
    	if (gui.getNbbois() == 7 && gui.getNbmrc2carte() == 3)
    	{
    		gui.afficher("   Félicitations !! Vous avez trouvé de quoi améliorer le radeau ainsi que le morceau de carte\n");
    		gui.afficher("   Direction l'île Obscure...\n");
    		allerEn("ILEMIRAGE");
    		gui.actuInv(-7, 0, 0);
    	}
    	else
    	{
    		gui.afficher("   Sans le dernier morceau de carte ça me paraît compliquer de savoir où se trouve la prochaine île...");
    	}
    }
    /**
     * permet d'aller dans  la forêt 
     * */

	public void foret()
	{
		if (gui.getNbmrc2carte() == 1)
		{
			allerEn("FORET");
		}
		
		else
		{
			gui.afficher("   Faisons les choses dans l'ordre, ramassez le morceau de carte avant d'aller dans la forêt");
		}
			
	}
	/**
	 * gére les morceaux de  carte 
	 * */
	
	public void carte()
	{
		 if (gui.getNbmrc2carte() == 1)
		{
			gui.afficheImage("mrc1.png");
		}
		else if (gui.getNbmrc2carte() == 2)
		{
			gui.afficheImage("mrc2.png");
		}
		else if (gui.getNbmrc2carte() == 3)
		{
			gui.afficheImage("mrc3.png");
		}
		else
		{
			gui.afficher("Aucun morceau de carte à afficher");
		}
			 
	}
	/**
	 * ça permet au personnage de perdre de la vie quand il s'approche du serpent  
	 * */
	
	 private void cobra() {
	        Runnable task = new Runnable() {
	            @Override
	            public void run() {
	                if(ZoneCourante.nomImage().equals("cobra.png")){
	                    gui.enleverVie(20);
	                     if(gui.barredevie.getValue() == 0)
	                    {
	                    	 gui.titrefin.setText("Perdu ! Vous n'avez plus de vie...");
	                    	 gui.fin.setVisible(true);
	                    }
	                }
	                else {
	                    return;
	                }
	            }
	        };
	        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
	    }
}
