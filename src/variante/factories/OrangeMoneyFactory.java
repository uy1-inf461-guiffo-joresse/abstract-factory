package variante.factories;

import variante.abstractions.GenererRecu;
import variante.abstractions.InitierTransaction;
import variante.abstractions.OperateurPaiementFactory;
import variante.abstractions.VerifierSolde;
import variante.models.OrangeGenererRecu;
import variante.models.OrangeInitierTransaction;
import variante.models.OrangeVerifierSolde;

public class OrangeMoneyFactory implements OperateurPaiementFactory {
    @Override
    public VerifierSolde creerVerifierSolde() {
        return new OrangeVerifierSolde();
    }

    @Override
    public InitierTransaction creerInitierTransaction() {
        return new OrangeInitierTransaction();
    }

    @Override
    public GenererRecu creerGenererRecu() {
        return new OrangeGenererRecu();
    }
}
