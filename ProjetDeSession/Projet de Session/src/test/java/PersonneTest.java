import net.sf.json.JSONArray;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    Personne p1 = new Personne();

    @Test
    void getAntecedentNull() {
        assertNull(p1.getAntecedents());
    }


    @Test
    void getSportsNull() {
        assertNull(p1.getSports());
    }

    @Test
    void setSports() {
    }

    @Test
    void getEmployeurNull() {
        assertNull(p1.getEmployeur());
    }

    @Test
    void getEmployeur(){
        p1.setEmployeur("Bureau en gros");
        assertEquals("Bureau en gros", p1.getEmployeur());
    }

    @Test
    void setEmployeur() {
        p1.setEmployeur("UQAM");
        assertEquals(p1.getEmployeur(), "UQAM");
    }

    @Test
    void getNumContratNull() {
        assertNull(p1.getEmployeur());
    }

    @Test
    void getNumContrat() {
        p1.setNumContrat("A1200");
        assertEquals("A1200", p1.getNumContrat());
    }


    @Test
    void setNumContrat() {
        p1.setNumContrat("R1234");
        assertEquals(p1.getNumContrat(), "R1234");
    }

    @Test
    void getDateEmbauche() {
        assertNull(p1.getDateEmbauche());
    }

    @Test
    void setDateEmbauche() {
        p1.setDateEmbauche("2000-01-01");
        assertEquals(p1.getDateEmbauche(), "2000-01-01");
    }

    @Test
    void getPartEmployeur() {
        assertEquals(0, p1.getPartEmployeur());
    }

    @Test
    void setPartEmployeur() {
        p1.setPartEmployeur(50);
        assertEquals(p1.getPartEmployeur(), 50);
    }

    @Test
    void getLieuTravail() {
        assertNull(p1.getLieuTravail());
    }

    @Test
    void setLieuTravail() {
        p1.setLieuTravail("Montréal");
        assertEquals(p1.getLieuTravail(), "Montréal");
    }

    @Test
    void setNom() {
        p1.setNom("Samuel");
        assertEquals(p1.getNom(), "Samuel");
    }

    @Test
    void isFumeurTabac() {
        assertFalse(p1.isFumeurTabac());
    }

    @Test
    void setFumeurTabac() {
        p1.setFumeurTabac(false);
        assertFalse(p1.isFumeurTabac());
    }

    @Test
    void isFumeurCannabis() {
        assertFalse(p1.isFumeurCannabis());
    }

    @Test
    void setFumeurCannabis() {
        p1.setFumeurCannabis(true);
        assertTrue(p1.isFumeurCannabis());
    }

    @Test
    void getGenre() {
        assertEquals(0, p1.getGenre());
    }

    @Test
    void setGenre() {
        p1.setGenre(2);
        assertEquals(p1.getGenre(), 2);
    }

    @Test
    void getNaissance() {
        assertNull(p1.getNaissance());
    }

    @Test
    void setNaissance() {
        p1.setNaissance("2000-01-01");
        assertEquals(p1.getNaissance(), "2000-01-01");
    }

    @Test
    void isAssCollective() {
        assertFalse(p1.isAssCollective());
    }

    @Test
    void setAssCollective() {
        p1.setAssCollective(true);
        assertTrue(p1.isAssCollective());
    }

    @Test
    void isAlcool() {
        assertFalse(p1.isAlcool());
    }

    @Test
    void setAlcool() {
        p1.setAlcool(true);
        assertTrue(p1.isAlcool());
    }

    @Test
    void calculerAge() {
        p1.setNaissance("2000-07-01");
        assertEquals(20, p1.calculerAge());
    }

    @Test
    void calculerAnciennete() {
        p1.setDateEmbauche("2000-06-01");
        assertEquals(241, p1.calculerAnciennete());
    }
}