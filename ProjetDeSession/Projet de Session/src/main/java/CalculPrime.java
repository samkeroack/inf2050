import org.apache.commons.math3.util.Precision;

/**
 * Sert à calculer la prime annuel que devra payer une personne assuré
 * Les primes varient selon le genre de la personne et les différentes
 * conditions de santé de la personne.
 *
 * @author Samuel Kéroack
 * @CodePermanent : KERS15059307
 * @Version Été 2020
 */
public class CalculPrime {
    /**
     * Calcul la prime de base d'une personne qui n'est pas un
     * homme (Genre: 0, 2, 9) selon son âge.
     *
     * @param personne a qui on calcule la prime de base
     * @return la prime de base de l'assuré
     */
    private static int calculerPrimeBaseNonHomme(Personne personne) {
        int prime;
        int age = personne.calculerAge();
        if (18 <= age && age <= 29) {
            prime = 100;
        } else if (30 <= age && age <= 40) {
            prime = 140;
        } else if (41 <= age && age <= 59) {
            prime = 155;
        } else if (60 <= age && age <= 73) {
            prime = 250;
        } else {
            prime = 600;
        }
        return prime;
    }

    /**
     * Calcul la prime de base d'un homme (Genre=1) selon son âge.
     *
     * @param personne un homme assuré
     * @return la prime de base de l'assuré
     */
    private static int calculerPrimeBaseHomme(Personne personne) {
        int prime;
        int age = personne.calculerAge();
        if (18 <= age && age <= 29) {
            prime = 150;
        } else if (30 <= age && age <= 40) {
            prime = 165;
        } else if (41 <= age && age <= 59) {
            prime = 200;
        } else if (60 <= age && age <= 73) {
            prime = 350;
        } else {
            prime = 700;
        }
        return prime;
    }

    /**
     * Vérifie quel prime devra être calculé pour le genre de la personne
     *
     * @param personne que l'on calcul sa prime de base
     * @return prime de base de la personne assurée
     */
    private static int verifierGenre(Personne personne) {
        int primeBase;
        if (personne.getGenre() == 1) {
            primeBase = calculerPrimeBaseHomme(personne);
        } else {
            primeBase = calculerPrimeBaseNonHomme(personne);
        }
        return primeBase;
    }

    /**
     * Calcul la prime finale (montant annuel) que l'assuré devra payé selon
     * différents critères
     *
     * @param personne assurée
     * @return le montant annuel à payer par l'assuré.
     */
    public static double calculerPrimeFinale(Personne personne) {
        int primeBase = verifierGenre(personne);
        double primeFinale = primeBase;
        if (personne.isFumeurTabac() || personne.isFumeurCannabis())
            primeFinale += 100;
        if (personne.isAlcool())
            primeFinale = primeFinale + (primeBase * 0.05);
        if (personne.getAntecedents().size() > 2)
            primeFinale = primeFinale + (primeBase * 0.15);
        if (personne.getSports().size() == 0)
            primeFinale += 25;
        if (personne.diagnostiquerCancer())
            primeFinale = primeFinale + (primeBase * 0.5);
        return primeFinale;
    }

    /**
     * Calculer prime payé par l'employeur et par l'employé
     *
     * @param personne assurée
     * @return tableau contenant les parts payés par l'employeur et l'employé
     * [0]=employeur
     * [1]=employé
     */
    public static double[] calculerParts(Personne personne) {
        double[] parts = new double[2];
        parts[0] = Precision.round(calculerPrimeFinale(personne)
              * personne.getPartEmployeur() / 100, 2);
        parts[1] = Precision.round(calculerPrimeFinale(personne) - parts[0], 2);
        return parts;
    }
}
