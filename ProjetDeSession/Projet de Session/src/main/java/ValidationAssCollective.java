/**
 * Vérifie si les données de l'assurance collective sont bonnes selon
 * différents critères de validation
 *
 * @author Samuel Kéroack
 * @CodePermanent : KERS15059307
 * @Version Été 2020
 */
public class ValidationAssCollective {
    /**
     * Vérifie que le nom de l'employeur est valide (Entre 5 et 50 caractères)
     *
     * @param personne assurée
     * @return si le nom de l'employeur est valide
     */
    private static boolean validerNomEmployeur(Personne personne) {
        return personne.getEmployeur().length() >= 5
              && personne.getEmployeur().length() <= 50;
    }

    /**
     * Vérifie que la part payée par l'employeur est valide (Entre 0 et 100%)
     *
     * @param personne assurée
     * @return si le pourcentage est valide
     */
    private static boolean validerPourcentageEmployeur(Personne personne) {
        return personne.getPartEmployeur() >= 0
              && personne.getPartEmployeur() <= 100;
    }

    /**
     * Vérifie que le numéro de contrat est valide (Commence par : A, R , H
     * suivi d'un nombre entre 1000 et 7000)
     *
     * @param personne assurée
     * @return si le numéro de contrat est valide
     */
    private static boolean validerNumContrat(Personne personne) {
        try {
            return personne.getNumContrat().length() == 5
                  && (personne.getNumContrat().charAt(0) == 'A'
                  || personne.getNumContrat().charAt(0) == 'R'
                  || personne.getNumContrat().charAt(0) == 'H'
                  || personne.getNumContrat().charAt(0) == 'a'
                  || personne.getNumContrat().charAt(0) == 'r'
                  || personne.getNumContrat().charAt(0) == 'h')
                  && Integer.parseInt(personne.getNumContrat().substring(1,
                  5)) >= 1000
                  && Integer.parseInt(personne.getNumContrat().substring(1,
                  5)) <= 7000;
        } catch (IndexOutOfBoundsException n) {
            System.out.println("Numéro de contrat invalide");
            System.exit(0);
        }
        return false;
    }

    /**
     * Vérifie les conditions pour qu'une assurance collective soit valide
     *
     * @param personne assurée
     */
    public static void validerAssCollective(Personne personne) {
        try {
            if (!validerNomEmployeur(personne)) {
                throw new Exception("Nom employeur invalide");
            } else if (!validerNumContrat(personne)) {
                throw new Exception("Numéro de contrat invalide");
            } else if (!validerPourcentageEmployeur(personne)) {
                throw new Exception("Pourcentage payé par l'employeur "
                      + "invalide");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(0);
        }
    }
}
