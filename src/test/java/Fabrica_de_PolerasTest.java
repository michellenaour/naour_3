import org.junit.Test;

import static org.junit.Assert.*;

public class Fabrica_de_PolerasTest {

    @Test
    public void crearPedido() {
    }

    @Test
    public void TestvalidarOpcion() {
        assertEquals(true, Fabrica_de_Poleras.validarOpción(1));
        assertEquals(false, Fabrica_de_Poleras.validarOpción(4));

    }

    @Test
    public void TestvalidarTalla() {
        assertEquals(true, Fabrica_de_Poleras.validarTalla("S"));
        assertEquals(false, Fabrica_de_Poleras.validarTalla(""));
    }

    @Test
    public void TestvalidarTipo() {
        assertEquals(true, Fabrica_de_Poleras.validarTipo("spandex"));
        assertEquals(false, Fabrica_de_Poleras.validarTipo(" "));
    }

    @Test
    public void TestvalidarEstampado() {
        assertEquals(true, Fabrica_de_Poleras.validarEstampado("no"));
        assertEquals(false, Fabrica_de_Poleras.validarEstampado(" "));
    }


}