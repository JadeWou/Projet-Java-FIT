import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginInterface {
    static // Déclarer le chemin du fichier CSV en tant que variable d'instance
    String fichier = "C:\\Users\\ugomi\\eclipse-workspace\\BasicFit2\\utilisateurs.csv"; 

    public static void main(String[] args) {
        // Création de l'interface de connexion
        JFrame frame = new JFrame("Connexion");
        frame.setSize(546, 330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(184, 197, 76));
        panel.setBounds(0, 0, 546, 330);
        panel.setLayout(null);
        frame.add(panel);
        
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
                    Interface window = new Interface();
                    window.getFrame().setVisible(true);
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
                    } else {
                        JOptionPane.showMessageDialog(frame, "Identifiant ou mot de passe incorrect.");
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur lors de la lecture du fichier.");
                    ex.printStackTrace();
                }
            }
        });
        
        frame.setVisible(true);
    }

	public Object getFrame() {
		// TODO Auto-generated method stub
		return null;
	}
}
