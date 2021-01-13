import net.sf.json.JSONArray;

import java.time.DateTimeException;

/**
 * Gère l'admissibilité d'une personne à l'assurance selon différents critères
 *
 * @author Samuel Kéroack
 * @CodePermanent : KERS15059307
 * @Version Été 2020
 */
public class Admissibilite {
    /**
     * Vérifie si la personne est assurable selon son âge
     *
     * @param personne assurée
     * @return si assurable ou non
     */
    private static boolean verifierAge(Personne personne) {
        try {
            return personne.calculerAge() >= 18
                  && personne.calculerAge() <= 85;
        } catch (DateTimeException d) {
            System.out.println("La date de naissance est postérieure"
                  + " à aujourd'hui.");
            System.exit(0);
        }
        return false;
    }

    /**
     * Vérifie l'éligibilté d'une personne selon la ville où elle travaille.
     *
     * @param personne assurée
     * @return si assurable ou non
     */
    private static boolean verifierVille(Personne personne) {
        return !(personne.getLieuTravail()
              .toLowerCase().contains("havre-saint-pierre")
              || personne.getLieuTravail().toLowerCase().contains("chibougamau")
              || personne.getLieuTravail().toLowerCase().contains("carignan")
              || personne.getLieuTravail().toLowerCase().contains("entrelacs")
              || personne.getLieuTravail().toLowerCase().contains("fasset"));
    }

    /**
     * Vérifie l'éligibilité d'une personne selon son ancienneté à son emploi
     *
     * @param personne assurée
     * @return si assurable ou non
     */
    private static boolean verifierAnciennete(Personne personne) {
        try {
            return personne.calculerAnciennete() >= 3;
        } catch (DateTimeException d) {
            System.out.println("La date d'embauche est postérieure"
                  + " à aujourd'hui.");
            System.exit(0);
        }
        return false;
    }

    /**
     * Vérifie si la personne est assurable selon les sports qu'elle pratique
     *
     * @param personne assurée
     * @return si assurable ou non
     */
    private static boolean verifierSportsDangereux(Personne personne) {
        JSONArray array = personne.getSports();
        for (Object o : array) {
            try {
                if ((((String) o).equalsIgnoreCase("Bungee")
                      || o.toString().equalsIgnoreCase("Saut en parachute"))
                      || o.toString().equalsIgnoreCase("Escalade")) {
                    return false;
                }
            } catch (ClassCastException c) {
                System.out.println("Sport(s) invalide(s)");
                System.exit(0);
            }
        }
        return true;
    }

    /**
     * Vérifie si la personne est assurable selon si elle est fumeuse ou non
     *
     * @param personne assurée
     * @return si assurable ou non
     */
    private static boolean verifierFumeur(Personne personne) {
        return !(personne.isFumeurTabac() && personne.isFumeurCannabis());
    }

    /**
     * Vérifie si la personne est assurable selon son âge si c'est une homme
     *
     * @param personne assurée
     * @return assurable ou non
     */
    private static boolean verifierAgeHomme(Personne personne) {
        boolean eligible = true;
        if (personne.getGenre() == 1
              && personne.calculerAge() > 80) {
            eligible = false;
        }
        return eligible;
    }

    /**
     * Vérifie si la personne est assurable selon tous les critères
     * d'assurabilités
     *
     * @param personne assurée
     * @return assurable ou non
     */
    public static boolean verifierEligibilite(Personne personne) {
        if (personne.isAssCollective()) {
            return verifierSportsDangereux(personne)
                  && verifierAge(personne)
                  && verifierFumeur(personne)
                  && verifierAgeHomme(personne)
                  && verifierVille(personne)
                  && verifierAnciennete(personne);
        } else {
            return verifierAge(personne)
                  && verifierAgeHomme(personne)
                  && verifierFumeur(personne)
                  && verifierSportsDangereux(personne);
        }
    }
}
