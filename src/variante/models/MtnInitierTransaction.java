package variante.models;

import variante.abstractions.InitierTransaction;

public class MtnInitierTransaction implements InitierTransaction {
    @Override
    public String executerDebit(String numeroCompte, double montant) {
        return "MOMO-" + numeroCompte + "-" + montant;
    }
}
