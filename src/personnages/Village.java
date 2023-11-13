package personnages;

public class Village {
    private String nom;
    private Gaulois[] villageois;
    private int nbVillageois = 0;
    private Chef chef;

    public Village(String nom, int nbVillageoisMaximum) {
        this.nom = nom;
        this.villageois = new Gaulois[nbVillageoisMaximum];
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterHabitant(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
        } else {
            System.out.println("Le village est plein");
        }
    }

    public Gaulois trouverHabitant(int numero) {
        if (numero >= 0 && numero < nbVillageois) {
            return villageois[numero];
        } else {
            System.out.println("Villager not found!");
            return null;
        }
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public void afficherVillageois() {
        System.out.println("Chief: " + chef.getNom());
        for (int i = 0; i < nbVillageois; i++) {
            System.out.println(villageois[i].getNom());
        }
    }

    @Override
    public String toString() {
        return "Village [nom=" + nom + ", population=" + nbVillageois + "]";
    }
}
