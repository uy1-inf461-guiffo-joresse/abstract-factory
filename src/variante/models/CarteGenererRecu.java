package variante.models;

import variante.abstractions.GenererRecu;

public class CarteGenererRecu implements GenererRecu {
    @Override
    public void editerJustificatif(String referenceTransaction, double montant) {
        System.out.println("Carte bancaire GIMAC/Visa : reçu " + referenceTransaction + " — " + montant + " XAF.");
    }
}
