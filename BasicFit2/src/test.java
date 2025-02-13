import javax.swing.*;
import java.awt.*;

public class test extends JFrame {
    public test() {
        setTitle("Interface avec Dégradé et Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new GradientPanel();
        mainPanel.setLayout(new BorderLayout());
        
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(200, getHeight()));
        menuPanel.setBackground(new Color(50, 50, 50));
        
        JButton btnInscription = new JButton("Inscris-toi");
        JButton btnMonCompte = new JButton("Mon compte");
        JButton btnFaitRepas = new JButton("Fait ton repas");
        
        btnInscription.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMonCompte.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnFaitRepas.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        menuPanel.add(Box.createVerticalStrut(50));
        menuPanel.add(btnInscription);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(btnMonCompte);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(btnFaitRepas);
        
        mainPanel.add(menuPanel, BorderLayout.WEST);
        add(mainPanel);
    }
    
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            
            for (int i = 0; i < width; i += 20) {
                float ratio = (float) i / width;
                Color color = new Color(0, (int) (255 * ratio), 0);
                g2d.setColor(color);
                g2d.fillRect(i, 0, 20, height);
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new test().setVisible(true);
        });
    }
}
