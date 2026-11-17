package variante.models;

import variante.abstractions.VerifierSolde;

public class OrangeVerifierSolde implements VerifierSolde {
    @Override
    public boolean consulterDisponibilite(String numeroCompte, double montant) {
        System.out.println("Orange Money : solde vérifié pour " + numeroCompte + ".");
        return montant > 0;
    }
}
