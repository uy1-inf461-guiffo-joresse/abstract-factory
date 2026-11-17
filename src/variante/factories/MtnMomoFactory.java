package variante.factories;

import variante.abstractions.GenererRecu;
import variante.abstractions.InitierTransaction;
import variante.abstractions.OperateurPaiementFactory;
import variante.abstractions.VerifierSolde;
import variante.models.MtnGenererRecu;
import variante.models.MtnInitierTransaction;
import variante.models.MtnVerifierSolde;

public class MtnMomoFactory implements OperateurPaiementFactory {
    @Override
    public VerifierSolde creerVerifierSolde() {
        return new MtnVerifierSolde();
    }

    @Override
    public InitierTransaction creerInitierTransaction() {
        return new MtnInitierTransaction();
    }

    @Override
    public GenererRecu creerGenererRecu() {
        return new MtnGenererRecu();
    }
}
