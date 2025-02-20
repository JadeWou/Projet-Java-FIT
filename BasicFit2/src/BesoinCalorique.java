
class BesoinCalorique {
    private int age;
    private double poids; // en kg
    private double taille; // en cm
    private String sexe;
    private double niveauActivite; // Facteur d'activité (ex: 1.2 pour sédentaire, 1.55 pour actif, etc.)

    public BesoinCalorique(int age, double poids, double taille, String sexe, double niveauActivite) {
        this.age = age;
        this.poids = poids;
        this.taille = taille;
        this.sexe = sexe;
        this.niveauActivite = niveauActivite;
    }

    /**
     * Calcule le besoin calorique journalier en fonction de la formule de Harris-Benedict.
     * @return Besoin calorique en kcal/jour
     */
    public static double calculerBesoin(int age, double poids, double taille, String sexe, double niveauActivite, String objectif) {
        double bmr; // Métabolisme de base

        if (sexe.equalsIgnoreCase("H")) {
            bmr = 88.36 + (13.4 * poids) + (4.8 * taille) - (5.7 * age);
        } else { // Femme
            bmr = 447.6 + (9.2 * poids) + (3.1 * taille) - (4.3 * age);
        }

        if(objectif.equalsIgnoreCase("perte")) {
        	bmr = bmr *0.9;
        }
        if(objectif.equalsIgnoreCase("prise")) {
        	bmr = bmr *1.1;
        }
        return bmr * niveauActivite; // Appliquer le facteur d'activité
        
        
    }
}