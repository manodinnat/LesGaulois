package personnages;

public class Musee {
    private Trophee[] trophees = new Trophee[200];
    private int nbTrophee = 0;

    public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
        if (nbTrophee < 200) {
            trophees[nbTrophee] = new Trophee(gaulois, equipement);
            nbTrophee++;
        } else {
            System.out.println("Le musée est plein !");
        }
    }
    public String extraireInstructionsCaml() {
        StringBuilder camlDeclaration = new StringBuilder();
        camlDeclaration.append("let musee = [\n");

        for (int i = 0; i < nbTrophee; i++) {
            Trophee troph = trophees[i];
            camlDeclaration.append("\"").append(troph.donnerNom()).append("\", \"")
                           .append(troph.getEquipement().toString().toLowerCase()).append("\"");
            if (i < nbTrophee - 1) {
                camlDeclaration.append(";\n");
            }
        }

        camlDeclaration.append("\n]");
        return camlDeclaration.toString();
    }
}
