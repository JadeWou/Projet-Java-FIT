import java.awt.EventQueue;

public class APP {
    public static void main(String[] args) {
       // String fichier = "C:\\Users\\ugomi\\eclipse-workspace\\BasicFit2\\utilisateurs.csv"; 

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface window = new Interface();
                    window.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
