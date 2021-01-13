import net.sf.json.JSONArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdmissibiliteTest {

    @Test
    void verifierEligibilite() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("2000-01-01");
        p1.setLieuTravail("Vaudreuil");
        p1.setDateEmbauche("2000-05-05");
        p1.setSports(j1);
        assertTrue(Admissibilite.verifierEligibilite(p1));
    }

    @Test
    void verifierEligibilite2() {
        Personne p2 = new Personne();
        JSONArray j1 = new JSONArray();
        j1.add(0, "Baseball");
        p2.setAssCollective(true);
        p2.setNaissance("2000-01-01");
        p2.setLieuTravail("Vaudreuil");
        p2.setDateEmbauche("2000-05-05");
        p2.setSports(j1);
        assertTrue(Admissibilite.verifierEligibilite(p2));
    }
}