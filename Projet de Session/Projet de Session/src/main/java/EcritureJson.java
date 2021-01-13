import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.io.IOException;

/**
 * S'occupe de l'écriture du fichier résultat en format JSON
 *
 * @author Samuel Kéroack
 * @CodePermanent : KERS15059307
 * @Version Été 2020
 */
public class EcritureJson {

    /**
     * Écrit dans le fichier de sortie le résultat de l'évaluation
     * d'admissibilité
     *
     * @param fichierSortie Le fichier à écrire
     * @param personne      La personne assurable
     * @param eligible      un boolean si la personne est éligible ou non à
     *                      l'assurance.
     * @throws JSONException si le fichier JSON est invalide.
     * @throws IOException   si le fichier de sortie est inaccessible
     */
    public static void ecrireFichierSortie(String fichierSortie,
                                           boolean eligible,
                                           Personne personne)
          throws IOException {
        try {
            JSONObject objetJson = new JSONObject();
            objetJson.put("eligible", eligible);
            //Si l'assuré est éligible on calcul le montant annuel
            if (eligible) {
                ajouterEligible(personne, objetJson);
            }
            DiskFile.saveStringIntoFile(fichierSortie, objetJson.toString(2));
        } catch (JSONException j) {
            System.out.println("Fichier JSON invalide");
        }
    }

    /**
     * Si la personne est éligbile à l'assurance on ajoute les champs
     * du montant_annuel et si elle est éligible à l'assurance collective
     * on ajoute les part à payé pour l'employé et l'employeur
     *
     * @param personne  assurée
     * @param objetJson de sortie à écrire
     */
    public static void ajouterEligible(Personne personne,
                                       JSONObject objetJson) {
        objetJson.put("montant_annuel",
              CalculPrime.calculerPrimeFinale(personne));
        if (personne.isAssCollective()) {
            objetJson.put("part_employeur",
                  CalculPrime.calculerParts(personne)[0]);
            objetJson.put("part_employe",
                  CalculPrime.calculerParts(personne)[1]);
        }
    }

}



