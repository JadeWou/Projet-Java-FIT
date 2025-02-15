
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});};
		// Charger l'image 
		

			public JFrame getFrame() {
				return frame;
			}
			public void setFrame(JFrame frame) {
				this.frame = frame;
			}
	/**
	 * Create the application.
	 */
	public Interface() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize () {

		
		frame = new JFrame();
		frame.setBounds(100, 100, 558, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	
		//frame.setContentPane(inscription());
		
		frame.setContentPane(Objectif());


		
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
		txtpnInscription.setText("inscrit toi !");
		txtpnInscription.setBounds(216, 11, 97, 47);
		panel.add(txtpnInscription);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setBackground(new Color(114, 104, 192));
		txtpnNom.setEditable(false);
		txtpnNom.setForeground(new Color(255, 255, 255));
		txtpnNom.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnNom.setText("nom :");
		txtpnNom.setBounds(116, 87, 29, 20);
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
		txtpnPrnom.setText("prénom :");
		txtpnPrnom.setForeground(new Color(255, 255, 255));
		txtpnPrnom.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnPrnom.setBounds(294, 87, 68, 20);
		panel.add(txtpnPrnom);
		
		JTextPane txtpnAge = new JTextPane();
		txtpnAge.setBackground(new Color(114, 104, 192));
		txtpnAge.setEditable(false);
		txtpnAge.setText("age :");
		txtpnAge.setForeground(new Color(255, 255, 255));
		txtpnAge.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnAge.setBounds(116, 135, 29, 20);
		panel.add(txtpnAge);
		
		Age = new JTextField();
		Age.setForeground(Color.BLACK);
		Age.setColumns(10);
		Age.setBackground(Color.LIGHT_GRAY);
		Age.setBounds(155, 135, 96, 20);
		panel.add(Age);
		
		Poids = new JTextField();
		Poids.setForeground(Color.BLACK);
		Poids.setColumns(10);
		Poids.setBackground(Color.LIGHT_GRAY);
		Poids.setBounds(372, 135, 96, 20);
		panel.add(Poids);
		
		Prenom = new JTextField();
		Prenom.setForeground(Color.BLACK);
		Prenom.setColumns(10);
		Prenom.setBackground(Color.LIGHT_GRAY);
		Prenom.setBounds(372, 87, 96, 20);
		panel.add(Prenom);
		
		JTextPane txtpnPoids = new JTextPane();
		txtpnPoids.setBackground(new Color(114, 104, 192));
		txtpnPoids.setEditable(false);
		txtpnPoids.setText("poids (kg) :");
		txtpnPoids.setForeground(new Color(255, 255, 255));
		txtpnPoids.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnPoids.setBounds(294, 135, 68, 20);
		panel.add(txtpnPoids);
		
		JTextPane txtpnTaille = new JTextPane();
		txtpnTaille.setBackground(new Color(114, 104, 192));
		txtpnTaille.setEditable(false);
		txtpnTaille.setText("taille (cm) :");
		txtpnTaille.setForeground(new Color(255, 255, 255));
		txtpnTaille.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnTaille.setBounds(79, 186, 68, 20);
		panel.add(txtpnTaille);
		
		Taille = new JTextField();
		Taille.setForeground(Color.BLACK);
		Taille.setColumns(10);
		Taille.setBackground(Color.LIGHT_GRAY);
		Taille.setBounds(155, 186, 96, 20);
		panel.add(Taille);
		
		JTextPane txtpnBmabma = new JTextPane();
		txtpnBmabma.setForeground(new Color(255, 255, 255));
		txtpnBmabma.setBackground(new Color(71, 58, 179));
		txtpnBmabma.setFont(new Font("Impact", Font.PLAIN, 44));
		txtpnBmabma.setText("FIT");
		txtpnBmabma.setEditable(false);
		txtpnBmabma.setBounds(34, 23, 65, 61);
		panel.add(txtpnBmabma);
		
		JButton validerInscription = new JButton("je valide ");
		validerInscription.setForeground(new Color(114, 104, 192));
		validerInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strPrenom = Prenom.getText();
				String strNom = Nom.getText();
				String strAge = Age.getText();
				String strPoids = Poids.getText();
				String strTaille = Taille.getText();
				String strSexe = Sexe.getText(); 
				
				if(strPrenom.equals("") || strNom.equals("") || strAge.equals("") || strPoids.equals("") || strTaille.equals("")|| strSexe.equals(""))  {
					
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
				inscriptionUtilisateur(strNom,strPrenom,intAge,floatPoids,floatTaille,strSexe);
				}catch (Exception ex){
		            // Affiche une boîte de dialogue en cas d'erreur
		            JOptionPane.showMessageDialog(null, "il faut mettre des chiffre dans age poids et taille", "Erreur", JOptionPane.ERROR_MESSAGE);
		        }
				
		
			}
		}}
		});
		validerInscription.setBounds(236, 266, 89, 23);
		panel.add(validerInscription);
		
		JTextPane txtpnSexe = new JTextPane();
		txtpnSexe.setText("Sexe : (H/F)");
		txtpnSexe.setForeground(Color.WHITE);
		txtpnSexe.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnSexe.setEditable(false);
		txtpnSexe.setBackground(new Color(114, 104, 192));
		txtpnSexe.setBounds(294, 186, 68, 20);
		panel.add(txtpnSexe);
		
		Sexe = new JTextField();
		Sexe.setForeground(Color.BLACK);
		Sexe.setColumns(10);
		Sexe.setBackground(Color.LIGHT_GRAY);
		Sexe.setBounds(372, 186, 96, 20);
		panel.add(Sexe);
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
		
		Canvas canvas = new Canvas();
		canvas.setBounds(374, 16, 0, 0);
		Objectif.add(canvas);
		
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
		txtrQuelEstVotre.setBounds(218, 85, 121, 34);
		Objectif.add(txtrQuelEstVotre);
		
		JTextPane txtpnBmabma = new JTextPane();
		txtpnBmabma.setForeground(new Color(255, 255, 255));
		txtpnBmabma.setBackground(new Color(71, 58, 179));
		txtpnBmabma.setFont(new Font("Impact", Font.PLAIN, 44));
		txtpnBmabma.setText("FIT");
		txtpnBmabma.setEditable(false);
		txtpnBmabma.setBounds(61, 23, 65, 61);
		Objectif.add(txtpnBmabma);
		
		return Objectif;
	}
}
