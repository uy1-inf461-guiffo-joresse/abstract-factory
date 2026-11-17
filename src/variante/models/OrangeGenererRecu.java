package variante.models;

import variante.abstractions.GenererRecu;

public class OrangeGenererRecu implements GenererRecu {
    @Override
    public void editerJustificatif(String referenceTransaction, double montant) {
        System.out.println("Orange Money : reçu " + referenceTransaction + " — " + montant + " XAF.");
    }
}
