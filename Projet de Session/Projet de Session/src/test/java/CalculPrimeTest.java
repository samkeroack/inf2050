import net.sf.json.JSONArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculPrimeTest {

    @Test
    void calculerPrimeFinale() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("2000-01-01");
        p1.setGenre(1);
        p1.setAlcool(true);
        p1.setAntecedents(j1);
        p1.setSports(j1);
        assertEquals(182.5, CalculPrime.calculerPrimeFinale(p1));
    }

    @Test
    void calculerPrimeFinale2() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("2000-01-01");
        p1.setGenre(2);
        p1.setAlcool(true);
        p1.setAntecedents(j1);
        p1.setSports(j1);
        assertEquals(130, CalculPrime.calculerPrimeFinale(p1));
    }

    @Test
    void calculerPrimeFinale3() {
        Personne p2 = new Personne();
        JSONArray j1 = new JSONArray();
        p2.setNaissance("1980-01-01");
        p2.setGenre(2);
        p2.setAlcool(true);
        p2.setAntecedents(j1);
        p2.setSports(j1);
        assertEquals(172, CalculPrime.calculerPrimeFinale(p2));
    }

    @Test
    void calculerPrimeFinale4() {
        Personne p3 = new Personne();
        JSONArray j1 = new JSONArray();
        p3.setNaissance("1970-01-01");
        p3.setGenre(1);
        p3.setAlcool(true);
        p3.setAntecedents(j1);
        p3.setSports(j1);
        assertEquals(235, CalculPrime.calculerPrimeFinale(p3));
    }

    @Test
    void calculerPrimeFinale5() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("1960-01-01");
        p1.setGenre(2);
        p1.setAlcool(true);
        p1.setAntecedents(j1);
        p1.setSports(j1);
        assertEquals(287.5, CalculPrime.calculerPrimeFinale(p1));
    }

    @Test
    void calculerPrimeFinale6() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("1950-01-01");
        p1.setGenre(2);
        p1.setAlcool(true);
        p1.setAntecedents(j1);
        p1.setSports(j1);
        assertEquals(287.5, CalculPrime.calculerPrimeFinale(p1));
    }

    @Test
    void calculerPrimeFinale7() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("1950-01-01");
        p1.setGenre(2);
        p1.setAlcool(true);
        p1.setAntecedents(j1);
        p1.setSports(j1);
        assertEquals(287.5, CalculPrime.calculerPrimeFinale(p1));
    }

    @Test
    void calculerParts() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("2000-01-01");
        p1.setGenre(1);
        p1.setAlcool(true);
        p1.setAntecedents(j1);
        p1.setSports(j1);
        p1.setPartEmployeur(50);
        double [] parts = new double []{91.25, 91.25};
        assertArrayEquals(parts, CalculPrime.calculerParts(p1));
    }

    @Test
    void calculerParts2() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("2000-01-01");
        p1.setGenre(1);
        p1.setAlcool(true);
        p1.setAntecedents(j1);
        p1.setSports(j1);
        p1.setPartEmployeur(0);
        double [] parts = new double []{0, 182.5};
        assertArrayEquals(parts, CalculPrime.calculerParts(p1));
    }

    @Test
    void calculerParts3() {
        Personne p1 = new Personne();
        JSONArray j1 = new JSONArray();
        p1.setNaissance("2000-01-01");
        p1.setGenre(1);
        p1.setAlcool(true);
        p1.setAntecedents(j1);
        p1.setSports(j1);
        p1.setPartEmployeur(100);
        double [] parts = new double []{182.5, 0};
        assertArrayEquals(parts, CalculPrime.calculerParts(p1));
    }
}