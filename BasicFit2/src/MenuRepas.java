import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRepas extends JFrame {
    private JTextField repasField;
    private JButton validerButton;
    private JButton changerButton;
    
    public MenuRepas() {
        setTitle("Menu Objectif Repas");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(184, 197, 76));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel label = new JLabel("Combien de repas dans la semaine ?", JLabel.CENTER);
        label.setForeground(Color.WHITE);
        add(label, gbc);

        gbc.gridy++;
        repasField = new JTextField(10);
        repasField.setBackground(Color.WHITE);
        repasField.setForeground(Color.BLACK);
        gbc.insets = new Insets(10, 5, 20, 5);
        add(repasField, gbc);

        gbc.gridy++;
        validerButton = new JButton("Valider");
        validerButton.setBackground(new Color(114, 104, 192));
        validerButton.setForeground(Color.WHITE);
        validerButton.setPreferredSize(new Dimension(160, 35));
        gbc.insets = new Insets(10, 5, 30, 5);
        add(validerButton, gbc);
        validerButton.addActionListener(e -> validerRepas());

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        gbc.insets = new Insets(20, 10, 10, 5);
        changerButton = new JButton("Changer d'objectif");
        changerButton.setBackground(new Color(114, 104, 192));
        changerButton.setForeground(Color.WHITE);
        changerButton.setPreferredSize(new Dimension(130, 30));
        add(changerButton, gbc);
        changerButton.addActionListener(e -> changerObjectif());
        
        // ActionListener pour le bouton "changer objectif"
        changerButton.addActionListener(new ActionListener(){
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
    }

    private void validerRepas() {
        String input = repasField.getText().trim();
        if (input.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Nombre de repas validé: " + input + " par semaine.");
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changerObjectif() {
        repasField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuRepas().setVisible(true));
    }
}
