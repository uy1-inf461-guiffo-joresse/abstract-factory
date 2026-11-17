package tests;

import cours.abstractions.IProduitFactory;
import cours.factories.ProduitFactory1;
import cours.factories.ProduitFactory2;
import cours.models.ProduitA1;
import cours.models.ProduitA2;
import cours.models.ProduitB1;
import cours.models.ProduitB2;
import variante.abstractions.OperateurPaiementFactory;
import variante.factories.CarteBancaireFactory;
import variante.factories.MtnMomoFactory;
import variante.factories.OrangeMoneyFactory;
import variante.models.CarteGenererRecu;
import variante.models.CarteInitierTransaction;
import variante.models.CarteVerifierSolde;
import variante.models.MtnGenererRecu;
import variante.models.MtnInitierTransaction;
import variante.models.MtnVerifierSolde;
import variante.models.OrangeGenererRecu;
import variante.models.OrangeInitierTransaction;
import variante.models.OrangeVerifierSolde;

public class ValidationPaiementFactoryTest {
    public static void main(String[] args) {
        verifierCours(new ProduitFactory1(), ProduitA1.class, ProduitB1.class);
        verifierCours(new ProduitFactory2(), ProduitA2.class, ProduitB2.class);

        verifierOperateur(new OrangeMoneyFactory(), OrangeVerifierSolde.class,
                OrangeInitierTransaction.class, OrangeGenererRecu.class);
        verifierOperateur(new MtnMomoFactory(), MtnVerifierSolde.class,
                MtnInitierTransaction.class, MtnGenererRecu.class);
        verifierOperateur(new CarteBancaireFactory(), CarteVerifierSolde.class,
                CarteInitierTransaction.class, CarteGenererRecu.class);

        System.out.println("Tous les tests de fabrique de paiement ont réussi.");
    }

    private static void verifierCours(IProduitFactory factory, Class<?> typeA, Class<?> typeB) {
        assert factory.getProduitA().getClass() == typeA : "ProduitA incorrect pour " + factory.getClass();
        assert factory.getProduitB().getClass() == typeB : "ProduitB incorrect pour " + factory.getClass();
    }

    private static void verifierOperateur(OperateurPaiementFactory factory, Class<?> typeVerificateur,
            Class<?> typeTransaction, Class<?> typeRecu) {
        assert factory.creerVerifierSolde().getClass() == typeVerificateur
                : "Vérificateur incohérent pour " + factory.getClass();
        assert factory.creerInitierTransaction().getClass() == typeTransaction
                : "Transaction incohérente pour " + factory.getClass();
        assert factory.creerGenererRecu().getClass() == typeRecu
                : "Reçu incohérent pour " + factory.getClass();
    }
}
