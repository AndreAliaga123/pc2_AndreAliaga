package com.mycompany.pc2_andrealiaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    // CASO 1: Texto con solo espacios
    @Test
    public void testTextoSoloEspacios() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize("   ");
        });

        assertEquals("El texto no puede estar vacío", ex.getMessage());
    }

    // CASO 2: Texto null
    @Test
    public void testTextoNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(null);
        });

        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    // CASO 3: Texto mayor a 1000 caracteres
    @Test
    public void testTextoMayorA1000() {
        String largo = "a".repeat(1001);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(largo);
        });

        assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
    }

    // CASO 4: Texto se invierte correctamente
    @Test
    public void testInvertirTexto() {
        String result = TextProcessor.reverseAndCapitalize("hola");
        assertEquals("ALOH", result);
    }

    // CASO 5: Texto convierte a mayúscula
    @Test
    public void testTextoMayusculas() {
        String result = TextProcessor.reverseAndCapitalize("hola");
        assertEquals("ALOH", result);
    }

    // CASO 6: Texto elimina espacios finales
    @Test
    public void testEliminarEspaciosFinales() {
        String result = TextProcessor.reverseAndCapitalize("hola   ");
        assertEquals("ALOH", result);
    }
}