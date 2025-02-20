import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utilisateur {

String identifiant;
String mdp;
String nom;
String prenom;
int age;
double taille;
double poids;
String sexe ;
double apport;
String objectif; 



public Utilisateur() {}

public Utilisateur(String identifiant,String mdp,String nom, String prenom, Integer age, float taille, float poids, String sexe, String objectif) {
super();
this.identifiant = identifiant;
this.mdp = mdp;
this.nom = nom;
this.prenom = prenom;
this.age = age;
this.taille = taille;
this.poids = poids;
this.sexe = sexe;
this.objectif = objectif; 
;

}

public void inscriptionUtilisateur(String inputIdentifiant,String inputMdp,String inputNom,String inputPrenom,Integer inputAge,float inputTaille,float inputPoids, String inputSexe, String inputobj) {

    String fichierCSV = "utilisateurs.csv";
    Path pathFichier  = Paths.get(fichierCSV);

// Vérifier si le fichier CSV existe, si ce n'est pas le cas, le créer
if(!Files.exists(pathFichier)) {
BufferedWriter writer;
try {

System.out.println("Fichier CSV manquant.Création...");
writer = new BufferedWriter(new FileWriter(fichierCSV));
writer.write("Identifiant;Mot de passe;Nom;Prenom;Age;Taille;Poids;Sexe;objectif;Niveau d'activité physique");
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
writer.write(inputIdentifiant+";"+inputMdp+";"+ inputNom + ";" + inputPrenom + ";" + inputAge + ";" + inputTaille + ";" + inputPoids + ";" + inputSexe + ";" + inputobj);
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
if (objectif.equals("perte")){
		apport = apport* 0.9;  
}if (objectif.equals("prise")){
	apport = apport * 1.1 ; 
}
}}
