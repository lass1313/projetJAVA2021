package jeu;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 * @author Lorris, Anthony, Lassana, Youssef
 * @version 2
 */

public class GUI implements ActionListener{
    private Jeu jeu;
    private JFrame debut;
    private JFrame fenetre;
    private JTextField entree;
    private JLabel inventaire = new JLabel();
    private JTextArea texte;
    private JLabel image;
    public JProgressBar barredevie;
    public JLabel textebarre;
    public int nbmrc2carte = 0;
    public int nbNourriture = 0;
    public int nbBois = 0;
    private String i = "<center>" + "Inventaire" + "<br>" + "<hr>";
    private String bois = "<br/>" + "Bois : ";
    private String coco = "<br/>" + "Nourriture : ";
    private String carte = "<br/>" + "Morceau de carte : ";
    public Timer timer;
    public JLabel titrefin;
    public JFrame fin;

    public GUI(Jeu j) {
        jeu = j;
        creerGUI();
    }
    /**
     * elle permet d'afficher dans la console 
     * @param s la variable à afficher 
     * */
   
	public void afficher(String s) {
        texte.append(s);
        texte.setCaretPosition(texte.getDocument().getLength());
    }
    
    public void afficher() {
        afficher("\n");
    }
    /**
     * affiche l'image 
     *@param nomImage le nom de l'image à afficher 
     * */
    
    public void afficheImage(String nomImage) {
	   	URL imageURL = this.getClass().getClassLoader().getResource("images/"+nomImage);
	   	if(imageURL != null) {
        	image.setIcon(new ImageIcon(imageURL));         
            
        }else {
        	image.setText("ERREUR IMAGE");
        }
    }
    /**
     * 
     * */
    
    public void enable(boolean ok) {
        entree.setEditable(ok);
        if ( ! ok )
            entree.getCaret().setBlinkRate(0);
    }
    /**
     * 
     * */

    public void actionPerformed(ActionEvent e) {
        executerCommande();
    }
    /**
     * exécute la commande lue 
     * */

    private void executerCommande() {
        String commandeLue = entree.getText();
        entree.setText("");
        jeu.traiterCommande( commandeLue);
    }
    /**
     * Création des éléments graphiques
     */
    public void creerGUI() {
    	
    	//Fenetre de début
        debut = new JFrame("The Lost Treasure");
        JButton buttonjouer = new JButton("Jouer");
        JLabel titrejouer = new JLabel("The Lost Treasure");
        JLabel imagedebut = new JLabel();
        JPanel paneldebut = new JPanel();
        Image img = new ImageIcon(this.getClass().getResource("../images/icon.png")).getImage();
        
        //Fenetre de jeu
        fenetre = new JFrame("The Lost Treasure");
        entree = new JTextField(34);
        texte = new JTextArea();
        barredevie = new JProgressBar();
        textebarre = new JLabel();
        JScrollPane listScroller = new JScrollPane(texte);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        image = new JLabel();
        Tester Chrono = new Tester();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        //Fin de jeu
        fin = new JFrame("The Lost Treasure");
        JButton buttonQuitter = new JButton("Quitter vers le bureau");
        titrefin = new JLabel("Gagné ! " + Chrono.LabelChrono.getText());
        JPanel panelfin = new JPanel();
        JPanel videfin = new JPanel();
        
        
        //Frame de jeu
        inventaire.setText("<html>" + i + bois + 0 + coco + 0 + carte + 0 + "</html>");
        inventaire.setVerticalAlignment(SwingConstants.TOP);
        inventaire.setHorizontalAlignment(SwingConstants.CENTER);
        inventaire.setFont(new java.awt.Font("Bolt", 1, 14));
        inventaire.setPreferredSize(new Dimension(252,40));
        inventaire.setMaximumSize(new Dimension(200,40));
        
        textebarre.setText("Barre de vie");
	    textebarre.setFont(new java.awt.Font("Bolt", 1, 14));
        textebarre.setHorizontalAlignment(SwingConstants.CENTER);
        textebarre.setForeground(Color.BLACK);
        
        barredevie.setOrientation(0);
        barredevie.setValue(70);
   	 	barredevie.setForeground(Color.RED);
   	 	
   	 	titrejouer.setFont(new java.awt.Font("Trebuchet MS", 3, 40));
   	 	
   	 	imagedebut.setIcon(new ImageIcon(getClass().getResource("../images/wait.png")));
   	 
        texte.setEditable(false);
        
        listScroller.setPreferredSize(new Dimension(500, 200));
        listScroller.setMinimumSize(new Dimension(150,50));
        
        panel.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel.setBorder(border);
        panel2.setBorder(border);
        
        barredevie.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
        image.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
        
        listScroller.setBorder(border);
        
        /**
         * ajout de la scrollbar et des boutons pour listScroller
         */
        listScroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {   
        	@Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.BLACK;
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }
            @Override    
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
            /***/
            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        });
        
        /**
         * panel contenant le @param panel2
         * @param image l'image actuelle du jeu au centre
         * @param listScroller la listScroller avec toutes les informations de chat
         * @param inventaire l'inventaire en bas à droite avec tous les items du joueur
         * @param entree la barre de saisie de commandes
         */
        panel.add(panel2,BorderLayout.NORTH);
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(inventaire, BorderLayout.EAST);
        panel.add(entree, BorderLayout.SOUTH);
        
        /**
         * @param Chrono txtField contenant le chronomètre de durée de jeu
         * @param barredevie la barre de vie du joueur
         * @param textebarre titre de la barre de vie
         */
        panel2.add(Chrono,BorderLayout.NORTH);
        panel2.add(barredevie,BorderLayout.SOUTH);
        panel2.add(textebarre,BorderLayout.CENTER);
        
        /**
         * @param panel ajout du panel 1 au centre de la fenetre
         * @param panel2 ajout du panel 2 au nord de la fenetre
         */
        fenetre.getContentPane().add(panel, BorderLayout.CENTER);
        fenetre.getContentPane().add(panel2, BorderLayout.NORTH);
        
        fenetre.setPreferredSize(new Dimension(1215,1020));
        fenetre.pack();
        fenetre.setIconImage(img);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        
        entree.addActionListener((ActionListener) this);

        //Frame de début
        buttonjouer.setBackground(Color.ORANGE);
        buttonjouer.setFont(new java.awt.Font("Trebuchet MS", 3, 30));
        buttonjouer.setFocusPainted(false);
        buttonjouer.setPreferredSize(new Dimension(100, 50));
        buttonjouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.setVisible(true);
                debut.setVisible(false);
                timer.start();
            }
        });
        
        titrejouer.setHorizontalAlignment(SwingConstants.CENTER);
        
        paneldebut.setBackground(new java.awt.Color(205,90,40));
        paneldebut.add(titrejouer);
        
        debut.add(paneldebut,BorderLayout.NORTH);
        debut.add(imagedebut,BorderLayout.CENTER);
        debut.add(buttonjouer,BorderLayout.SOUTH);
        
        debut.setPreferredSize(new Dimension(1410,900));
        debut.pack();
        debut.setIconImage(img);
        debut.setLocationRelativeTo(null);
        debut.setVisible(true);
        debut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        debut.setResizable(false);
 
        //Frame de fin
        buttonQuitter.setBackground(Color.ORANGE);
        buttonQuitter.setFont(new java.awt.Font("Trebuchet MS", 3, 30));
        buttonQuitter.setFocusPainted(false);
        buttonQuitter.setPreferredSize(new Dimension(400, 40));
        buttonQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /*
         titrefin.setText("Gagné ! " + Chrono.LabelChrono.getText());
         titrefin.setForeground(Color.black);
         panelfin.setBackground(Color.white);
         videfin.setBackground(Color.white);
        */
        titrefin.setForeground(Color.white);
        titrefin.setFont(new java.awt.Font("Trebuchet MS", 3, 30));
        
        videfin.setPreferredSize(new Dimension(400,80));
        videfin.setBackground(Color.black);
        
        panelfin.add(titrefin,BorderLayout.NORTH);
        panelfin.add(videfin,BorderLayout.CENTER);
        panelfin.add(buttonQuitter,BorderLayout.SOUTH);
        panelfin.setBackground(Color.black);
        
        fin.setPreferredSize(new Dimension(550,230));
        fin.add(panelfin);
        fin.pack();
    	fin.setIconImage(img);
        fin.setLocationRelativeTo(null);
        fin.setVisible(false);
        fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fin.setResizable(false);
        
        entree.requestFocus();
    }
    
    
	@SuppressWarnings("serial")
	/**
	 * cette class permet d'afficher le chrono graphiquement 
	 * */
	
	public class Tester extends JPanel {
		public static final int TIMER_DELAY = 1000;
		private JLabel LabelChrono = new JLabel();
		public Tester() {
			add(LabelChrono);
			LabelChrono.setSize(303, 28);
			LabelChrono.setHorizontalAlignment(SwingConstants.CENTER);
			LabelChrono.setFont(new java.awt.Font("Trebuchet MS", 3, 22));
			Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
			LabelChrono.setBorder(border);
			   
			if (timer != null && timer.isRunning()) {
				return;
			}
			LabelChrono.setText("");
			timer = new Timer(TIMER_DELAY, new TimerListener());
		}
		/**
		 * cette class permet de compter le chrono
		 * */
	    
		public class TimerListener implements ActionListener {
			   
			private int counter = 0;

		    public int getCounter() {
				return counter;
			}
		    /**
		     * actualise la barre de vie 
		     * @pram e 
		     * */
			@Override
      		public void actionPerformed(ActionEvent e) {
		    	  
				int[] temps= {100,200,300,400,500,600,700,800,900,1000,1100,1200};
				  
				for (int i = 0; i<temps.length; i++) {
					textebarre.setText("Vie : "+barredevie.getValue()+"%");
					if(temps[i] == counter) {
						barredevie.setValue(barredevie.getValue()-10);
					}
				}
		    	
		    	if (barredevie.getValue() == 0) {
					textebarre.setText("Plus de vie");
					timer.stop();
		    	}
		    	
		    	LabelChrono.setOpaque(true); 
		        LabelChrono.setText("Temps : " + String.valueOf(counter) + " secondes");
		    	  
		    	counter++;

				if (counter >=0 && counter < 720) {
 		        	LabelChrono.setForeground(Color.BLACK);
		    	} else if (counter >=720 && counter < 840) {
    		        	LabelChrono.setForeground(Color.ORANGE);
    		        }else if(counter >= 840 && counter < 1000) {
    		        		LabelChrono.setForeground(Color.RED);
    		        	}else if (counter >= 1000) {
    		        		kill();
	    		        }
		    }
	   	}
    }
	/**
	 * actualise l'inventaire 
	 * @param  pnbBois le nombre de bois 
	 * @param pnbnouriture le nombre de nouriture 
	 * @param pnbmrc2carte le nombre de carte 
	 * */
    
	public void actuInv(int pnbBois, int pnbNourriture, int pnbmrc2carte) {
		this.nbBois += pnbBois;
		this.nbNourriture += pnbNourriture;
		this.nbmrc2carte += pnbmrc2carte;
			   
		inventaire.setText("<html>" + i + bois + nbBois + coco + nbNourriture + carte + nbmrc2carte + "</html>");
	}
	/**
     * peremt au personnage de pouvoir manger
     * */
	
    public void manger() {
       	if (barredevie.getValue() == 100) {
    		afficher("  Ton ventre est rempli !");
    	}else {
	    		barredevie.setValue(barredevie.getValue()+5);
	    		this.nbNourriture--;	
	    		inventaire.setText("<html>" + i + bois + nbBois + coco + nbNourriture + carte + nbmrc2carte + "</html>");
	    		}
    }
    /**
     * tue le personnage quand il a plus de vie 
     * */
    
    public void kill() {
        barredevie.setValue(0);
        timer.stop();
        textebarre.setText("Vie : 0%");
        titrefin.setText("Perdu ! Vous n'avez plus de vie...");
        entree.setEditable(false);
        fin.setVisible(true);
    }
    /**
     * Renvoie le nombre de carte 
     * @return le nombre de carte 
     * */

	public int getNbmrc2carte() {
		return nbmrc2carte;
	}

	public void setNbmrc2carte(int nbmrc2carte) {
		this.nbmrc2carte = nbmrc2carte;
	}
	/**
     * Renvoie le nombre de nourriture 
     * @return le nombre de nourriture 
     * */

	public int getnbNourriture() {
		return nbNourriture;
	}

	public void setnbNourriture(int nbNourriture) {
		this.nbNourriture = nbNourriture;
	}
	/**
     * Renvoie le nombre de bois
     * @return le nombre de bois
     * */

	public int getnbBois() {
		return nbBois;
	}

	public void setnbBois(int nbBois) {
		this.nbBois = nbBois;
	}
	/**
	 * cette class gère le son 
	 * */
	 public class Sound {
        private final AudioClip audioClip;  //le son créé depuis l'url
     
        public Sound() {
            URL url;
            url = Sound.class.getResource("../son/son.wav");
            audioClip = Applet.newAudioClip(url);
        }
        /**
         * permet de jouer le son 
         * */
        public void jouer() {
           audioClip.play();
        }
        /**
         * joue le son en boucle
         * */
        public void jouerEnBoucle() {
           audioClip.loop();
        }
        /**
         * arrête le son 
         * */
        public void arreter() {
            audioClip.stop();
        }
    }
	 /**
	  * elle permet de diminuer la barre de vie  
	  * @pram vie  la vie à enlever de la barre de vie 
	  * */
	 
	 public void enleverVie(int vie) {
	        barredevie.setValue(barredevie.getValue()-vie);
	    }
	 
}