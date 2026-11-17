package variante.models;

import variante.abstractions.InitierTransaction;

public class OrangeInitierTransaction implements InitierTransaction {
    @Override
    public String executerDebit(String numeroCompte, double montant) {
        return "OM-" + numeroCompte + "-" + montant;
    }
}
