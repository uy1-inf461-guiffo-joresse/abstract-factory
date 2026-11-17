package variante.factories;

import variante.abstractions.GenererRecu;
import variante.abstractions.InitierTransaction;
import variante.abstractions.OperateurPaiementFactory;
import variante.abstractions.VerifierSolde;
import variante.models.CarteGenererRecu;
import variante.models.CarteInitierTransaction;
import variante.models.CarteVerifierSolde;

public class CarteBancaireFactory implements OperateurPaiementFactory {
    @Override
    public VerifierSolde creerVerifierSolde() {
        return new CarteVerifierSolde();
    }

    @Override
    public InitierTransaction creerInitierTransaction() {
        return new CarteInitierTransaction();
    }

    @Override
    public GenererRecu creerGenererRecu() {
        return new CarteGenererRecu();
    }
}
