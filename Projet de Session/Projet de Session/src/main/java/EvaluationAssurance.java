
import java.io.IOException;

/**
 * Gère l'évaluation d'assurance d'une personne selon divers critères
 * On établie l'assurabilité d'une personne et on calcul le montant annuel
 * de la prime si la personne est admissible.
 * Les informations sont lus et écrits en format Json.
 *
 * @author Samuel Kéroack
 * @CodePermanent : KERS15059307
 * @Version Été 2020
 */
public class EvaluationAssurance {
    /**
     * Main du logiciel, prend en paramètre deux fichiers Json soit
     * un fichier d'entrée et un fichier de sortie.
     *
     * @param args 2 fichiers Json
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                String fichierEntree = args[0];
                String fichierSortie = args[1];
                Personne personne = new Personne();
                LectureJson.getJsonObject(fichierEntree, personne);
                EcritureJson.ecrireFichierSortie(fichierSortie,
                      Admissibilite.verifierEligibilite(personne),
                      personne);
            } catch (IOException e) {
                System.out.println("Fichiers en arguments inaccessibles.");
            }
        } else {
            System.out.println("Fichiers JSON manquants en paramètre.");
        }
    }
}

