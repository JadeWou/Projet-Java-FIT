

class Plat {
     private String nom;
     private double calories;
     private double proteines;
     private double glucides;
     private double lipides;
     private  boolean viande;
     private  boolean lipidesRiches;
     private  boolean glucidesRiches;

//    public Plat(String nom, double calories, double proteines, double glucides, double lipides, boolean viande, boolean glucidesRiches, boolean lipidesRiches) {
//        this.nom = nom;
//        this.calories = calories;
//        this.proteines = proteines;
//        this.glucides = glucides;
//        this.lipides = lipides;
//        this.viande = viande;
//        this.lipidesRiches = lipidesRiches;
//        this.glucidesRiches = glucidesRiches;
//    }
    public Plat(String nom, double calories, double proteines, double glucides, double lipides) {
        this.nom = nom;
        this.calories = calories;
        this.proteines = proteines;
        this.glucides = glucides;
        this.lipides = lipides;

    }
    
    
    
    public double qteProteines() {
    	return proteines;
    }

    public double qteLipides() {
    	return lipides;
    }
    
    public double qteGlucides() {
    	return glucides;
    }
    
    public double kcal() {
    	return calories;
    }
    
    public boolean isViande() {
        return viande;
    }

    public boolean isLipides() {
        return lipidesRiches;
    }

    public boolean isGlucides() {
        return glucidesRiches;
    }

    public String getNom() {
        return nom;
    }
}