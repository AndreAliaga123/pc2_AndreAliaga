package com.mycompany.pc2_andrealiaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    // CASO 1: Correo tiene menos de 6 caracteres
    @Test
    public void testCorreoMenosDe6() {
        String email = "a@b.c"; // 5 caracteres
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

    // CASO 2: Correo comienza con un punto
    @Test
    public void testCorreoComienzaConPunto() {
        String email = ".Andre@yahoo.com";
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

    // CASO 3: Correo tiene dos puntos consecutivos
    @Test
    public void testCorreoDosPuntosConsecutivos() {
        String email = "andre..ortiz@yahoo.com";
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

    // CASO 4: Correo tiene espacios
    @Test
    public void testCorreoConEspacios() {
        String email = "andre ortiz@yahoo.com";
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

    // CASO 5: Correo null o vacío → excepción
    @Test
    public void testCorreoNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            EmailValidator.isValid(null);
        });

        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    // CASO 6: Correo válido
    @Test
    public void testCorreoValido() {
        String email = "andreoj@gmail.com";
        boolean result = EmailValidator.isValid(email);
        assertTrue(result);
    }

    // EXTRA 1: Correo vacío "" → excepción
    @Test
    public void testCorreoVacio() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            EmailValidator.isValid("");
        });
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

// EXTRA 2: Correo mayor a 254 caracteres
    @Test
    public void testCorreoMayorA254() {
        String longLocal = "a".repeat(260);
        String email = longLocal + "@gmail.com"; // supera 254
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

// EXTRA 3: Correo con múltiples @
    @Test
    public void testCorreoMultiplesArrobas() {
        String email = "andre@ortiz@gmail.com";
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

// EXTRA 4: Local vacío antes del @
    @Test
    public void testLocalVacio() {
        String email = "@gmail.com";
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

// EXTRA 5: Local termina con punto
    @Test
    public void testLocalTerminaConPunto() {
        String email = "andre.@gmail.com";
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

// EXTRA 6: Local contiene carácter inválido
    @Test
    public void testLocalConCaracterInvalido() {
        String email = "andre!@gmail.com"; // ! no permitido
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

// EXTRA 7: Dominio sin punto
    @Test
    public void testDominioSinPunto() {
        String email = "andre@gmail";
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

// EXTRA 8: Dominio con menos de 2 caracteres antes del punto
    @Test
    public void testDominioCortoAntesDelPunto() {
        String email = "andre@g.com"; // solo 1 char antes del punto
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

// EXTRA 9: Dominio con caracteres inválidos
    @Test
    public void testDominioConCaracterInvalido() {
        String email = "andre@gm%ail.com"; // % no permitido
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }

// EXTRA 10: Extensión menor a 2 caracteres
    @Test
    public void testExtensionMenorA2() {
        String email = "andre@gmail.c"; // extensión de 1 char
        boolean result = EmailValidator.isValid(email);
        assertFalse(result);
    }
}
