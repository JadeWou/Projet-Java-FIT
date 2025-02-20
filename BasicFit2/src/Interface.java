
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

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
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;

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
	private JTextField userText;
	private JTextField passwordText;
	private static String choix = "";
	private static String coefChoix;

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
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		frame.setLocationRelativeTo(null); // Centrer la fenêtre
		
		frame.setTitle("FIT App");
		ImageIcon appIcon = new ImageIcon("image/logo.png"); // Remplacez le chemin avec celui de votre icône
        frame.setIconImage(appIcon.getImage());  // Définir l'icône de la fenêtre

		
		
	
		frame.setContentPane(connexion());
		//frame.setContentPane(inscription());
		//frame.setContentPane(Objectif());
		//frame.setContentPane(MenuRepas());
		//frame.setContentPane(Activite());

		
	}
	
	//PAGE CONNEXION	
	JPanel connexion() {
		
	    String fichier = "utilisateurs.csv"; 
	
		JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
	        panel.setBackground(Color.decode("#f0f8f0"));  // Fond légèrement vert

	     // Charger l'image
	        String imagePath = "image/logo.png";  // Chemin de votre image
	        ImageIcon originalImageIcon = new ImageIcon(imagePath);
	        Image originalImage = originalImageIcon.getImage();
	        // Redimensionner l'image (par exemple, pour la redimensionner à 100x100 pixels)
	        Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Taille ajustée
	        // Créer un nouveau ImageIcon avec l'image redimensionnée
	        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
	        // Créer un JLabel avec l'image redimensionnée
	        JLabel imageLabel = new JLabel(resizedImageIcon);
	        
		    
		JLabel userLabel = new JLabel("Pseudo :");    
		JTextField userText = new JTextField(20);    

		JLabel passwordLabel = new JLabel("Mot de passe :");
		JPasswordField passwordText = new JPasswordField(20);

	    
		JButton loginButton = new JButton("Se connecter");	    
		JButton registerButton = new JButton("Je n'ai pas encore de compte");
	    
		// Styles des labels
			userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			
		// Personnaliser les champs de texte
			userText.setBorder(BorderFactory.createLineBorder(Color.decode("#84B59F"), 2));  // Bordure verte
			passwordText.setBorder(BorderFactory.createLineBorder(Color.decode("#84B59F"), 2));  // Bordure verte
			userText.setFont(new Font("Arial", Font.PLAIN, 14));
			passwordText.setFont(new Font("Arial", Font.PLAIN, 14));
		
			
		// Personnaliser les boutons
	        loginButton.setBackground(Color.decode("#84B59F")); // Vert pour le bouton "Se connecter"
	        loginButton.setForeground(Color.white);
	        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
	        loginButton.setFocusPainted(false);
	        loginButton.setPreferredSize(new Dimension(300, 40));
        
	        registerButton.setBackground(Color.decode("#84B59F")); // Un vert plus clair pour "Je n'ai pas encore de compte"
	        registerButton.setForeground(Color.white);
	        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
	        registerButton.setFocusPainted(false);
	        registerButton.setPreferredSize(new Dimension(300, 40));
	        
	     
	     // Ajouter des espaces pour l'espacement des composants
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10);
	        gbc.anchor = GridBagConstraints.CENTER;  // Centrer les composants   
	        
	        
	     // Ajouter l'image redimensionnée en haut au centre
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.gridwidth = 2;  // L'image occupe deux colonnes
	        panel.add(imageLabel, gbc);
	        
	        
	     // Ajouter les autres composants au panneau
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.gridwidth = 1;
	        panel.add(userLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        panel.add(userText, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        panel.add(passwordLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        panel.add(passwordText, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.gridwidth = 2;
	        panel.add(loginButton, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 4;
	        gbc.gridwidth = 2;
	        panel.add(registerButton, gbc);
		
		    
	    // ActionListener pour le bouton "Je n'ai pas de compte"
	    registerButton.addActionListener(new ActionListener(){
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            try {
		                //Interface window = new Interface();
		                frame.setContentPane(inscription());
		                frame.revalidate();
		                frame.repaint();
		                
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
		                    
		                    frame.setContentPane(RecommandationChef());
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
				panel.setLayout(new GridBagLayout());
		        panel.setBackground(Color.decode("#f0f8f0"));  // Fond légèrement vert

			
		    JLabel titleLabel = new JLabel("Inscription", JLabel.CENTER);
		        titleLabel.setFont(new Font("Book Antiqua", Font.BOLD, 44));
		        titleLabel.setForeground(Color.decode("#50808E"));
			
		    JLabel labelNom = new JLabel("Nom :");
		    JLabel labelPrenom = new JLabel("Prénom :");
	        JLabel labelAge = new JLabel("Âge :");
	        JLabel labelPoids = new JLabel("Poids (kg) :");
	        JLabel labelTaille = new JLabel("Taille (cm) :");
	        JLabel labelSexe = new JLabel("Sexe (H/F) :");
	        JLabel labelEmail = new JLabel("E-mail :");
	        JLabel labelPassword = new JLabel("Mot de passe :");
	        
	        JTextField Nom = new JTextField(20);
	        JTextField Prenom = new JTextField(20);
	        JTextField Age = new JTextField(20);
	        JTextField Poids = new JTextField(20);
	        JTextField Taille = new JTextField(20);
	        
	        JTextField Sexe = new JTextField(20);
	        
	        JTextField fieldEmail = new JTextField(20);
	        JPasswordField fieldPassword = new JPasswordField(20);
	        		
		
			// Créer un bouton pour l'inscription
			JButton validerInscription = new JButton("S'inscrire");
				validerInscription.setBackground(Color.decode("#50808E")); // Vert pour le bouton
				validerInscription.setForeground(Color.white);
				validerInscription.setFont(new Font("Arial", Font.BOLD, 14));
				validerInscription.setFocusPainted(false);
				validerInscription.setPreferredSize(new Dimension(200, 40));
		        
		    // Utiliser GridBagLayout pour aligner les éléments
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.insets = new Insets(10, 10, 10, 10);  // Ajouter des espacements entre les éléments
		        gbc.anchor = GridBagConstraints.CENTER;  // Centrer les éléments

		     // Placer le titre
		        gbc.gridx = 0;
		        gbc.gridy = 0;
		        gbc.gridwidth = 2;  // Faire en sorte que le titre occupe toute la largeur
		        panel.add(titleLabel, gbc);

		        // Créer un panel avec une bordure pour entourer les informations (sans le bouton)
		        JPanel infoPanel = new JPanel();
		        infoPanel.setLayout(new GridBagLayout());
		        infoPanel.setBackground(Color.decode("#f0f8f0")); // Fond légèrement vert
		        infoPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#50808E"), 2)); // Bordure verte

			        // Placer le label et le champ de saisie pour le nom
			        gbc.gridwidth = 1;  // Réinitialiser à une seule colonne
			        gbc.gridy = 0;
			        infoPanel.add(labelNom, gbc);
			        gbc.gridx = 1;
			        infoPanel.add(Nom, gbc);
	
			        // Placer le label et le champ de saisie pour le prénom
			        gbc.gridx = 0;
			        gbc.gridy = 1;
			        infoPanel.add(labelPrenom, gbc);
			        gbc.gridx = 1;
			        infoPanel.add(Prenom, gbc);
	
			        // Placer le label et le champ de saisie pour l'âge
			        gbc.gridx = 0;
			        gbc.gridy = 2;
			        infoPanel.add(labelAge, gbc);
			        gbc.gridx = 1;
			        infoPanel.add(Age, gbc);
	
			        // Placer le label et le champ de saisie pour le poids
			        gbc.gridx = 0;
			        gbc.gridy = 3;
			        infoPanel.add(labelPoids, gbc);
			        gbc.gridx = 1;
			        infoPanel.add(Poids, gbc);
	
			        // Placer le label et le champ de saisie pour la taille
			        gbc.gridx = 0;
			        gbc.gridy = 4;
			        infoPanel.add(labelTaille, gbc);
			        gbc.gridx = 1;
			        infoPanel.add(Taille, gbc);
	
			        // Placer le label et le combo box pour le sexe
			        gbc.gridx = 0;
			        gbc.gridy = 5;
			        infoPanel.add(labelSexe, gbc);
			        gbc.gridx = 1;
			        infoPanel.add(Sexe, gbc);
	
			        // Placer le label et le champ de saisie pour l'email
			        gbc.gridx = 0;
			        gbc.gridy = 6;
			        infoPanel.add(labelEmail, gbc);
			        gbc.gridx = 1;
			        infoPanel.add(fieldEmail, gbc);
	
			        // Placer le label et le champ de saisie pour le mot de passe
			        gbc.gridx = 0;
			        gbc.gridy = 7;
			        infoPanel.add(labelPassword, gbc);
			        gbc.gridx = 1;
			        infoPanel.add(fieldPassword, gbc);
	
			        // Placer le bouton d'inscription (sans la bordure)
			        gbc.gridx = 0;
			        gbc.gridy = 8;
			        gbc.gridwidth = 2;
			        panel.add(infoPanel, gbc);  // Ajouter le panel avec les informations dans le panel principal
	
			        // Placer le bouton en dehors de la bordure
			        gbc.gridx = 0;
			        gbc.gridy = 9;
			        panel.add(validerInscription, gbc);	
					
					
					
				
			//ACTION DU BOUTON VALIDER	
			validerInscription.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String strPrenom = Prenom.getText();
					String strNom = Nom.getText();
					String strAge = Age.getText();
					String strPoids = Poids.getText();
					String strTaille = Taille.getText();
					String strSexe = Sexe.getText();					
					String strid = fieldEmail.getText();
					String strmdp= new String(fieldPassword.getPassword());
					String strobj= " "; 
					
					String pseudo = fieldEmail.getText();
		            String password = new String(fieldPassword.getPassword());
		            
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
						
						inscriptionUtilisateur(strid,strmdp,strNom,strPrenom,intAge,floatTaille,floatPoids,strSexe,strobj);
						
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
				Objectif.setLayout(new GridBagLayout());
				Objectif.setBackground(Color.decode("#f0f8f0"));  // Fond légèrement vert
		
			
				ImageIcon originalImageIcon = new ImageIcon("image/logo.png");  // Remplacez par le chemin de votre image
		        Image originalImage = originalImageIcon.getImage();
		        Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Redimensionner l'image
		        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		        JLabel imageLabel = new JLabel(resizedImageIcon);
		     
		        
		    JLabel titleLabel = new JLabel("Quel est votre objectif ?", JLabel.CENTER);
		        titleLabel.setFont(new Font("Book Antiqua", Font.BOLD, 36));
		        titleLabel.setForeground(Color.decode("#84B59F"));     
		    
		        
		    
		        JButton perte = new JButton("Perte de poids");
		        JButton prise = new JButton("Prise de poids");
		        JButton maintien = new JButton("Maintien de poids");
		    
		        
		        //POSITIONNEMENT APPARENCE SETUP
			        perte.setBackground(Color.decode("#84B59F"));
			        perte.setForeground(Color.white);
			        perte.setFont(new Font("Arial", Font.BOLD, 18));  // Texte plus gros
			        perte.setFocusPainted(false);
			        perte.setPreferredSize(new Dimension(300, 60)); // Bouton plus grand
	
			        prise.setBackground(Color.decode("#84B59F"));
			        prise.setForeground(Color.white);
			        prise.setFont(new Font("Arial", Font.BOLD, 18));  // Texte plus gros
			        prise.setFocusPainted(false);
			        prise.setPreferredSize(new Dimension(300, 60)); // Bouton plus grand
	
			        maintien.setBackground(Color.decode("#84B59F"));
			        maintien.setForeground(Color.white);
			        maintien.setFont(new Font("Arial", Font.BOLD, 18));  // Texte plus gros
			        maintien.setFocusPainted(false);
			        maintien.setPreferredSize(new Dimension(300, 60)); // Bouton plus grand

			     // Utiliser GridBagLayout pour positionner les éléments
			        GridBagConstraints gbc = new GridBagConstraints();
			        gbc.insets = new Insets(10, 10, 10, 10);  // Ajouter de l'espace entre les éléments
			        gbc.anchor = GridBagConstraints.CENTER; // Centrer les éléments

			        // Placer le logo plus haut
			        gbc.gridx = 0;
			        gbc.gridy = 0;
			        gbc.gridwidth = 2;
			        Objectif.add(imageLabel, gbc);

			        // Placer le titre "Quel est votre objectif"
			        gbc.gridx = 0;
			        gbc.gridy = 1;
			        gbc.gridwidth = 2;
			        Objectif.add(titleLabel, gbc);

			        // Placer les boutons (avec inversement des boutons)
			        gbc.gridx = 0;
			        gbc.gridy = 2;
			        gbc.gridwidth = 1;
			        Objectif.add(prise, gbc);  // Bouton "Prise de poids" à la première position

			        gbc.gridx = 1;
			        gbc.gridy = 2;
			        Objectif.add(perte, gbc);  // Bouton "Perte de poids" à la deuxième position

			        gbc.gridx = 0;
			        gbc.gridy = 3;
			        gbc.gridwidth = 2;
			        Objectif.add(maintien, gbc);  // Bouton "Maintien de poids" en dessous
		
			        
			        
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
				                        colonnes[8] = "maintien;"; // Modifier la 9ᵉ colonne
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
			            
				            frame.setContentPane(Activite());
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
			                        colonnes[8] = "prise;"; // Modifier la 9ᵉ colonne
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
			            
			            frame.setContentPane(Activite());
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
			                        colonnes[8] = "perte;"; // Modifier la 9ᵉ colonne
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
			            
			            frame.setContentPane(Activite());
		                frame.revalidate();
		                frame.repaint();
	
			            
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
			});      
		    
			
			
		return Objectif;
	}
	
	
	//PAGE CHOIX REPAS
	JPanel MenuRepas() {
		
		JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			panel.setBackground(Color.decode("#f0f8f0"));  // Fond légèrement vert
			
			
			ImageIcon originalImageIcon = new ImageIcon("image/logo.png");  // Remplacez par le chemin de votre image
	        Image originalImage = originalImageIcon.getImage();
	        Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Redimensionner l'image
	        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
	        JLabel imageLabel = new JLabel(resizedImageIcon);

	        
	        JLabel titleLabel = new JLabel("Combien de repas par jour ?", JLabel.CENTER);
		        titleLabel.setFont(new Font("Book Antiqua", Font.BOLD, 36));
		        titleLabel.setForeground(Color.decode("#84B59F")); 
	        
        
		    JTextField repasField = new JTextField(10);
		        repasField.setFont(new Font("Arial", Font.PLAIN, 14));
		        repasField.setBorder(BorderFactory.createLineBorder(Color.decode("#84B59F"), 2));


		    JButton validerButton = new JButton("Valider");
		        validerButton.setBackground(Color.decode("#84B59F"));
		        validerButton.setForeground(Color.white);
		        validerButton.setFont(new Font("Arial", Font.BOLD, 14));
		        validerButton.setFocusPainted(false);
		        validerButton.setPreferredSize(new Dimension(300, 40)); 
		        
		        
		    JButton changerButton = new JButton("Changer d'objectif");
			    changerButton.setBackground(Color.decode("#84B59F"));
			    changerButton.setForeground(Color.white);
			    changerButton.setFont(new Font("Arial", Font.BOLD, 14));
			    changerButton.setFocusPainted(false);
			    changerButton.setPreferredSize(new Dimension(300, 40));     
		        
		
		//POSITIONNEMENT APPARENCE
			 // Utiliser GridBagLayout pour positionner les éléments
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.insets = new Insets(10, 10, 10, 10);  // Ajouter de l'espace entre les éléments
		        gbc.anchor = GridBagConstraints.CENTER; // Centrer les éléments
		        
		        
		        // Placer le logo plus haut
		        gbc.gridx = 0;
		        gbc.gridy = 0;
		        gbc.gridwidth = 2;
		        panel.add(imageLabel, gbc);

		        // Placer le titre "Nombre de repas par jour"
		        gbc.gridx = 0;
		        gbc.gridy = 1;
		        gbc.gridwidth = 2;
		        panel.add(titleLabel, gbc);

		        // Placer le champ de texte pour le nombre de repas
		        gbc.gridx = 0;
		        gbc.gridy = 2;
		        gbc.gridwidth = 2;
		        panel.add(repasField, gbc);

		        // Placer le bouton "Valider"
		        gbc.gridx = 0;
		        gbc.gridy = 3;
		        panel.add(validerButton, gbc);

		        // Placer le bouton "Changer d'objectif"
		        gbc.gridx = 0;
		        gbc.gridy = 4;
		        panel.add(changerButton, gbc);    
			    
			    //ACTIONS DES BOUTONS
		        
		        
        validerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {   			

    	            String inputFile = "utilisateurs.csv";
    	            List<String> lignes = new ArrayList<>();

    	            try {
    	                // Lire et modifier les lignes
    	                try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
    	                    String ligne;
    	                    while ((ligne = br.readLine()) != null) {
    	                        String[] colonnes = ligne.split(";", -1); // Garder les colonnes vides

    	                        System.out.println(getPseudo());
    	                        System.out.println(getPassword());

    	                        if (colonnes[0].equals(getPseudo()) && colonnes[1].equals(getPassword())) { 
    	                        	String nbRepas = repasField.getText();
    	                            colonnes[10] = nbRepas; // Modifier la 9ᵉ colonne
    	                        }

//    	                        if (colonnes[0].equals(getPseudo()) && colonnes[1].equals(getPassword())) { 
//    	                            double besoin = BesoinCalorique.calculerBesoin(
//    	                                Integer.parseInt(colonnes[4]), 
//    	                                Double.parseDouble(colonnes[6]), 
//    	                                Double.parseDouble(colonnes[5]), 
//    	                                colonnes[7], 
//    	                                Double.parseDouble(colonnes[9]), 
//    	                                colonnes[8]
//    	                            );
//    	                            
//    	                            String test = Repas.trouverRepas(besoin);
//    	                            
//    	                        }
    	                        

    	                        lignes.add(String.join(";", colonnes));
    	                    }
    	                }

    	                // Réécriture du fichier avec la liste des lignes
    	                BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
    	                for (String ligneReecriture : lignes) {  
    	                    bw.write(ligneReecriture);
    	                    bw.newLine();
    	                }
    	                bw.close();

    	                System.out.println("Fichier mis à jour avec succès !");
    	            } catch (IOException e1) {
    	                e1.printStackTrace();
    	            }
    	        
    	  
    			frame.setContentPane(RecommandationChef());
    			frame.revalidate();
                frame.repaint();
    		}});
        
        changerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.setContentPane(Objectif());
    			frame.revalidate();
                frame.repaint();
    		}});
        //changerButton.addActionListener(e -> changerObjectif());
        
	
        
    return panel;

		
	}
	

	// PAGE ACTIVITE
	JPanel Activite() {
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.decode("#f0f8f0"));

	    JLabel titleLabel = new JLabel("Quel est ton niveau d'activité physique ?", JLabel.CENTER);
	    titleLabel.setFont(new Font("Book Antiqua", Font.BOLD, 26));
	    titleLabel.setForeground(Color.decode("#5A8F7B"));
	    titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0)); // Espacement ajusté

	    // AGENCEMENT VISUEL
	    JPanel contentPanel = new JPanel(new GridBagLayout());
	    contentPanel.setBackground(Color.decode("#f0f8f0"));

	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(10, 15, 10, 15);
	    gbc.anchor = GridBagConstraints.WEST;

	    // Panel des boutons à gauche
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(5, 1, 15, 15)); // Espacement augmenté
	    buttonPanel.setBackground(Color.decode("#f0f8f0"));

	    // Panel pour la description à droite
	    JPanel descriptionPanel = new JPanel(new BorderLayout());
	    descriptionPanel.setBackground(Color.decode("#DFF5E5"));
	    descriptionPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#84B59F"), 3, true)); // Bord arrondi
	    descriptionPanel.setPreferredSize(new Dimension(350, 170));

	    JLabel descriptionLabel = new JLabel("<html><center>Sélectionnez une activité<br>pour voir sa description</center></html>", JLabel.CENTER);
	    descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
	    descriptionLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
	    descriptionPanel.add(descriptionLabel, BorderLayout.CENTER);

	    // Liste des activités et leurs descriptions
	    String[] activites = {
	        "Sédentaire",
	        "Légèrement actif",
	        "Modérément actif",
	        "Très actif",
	        "Extrêmement actif"
	    };

	    String[] descriptions = {
	        "<html><b>Sédentaire :</b><br>Peu ou pas d'activité physique.</html>",
	        "<html><b>Légèrement actif :</b><br>Un peu de marche ou sport léger (1-3 jours/semaine).</html>",
	        "<html><b>Modérément actif :</b><br>Exercice modéré 3-5 jours/semaine.</html>",
	        "<html><b>Très actif :</b><br>Exercice intense 6-7 jours/semaine.</html>",
	        "<html><b>Extrêmement actif :</b><br>Activité physique intense et travail physique exigeant.</html>"
	    };

	    // Création des boutons avec un ButtonGroup
	    ButtonGroup group = new ButtonGroup();

	    for (int i = 0; i < activites.length; i++) {
	        JRadioButton button = new JRadioButton(activites[i]);
	        button.setFont(new Font("Arial", Font.BOLD, 16));
	        button.setBackground(Color.decode("#f0f8f0"));
	        button.setActionCommand(activites[i]); // Utiliser l'activité en tant qu'actionCommand
	        button.setBorder(BorderFactory.createLineBorder(Color.decode("#84B59F"), 2, true)); // Bordure verte
	        button.setFocusPainted(false);
	        button.setPreferredSize(new Dimension(220, 40));
	        group.add(button);
	        buttonPanel.add(button);

	        // Ajouter une action pour afficher la description et stocker la sélection
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String choix = e.getActionCommand();
	                descriptionLabel.setText(descriptions[getIndex(activites, choix)]);

	                // Associer le coefficient selon l'activité choisie
	                switch (choix) {
	                    case "Sédentaire":
	                        coefChoix = "1.2";
	                        break;
	                    case "Légèrement actif":
	                        coefChoix = "1.375";
	                        break;
	                    case "Modérément actif":
	                        coefChoix = "1.55";
	                        break;
	                    case "Très actif":
	                        coefChoix = "1.725";
	                        break;
	                    case "Extrêmement actif":
	                        coefChoix = "1.9";
	                        break;
	                }
	            }
	        });
	    }

	    // Bouton "Valider"
	    JButton validerButton = new JButton("Valider");
	    validerButton.setBackground(Color.decode("#84B59F"));
	    validerButton.setForeground(Color.white);
	    validerButton.setFont(new Font("Arial", Font.BOLD, 16));
	    validerButton.setFocusPainted(false);
	    validerButton.setPreferredSize(new Dimension(220, 45));

	    validerButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String inputFile = "utilisateurs.csv";
	            List<String> lignes = new ArrayList<>();

	            try {
	                // Lire et modifier les lignes
	                try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
	                    String ligne;
	                    while ((ligne = br.readLine()) != null) {
	                        String[] colonnes = ligne.split(";", -1); // Garder les colonnes vides

	                        System.out.println(getPseudo());
	                        System.out.println(getPassword());

	                        if (colonnes[0].equals(getPseudo()) && colonnes[1].equals(getPassword())) { 
	                            colonnes[9] = coefChoix; // Modifier la 9ᵉ colonne
	                        }



	                        lignes.add(String.join(";", colonnes));
	                    }
	                }

	                // Réécriture du fichier avec la liste des lignes
	                BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
	                for (String ligneReecriture : lignes) {  
	                    bw.write(ligneReecriture);
	                    bw.newLine();
	                }
	                bw.close();

	                System.out.println("Fichier mis à jour avec succès !");
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
    			frame.setContentPane(RecommandationChef());
    			frame.revalidate();
                frame.repaint();
	        }
	    });

	    // Ajout des éléments au contentPanel
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    contentPanel.add(buttonPanel, gbc);

	    gbc.gridx = 1;
	    contentPanel.add(descriptionPanel, gbc);

	    // Ajouter le tout au panel principal
	    panel.setLayout(new BorderLayout());
	    panel.add(titleLabel, BorderLayout.NORTH);
	    panel.add(contentPanel, BorderLayout.CENTER);

	    // Panel pour centrer le bouton valider
	    JPanel buttonPanelContainer = new JPanel();
	    buttonPanelContainer.setBackground(Color.decode("#f0f8f0"));
	    buttonPanelContainer.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
	    buttonPanelContainer.add(validerButton);
	    panel.add(buttonPanelContainer, BorderLayout.SOUTH);

	    return panel;
	}
	
	

	// Fonction utilitaire pour trouver l'index d'un élément dans un tableau
	private int getIndex(String[] array, String value) {
	    for (int i = 0; i < array.length; i++) {
	        if (array[i].equals(value)) {
	            return i;
	        }
	    }
	    return -1; // Valeur non trouvée

	}
	
	
	
	
	//PAGE RECOMMANDATION
	JPanel RecommandationChef() {
	    JPanel panel = new JPanel(new BorderLayout());
	    panel.setBackground(Color.decode("#f0f8f0"));

	    // 🔹 Titre
	    JLabel titleLabel = new JLabel("Recommandation du chef", JLabel.CENTER);
	    titleLabel.setFont(new Font("Book Antiqua", Font.BOLD, 28));
	    titleLabel.setForeground(Color.decode("#5A8F7B"));
	    titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

	    // 🔹 Conteneur principal
	    JPanel contentPanel = new JPanel(new GridBagLayout());
	    contentPanel.setBackground(Color.decode("#f0f8f0"));
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(10, 10, 10, 10);
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    // 🟢 Suppression du cadre "Objectif" ici
	    // Il n'y a plus de panneau "objectifPanel" et on ne l'ajoute plus au `contentPanel`
	    
	    String test = "Aucune recommandation trouvée."; // Valeur par défaut

	    String inputFile = "utilisateurs.csv";
	    List<String> lignes = new ArrayList<>();

	    try {
	        // Lire et modifier les lignes
	        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
	            String ligne;
	            while ((ligne = br.readLine()) != null) {
	                String[] colonnes = ligne.split(";", -1); // Garder les colonnes vides

	                if (colonnes[0].equals(getPseudo()) && colonnes[1].equals(getPassword())) { 
	                    double besoin = BesoinCalorique.calculerBesoin(
	                        Integer.parseInt(colonnes[4]), 
	                        Double.parseDouble(colonnes[6]), 
	                        Double.parseDouble(colonnes[5]), 
	                        colonnes[7], 
	                        Double.parseDouble(colonnes[9]), 
	                        colonnes[8]
	                    );

	                    test = Repas.trouverRepas(besoin); // Mise à jour de la variable test
	                }
	            }
	        }
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }

	    // 🟢 Cadre Recommandation (agrandi)
	    JPanel recommandationPanel = new JPanel(new BorderLayout());
	    recommandationPanel.setBackground(Color.decode("#DFF5E5"));
	    recommandationPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#84B59F"), 3, true));
	    recommandationPanel.setPreferredSize(new Dimension(800, 600)); // Augmentation de la largeur à 800

	    // 🔹 Utilisation d'une police compatible avec les emojis
	    Font font = new Font("Segoe UI Emoji", Font.PLAIN, 16); // Choisir une police supportant les emojis
	    JTextArea recommandationArea = new JTextArea(test);
	    recommandationArea.setFont(font);
	    recommandationArea.setBackground(Color.decode("#DFF5E5"));
	    recommandationArea.setForeground(Color.decode("#333333"));
	    recommandationArea.setEditable(false);
	    recommandationArea.setLineWrap(true);
	    recommandationArea.setWrapStyleWord(true);
	    recommandationArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	    recommandationPanel.add(recommandationArea, BorderLayout.CENTER);

	    // 🔹 Positionnement des cadres
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridheight = 2; // Ajout d'une hauteur de grille plus grande pour prendre tout l'espace
	    contentPanel.add(recommandationPanel, gbc);

	    // 🔹 Boutons
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setBackground(Color.decode("#f0f8f0"));

	    JButton btnNouvelleTentative = new JButton("Nouvelle tentative");
	    JButton btnChanger = new JButton("Changer Paramètre");
	    JButton btnQuitter = new JButton("Quitter");
	    
	    btnNouvelleTentative.setBackground(Color.decode("#84B59F"));
	    btnNouvelleTentative.setForeground(Color.white);
	    btnNouvelleTentative.setFont(new Font("Arial", Font.BOLD, 16));
	    btnNouvelleTentative.setFocusPainted(false);
	    btnNouvelleTentative.setPreferredSize(new Dimension(220, 50));

	    btnChanger.setBackground(Color.decode("#84B59F"));
	    btnChanger.setForeground(Color.white);
	    btnChanger.setFont(new Font("Arial", Font.BOLD, 16));
	    btnChanger.setFocusPainted(false);
	    btnChanger.setPreferredSize(new Dimension(220, 50));

	    btnQuitter.setBackground(Color.decode("#FF6B6B"));
	    btnQuitter.setForeground(Color.white);
	    btnQuitter.setFont(new Font("Arial", Font.BOLD, 16));
	    btnQuitter.setFocusPainted(false);
	    btnQuitter.setPreferredSize(new Dimension(220, 50));

	    buttonPanel.add(btnNouvelleTentative);
	    buttonPanel.add(btnChanger);
	    buttonPanel.add(btnQuitter);
	    
	    btnNouvelleTentative.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.setContentPane(RecommandationChef());
	            frame.revalidate();
	            frame.repaint();
	        }
	    });

	    // 🔹 Action du bouton Quitter
	    btnQuitter.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);
	        }
	    });
	    
	    btnChanger.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.setContentPane(Objectif());
	            frame.revalidate();
	            frame.repaint();
	        }
	    });

	    // 🔹 Ajout au panel principal
	    panel.add(titleLabel, BorderLayout.NORTH);
	    panel.add(contentPanel, BorderLayout.CENTER);
	    panel.add(buttonPanel, BorderLayout.SOUTH);

	    return panel;
	}





}


