package personnages;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    public Romain(String nom, int force) {
        assert force > 0 : "Force of a Roman must be positive!";
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
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

    public void recevoirCoup(int forceCoup) {
        assert force > 0 : "Precondition failed: Roman's force should be positive!";
        int initialForce = force;

        force -= forceCoup;
        if (force > 0) {
            parler("Aïe !");
        } else {
            parler("J'abandonne...");
        }

        assert force < initialForce : "Postcondition failed: Roman's force should have decreased!";
    }
}
