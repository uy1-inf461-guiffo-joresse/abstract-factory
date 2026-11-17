package variante.models;

import variante.abstractions.InitierTransaction;

public class CarteInitierTransaction implements InitierTransaction {
    @Override
    public String executerDebit(String numeroCompte, double montant) {
        return "CARD-" + numeroCompte + "-" + montant;
    }
}
