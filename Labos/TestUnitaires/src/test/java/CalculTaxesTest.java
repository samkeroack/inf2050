import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculTaxesTest {

    @Test
    void calculerTaxeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->CalculTaxes.calculerTaxe(0,true, true));
    }

    @Test
    void calculerTaxeTest2() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->CalculTaxes.calculerTaxe(-9,true, true));
    }


    @Test
    void calculerTaxeTest3() {
        assertEquals(105, CalculTaxes.calculerTaxe(100, true, false));
    }

    @Test
    void calculerTaxeTest4() {
        assertEquals(110, CalculTaxes.calculerTaxe(100, false, true));
    }

    @Test
    void calculerTaxeTest5() {
        assertEquals(115, CalculTaxes.calculerTaxe(100, true, true));
    }
}