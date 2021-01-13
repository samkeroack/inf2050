import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.io.IOException;


/**
 * Gère la lecture du fichier JSON et associe les éléments du fichiers
 * à un objet personne.
 *
 * @author Samuel Kéroack
 * @CodePermanent : KERS15059307
 * @Version Été 2020
 */
public class LectureJson {

    /**
     * Lit un fichier Json en parametre et l'associe à un objet personne
     * en appelant la méthode parseToPersonne
     *
     * @param filename le fichier Json
     * @param personne la personne assurée
     * @throws IOException si le fichier d'entrée est introuvable
     *                     ou innaccesible
     */
    public static void getJsonObject(String filename,
                                     Personne personne) throws IOException {
        try {
            //Lit le fichier en string et le convertit en JsonObject
            String jsonString = DiskFile.loadFileIntoString(filename);
            JSONObject object = (JSONObject) JSONSerializer.toJSON(jsonString);
            parseToPersonne(object, personne);
        } catch (NullPointerException | NumberFormatException
              | ClassCastException | JSONException n) {
            System.out.println("Le fichier JSON est invalide");
            System.exit(0);
        }
    }

    /**
     * Associe les clefs de l'objet Json aux attributs
     * d'un objet Personne
     *
     * @param object   L'objet JSON
     * @param personne L'objet Personne
     * @throws JSONException         Si le format JSON n'est pas respecté
     * @throws NumberFormatException Si la valeur n'est pas du bon type
     */
    private static void parseToPersonne(JSONObject object,
                                        Personne personne) throws JSONException,
          NumberFormatException, NullPointerException, ClassCastException {
        personne.setNom((String) object.get("nom"));
        personne.setGenre(Integer.parseInt(object.getString("genre").trim()));
        personne.setNaissance(object.getString("date_de_naissance").trim());
        personne.setAssCollective(object.getBoolean("assurance_collective"));
        JSONObject fumeurObject = (JSONObject) object.get("fumeur");
        personne.setFumeurTabac(fumeurObject.getBoolean("tabac"));
        personne.setFumeurCannabis(fumeurObject.getBoolean("cannabis"));
        personne.setAntecedents(object.getJSONArray("antecedents"));
        personne.setAlcool(object.getBoolean("alcool"));
        personne.setSports(object.getJSONArray("sports"));
        parseAssCollective(object, personne);
    }

    /**
     * Ajoute si la personne est souscrit à l'assurance collective les champs
     * sur l'assurance collective. Si le champ d'assurance collective est false
     * Mais que les champs de l'assurance collective sont présent, lance une
     * exception d'invalidité.
     *
     * @param object   JSON
     * @param personne qui va être attribuée les champs assurance collective.
     */
    private static void parseAssCollective(JSONObject object,
                                           Personne personne) throws JSONException {
        if (object.getBoolean("assurance_collective")) {
            personne.setEmployeur(object.getString("employeur").trim());
            personne.setNumContrat(object.getString("numero_contrat").trim());
            personne.setDateEmbauche(object.getString("date_embauche").trim());
            personne.setPartEmployeur(Integer.parseInt(
                  object.getString("part_employeur").trim()));
            personne.setLieuTravail(object.getString("lieu_travail").trim());
            ValidationAssCollective.validerAssCollective(personne);
        } else if (!object.getBoolean("assurance_collective")
              && ((object.has("employeur"))
              || object.has("numero_contrat") || object.has("date_embauche")
              || object.has("part_employeur") || object.has("lieu_travail"))) {
            throw new JSONException();
        }
    }
}



