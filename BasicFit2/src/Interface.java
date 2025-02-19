
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Interface extends Utilisateur{

	private JFrame frame;
	private JTextField Nom;
	private JTextField Age;
	private JTextField Poids;
	private JTextField Prenom;
	private JTextField Taille;
	private JTextField txtPagePrincipal;
	private JTextField Sexe;
	private JTextField textField;
	private JTextField textField_1;

	private String pseudo;
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	private String password;



	
	
	 // Launch the application.
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Interface window = new Interface();
//					
//					window.frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});};
		
		// Charger l'image 
		

			public JFrame getFrame() {
				return frame;
			}
			public void setFrame(JFrame frame) {
				this.frame = frame;
			}
	
	//Create the application.
	
	public Interface() {
		
		initialize();
	}

	
	// Initialize the contents of the frame.
	
	private void initialize () {

		
		frame = new JFrame();
		frame.setBounds(100, 100, 558, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	
		frame.setContentPane(connexion());
		//frame.setContentPane(inscription());
		//frame.setContentPane(Objectif());
		//frame.setContentPane(MenuRepas());

		
	}
	
	
JPanel connexion() {
		
	    String fichier = "utilisateurs.csv"; 
	
		JPanel panel = new JPanel();
	    panel.setBackground(new Color(184, 197, 76));
	    panel.setBounds(0, 0, 546, 330);
	    panel.setLayout(null);
	    //frame.add(panel);
	    
	    JTextPane title = new JTextPane();
		    title.setForeground(new Color(255, 255, 255));
		    title.setBackground(new Color(71, 58, 179));
		    title.setFont(new Font("Impact", Font.PLAIN, 44));
		    title.setText("FIT");
		    title.setEditable(false);
		    title.setBounds(61, 23, 65, 61);
		    panel.add(title);
	    
		    
	    JLabel userLabel = new JLabel("Pseudo:");
		    userLabel.setBounds(150, 100, 80, 25);
		    panel.add(userLabel);
	    
		    
	    JTextField userText = new JTextField(20);
		    userText.setBounds(250, 100, 165, 25);
		    panel.add(userText);
	    
	    JLabel passwordLabel = new JLabel("Mot de passe:");
		    passwordLabel.setBounds(150, 140, 100, 25);
		    panel.add(passwordLabel);
	    
	    JPasswordField passwordText = new JPasswordField(20);
		    passwordText.setBounds(250, 140, 165, 25);
		    panel.add(passwordText);
	    
	    JButton loginButton = new JButton("Se connecter");
		    loginButton.setForeground(new Color(255, 255, 255));
		    loginButton.setBackground(new Color(114, 104, 192));
		    loginButton.setBounds(200, 190, 150, 40);
		    panel.add(loginButton);
	    
	    JButton registerButton = new JButton("Je n'ai pas de compte");
		    registerButton.setForeground(new Color(255, 255, 255));
		    registerButton.setBackground(new Color(114, 104, 192));
		    registerButton.setBounds(20, 250, 200, 40);
		    panel.add(registerButton);
	    
	    JLabel messageLabel = new JLabel("");
		    messageLabel.setBounds(150, 280, 300, 25);
		    panel.add(messageLabel);
	    
		    
		    
	    // ActionListener pour le bouton "Je n'ai pas de compte"
	    registerButton.addActionListener(new ActionListener(){
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            try {
		                //Interface window = new Interface();
		                frame.setContentPane(inscription());;
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        }
		    });
	    
	    
	    
	    // ActionListener pour le bouton de connexion
	    loginButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
		            String pseudo = userText.getText();
		            String password = new String(passwordText.getPassword());
		            
		            setPseudo(pseudo);
		            setPassword(password);
		            
		            
		
		            // Vérifier les identifiants et mots de passe dans le fichier CSV
		            try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
		                String ligne;
		                br.readLine(); // Ignorer la première ligne (en-têtes)
		                boolean utilisateurTrouve = false;
		
		                while ((ligne = br.readLine()) != null) {
		                    String[] colonnes = ligne.split(";");
		
		                    // Récupérer les identifiants et mots de passe modifier 
		                    String identifiant = colonnes[0];
		                    String motDePasse = colonnes[1];
		
		                    // Vérifier si les identifiants correspondent
		                    if (pseudo.equals(identifiant) && password.equals(motDePasse)) {
		                        utilisateurTrouve = true;
		                        break;
		                    }
		                }
		
		                if (utilisateurTrouve) {
		                    JOptionPane.showMessageDialog(frame, "Connexion réussie !");
		                    
		                    frame.setContentPane(Objectif());
			                frame.revalidate();
			                frame.repaint();
			                
		                } else {
		                    JOptionPane.showMessageDialog(frame, "Identifiant ou mot de passe incorrect.");
		                }
		
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(frame, "Erreur lors de la lecture du fichier.");
		                ex.printStackTrace();
		            }
		        }
		    });
    return panel;
}
	
	
	
	
	
	// PAGE INSCRIPTION
	JPanel inscription() {
			
			JPanel panel = new JPanel();
				panel.setBackground(new Color(184, 197, 76));
				//panel.setBackground(new Color(123, 164, 72));
				panel.setBounds(0, 0, 146, 2000);
				panel.setLayout(null);
			
			JTextPane txtpnInscription = new JTextPane();
				txtpnInscription.setBackground(new Color(114, 104, 192));
				txtpnInscription.setEditable(false);
				txtpnInscription.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
				txtpnInscription.setForeground(new Color(255, 255, 255));
				txtpnInscription.setText("Inscrits toi !");
				txtpnInscription.setBounds(216, 11, 97, 47);
				panel.add(txtpnInscription);
			
			JTextPane txtpnNom = new JTextPane();
				txtpnNom.setBackground(new Color(114, 104, 192));
				txtpnNom.setEditable(false);
				txtpnNom.setForeground(new Color(255, 255, 255));
				txtpnNom.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
				txtpnNom.setText("Nom :");
				txtpnNom.setBounds(107, 87, 38, 20);
				panel.add(txtpnNom);
			
				Nom = new JTextField();
				Nom.setBackground(Color.LIGHT_GRAY);
				Nom.setForeground(Color.BLACK);
				Nom.setBounds(155, 87, 96, 20);
				panel.add(Nom);
				Nom.setColumns(10);
			
			JTextPane txtpnPrnom = new JTextPane();
				txtpnPrnom.setBackground(new Color(114, 104, 192));
				txtpnPrnom.setEditable(false);
				txtpnPrnom.setText("Prénom :");
				txtpnPrnom.setForeground(new Color(255, 255, 255));
				txtpnPrnom.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
				txtpnPrnom.setBounds(294, 87, 68, 20);
				panel.add(txtpnPrnom);
				
				Prenom = new JTextField();
				Prenom.setForeground(Color.BLACK);
				Prenom.setColumns(10);
				Prenom.setBackground(Color.LIGHT_GRAY);
				Prenom.setBounds(372, 87, 96, 20);
				panel.add(Prenom);
			
			JTextPane txtpnAge = new JTextPane();
				txtpnAge.setBackground(new Color(114, 104, 192));
				txtpnAge.setEditable(false);
				txtpnAge.setText("Age :");
				txtpnAge.setForeground(new Color(255, 255, 255));
				txtpnAge.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
				txtpnAge.setBounds(107, 135, 38, 20);
				panel.add(txtpnAge);
			
				Age = new JTextField();
				Age.setForeground(Color.BLACK);
				Age.setColumns(10);
				Age.setBackground(Color.LIGHT_GRAY);
				Age.setBounds(155, 135, 96, 20);
				panel.add(Age);
			
			
			JTextPane txtpnPoids = new JTextPane();
				txtpnPoids.setBackground(new Color(114, 104, 192));
				txtpnPoids.setEditable(false);
				txtpnPoids.setText("Poids (kg) :");
				txtpnPoids.setForeground(new Color(255, 255, 255));
				txtpnPoids.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
				txtpnPoids.setBounds(294, 135, 68, 20);
				panel.add(txtpnPoids);
				
				Poids = new JTextField();
				Poids.setForeground(Color.BLACK);
				Poids.setColumns(10);
				Poids.setBackground(Color.LIGHT_GRAY);
				Poids.setBounds(372, 135, 96, 20);
				panel.add(Poids);
			
			JTextPane txtpnTaille = new JTextPane();
				txtpnTaille.setBackground(new Color(114, 104, 192));
				txtpnTaille.setEditable(false);
				txtpnTaille.setText("Taille (cm) :");
				txtpnTaille.setForeground(new Color(255, 255, 255));
				txtpnTaille.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
				txtpnTaille.setBounds(80, 176, 68, 20);
				panel.add(txtpnTaille);
				
				Taille = new JTextField();
				Taille.setForeground(Color.BLACK);
				Taille.setColumns(10);
				Taille.setBackground(Color.LIGHT_GRAY);
				Taille.setBounds(156, 176, 96, 20);
				panel.add(Taille);
			
			JTextPane txtpnBmabma = new JTextPane();
				txtpnBmabma.setForeground(new Color(255, 255, 255));
				txtpnBmabma.setBackground(new Color(71, 58, 179));
				txtpnBmabma.setFont(new Font("Impact", Font.PLAIN, 44));
				txtpnBmabma.setText("FIT");
				txtpnBmabma.setEditable(false);
				txtpnBmabma.setBounds(34, 23, 65, 61);
				panel.add(txtpnBmabma);
				
				
				
				JTextPane txtpnSexe = new JTextPane();
				txtpnSexe.setText("Sexe : (H/F)");
				txtpnSexe.setForeground(Color.WHITE);
				txtpnSexe.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
				txtpnSexe.setEditable(false);
				txtpnSexe.setBackground(new Color(114, 104, 192));
				txtpnSexe.setBounds(295, 176, 68, 20);
				panel.add(txtpnSexe);
			
				Sexe = new JTextField();
				Sexe.setForeground(Color.BLACK);
				Sexe.setColumns(10);
				Sexe.setBackground(Color.LIGHT_GRAY);
				Sexe.setBounds(373, 176, 96, 20);
				panel.add(Sexe);
			
			JTextPane txtpnMotDePasse = new JTextPane();
				txtpnMotDePasse.setText("Mot de passe :");
				txtpnMotDePasse.setForeground(Color.WHITE);
				txtpnMotDePasse.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
				txtpnMotDePasse.setEditable(false);
				txtpnMotDePasse.setBackground(new Color(114, 104, 192));
				txtpnMotDePasse.setBounds(275, 223, 89, 20);
				panel.add(txtpnMotDePasse);
				
				textField = new JTextField();
				textField.setForeground(Color.BLACK);
				textField.setColumns(10);
				textField.setBackground(Color.LIGHT_GRAY);
				textField.setBounds(372, 223, 96, 20);
				panel.add(textField);
			
			JTextPane txtpnIdentifiant = new JTextPane();
				txtpnIdentifiant.setText("Identifiant :");
				txtpnIdentifiant.setForeground(Color.WHITE);
				txtpnIdentifiant.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
				txtpnIdentifiant.setEditable(false);
				txtpnIdentifiant.setBackground(new Color(114, 104, 192));
				txtpnIdentifiant.setBounds(70, 223, 77, 20);
				panel.add(txtpnIdentifiant);
				
				textField_1 = new JTextField();
				textField_1.setForeground(Color.BLACK);
				textField_1.setColumns(10);
				textField_1.setBackground(Color.LIGHT_GRAY);
				textField_1.setBounds(155, 223, 96, 20);
				panel.add(textField_1);
				
				
			
			JButton validerInscription = new JButton("je valide ");
				validerInscription.setForeground(new Color(114, 104, 192));
				validerInscription.setBounds(236, 266, 89, 23);
				panel.add(validerInscription);
				
				
			//ACTION DU BOUTON VALIDER	
			validerInscription.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String strPrenom = Prenom.getText();
					String strNom = Nom.getText();
					String strAge = Age.getText();
					String strPoids = Poids.getText();
					String strTaille = Taille.getText();
					String strSexe = Sexe.getText(); 
					String strid = textField_1.getText();
					String strmdp= textField.getText();
					String strobj= " "; 
					
					String pseudo = textField_1.getText();
		            String password = new String(textField.getText());
		            
		            setPseudo(pseudo);
		            setPassword(password);
					
					if(strPrenom.equals("") || strNom.equals("") || strAge.equals("") || strPoids.equals("") || strTaille.equals("")|| strSexe.equals("")|| strid.equals("")|| strmdp.equals(""))  {
						
						JOptionPane.showMessageDialog(frame,"Il faut nécessairement remplir toutes les informations","Attention",JOptionPane.WARNING_MESSAGE);
	
				
				}else {
					if ( !strSexe.equals("H") && !strSexe.equals("F")) {// si il met autre chose que H ou F dans sexe 
						JOptionPane.showMessageDialog(frame,"Merci de bien spécifier F pour femme ou H pour homme, le calcul de l'apport en Kcal varie en fonction du sexe","Attention",JOptionPane.WARNING_MESSAGE);
					}else {
					try {
						Integer intAge = Integer.parseInt(strAge);
						Float floatPoids = Float.parseFloat(strPoids);
						Float floatTaille = Float.parseFloat(strTaille);
						
						frame.setContentPane(Objectif());					
		                frame.revalidate();
		                frame.repaint();
						
						inscriptionUtilisateur(strid,strmdp,strNom,strPrenom,intAge,floatPoids,floatTaille,strSexe,strobj);
						
					}catch (Exception ex){
			            // Affiche une boîte de dialogue en cas d'erreur
			            JOptionPane.showMessageDialog(null, "il faut mettre des chiffre dans age poids et taille", "Erreur", JOptionPane.ERROR_MESSAGE);
			        }
	
					}
				}}
				
			});
					
		 return panel;
	}
	
	
	
	
	
	//PAGE OBJECTIF
	JPanel Objectif() {
		
			JPanel Objectif = new JPanel();
				Objectif.setBackground(new Color(184, 197, 76));
				Objectif.setBounds(0, 0, 546, 330);
				//frame.getContentPane().add(Objectif);
				Objectif.setLayout(null);
			
			JButton maintien = new JButton("Maintien de poids");
				maintien.setForeground(new Color(255, 255, 255));
				maintien.setBackground(new Color(114, 104, 192));
				maintien.setBounds(218, 152, 146, 68);
				Objectif.add(maintien);
				
			JButton perte = new JButton("Perte de poids");
				perte.setForeground(new Color(255, 255, 255));
				perte.setBackground(new Color(114, 104, 192));
				perte.setBounds(39, 152, 146, 68);
				Objectif.add(perte);
			
	//		Canvas canvas = new Canvas();
	//		canvas.setBounds(374, 16, 0, 0);
	//		Objectif.add(canvas);
			
			JButton prise = new JButton("Prise de poids");
				prise.setForeground(new Color(255, 255, 255));
				prise.setBackground(new Color(114, 104, 192));
				prise.setBounds(390, 152, 146, 68);
				Objectif.add(prise);
			
			JTextArea txtrQuelEstVotre = new JTextArea();
				txtrQuelEstVotre.setBackground(new Color(114, 104, 192));
				txtrQuelEstVotre.setForeground(new Color(255, 255, 255));
				txtrQuelEstVotre.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txtrQuelEstVotre.setText("Quel est votre objectif ?");
				txtrQuelEstVotre.setEditable(false);
				txtrQuelEstVotre.setBounds(229, 50, 121, 34);
				Objectif.add(txtrQuelEstVotre);
			
			JTextPane txtpnBmabma = new JTextPane();
				txtpnBmabma.setForeground(new Color(255, 255, 255));
				txtpnBmabma.setBackground(new Color(71, 58, 179));
				txtpnBmabma.setFont(new Font("Impact", Font.PLAIN, 44));
				txtpnBmabma.setText("FIT");
				txtpnBmabma.setEditable(false);
				txtpnBmabma.setBounds(61, 23, 65, 61);
				Objectif.add(txtpnBmabma);
			
				
			//ACTION BOUTON MAINTIEN	
			maintien.addActionListener(new ActionListener(){
			    @Override
			    public void actionPerformed(ActionEvent objectif) {
				    	
				    	String inputFile = "utilisateurs.csv";
				    	List<String> lignes = new ArrayList<>();
				    	
				    	try {
				            // Lire et modifier les lignes
				            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
				                String ligne; // Déclaration de la variable ligne pour lire les lignes
				                while ((ligne = br.readLine()) != null) {
				                    String[] colonnes = ligne.split(";", -1); // Garder les colonnes vides
				                    
				                    System.out.println(getPseudo());
				                    System.out.println(getPassword());
		
				                    if (colonnes[0].equals(getPseudo()) && colonnes[1].equals(getPassword())) { 
				                        colonnes[8] = "maintien"; // Modifier la 9ᵉ colonne
				                    }
		
				                    lignes.add(String.join(";", colonnes));
				                }
				                br.close();  // La fermeture de br est déjà gérée par try-with-resources
		
				                // Réécriture du fichier avec la liste des lignes
				                BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
				                for (String ligneReecriture : lignes) {  // Changer le nom de la variable ici
				                    bw.write(ligneReecriture);
				                    bw.newLine();
				                }
				                bw.close();
				                
				                
				                System.out.println("Fichier mis à jour avec succès !");
				            }
			            
				            frame.setContentPane(MenuRepas());
			                frame.revalidate();
			                frame.repaint();
	
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
			});
			
			
			
			//ACTION BOUTON PRISE
			prise.addActionListener(new ActionListener(){
			    @Override
			    public void actionPerformed(ActionEvent objectif) {
			    	String inputFile = "utilisateurs.csv";
			    	List<String> lignes = new ArrayList<>();
			    	
			    	try {
			            // Lire et modifier les lignes
			            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			                String ligne; // Déclaration de la variable ligne pour lire les lignes
			                while ((ligne = br.readLine()) != null) {
			                    String[] colonnes = ligne.split(";", -1); // Garder les colonnes vides
			                    
			                    System.out.println(getPseudo());
			                    System.out.println(getPassword());
	
			                    if (colonnes[0].equals(getPseudo()) && colonnes[1].equals(getPassword())) { 
			                        colonnes[8] = "prise"; // Modifier la 9ᵉ colonne
			                    }
	
			                    lignes.add(String.join(";", colonnes));
			                }
			                br.close();  // La fermeture de br est déjà gérée par try-with-resources
	
			                // Réécriture du fichier avec la liste des lignes
			                BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
			                for (String ligneReecriture : lignes) {  // Changer le nom de la variable ici
			                    bw.write(ligneReecriture);
			                    bw.newLine();
			                }
			                bw.close();
			                
			                
			                System.out.println("Fichier mis à jour avec succès !");
			            }
			            
			            frame.setContentPane(MenuRepas());
		                frame.revalidate();
		                frame.repaint();
	
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
			});
			
			
			//ACTION BOUTON PERTE
			perte.addActionListener(new ActionListener(){
			    @Override
			    public void actionPerformed(ActionEvent objectif) {
			    	String inputFile = "utilisateurs.csv";
			    	List<String> lignes = new ArrayList<>();
			    	
			    	try {
			            // Lire et modifier les lignes
			            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			                String ligne; // Déclaration de la variable ligne pour lire les lignes
			                while ((ligne = br.readLine()) != null) {
			                    String[] colonnes = ligne.split(";", -1); // Garder les colonnes vides
			                    
			                    System.out.println(getPseudo());
			                    System.out.println(getPassword());
	
			                    if (colonnes[0].equals(getPseudo()) && colonnes[1].equals(getPassword())) { 
			                        colonnes[8] = "perte"; // Modifier la 9ᵉ colonne
			                    }
	
			                    lignes.add(String.join(";", colonnes));
			                }
			                br.close();  // La fermeture de br est déjà gérée par try-with-resources
	
			                // Réécriture du fichier avec la liste des lignes
			                BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
			                for (String ligneReecriture : lignes) {  // Changer le nom de la variable ici
			                    bw.write(ligneReecriture);
			                    bw.newLine();
			                }
			                bw.close();
			                
			                
			                System.out.println("Fichier mis à jour avec succès !");
			            }
			            
			            frame.setContentPane(MenuRepas());
		                frame.revalidate();
		                frame.repaint();
	
			            
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
			});      
		    
			
			
		return Objectif;
	}
	
	
	
	JPanel MenuRepas() {
		
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBackground(new Color(184, 197, 76));
        //add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel("Combien de repas dans la semaine ?", JLabel.CENTER);
        label.setForeground(Color.WHITE);
        panel.add(label);

        JTextField repasField = new JTextField(10);
        panel.add(repasField);

        JButton validerButton = new JButton("Valider");
        validerButton.setBackground(new Color(114, 104, 192));
        validerButton.setForeground(Color.WHITE);
        panel.add(validerButton);

        //validerButton.addActionListener(e -> validerRepas());
        
        validerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.setContentPane(Objectif());
    		}});
        

        JButton changerButton = new JButton("Changer objectif");
        changerButton.setBackground(new Color(114, 104, 192));
        changerButton.setForeground(Color.WHITE);
        panel.add(changerButton, BorderLayout.SOUTH);

        changerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.setContentPane(Objectif());
    		}});
        //changerButton.addActionListener(e -> changerObjectif());
        
	
        
    return panel;

		
	}
	
}
