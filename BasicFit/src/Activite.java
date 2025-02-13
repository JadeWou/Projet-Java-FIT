import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Activite {

	double nb_heure;
	
	public Activite(double nb_heure) {
		super();
		this.nb_heure = nb_heure;
	}
	
	static void selectionSport(String inputNom, String inputPrenom, String inputLibelle,double nb_heure) {
		
	    String fichierCSV = "Activites.csv";
	    Path pathFichier  = Paths.get(fichierCSV);
		
		// Vérifier si le fichier CSV existe, si ce n'est pas le cas, le créer
		if(!Files.exists(pathFichier)) {
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(fichierCSV));
				writer.write("Nom;Prenom;Sport;Nombre_heures");
				writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(fichierCSV, true));
				writer.write(inputNom + ";" + inputPrenom + ";" + inputLibelle + ";" + nb_heure);
			    writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
