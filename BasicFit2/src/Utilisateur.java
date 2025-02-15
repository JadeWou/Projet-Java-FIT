import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utilisateur {

	String id;
	String nom;
	String prenom;
	int age;
	double taille;
	double poids;
	String sexe ;
	double apport;

	
	
//	public Utilisateur(String id, String nom, String prenom, int age, double taille, double poids, String régime,
//			String allergies) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.age = age;
//		this.taille = taille;
//		this.poids = poids;
//
//	}
	public Utilisateur() {}
	
	public Utilisateur(String nom, String prenom, Integer age, float taille, float poids, String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.sexe = sexe;

	}
	
	public void inscriptionUtilisateur(String inputNom,String inputPrenom,Integer inputAge,float inputTaille,float inputPoids, String sexe) {
		
	    String fichierCSV = "utilisateurs.csv";
	    Path pathFichier  = Paths.get(fichierCSV);
		
		// Vérifier si le fichier CSV existe, si ce n'est pas le cas, le créer
		if(!Files.exists(pathFichier)) {
			BufferedWriter writer;
			try {
				
				System.out.println("Fichier CSV manquant.Création...");
				writer = new BufferedWriter(new FileWriter(fichierCSV));
				writer.write("Nom;Prenom;Age;Taille;Poids");
				writer.newLine();
				writer.close();
				System.out.println("Fichier CSV Créé");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(fichierCSV, true));
				writer.write(inputNom + ";" + inputPrenom + ";" + inputAge + ";" + inputTaille + ";" + inputPoids);
			    writer.newLine();
			    writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("Utilisateur enregistré");

	}
	public void calculkcal() { // calcule apport en kcal d'une personnne 
		if( sexe.equals("H")) {
			apport= 10* poids + 6.25* taille - 5* age +5 ;
		}else { 
			apport= 10 * poids + 6.25*taille -5*age -161 ; 
		}
	}
	

} 


