package variante.abstractions;

public interface OperateurPaiementFactory {
    VerifierSolde creerVerifierSolde();

    InitierTransaction creerInitierTransaction();

    GenererRecu creerGenererRecu();
}
