import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Gère les attributs d'une personne souscrit à l'assurance.
 *
 * @author Samuel Kéroack
 * @CodePermanent : KERS15059307
 * @Version Été 2020
 */
public class Personne {

    private String nom;
    private int genre;
    private String naissance;
    private boolean assCollective;
    private boolean fumeurTabac;
    private boolean fumeurCannabis;
    private boolean alcool;
    private JSONArray antecedents;
    private JSONArray sports;
    private String employeur;
    private String numContrat;
    private String dateEmbauche;
    private int partEmployeur;
    private String lieuTravail;


    //Constructeurs

    public Personne(String nom, int genre, String naissance,
                    boolean assCollective, boolean fumeurTabac,
                    boolean fumeurCannabis, boolean alcool,
                    JSONArray antecedents, JSONArray sports) {
        this.nom = nom;
        this.genre = genre;
        this.naissance = naissance;
        this.assCollective = assCollective;
        this.fumeurTabac = fumeurTabac;
        this.fumeurCannabis = fumeurCannabis;
        this.alcool = alcool;
        this.antecedents = antecedents;
        this.sports = sports;
    }

    public Personne() {
    }

    //Getters & Setters


    public String getNom() {
        return nom;
    }

    public JSONArray getAntecedents() {
        return antecedents;
    }

    /**
     * Si les éléments du JsonArray en paramètre ne sont pas vides
     * ils sont ajouté à l'attribut antecedents
     *
     * @param antecedents
     */
    public void setAntecedents(JSONArray antecedents) {
        this.antecedents = new JSONArray();
        for (int i = 0; i < antecedents.size(); i++)
            if (!antecedents.getJSONObject(i).isEmpty()
                    && !antecedents.getJSONObject(i).getString("diagnostic").isBlank()
                    && !antecedents.getJSONObject(i).getString("depuis").isBlank()) {
                this.antecedents.add(antecedents.getJSONObject(i));
            }
    }

    public JSONArray getSports() {
        return sports;
    }

    /**
     * Si les éléments du JSONarray en paramètre ne sont pas vide ils sont
     * ajouté à l'attributs sports
     *
     * @param sports
     */
    public void setSports(JSONArray sports) {
        this.sports = new JSONArray();
        for (int i = 0; i < sports.size(); i++) {
            if (!sports.get(i).equals("")) {
                this.sports.add(sports.getString(i));
            }
        }
    }


    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public String getNumContrat() {
        return numContrat;
    }

    public void setNumContrat(String numContrat) {
        this.numContrat = numContrat;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getPartEmployeur() {
        return partEmployeur;
    }

    public void setPartEmployeur(int partEmployeur) {
        this.partEmployeur = partEmployeur;
    }

    public String getLieuTravail() {
        return lieuTravail;
    }

    public void setLieuTravail(String lieuTravail) {
        this.lieuTravail = lieuTravail;
    }

    public void setNom(String nom) {
        if (nom == null) {
            throw new NullPointerException();
        } else {
            this.nom = nom;
        }
    }


    public boolean isFumeurTabac() {
        return fumeurTabac;
    }


    public void setFumeurTabac(boolean fumeurTabac) {
        this.fumeurTabac = fumeurTabac;
    }


    public boolean isFumeurCannabis() {
        return fumeurCannabis;
    }


    public void setFumeurCannabis(boolean fumeurCannabis) {
        this.fumeurCannabis = fumeurCannabis;
    }


    public int getGenre() {
        return genre;
    }

    /**
     * Vérifie si le genre est défini par la norme ISO 5218
     * Sinon, affiche un message d'erreur et quitte le programme.
     *
     * @param genre en format numérique (ISO 5218)
     */
    public void setGenre(int genre) {
        if (genre != 0 && genre != 1 && genre != 2 && genre != 9) {
            System.out.println("Le genre est invalide. (ISO 5218)");
            System.exit(0);
        } else {
            this.genre = genre;
        }
    }


    public String getNaissance() {
        return naissance;
    }


    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public boolean isAssCollective() {
        return assCollective;
    }

    public void setAssCollective(boolean assCollective) {
        this.assCollective = assCollective;
    }

    public boolean isAlcool() {
        return alcool;
    }


    public void setAlcool(boolean alcool) {
        this.alcool = alcool;
    }

    //Méthodes utilitaires de Personne.

    /**
     * Vérifie si un des diagnostic d'une personne est un cancer
     *
     * @return un boolean si la personne a un diagnostic de cancer
     */
    public boolean diagnostiquerCancer() {
        String diagnostic;
        boolean cancer = false;
        try {
            for (Object jsonObject : this.getAntecedents()) {
                diagnostic = ((String) ((JSONObject)
                        jsonObject).get("diagnostic")).toLowerCase();
                if (diagnostic.contains("cancer")) {
                    cancer = true;
                }
            }
        } catch (ClassCastException | NullPointerException c) {
            System.out.println("Antecedent(s) invalide(s)");
            System.exit(0);
        }

        return cancer;
    }

    /**
     * Calcule l'age d'une personne avec sa date de naissance en
     * format ISO-8601
     *
     * @return l'age de la personne
     * @throws DateTimeException si la date de naissance est après la
     *                           date actuelle.
     */
    public int calculerAge() throws DateTimeException {
        try {
            LocalDate naissance = LocalDate.parse(this.getNaissance(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            testerDateAnterieure(naissance);
            return Period.between(naissance, LocalDate.now()).getYears();
        } catch (DateTimeParseException | NullPointerException d) {
            System.out.println("Date de naissance invalide. (ISO-8601)");
            System.exit(0);
        }
        return 0;
    }

    /**
     * Calcul l'ancienneté d'une personne à son emploi actuel
     *
     * @return le nombre de mois qu'elle est à cet emploi
     * @throws DateTimeException si la date d'embauche est après la
     *                           date actuelle
     */
    public int calculerAnciennete() throws DateTimeException {
        try {
            LocalDate embauche = LocalDate.parse(this.getDateEmbauche(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            testerDateAnterieure(embauche);
            if (Period.between(embauche, LocalDate.now()).getYears() < 1) {
                return Period.between(embauche, LocalDate.now()).getMonths();
            } else {
                return Period.between(embauche, LocalDate.now()).getYears() * 12
                        + Period.between(embauche, LocalDate.now()).getMonths();
            }
        } catch (DateTimeParseException | NullPointerException d) {
            System.out.println("Date d'embauche invalide. (ISO-8601)");
            System.exit(0);
        }
        return 0;
    }

    /**
     * Test si la date passé en paramètre est antérieure à la date d'audjoud'hui
     *
     * @param date à tester
     */
    private void testerDateAnterieure(LocalDate date) {
        if (LocalDate.now().isBefore(date)) {
            throw new DateTimeException("La date d'embauche est "
                    + "postérieure à aujourd'hui");
        }
    }
}



