package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 1;
    private int nbtrophees;
    private Equipement[] trophees = new Equipement[100];

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + "»");
    }

   // private String prendreParole() {
   //     return "Le gaulois " + nom + " : ";
   // }

    //public void frapper(Romain romain) {
    //    int forceDuCoup = (force / 3) * effetPotion;
    //    System.out.println(nom + " envoie un coup de force " + forceDuCoup + " dans la mâchoire de " + romain.getNom());
    //    romain.recevoirCoup(forceDuCoup);
    //}

    public void boirePotion(int forcePotion) {
        this.effetPotion = forcePotion;
        System.out.println("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
    }

    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + "]";
    }

    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Astérix", 8);
        Druide panoramix = new Druide("Panoramix", 5, 10);
        panoramix.preparerPotion();
        asterix.boirePotion(panoramix.getForcePotion());
    }

    private String prendreParole() {
        return "Le gaulois " + nom + " : ";
    }
    public void faireUneDonnation(Musee musee) {
		if (nbtrophees > 0) {
            StringBuilder annonce = new StringBuilder();
            annonce.append("Le gaulois ").append(nom).append(" : « Je donne au musee tous mes trophees :\n");
            for (int i = 0; i < nbtrophees; i++) {
                musee.donnerTrophees(this, trophees[i]);
                annonce.append("- ").append(trophees[i]).append("\n");
                trophees[i] = null; // Le trophée est donné, donc il est retiré du tableau du gaulois
            }
            nbtrophees = 0; // Reset le nombre de trophées du gaulois
            annonce.append("»");
            System.out.println(annonce.toString());
        } else {
            System.out.println("Le gaulois " + nom + " n'a pas de trophées à donner.");
        }
    }
    
    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        int marc = (force / 3) * effetPotion;
        Equipement[] equipements = romain.recevoirCoup(marc);

        if (equipements != null) {
            for (int i = 0; i < equipements.length; i++, nbtrophees++) {
                this.trophees[nbtrophees] = equipements[i];
            }
        }
    }
}