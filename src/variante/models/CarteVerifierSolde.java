package variante.models;

import variante.abstractions.VerifierSolde;

public class CarteVerifierSolde implements VerifierSolde {
    @Override
    public boolean consulterDisponibilite(String numeroCompte, double montant) {
        System.out.println("Carte bancaire GIMAC/Visa : autorisation vérifiée pour " + numeroCompte + ".");
        return montant > 0;
    }
}
