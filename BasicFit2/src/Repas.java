import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//import calcul.BesoinCalorique;
//import calcul.Plat;

public class Repas {

	   public static void trouverRepas(double besoin){
	        String csvFile = "bdd_aliment2.csv"; 
	        List<Plat> plats = new ArrayList<>();

	        // Chargement des aliments depuis le CSV
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            String line;
	            br.readLine(); // Ignorer l'entête
	            
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(";");
	                String nom = values[3];
	                float calories = Float.parseFloat(values[4]);
	                float proteines = Float.parseFloat(values[5]);
	                float glucides = Float.parseFloat(values[6]);
	                float lipides = Float.parseFloat(values[7]);
	                
	                Plat aliment = new Plat(nom, calories, proteines, glucides, lipides);
	                plats.add(aliment);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Définir les besoins nutritionnels
//	        BesoinCalorique personne = new BesoinCalorique(22, 68, 173, "homme", 1.5);
//	        double besoin = personne.calculerBesoin();
	        System.out.println("Besoin journalier : " + besoin +" kcal");
	        
	        int nombreRepas = 1; 
	        double besoinProteines = (besoin / nombreRepas) * 0.20 / 4; // en grammes
	        double besoinLipides = (besoin / nombreRepas) * 0.30 / 9;
	        double besoinGlucides = (besoin / nombreRepas) * 0.50 / 4;

	        // Trouver un repas optimisé
	        Map<Plat, Integer> meilleurRepas = trouverMeilleurRepas(plats, besoin / nombreRepas, besoinProteines, besoinLipides, besoinGlucides);
	        
	        // Affichage du meilleur repas trouvé
	        System.out.println("\n🍽️ Meilleur repas trouvé :");
	        double totalCalories = 0, totalProteines = 0, totalLipides = 0, totalGlucides = 0;
	        
	        for (Map.Entry<Plat, Integer> entry : meilleurRepas.entrySet()) {
	            Plat plat = entry.getKey();
	            int quantite = entry.getValue();
	            
	            double kcal = quantite * plat.kcal() / 100;
	            double prot = quantite * plat.qteProteines() / 100;
	            double lip = quantite * plat.qteLipides() / 100;
	            double glu = quantite * plat.qteGlucides() / 100;
	            
	            totalCalories += kcal;
	            totalProteines += prot;
	            totalLipides += lip;
	            totalGlucides += glu;

	            System.out.printf("- %s : %dg (%.1f kcal, %.1fP, %.1fL, %.1fG)\n", plat.getNom(), quantite, kcal, prot, lip, glu);
	        }

	        System.out.println("\n🔹 Total nutritionnel :");
	        System.out.printf("Calories : %.1f kcal\n", totalCalories);
	        System.out.printf("Protéines : %.1f g\n", totalProteines);
	        System.out.printf("Lipides : %.1f g\n", totalLipides);
	        System.out.printf("Glucides : %.1f g\n", totalGlucides);
	    }

	    public static Map<Plat, Integer> trouverMeilleurRepas(List<Plat> plats, double besoinCal, double besoinP, double besoinL, double besoinG) {
	        Random rand = new Random();
	        Map<Plat, Integer> meilleurRepas = new HashMap<>();
	        double meilleureErreur = Double.MAX_VALUE;

	        for (int i = 0; i < 10000; i++) { // On fait 10 000 essais
	            Collections.shuffle(plats);
	            Plat p1 = plats.get(0);
	            Plat p2 = plats.get(1);
	            Plat p3 = plats.get(2);

	            for (int q1 = 50; q1 <= 300; q1 += 10) {
	                for (int q2 = 50; q2 <= 300; q2 += 10) {
	                    for (int q3 = 50; q3 <= 300; q3 += 10) {
	                        double totalCal = (q1 * p1.kcal() + q2 * p2.kcal() + q3 * p3.kcal()) / 100;
	                        double totalP = (q1 * p1.qteProteines() + q2 * p2.qteProteines() + q3 * p3.qteProteines()) / 100;
	                        double totalL = (q1 * p1.qteLipides() + q2 * p2.qteLipides() + q3 * p3.qteLipides()) / 100;
	                        double totalG = (q1 * p1.qteGlucides() + q2 * p2.qteGlucides() + q3 * p3.qteGlucides()) / 100;

	                        double erreur = Math.abs(besoinCal - totalCal) + Math.abs(besoinP - totalP) 
	                                      + Math.abs(besoinL - totalL) + Math.abs(besoinG - totalG);

	                        if (erreur < meilleureErreur) {
	                            meilleureErreur = erreur;
	                            meilleurRepas.clear();
	                            meilleurRepas.put(p1, q1);
	                            meilleurRepas.put(p2, q2);
	                            meilleurRepas.put(p3, q3);
	                        }
	                    }
	                }
	            }
	        }
	        return meilleurRepas;
	    }
	}

