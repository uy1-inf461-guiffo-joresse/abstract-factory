package variante.models;

import variante.abstractions.VerifierSolde;

public class MtnVerifierSolde implements VerifierSolde {
    @Override
    public boolean consulterDisponibilite(String numeroCompte, double montant) {
        System.out.println("MTN Mobile Money : solde vérifié pour " + numeroCompte + ".");
        return montant > 0;
    }
}
