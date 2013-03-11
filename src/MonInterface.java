import java.awt.*;       
import java.awt.event.*; 
import java.io.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.lang.String;
import java.util.ArrayList;
import java.util.Hashtable;


public class MonInterface extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel conteneurPrincipal;
		
	
	private JPanel design4_7;
	private JPanel designfichiers;
	private JPanel designconnexion;
	private JPanel designdownload;	
	private JPanel disignBrep_source;
	private JPanel disignTrep_source;
	private JPanel disign5_1;
	private Box disign5_3;
	private JPanel designBenregistrer;
		
	private JPanel conteneurNiv1_1;
	private JPanel conteneurNiv1_2;
	private JPanel conteneurNiv2_1;
	private JTabbedPane conteneurNiv2_2;
	private JPanel conteneurNiv2_3;
	private JPanel conteneurNiv2_4;
	private JPanel conteneurNiv2_5;
	private JPanel conteneurNiv3_1;
	private JPanel conteneurNiv3_2;
	private JPanel conteneurNiv3_3;
	private JPanel conteneurNiv3_4;
	private JPanel conteneurNiv3_5;
	private JPanel conteneurNiv3_6;
	private JPanel conteneurNiv3_7;
	private JPanel conteneurNiv4_1;
	private JPanel conteneurNiv4_2;
	private JPanel conteneurNiv4_3;
	private JPanel conteneurNiv4_4;
	private JPanel conteneurNiv4_5;
	private JPanel conteneurNiv4_6;
	private JPanel conteneurNiv4_7;
	private JPanel conteneurNiv4_8;
	private JPanel conteneurNiv5_1;
	private JPanel conteneurNiv5_2;
	private JPanel conteneurNiv5_3;
	private JPanel conteneurNiv5_4;
	private JPanel conteneurNiv5_5;
	private JPanel conteneurNiv5_6;
	private JPanel conteneurNiv5_7;
	private JPanel conteneurNiv5_8;
	private JPanel conteneurNiv6_1;
	private JPanel conteneurNiv6_2;
	private Box conteneurNiv6_3;
	private JPanel conteneurNiv6_4;
	private JPanel conteneurNiv6_5;
	private JPanel conteneurNiv7_1;
		

	//Permet de ràgler le nombre de derniers messages qui apparaitront dans la liste à droite
	private int n_derniers_messages = 18;
	private String chaine_affich;
	private String chaine_intelligence;
	private String chaine_etat_robot;
	//index du dernier message traité de la file Lanceur.filemessages permettant de relever seulement les 10 derniers messages
	private int premier_mess = 0;
	private int dernier_mess = 0;
	//date hors ligne en cours
	private int date_hl_encours;
	private MAJ_Interface maj_horsligne;

	//Zone de texte pour afficher les n derniers messages
	private JTextArea aff_derniers_mess;
	private JTextArea ordre_intel;
	private JTextArea etat_robot;

	private ArrayList<Message> filemessages;
	public static Fabrique fabrique;
	private Lanceur lanceur;
	private Client socketTCP;
	private ClientFTP ftp;
	private MAJ_Interface maj_interface;
	
	private JLabel aff_lieu, aff_date;
	
	private JButton download;
	private JButton connexion;
	private JButton connexion_deconnexion ,Benregistrer, Brep_source, MAJ_ports, Bsend;
	private JButton BLecture, BPause, BSuivant, BPrecedent;
	//private JButton BLecture2, BPause2, BSuivant2, BPrecedent2;
	
	private ButtonGroup groupe1;
	private JRadioButton tmpReel;
	private JRadioButton hrLigne;

	// #1 Dàclarations pour les capteurs
    private JProgressBar tele_laz = new JProgressBar(0,50);
    private JProgressBar son_av1 = new JProgressBar(0,50);
    private JProgressBar son_av2 = new JProgressBar(0,50);
    private JLabel pcapt_coul = new JLabel();
    private JLabel psonar_ar_1 = new JLabel();
    private JLabel psonar_ar_2 = new JLabel();
    private JLabel pcapt1 = new JLabel();
    private JLabel pcapt2 = new JLabel();
    private JLabel pcapt3 = new JLabel();
    private JLabel pcapt4 = new JLabel();
    private JLabel pcapt_lame_1 = new JLabel();
    private JLabel pcapt_lame_2 = new JLabel();
    private JLabel pcapt_distrib = new JLabel();
    //image pour ON/OFF des capteurs
    ImageIcon ON = new ImageIcon("Images/mini_smiley_vert.png");
    ImageIcon OFF = new ImageIcon("Images/smiley_rouge.png");
    
    private JFileChooser rep_source = new JFileChooser();

    private JFileChooser enregistrer = new JFileChooser();
    
    private JLabel Trep_source;
    private JLabel Trep_ip2;
    private JLabel Trep_ip;
    private JTextField Date, Lieu, send;
    
	private ImageIcon robot = new ImageIcon("Images/robot3.png");
    private JLabel robot_lab = new JLabel(robot);
    
    private JLabel penregistrer = new JLabel(" ", JLabel.CENTER);
    
    private boolean vcapt_coul = true;
    private boolean vsonar_ar_1 = false;
    private boolean vsonar_ar_2 = true;
    private boolean vcapt1 = true;
    private boolean vcapt2 = true;
    private boolean vcapt3 = false;
    private boolean vcapt4 = true;
    private boolean vcapt_lame_1 = true;
    private boolean vcapt_lame_2 = false;
    private boolean vcapt_distrib = false;
    
    private boolean vconnexion_deconnexion = false;
    private boolean venregistrer = false;
    private JComboBox<String> fichiers;
    private JTextField ip;
    private JTextField ip2;
    
	private Table terrain;
   
    private JSlider slider;
    private JTextField val_S;
    private JTextField val_ms;
    
    private JLabel ms;
    private JLabel S;
    
	
	
	public MonInterface (Lanceur lanceur){
		
		this.lanceur = lanceur;
		
		conteneurNiv1_1 = new JPanel();
		conteneurNiv2_1 = new JPanel();
				conteneurNiv3_1 = new JPanel();
					conteneurNiv4_1 = new JPanel();
					conteneurNiv4_2 = new JPanel();
						disign5_1 = new JPanel();
						conteneurNiv5_1 = new JPanel();
							conteneurNiv6_4 = new JPanel();
							conteneurNiv6_5 = new JPanel();
								conteneurNiv5_2 = new JPanel();
								disign5_3 = Box.createHorizontalBox();
								conteneurNiv5_3 = new JPanel();
								conteneurNiv5_4 = new JPanel();
							conteneurNiv6_2 = new JPanel();
							conteneurNiv6_3 = Box.createHorizontalBox();
							designBenregistrer = new JPanel();
						conteneurNiv4_8 = new JPanel();
			conteneurNiv2_2 = new JTabbedPane();
				conteneurNiv3_2 = new JPanel();
					conteneurNiv4_3 = new JPanel();
						design4_7 = new JPanel();
						designfichiers = new JPanel();
						designconnexion = new JPanel();
						designdownload = new JPanel();
						conteneurNiv4_7 = new JPanel();
					conteneurNiv4_4 = new JPanel();
						conteneurNiv5_5 = new JPanel();
							conteneurNiv6_1 = new JPanel();
							disignBrep_source = new JPanel();
								conteneurNiv7_1 = new JPanel();
								conteneurNiv5_6 = new JPanel();
								disignTrep_source = new JPanel();
							conteneurNiv5_7 = new JPanel();
							conteneurNiv5_8 = new JPanel();
				conteneurNiv3_7 = new JPanel();
				
		conteneurNiv2_3 = new JPanel();
			conteneurNiv3_3 = new JPanel();
			conteneurNiv3_4 = new JPanel();
		conteneurNiv2_4 = new JPanel();
			conteneurNiv3_5 = new JPanel();
				conteneurNiv4_5 = new JPanel();
				conteneurNiv4_6 = new JPanel();
			conteneurNiv3_6 = new JPanel();
	conteneurNiv1_2 = new JPanel();
		conteneurNiv2_5 = new JPanel();
	

	
	conteneurNiv1_1.setLayout(new BorderLayout());
		conteneurNiv2_1.setLayout(new BorderLayout());
		conteneurNiv2_1.setLayout(new GridLayout(1,2));
			conteneurNiv3_1.setLayout(new BorderLayout());
				conteneurNiv4_1.setLayout(new BorderLayout());
				conteneurNiv4_2.setLayout(new BorderLayout());
				conteneurNiv4_2.setLayout(new GridLayout(2,2));
					conteneurNiv5_1.setLayout(new BorderLayout());
						conteneurNiv6_5.setLayout(new BorderLayout());
						conteneurNiv6_4.setLayout(new BorderLayout());
							conteneurNiv5_2.setLayout(new BorderLayout());
							//disign5_3.setLayout(new BoxLayout(connexion_deconnexion, ));
							conteneurNiv5_3.setLayout(new BorderLayout());
							conteneurNiv5_4.setLayout(new BorderLayout());				
						conteneurNiv6_2.setLayout(new BorderLayout());
						//conteneurNiv6_3.setLayout(new BorderLayout());
						designBenregistrer.setLayout(new FlowLayout());
				conteneurNiv4_8.setLayout(new BorderLayout());
			conteneurNiv3_2.setLayout(new BorderLayout());
				conteneurNiv4_3.setLayout(new GridLayout(2,2));
					design4_7.setLayout(new FlowLayout());
					designfichiers.setLayout(new FlowLayout());
					designconnexion.setLayout(new FlowLayout());
					designdownload.setLayout(new FlowLayout());
					conteneurNiv4_7.setLayout(new BorderLayout());
					conteneurNiv4_4.setLayout(new GridLayout(3,1));
						conteneurNiv5_5.setLayout(new BorderLayout());
							conteneurNiv6_1.setLayout(new BorderLayout());
							conteneurNiv6_1.setLayout(new GridLayout(1,2));
							disignBrep_source.setLayout(new FlowLayout());
								conteneurNiv7_1.setLayout(new BorderLayout());
			conteneurNiv3_7.setLayout(new BorderLayout());
			
					conteneurNiv5_6.setLayout(new BorderLayout());
					conteneurNiv5_7.setLayout(new GridLayout(1,4));
					conteneurNiv5_8.setLayout(new BorderLayout());
		conteneurNiv2_3.setLayout(new BorderLayout());
			conteneurNiv3_3.setLayout(new BorderLayout());
			
			// #2 MODIFIER ICI LE GRIDLAYOUT POUR LA LISTE DES CAPTEURS
			conteneurNiv3_3.setLayout(new GridLayout(13,2));
			
			conteneurNiv3_4.setLayout(new BorderLayout());
		conteneurNiv2_4.setLayout(new BorderLayout());
			conteneurNiv3_5.setLayout(new BorderLayout());
			conteneurNiv3_5.setLayout(new GridLayout(1,2));				
				conteneurNiv4_5.setLayout(new BorderLayout());
				conteneurNiv4_6.setLayout(new BorderLayout());
			conteneurNiv3_6.setLayout(new BorderLayout());
	conteneurNiv1_2.setLayout(new GridLayout(2,1));
		conteneurNiv2_5.setLayout(new GridLayout(2,1));

		groupe1 = new ButtonGroup();
		tmpReel = new JRadioButton("Espionnage Temps Réel", true);
		hrLigne = new JRadioButton("Espionnage Hors Ligne");	
		
		download = new JButton ("Download");
		connexion = new JButton ("Connexion");
		connexion_deconnexion = new JButton ("Connexion");
		Benregistrer = new JButton("Enregistrer");
		Bsend = new JButton("SEND");			
		
		new JButton ("Charger");
		new JButton ("Parcourir");
		Brep_source = new JButton ("Charger fichier");
		
		rep_source.setFileFilter(new FileNameExtensionFilter("Fichier XML", "xml"));
		enregistrer.setFileFilter(new FileNameExtensionFilter("Fichier XML", "xml"));
		
		MAJ_ports = new JButton(new ImageIcon("Images/refresh_icon.png"));
		
		BLecture = new JButton(new ImageIcon("Images/bouton lecture.png"));
		BPause = new JButton(new ImageIcon("Images/bouton pause.png"));
		BSuivant = new JButton(new ImageIcon("Images/bouton suivant.png"));
		BPrecedent = new JButton(new ImageIcon("Images/bouton précédent.png"));
				
		
		fichiers = new JComboBox<String>();
		fichiers.addItem("sélectionner fichier");
		ip = new JTextField("192.168.1.129");
		ip2 = new JTextField("192.168.1.129");
		//lister_ports();
		
		
		aff_date = new JLabel("Affichage de la date");
		aff_lieu = new JLabel("Affichage du lieu");
		
		groupe1.add(tmpReel);
		groupe1.add(hrLigne);
		

		
		
		Trep_source = new JLabel("Fichier à charger");
		Trep_ip2 = new JLabel("@ip");
		Trep_ip = new JLabel("@ip");
		
		Date = new JTextField("Date");
		Lieu = new JTextField("Lieu");		
		send = new JTextField();
		
		ms = new JLabel("ms");
		S = new JLabel("S");
		
		val_S = new JTextField("00");
		val_ms = new JTextField("000");
		
		tele_laz.setForeground(Color.yellow);
		son_av1.setForeground(Color.yellow);
		son_av2.setForeground(Color.yellow);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// #4 Modification du titre de la fenàtre
		this.setTitle("Espion CAN Raspberry PI");
		this.setBounds(10,40,1125,700);
        
		conteneurPrincipal = (JPanel) getContentPane();					
		
		conteneurPrincipal.add(conteneurNiv1_1, BorderLayout.CENTER);				
			
			conteneurNiv1_1.add(conteneurNiv2_1, BorderLayout.NORTH);
													
				conteneurNiv2_1.add(conteneurNiv3_1, BorderLayout.WEST);
				TitledBorder panneau_controle;
				panneau_controle = BorderFactory.createTitledBorder("Panneau de controle");
				conteneurNiv2_1.setBorder(panneau_controle);
																
					conteneurNiv3_1.add(conteneurNiv4_1, BorderLayout.NORTH);
					//TitledBorder temps_reel;
					//temps_reel = BorderFactory.createTitledBorder("Espionnage en Temps Réel");
					//conteneurNiv3_1.setBorder(temps_reel);
						conteneurNiv4_1.add(tmpReel);
						
																	
					conteneurNiv3_1.add(conteneurNiv4_2, BorderLayout.CENTER);						
				    
				    	conteneurNiv4_2.add(disign5_1);
				    		disign5_1.add(conteneurNiv5_1);
				    			conteneurNiv5_1.add(conteneurNiv6_5, BorderLayout.WEST);
				    			conteneurNiv5_1.add(conteneurNiv6_4, BorderLayout.CENTER);
				    				conteneurNiv6_5.add(Trep_ip, BorderLayout.CENTER);
				    				conteneurNiv6_4.add(ip, BorderLayout.CENTER);
				    		
				    	conteneurNiv4_2.add(conteneurNiv5_2);				   		
				   		
				   			conteneurNiv5_2.add(Date, BorderLayout.NORTH);
				   			conteneurNiv5_2.add(Lieu, BorderLayout.SOUTH);
				   	
				   		conteneurNiv4_2.add(conteneurNiv5_3);
				   			conteneurNiv5_3.add(disign5_3, BorderLayout.CENTER);
				   			disign5_3.add(connexion_deconnexion);
			    	
					   		conteneurNiv4_2.add(conteneurNiv5_4);  
				   			conteneurNiv5_4.add(conteneurNiv6_2, BorderLayout.WEST);
				   			penregistrer.setIcon(new ImageIcon("Images/carre_noire.png"));
				   			conteneurNiv5_4.add(conteneurNiv6_3, BorderLayout.CENTER);
				   				conteneurNiv6_2.add(penregistrer, BorderLayout.CENTER);
				   				conteneurNiv6_3.add(Benregistrer);
				   					//designBenregistrer.add(Benregistrer);
				   				
				   	conteneurNiv3_1.add(conteneurNiv4_8, BorderLayout.SOUTH);	
				   		conteneurNiv4_8.add(send, BorderLayout.CENTER);
				   		conteneurNiv4_8.add(Bsend, BorderLayout.EAST);
				   	
				   
				   	/*conteneurNiv3_2.add(conteneurNiv4_3, BorderLayout.NORTH);
				   	TitledBorder enregistre;
				   	enregistre = BorderFactory.createTitledBorder("Espionnage Enregistré");
					conteneurNiv3_2.setBorder(enregistre);
						conteneurNiv4_3.add(hrLigne);*/
				   	
				   	conteneurNiv3_2.add(conteneurNiv4_4, BorderLayout.CENTER);						
						    
				    	conteneurNiv4_4.add(conteneurNiv5_5);
				    		conteneurNiv5_5.add(conteneurNiv6_1, BorderLayout.CENTER);
				    			conteneurNiv6_1.add(disignBrep_source);
				    				disignBrep_source.add(Brep_source);
				    			
				    			conteneurNiv6_1.add(conteneurNiv7_1, BorderLayout.CENTER);
				    				conteneurNiv7_1.add(aff_date, BorderLayout.NORTH);
				    				conteneurNiv7_1.add(aff_lieu, BorderLayout.SOUTH);
					    
				    	conteneurNiv4_4.add(conteneurNiv5_6);				   		
				    		conteneurNiv5_6.add(disignTrep_source, BorderLayout.WEST);
				    			disignTrep_source.add(Trep_source);
				    		
				    		
				    conteneurNiv3_7.add(conteneurNiv4_3, BorderLayout.CENTER);
				    
				    conteneurNiv4_3.add(design4_7);
				    	design4_7.add(conteneurNiv4_7);
				    	conteneurNiv4_7.add(Trep_ip2, BorderLayout.WEST);
				    	conteneurNiv4_7.add(ip2, BorderLayout.CENTER);
				    						    	
				    conteneurNiv4_3.add(designfichiers);
				    	designfichiers.add(fichiers);
				    	
				    conteneurNiv4_3.add(designconnexion);
				    	designconnexion.add(connexion);
				    
				    conteneurNiv4_3.add(designdownload);
				    	designdownload.add(download);
				    		
				   
				    conteneurNiv2_2.addTab("Horsligne", conteneurNiv3_2); 
				    conteneurNiv2_2.addTab("Rasberry-Pi", conteneurNiv3_7); 
				    conteneurNiv5_8.add(hrLigne, BorderLayout.NORTH);
				    conteneurNiv5_8.add(conteneurNiv2_2, BorderLayout.CENTER);
		    		conteneurNiv5_8.add(conteneurNiv5_7, BorderLayout.SOUTH);
		    			conteneurNiv5_7.add(BPrecedent);
		    			conteneurNiv5_7.add(BLecture);
		    			conteneurNiv5_7.add(BPause);		    		
		    			conteneurNiv5_7.add(BSuivant );
				    conteneurNiv2_1.add(conteneurNiv5_8, BorderLayout.EAST);
				    
			conteneurNiv1_1.add(conteneurNiv2_3, BorderLayout.WEST);
				
				conteneurNiv2_3.add(conteneurNiv3_3, BorderLayout.CENTER);
				
						// #3 AJOUTER ICI CHAQUE CAPTEUR AU CONTENEUR 3_3
					
						conteneurNiv3_3.add(new JLabel ("Télémétre Laser"));
						conteneurNiv3_3.add(tele_laz);
						conteneurNiv3_3.add(new JLabel ("Sonar avant 1"));
						conteneurNiv3_3.add(son_av1);
						conteneurNiv3_3.add(new JLabel ("Sonar avant 2"));
						conteneurNiv3_3.add(son_av2);
						conteneurNiv3_3.add(new JLabel ("Capteur de couleurs"));
						conteneurNiv3_3.add(pcapt_coul, BorderLayout.CENTER);		
						conteneurNiv3_3.add(new JLabel ("Sonar arrière 1"));
						conteneurNiv3_3.add(psonar_ar_1, BorderLayout.CENTER);
						conteneurNiv3_3.add(new JLabel ("Sonar arrière 2"));
						conteneurNiv3_3.add(psonar_ar_2);
						conteneurNiv3_3.add(new JLabel ("Capteur 1"));
						conteneurNiv3_3.add(pcapt1);
						conteneurNiv3_3.add(new JLabel ("Capteur 2"));
						conteneurNiv3_3.add(pcapt2);
						conteneurNiv3_3.add(new JLabel ("Capteur 3"));
						conteneurNiv3_3.add(pcapt3);
						conteneurNiv3_3.add(new JLabel ("Capteur 4"));
						conteneurNiv3_3.add(pcapt4);
						conteneurNiv3_3.add(new JLabel ("Capteur à lame 1"));
						conteneurNiv3_3.add(pcapt_lame_1);
						conteneurNiv3_3.add(new JLabel ("Capteur à lame 2"));
						conteneurNiv3_3.add(pcapt_lame_2);
						conteneurNiv3_3.add(new JLabel ("Capteur de distributeur"));
						conteneurNiv3_3.add(pcapt_distrib);
						TitledBorder etat_capt;
						etat_capt = BorderFactory.createTitledBorder("Etat des Capteurs");
						conteneurNiv3_3.setBorder(etat_capt);
						
						
					conteneurNiv2_3.add(conteneurNiv3_4, BorderLayout.SOUTH);
					robot_lab.setSize(conteneurNiv3_4.getWidth(),conteneurNiv3_4.getHeight());
					conteneurNiv3_4.add(robot_lab, BorderLayout.CENTER);

					
					terrain = new Table("Images/terrain.png");
					
					conteneurNiv1_1.add(terrain);
					val_S = new JTextField("00");
					val_ms = new JTextField("000");

						 val_S.addKeyListener(new java.awt.event.KeyAdapter() {   
							   public void keyTyped(java.awt.event.KeyEvent e) {    
								   if (e.getKeyChar() == 10){
									   slider.setValue((Integer.decode(val_S.getText())*1000) + (Integer.decode(val_ms.getText()) ));
									   //gére l'affichage dans le cas ou on est en mode hors ligne
									   afficher_horsligne(false, slider.getValue());
								   }
							   }
							});
						 val_ms.addKeyListener(new java.awt.event.KeyAdapter() {   
							   public void keyTyped(java.awt.event.KeyEvent e) {    
								   if (e.getKeyChar() == 10){
									   slider.setValue((Integer.decode(val_S.getText())*1000) + (Integer.decode(val_ms.getText()) ));
									   //gére l'affichage dans le cas ou on est en mode hors ligne
									   afficher_horsligne(false, slider.getValue());
								   }
							   }
							});
							conteneurNiv1_1.add(conteneurNiv2_4, BorderLayout.SOUTH);
							conteneurNiv2_4.add(conteneurNiv3_5, BorderLayout.WEST);
								conteneurNiv3_5.add(conteneurNiv4_5);
									conteneurNiv4_5.add(val_S, BorderLayout.CENTER);
									conteneurNiv4_5.add(S, BorderLayout.EAST);
								conteneurNiv3_5.add(conteneurNiv4_6);				
									conteneurNiv4_6.add(val_ms, BorderLayout.CENTER);
									conteneurNiv4_6.add(ms, BorderLayout.EAST);
									
							conteneurNiv2_4.add(conteneurNiv3_6, BorderLayout.CENTER);

						
						final int slide_MIN = 0;
						final int slide_MAX = 90000;
						final int slide_INIT = 0;
						
						slider = new JSlider(JSlider.HORIZONTAL, slide_MIN, slide_MAX, slide_INIT);
						slider.setMajorTickSpacing(10000);
						slider.setMinorTickSpacing(1000);
						slider.setPaintTicks(true);
						slider.setPaintLabels(true);
						
						//permet de redefinir l'affichage par dàfaut du slider, afin d'avoir l'echelle en secondes
						Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
						labelTable.put(new Integer(0), new JLabel("0"));
						labelTable.put(new Integer(10000), new JLabel("10"));
						labelTable.put(new Integer(20000), new JLabel("20"));
						labelTable.put(new Integer(30000), new JLabel("30"));
						labelTable.put(new Integer(40000), new JLabel("40"));
						labelTable.put(new Integer(50000), new JLabel("50"));
						labelTable.put(new Integer(60000), new JLabel("60"));
						labelTable.put(new Integer(70000), new JLabel("70"));
						labelTable.put(new Integer(80000), new JLabel("80"));
						labelTable.put(new Integer(90000), new JLabel("90"));
						
						slider.setLabelTable(labelTable);
						slider.setPaintLabels(true);
						conteneurNiv3_6.add(slider);
			conteneurPrincipal.add(conteneurNiv1_2, BorderLayout.EAST);
			
		
			
		aff_derniers_mess = new JTextArea(20,15);
		ordre_intel = new JTextArea(10,15);
		etat_robot = new JTextArea(10,15);

		conteneurNiv1_2.add(aff_derniers_mess);
			TitledBorder der_mess;
			der_mess = BorderFactory.createTitledBorder("Derniers messages");
			aff_derniers_mess.setBorder(der_mess);
		conteneurNiv1_2.add(conteneurNiv2_5);
			conteneurNiv2_5.add(ordre_intel);
				TitledBorder ordre_inteli;
				ordre_inteli = BorderFactory.createTitledBorder("Ordres intelligence");
				ordre_intel.setBorder(ordre_inteli);
			conteneurNiv2_5.add(etat_robot);
				TitledBorder et_rob;
				et_rob = BorderFactory.createTitledBorder("Etat du robot");
				etat_robot.setBorder(et_rob);
	
		//ajouts des bouttons aux diffàrents listeners
		Brep_source.addActionListener(this);
		Benregistrer.addActionListener(this);
		connexion_deconnexion.addActionListener(this);
		slider.addMouseListener(this);
		tmpReel.addActionListener(this);
		hrLigne.addActionListener(this);
		MAJ_ports.addActionListener(this);
		BLecture.addActionListener(this);
		BPause.addActionListener(this);
		BSuivant.addActionListener(this);
		BPrecedent.addActionListener(this);
		connexion.addActionListener(this);
		Bsend.addActionListener(this);
		download.addActionListener(this);
		fichiers.addActionListener(this);

		//appel de la fonction au démarage pour que le le temps réel soit activé
		tempsreel_active();

	}

	//actionPerformed detectant les evenements sur les bouttons
	public void actionPerformed(ActionEvent event) {		
		//si on a appuyà sur le boutton "charger fichier"
		if(event.getSource() == Brep_source){
		    
		    
			filemessages = new ArrayList<Message>();
			int returnVal = rep_source.showOpenDialog(null); //affiche la boite de dialogue
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = rep_source.getSelectedFile();
	            Trep_source.setText(file.getName());
	            
	            try {
				
					filemessages = new ArrayList<Message>();
		            
					ParseXML monFichier = new ParseXML(file.getAbsolutePath(), true);
				
					fabrique = new Fabrique(filemessages);
					fabrique.creer_message(monFichier);
					
					afficher_horsligne(false, 0);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} 			
			}
		}
							
		
		//si on a appuyà sur le boutton "Connexion/Deconnexion"
		if(event.getSource()== connexion_deconnexion){
			vconnexion_deconnexion = !vconnexion_deconnexion;
			
			if(vconnexion_deconnexion == true){
				connexion_deconnexion.setText("Déconnexion");
				filemessages = new ArrayList<Message>();
				fabrique = new Fabrique(filemessages);
		    	socketTCP = new Client();
		    	//instanciation de MAJ_Interface en mode temps_réel (true)
		    	maj_interface = new MAJ_Interface(this, filemessages, true);
				
			}else{
				connexion_deconnexion.setText("Connexion");
		    	penregistrer.setIcon(new ImageIcon("Images/carre_noire.png"));
				new SendTCP(socketTCP.getSocket(), "stop");
				maj_interface.close();
		    	socketTCP.closeSocket();
			}
		}
		
		//si on a appuyà sur le boutton radio "Temps Réel"
		if(event.getSource() == tmpReel){
			tempsreel_active();
			lanceur.tempsreel=true;
			
			if(maj_horsligne != null) {
				maj_horsligne.close();
			}
		}
		
		//si on a appuyà sur le boutton radio "Hors Ligne"
		if(event.getSource() == hrLigne){
			horsligne_active();
			if(vconnexion_deconnexion == true){
				penregistrer.setIcon(new ImageIcon("Images/carre_noire.png"));
				lanceur.tempsreel=false;
			}
		}
		
		if(event.getSource() == BLecture){
			//MAJ_Interface(MonInterface vue1, ArrayList<Message> filemessages, boolean temps_reel)
			if(filemessages != null) {
				if (filemessages.size() != 0) {
					maj_horsligne = new MAJ_Interface(this, null, false);
					BLecture.setEnabled(false);
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Il n'y a rien à lire !\nFaire une acquisition ou charger un fichier XML");
			}
		}
		if(event.getSource() == BPause){
			if(maj_horsligne != null) {
				maj_horsligne.close();
				BLecture.setEnabled(true);
			}
		}
		
		if(event.getSource() == BSuivant){	
			if(filemessages != null) {
				if (filemessages.size() != 0) {
					//si le mode lecture est stoppé :
					if(BLecture.isEnabled() == true) {
						if(slider.getValue() <= 89900) {
						afficher_horsligne(true, 100);
						}
						else {
							afficher_horsligne(false, 90000);
						}
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Il n'y a rien à lire !\nFaire une acquisition ou charger un fichier csv");
			}
		}
		
		if(event.getSource() == BPrecedent){
			maj_pos_robot(1500, 1300, 45);
			if(filemessages != null) {
				if (filemessages.size() != 0) {
					//si le mode lecture est stoppé :
					if(BLecture.isEnabled() == true) {
						if (slider.getValue() >= 100) {
							afficher_horsligne(true, -100);
						}
						else {
							afficher_horsligne(false, 0);
						}	
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Il n'y a rien à lire !\nFaire une acquisition ou charger un fichier csv");
			}
		}
		if(event.getSource() == Benregistrer){
			venregistrer = !venregistrer;
			if(venregistrer){
				penregistrer.setIcon(new ImageIcon("Images/cercle_rouge.png"));
				new SendTCP(socketTCP.getSocket(), "enregistrer-test.xml");
			}
			if(!venregistrer){
				penregistrer.setIcon(new ImageIcon("Images/carre_noire.png"));
				new SendTCP(socketTCP.getSocket(), "stop");
			}
			
		}
		
		if(event.getSource() == connexion){
			//TODO
			String[] files;
			ftp = new ClientFTP(ip2.getText());
			files = ftp.browse();
			for(int i =0; i<files.length;i++){
				fichiers.addItem(files[i]);
			}
			
		}
		if(event.getSource() == download){
			if(fichiers.getSelectedItem().toString() != "sélectionner fichier" 
					&& ftp != null){
				//
				enregistrer.setSelectedFile(new File(fichiers.getSelectedItem().toString()));
				int returnVal = enregistrer.showSaveDialog(null); //affiche la boite de dialogue
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            try {
		            	ftp.downdload(enregistrer.getSelectedFile().toString(), fichiers.getSelectedItem().toString());
						
					} catch (Exception e) {
						e.printStackTrace();
					} 			
				}
			}
		}
		if(event.getSource() == fichiers){
			if(fichiers.getSelectedItem().toString() != "sélectionner fichier" 
					&& ftp != null){
				try {
					System.out.println("le fichier "+fichiers.getSelectedItem().toString()+" est chargé");
					filemessages = new ArrayList<Message>();
					fabrique = new Fabrique(filemessages);
					fabrique.decoderTrame(ftp.getMessages(fichiers.getSelectedItem().toString()));
					afficher_horsligne(false, 0);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		if(event.getSource() == Bsend){
			if(!send.getText().isEmpty()){
				new SendTCP(socketTCP.getSocket(), send.getText());
			}
		}
}

	//gere toute la mise à jour de l'interface
	//cette fonction est appellàe dans la classe MAJ_Interface
	public void maj() {
		System.out.println("MAJ DE L'INTERFACE");
		
		int i;
		
		//on remet à zàro chaque chaine d'affichage
		//chaine contenant tous les messages
		chaine_affich = "";
		//les messages venant de l'intelligence
		chaine_intelligence = "";
		//les messages allant dans "àtat robot", venant des cartes capteur et actionneur
		chaine_etat_robot = "";
		
		dernier_mess = filemessages.size();
		if (dernier_mess > n_derniers_messages) {
			premier_mess = dernier_mess -n_derniers_messages;
		}
		else {
			premier_mess = 0;
		}
		
		//MISE A JOUR DES VALEURS
		for (i = premier_mess; i<dernier_mess; i++) {
			// on met à jour les valeurs des capteurs
			// on met à jour les valeurs des chaines de caractàres
			affichage_messages(i);
		}
		
		//MISE A JOUR DE L'AFFICHAGE AVEC LES NOUVELLES VALEURS
		//mise a jour de la valeur du slider avec la date du dernier message reàu
		slider.setValue(filemessages.get(i-1).date);
		
		//on affiche toutes les chaines dans leur zone de texte
		aff_derniers_mess.setText(chaine_affich);
		ordre_intel.setText(chaine_intelligence);
		etat_robot.setText(chaine_etat_robot);
					
		//mise à jour de l'affichage des capteurs
		maj_capteurs();

	}
	
	
	//gere l'affichage et la maj de l'interface lorsque l'on est en mode hors ligne
	//SI ajouter == true : la date en cours va etre incràmentàe de la valeur de val_date
	//SI ajouter == false : la date en cours va prendre la valeur de val_date
	public void afficher_horsligne(boolean ajouter, int val_date) {
		int i,premier_message, dernier_message;
		
		if (ajouter==true) {
			date_hl_encours += val_date;
		}
		else {
			date_hl_encours = val_date;
		}
		
		slider.setValue(date_hl_encours);
		val_S.setText(Integer.toString(date_hl_encours/1000));
		val_ms.setText(Integer.toString(date_hl_encours%1000));
		val_S.setColumns(2);
		val_ms.setColumns(3);
		
		chaine_affich = "";
		chaine_intelligence = "";
		chaine_etat_robot = "";
		
		//si on est en mode hors_ligne, alors on peut chercher la date dans la liste des messages
		//Il faut verifier que la liste de message n'est pas vide 
		if (filemessages != null) {
			if ((hrLigne.isSelected() == true) && (filemessages.size() > 0)) {
				//on cherche dans un premier temps un index approximatif
				dernier_message = date_to_index(slider.getValue());
				
				if (dernier_message != -1){
					//lire ensuite les n derniers messages avant celui trouvé par date_to_index
					
					if (dernier_message < n_derniers_messages) {
						premier_message = 0;
					}
					else{
						premier_message = dernier_message - n_derniers_messages;
					}
					
					for (i=premier_message; i<=dernier_message; i++){
						 affichage_messages(i);
					}
				}
				aff_derniers_mess.setText(chaine_affich);
				ordre_intel.setText(chaine_intelligence);
				etat_robot.setText(chaine_etat_robot);
				
				//mise à jour de l'affichage des capteurs
				maj_capteurs();
			}
		}
	}
	
	// #4 fonction mettant à jour l'affichage des capteurs
	private void maj_capteurs() {
		
		tele_laz.setValue(40);
		son_av1.setValue(30);
		son_av2.setValue(10);
		
		if (vcapt_coul == true){
			 pcapt_coul.setIcon(ON);
		}else{
			pcapt_coul.setIcon(OFF);
		}
		
		if (vsonar_ar_1 == true){
			 psonar_ar_1.setIcon(ON);
		}else{
			psonar_ar_1.setIcon(OFF);
		}
		
		if (vsonar_ar_2 == true){
			 psonar_ar_2.setIcon(ON);
		}else{
			psonar_ar_2.setIcon(OFF);
		}
		
		if (vcapt1 == true){
			 pcapt1.setIcon(ON);
		}else{
			pcapt1.setIcon(OFF);
		}
		
		if (vcapt2 == true){
			 pcapt2.setIcon(ON);
		}else{
			pcapt2.setIcon(OFF);
		}
		
		if (vcapt3 == true){
			 pcapt3.setIcon(ON);
		}else{
			pcapt3.setIcon(OFF);
		}
		
		if (vcapt4 == true){
			 pcapt4.setIcon(ON);
		}else{
			pcapt4.setIcon(OFF);
		}
		
		if (vcapt_lame_1 == true){
			 pcapt_lame_1.setIcon(ON);
		}else{
			pcapt_lame_1.setIcon(OFF);
		}
		
		if (vcapt_lame_2 == true){
			 pcapt_lame_2.setIcon(ON);
		}else{
			pcapt_lame_2.setIcon(OFF);
		}
		
		if (vcapt_distrib == true){
			 pcapt_distrib.setIcon(ON);
		}else{
			pcapt_distrib.setIcon(OFF);
		}
	}
	
	//permet de gerer la mise a jour des chaines de caracteres des "n derniers messages" et "messages intelligence"
	//gere àgalement la mise à jour de la valeur des capteurs
	//prend en parametre l'index d'un message dans la liste "filemessage"
	private void affichage_messages(int i){
		
		int ID_message = filemessages.get(i).getId();
		//System.out.println("ID=" + ID_message);
		
		switch (ID_message) {
		
		//deplacement1
		case(0x100):
			int positionX = 0;
			int positionY = 0;
			int anglesign = 0;
			chaine_affich = chaine_affich + "[" + i + "]" + filemessages.get(i).toString() + "\n";
			positionX = ((Deplacement1)filemessages.get(i)).positionX;
			positionY = ((Deplacement1)filemessages.get(i)).positionY;
			maj_pos_robot(positionX, positionY, anglesign);
		break;
		
		//Deplacement 2
		case(0x111):
			chaine_affich = chaine_affich + "[" + i + "]" + filemessages.get(i).toString() + "\n";
		break;	
		
		//capteur
		case(0x200):
			chaine_affich = chaine_affich + "[" + i + "]" + filemessages.get(i).toString() + "\n";
			chaine_etat_robot = chaine_etat_robot + "[" + i + "]" + filemessages.get(i).toString() + "\n";
		break;				
		
		//intelligence
		case(0x140):
			chaine_intelligence = chaine_intelligence + "[" + i + "]" + filemessages.get(i).toString() + "\n";
			chaine_affich = chaine_affich + "[" + i + "]" + filemessages.get(i).toString() + "\n";
		break;	
		
		//actionneur
		case(0x500):
			chaine_affich = chaine_affich + "[" + i + "]" + filemessages.get(i).toString() + "\n";
			chaine_etat_robot = chaine_etat_robot + "[" + i + "]" + filemessages.get(i).toString() + "\n";
		break;
		
		//Carte espion
		case(0x7FF):
			chaine_affich = chaine_affich + "[" + i + "]" + filemessages.get(i).toString() + "\n";
		break;
		
		//Autre
		default:
			System.out.println("ID non reconnu dans l'interface");
		break;
		
		}
	}
	
	//permet de trouver l'index d'un message dans la filemessages à partir de sa date
	private int date_to_index(int date) {
		
		//System.out.println("date_to_index : date = " + date);

		//algorithme de recherche par dichotomie (a chaque fois on divise le tableau en 2) 
		boolean fin_iteration = false;
		int debut = 0;
		int fin = filemessages.size();
		int milieu=-1;
		
		if(date > filemessages.get(0).date) {
			while(!fin_iteration) {
				
				milieu = (debut+fin)/2;
				if((filemessages.get(milieu).date) == date) {
					fin_iteration = true;
				}
				else {
					if((filemessages.get(milieu).date) > date) {
						fin = milieu;
					}
					else {
						debut = milieu;
					}
					//System.out.println("milieu = " + milieu + " ; debut = " + debut + " ; fin = " +fin);
				}
				if((fin - debut) <= 1){
					milieu = debut; //prend la valeur min.
					fin_iteration = true;
				}
			}
		}
		//System.out.println("index trouve" + milieu);
		
		//si la date a trouver est 0, milieu = -1, car a la date 0 aucun message n'a pu àtre reàu
		return milieu;
		
	}
	
	
	private void maj_pos_robot(int x, int y, double teta) {

		//mm vers pixel -> *119/600
		terrain.robot.X = x*119/600;
		terrain.robot.Y = y*119/600;
		terrain.robot.teta = teta;
		terrain.repaint();
	}
	
	
	//permet de detecter un evenement sur la souris
	public void mouseReleased(MouseEvent e) {
		//permet de mettre à jour les champs de texte lorsque l'on a bougà le curseur du slider
		if (e.getSource() == slider){
			val_S.setText(Integer.toString(slider.getValue()/1000));
			val_ms.setText(Integer.toString(slider.getValue()%1000));
			val_S.setColumns(2);
			val_ms.setColumns(3);
			afficher_horsligne(false, slider.getValue());
		}

	}
	

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == slider){		
			//convertit la position de la souris au moment du click en une valeur comprise par le slider (0 -> 90000)
			double temp = e.getPoint().getX() * slider.getMaximum() / slider.getSize().getWidth();
			val_S.setText(Integer.toString((int) temp/1000));
			val_ms.setText(Integer.toString((int) temp%1000));
			val_S.setColumns(2);
			val_ms.setColumns(3);
			afficher_horsligne(false, (int) temp);
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	

	
	//permet de desactiver certains elements de l'interface lorsque l'on est en mode temps reel
	private void tempsreel_active() {
		//System.out.println("temps reel actif");
		conteneurNiv2_2.setEnabled(false);
		Brep_source.setEnabled(false);
		BLecture.setEnabled(false);
		BPause.setEnabled(false);
		BSuivant.setEnabled(false);
		BPrecedent.setEnabled(false);
		
		connexion_deconnexion.setEnabled(true);
		Benregistrer.setEnabled(true);
		Date.setEnabled(true);
		Lieu.setEnabled(true);
	}
	
	//permet de desactiver certains elements de l'interface lorsque l'on est en mode hors ligne
	private void horsligne_active(){
		//System.out.println("hors ligne actif");
		conteneurNiv2_2.setEnabled(true);
		Brep_source.setEnabled(true);
		BLecture.setEnabled(true);
		BPause.setEnabled(true);
		BSuivant.setEnabled(true);
		BPrecedent.setEnabled(true);

		connexion_deconnexion.setEnabled(false);
		Benregistrer.setEnabled(true);
		Date.setEnabled(false);
		Lieu.setEnabled(false);
	}

}	



