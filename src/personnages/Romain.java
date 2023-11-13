package personnages;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }
    
    public int getForce() {
    	return force;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + "»");
    }

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }

    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 0:
                equipements[nbEquipement] = equipement;
                nbEquipement++;
                afficherMessageEquipement("s'équipe avec un", equipement);
                break;
            case 1:
                if (equipements[0] == equipement) {
                    afficherMessageEquipement("possède déjà", equipement);
                } else {
                    equipements[nbEquipement] = equipement;
                    nbEquipement++;
                    afficherMessageEquipement("s'équipe avec un", equipement);
                }
                break;
            case 2:
                afficherMessageEquipement("est déjà bien protégé", null);
                break;
        	default:
        		break;
        }
    
    }

    private void afficherMessageEquipement(String message, Equipement equipement) {
        if (equipement != null) {
            System.out.println("Le soldat " + nom + " " + message + " " + equipement + ".");
        } else {
            System.out.println("Le soldat " + nom + " " + message + " !");
        }
    }

    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
    }

    //public void recevoirCoup(int forceCoup) {
       // assert force > 0 : "Precondition failed: La force d'un romain devrait être positive!";
        //int initialForce = force;

        //force -= forceCoup;
        //if (force > 0) {
        //    parler("Aïe !");
        //} else {
        //    parler("J'abandonne...");
        //}

        //assert force < initialForce : "Postcondition failed: La force du romain devrait avoir diminuée!";
    //}
    
    public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        // précondition
        assert force > 0;
        int oldForce = force;
        forceCoup = calculResistanceEquipement(forceCoup);
        force -= forceCoup;
        //if (force > 0) {
        //	parler("Aïe");
        //} else {
        //     equipementEjecte = ejecterEquipement();
        //     parler("J'abandonne...");
        //}
        if (force != 0) {
        	parler("Aïe");
        }else {
            equipementEjecte = ejecterEquipement();
            parler("J'abandonne...");
         
       }
       // post condition la force a diminuée
       assert force < oldForce;
       return equipementEjecte;
    }
    
    private int calculResistanceEquipement(int forceCoup) {
        int initialForceCoup = forceCoup; // Store the initial force of the coup
        String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
        int resistanceEquipement = 0;
        if (nbEquipement != 0){
            texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
            for (int i = 0; i < nbEquipement; i++) {
                if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
                    resistanceEquipement += 8;
                } else if (equipements[i] != null) {
                    System.out.println("Equipement casque");
                    resistanceEquipement += 5;
                }
            }
            texte += resistanceEquipement + "!";
        }
        parler(texte);
        forceCoup = Math.max(0, forceCoup - resistanceEquipement); // Ensure forceCoup doesn't go negative
        return Math.min(initialForceCoup, forceCoup); // Ensure forceCoup doesn't exceed its initial value
    }

    
    private Equipement[] ejecterEquipement() {
    	Equipement[] equipementEjecte = new Equipement[nbEquipement];
    	System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
         int nbEquipementEjecte = 0;
         for (int i = 0; i < nbEquipement; i++) {
        	 if (equipements[i] != null) {
    	    	 equipementEjecte[nbEquipementEjecte] = equipements[i];
    	         nbEquipementEjecte++;
    	         equipements[i] = null;
    	     }
    	  }
    	 return equipementEjecte;
    }
    
    
}

