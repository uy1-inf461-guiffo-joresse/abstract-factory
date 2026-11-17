package variante;

import variante.abstractions.GenererRecu;
import variante.abstractions.InitierTransaction;
import variante.abstractions.OperateurPaiementFactory;
import variante.abstractions.VerifierSolde;
import variante.factories.CarteBancaireFactory;
import variante.factories.MtnMomoFactory;
import variante.factories.OrangeMoneyFactory;

public class SimulateurPaiementClient {
    private static final String NUMERO_COMPTE = "699123456";
    private static final double MONTANT = 5000.0;

    public static void main(String[] args) {
        simuler("Orange Money", new OrangeMoneyFactory());
        simuler("MTN Mobile Money", new MtnMomoFactory());
        simuler("Carte bancaire GIMAC/Visa", new CarteBancaireFactory());
    }

    private static void simuler(String operateur, OperateurPaiementFactory factory) {
        System.out.println("\n=== Paiement via " + operateur + " ===");
        VerifierSolde verifier = factory.creerVerifierSolde();
        InitierTransaction transaction = factory.creerInitierTransaction();
        GenererRecu recu = factory.creerGenererRecu();

        if (!verifier.consulterDisponibilite(NUMERO_COMPTE, MONTANT)) {
            System.out.println("Paiement refusé : solde indisponible.");
            return;
        }

        String reference = transaction.executerDebit(NUMERO_COMPTE, MONTANT);
        recu.editerJustificatif(reference, MONTANT);
    }
}
