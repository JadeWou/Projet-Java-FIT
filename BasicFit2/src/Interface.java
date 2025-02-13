
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 546, 330);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
	
		frame.setContentPane(inscription());
		
		
		
	}
	
	
	
	JPanel inscription() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(123, 164, 72));
		panel.setBounds(0, 0, 146, 2000);
		panel.setLayout(null);
		
		JTextPane txtpnInscription = new JTextPane();
		txtpnInscription.setEditable(false);
		txtpnInscription.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		txtpnInscription.setForeground(Color.DARK_GRAY);
		txtpnInscription.setText("inscrit toi !");
		txtpnInscription.setBounds(275, 11, 97, 47);
		panel.add(txtpnInscription);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setEditable(false);
		txtpnNom.setForeground(Color.DARK_GRAY);
		txtpnNom.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnNom.setText("nom :");
		txtpnNom.setBounds(160, 62, 29, 20);
		panel.add(txtpnNom);
		
		Nom = new JTextField();
		Nom.setBackground(Color.LIGHT_GRAY);
		Nom.setForeground(Color.BLACK);
		Nom.setBounds(199, 62, 96, 20);
		panel.add(Nom);
		Nom.setColumns(10);
		
		JTextPane txtpnPrnom = new JTextPane();
		txtpnPrnom.setEditable(false);
		txtpnPrnom.setText("prénom :");
		txtpnPrnom.setForeground(Color.DARK_GRAY);
		txtpnPrnom.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnPrnom.setBounds(343, 62, 52, 20);
		panel.add(txtpnPrnom);
		
		JTextPane txtpnAge = new JTextPane();
		txtpnAge.setEditable(false);
		txtpnAge.setText("age :");
		txtpnAge.setForeground(Color.DARK_GRAY);
		txtpnAge.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnAge.setBounds(160, 104, 29, 20);
		panel.add(txtpnAge);
		
		Age = new JTextField();
		Age.setForeground(Color.BLACK);
		Age.setColumns(10);
		Age.setBackground(Color.LIGHT_GRAY);
		Age.setBounds(199, 104, 96, 20);
		panel.add(Age);
		
		Poids = new JTextField();
		Poids.setForeground(Color.BLACK);
		Poids.setColumns(10);
		Poids.setBackground(Color.LIGHT_GRAY);
		Poids.setBounds(394, 104, 96, 20);
		panel.add(Poids);
		
		Prenom = new JTextField();
		Prenom.setForeground(Color.BLACK);
		Prenom.setColumns(10);
		Prenom.setBackground(Color.LIGHT_GRAY);
		Prenom.setBounds(394, 62, 96, 20);
		panel.add(Prenom);
		
		JTextPane txtpnPoids = new JTextPane();
		txtpnPoids.setEditable(false);
		txtpnPoids.setText("poids (kg) :");
		txtpnPoids.setForeground(Color.DARK_GRAY);
		txtpnPoids.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnPoids.setBounds(327, 104, 68, 20);
		panel.add(txtpnPoids);
		
		JTextPane txtpnTaille = new JTextPane();
		txtpnTaille.setEditable(false);
		txtpnTaille.setText("taille (cm) :");
		txtpnTaille.setForeground(Color.DARK_GRAY);
		txtpnTaille.setFont(new Font("Book Antiqua", Font.PLAIN, 11));
		txtpnTaille.setBounds(236, 146, 68, 20);
		panel.add(txtpnTaille);
		
		Taille = new JTextField();
		Taille.setForeground(Color.BLACK);
		Taille.setColumns(10);
		Taille.setBackground(Color.LIGHT_GRAY);
		Taille.setBounds(314, 146, 96, 20);
		panel.add(Taille);
		
		JButton validerInscription = new JButton("je valide ");
		validerInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strPrenom = Prenom.getText();
				String strNom = Nom.getText();
				String strAge = Age.getText();
				String strPoids = Poids.getText();
				String strTaille = Taille.getText();
				
				
				if(strPrenom.equals("") || strNom.equals("") || strAge.equals("") || strPoids.equals("") || strTaille.equals("")) {
					
					JOptionPane.showMessageDialog(frame,"Il faut nécessairement remplir toutes les informations","Attention",JOptionPane.WARNING_MESSAGE);

			
			}else {
				
				try {
				Integer intAge = Integer.parseInt(strAge);
				Float floatPoids = Float.parseFloat(strPoids);
				Float floatTaille = Float.parseFloat(strTaille);
				frame.setContentPane(Objectif()); 
				inscriptionUtilisateur(strNom,strPrenom,intAge,floatPoids,floatTaille);
				}catch (Exception ex){
		            // Affiche une boîte de dialogue en cas d'erreur
		            JOptionPane.showMessageDialog(null, "Ca marche pas niquez vous ", "Erreur", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		}
		});
		validerInscription.setBounds(283, 217, 89, 23);
		panel.add(validerInscription);
		 return panel;
	}
	
	
	JPanel Objectif() {
		JPanel Objectif = new JPanel();
		Objectif.setBackground(Color.BLACK);
		Objectif.setBounds(0, 0, 546, 330);
		frame.getContentPane().add(Objectif);
		Objectif.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Maintien de poids");
		btnNewButton_2.setBounds(218, 175, 121, 23);
		Objectif.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Perte de poids");
		btnNewButton_1.setBounds(218, 130, 121, 23);
		Objectif.add(btnNewButton_1);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(374, 16, 0, 0);
		Objectif.add(canvas);
		
		JButton btnNewButton_3 = new JButton("Prise de poids");
		btnNewButton_3.setBounds(218, 220, 121, 23);
		Objectif.add(btnNewButton_3);
		
		JTextArea txtrQuelEstVotre = new JTextArea();
		txtrQuelEstVotre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrQuelEstVotre.setText("Quel est votre objectif ?");
		txtrQuelEstVotre.setEditable(false);
		txtrQuelEstVotre.setBounds(218, 85, 121, 23);
		Objectif.add(txtrQuelEstVotre);
		
		JTextPane txtpnBmabma = new JTextPane();
		txtpnBmabma.setForeground(new Color(0, 0, 0));
		txtpnBmabma.setBackground(Color.ORANGE);
		txtpnBmabma.setFont(new Font("Impact", Font.PLAIN, 44));
		txtpnBmabma.setText("FIT");
		txtpnBmabma.setEditable(false);
		txtpnBmabma.setBounds(122, 28, 65, 61);
		Objectif.add(txtpnBmabma);
		
		return Objectif;
	}
	
}
