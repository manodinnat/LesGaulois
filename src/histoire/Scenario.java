package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
	    // Création des personnages
	    Gaulois asterix = new Gaulois("Astérix", 8);
	    Romain minus = new Romain("Minus", 6);

	    // Scénario
	    asterix.parler("Bonjour à tous");
	    minus.parler("UN GAU... UN GAUGAU...");

	    asterix.frapper(minus);
	    minus.parler("Aïe");

	    asterix.frapper(minus);
	    minus.parler("Aïe");

	    asterix.frapper(minus);
	    minus.parler("J'abandonne...");
	}


}
