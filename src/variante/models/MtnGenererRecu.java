package variante.models;

import variante.abstractions.GenererRecu;

public class MtnGenererRecu implements GenererRecu {
    @Override
    public void editerJustificatif(String referenceTransaction, double montant) {
        System.out.println("MTN Mobile Money : reçu " + referenceTransaction + " — " + montant + " XAF.");
    }
}
