import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Objectif {

	String objectif;
	public Objectif(String objectif) {
		super();
		this.objectif = objectif;
	}
	
	
	static void selectionObjectif(int sexe,String inputObjectif, String inputNom, String inputPrenom, Integer inputAge, float inputTaille, float inputPoids) {
		
		double coef = 1;
		double calories;
		
		if(sexe == 0) {
		
		if(inputObjectif == "Perte de poids") {
			 coef = 0.9;
		} else if(inputObjectif == "Prise de poids") {
			 coef = 1.1;
		} else if(inputObjectif == "Maintient du poids") {
			 coef = 1;
		}
		
		calories = 10*inputPoids+6.25*inputTaille-5*inputAge-161;
		
		}else {if(inputObjectif == "Perte de poids") {
			 coef = 0.9;
		} else if(inputObjectif == "Prise de poids") {
			 coef = 1.1;
		} else if(inputObjectif == "Maintient du poids") {
			 coef = 1;
		}
		
		calories = 10*inputPoids+6.25*inputTaille-5*inputAge+5;
		}
		
		
		
	    String fichierCSV = "objectifs.csv";
	    Path pathFichier  = Paths.get(fichierCSV);
	    
		// Vérifier si le fichier CSV existe, si ce n'est pas le cas, le créer
		if(!Files.exists(pathFichier)) {
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(fichierCSV));
				writer.write("Nom;Prenom;Objectif");
				writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(fichierCSV, true));
				writer.write(inputNom + ";" + inputPrenom + ";" + coef);
			    writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	
}