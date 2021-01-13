import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FichierTest {

    @Test
    public void testNomFichier(){

        assertEquals("fichier.txt", Fichier.nomFichier("/user/ela/blablabla/fichier.txt"));
    }

    @Test
    public void testExtension(){
        assertEquals("txt", Fichier.extension("/user/ela/blablabla/fichier.txt"));

    }


}