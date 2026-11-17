# Agrégateur de paiements — Abstract Factory

**Étudiant :** GUIFFO TATCHIM JORESSE  
**Matricule :** 25G2037  
**Formation :** Master 1 SIGL  
**Cours :** INF461 — Génie logiciel

Ce projet présente le patron **Abstract Factory** avec l’exemple générique du cours et une passerelle de simulation pour paiements de la zone CEMAC. La variante FinTech regroupe vérification de disponibilité, débit et reçu dans des familles cohérentes pour Orange Money, MTN Mobile Money et carte bancaire GIMAC/Visa.

## Arborescence

```text
src/
├── cours/                         # Exemple générique du cours, conservé
│   ├── abstractions/
│   ├── factories/
│   ├── models/
│   └── Client.java
├── variante/                      # Agrégateur de paiements CEMAC
│   ├── abstractions/              # Opérations et fabrique abstraites
│   ├── factories/                 # Fabriques des trois opérateurs
│   ├── models/                    # Produits concrets par opérateur
│   └── SimulateurPaiementClient.java
└── tests/
    └── ValidationPaiementFactoryTest.java

diagramme_variante_paiement.puml   # Diagramme UML de la variante
```

## Compiler et exécuter

Depuis la racine, avec un JDK installé :

```sh
javac -d bin src/cours/**/*.java src/variante/**/*.java src/tests/*.java
```

Cette commande utilise l’expansion récursive `**` d’un shell compatible, tel que Bash avec `globstar` activé.

Exécuter l’exemple générique :

```sh
java -cp bin cours.Client
```

Simuler les paiements des trois opérateurs :

```sh
java -cp bin variante.SimulateurPaiementClient
```

Lancer les tests avec assertions activées :

```sh
java -ea -cp bin tests.ValidationPaiementFactoryTest
```

## Analyse architecturale

### Découplage et inversion des dépendances

Le simulateur dépend de `OperateurPaiementFactory` et des abstractions `VerifierSolde`, `InitierTransaction` et `GenererRecu`. Il orchestre le scénario sans importer de produit concret. Les fabriques concrètes assemblent les détails propres à chaque fournisseur. Le code de haut niveau dépend ainsi des abstractions, conformément au Principe d’Inversion de Dépendance (DIP).

### Cohérence transactionnelle

Chaque fabrique produit un trio du même opérateur : vérificateur, initiateur de débit et générateur de reçu. Le client ne combine donc pas, par exemple, une vérification Orange Money avec un débit MTN et un reçu carte. Cette cohérence d’assemblage est garantie par le choix d’une seule fabrique pour tout le scénario.

### Extensibilité des opérateurs

Ajouter un opérateur revient à créer ses trois produits et une implémentation de `OperateurPaiementFactory`. Le simulateur peut ensuite recevoir cette fabrique sans changer son orchestration. Cela illustre le principe Ouvert/Fermé (OCP) pour l’ajout de familles, même si le point de composition qui sélectionne les opérateurs doit connaître les nouvelles fabriques.

### Compromis lors d’une nouvelle opération

Ajouter une opération de paiement, comme l’annulation ou le remboursement, impose de modifier `OperateurPaiementFactory` et chacune de ses fabriques. Chaque fournisseur doit aussi fournir le nouveau produit concret. Abstract Factory facilite l’ajout de familles d’opérateurs, mais rend l’ajout d’un nouveau type d’opération plus coûteux.

### Périmètre de la simulation

Les produits sont des simulateurs pédagogiques : ils n’appellent aucun service bancaire, ne vérifient aucun solde réel et ne débitent aucun compte. Le montant est exprimé en XAF.
