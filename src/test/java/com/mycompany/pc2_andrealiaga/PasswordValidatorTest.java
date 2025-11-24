package com.mycompany.pc2_andrealiaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    // CASO 1: Contraseña válida
    @Test
    public void testContrasenaValida() {
        String password = "As1234!11";
        boolean result = PasswordValidator.isValid(password);
        assertTrue(result);
    }

    // CASO 2: Sin carácter especial
    @Test
    public void testSinCaracterEspecial() {
        String password = "Andre1234";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 3: Espacio al inicio
    @Test
    public void testEspacioAlInicio() {
        String password = " hola1234";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 4: Contraseña null → debe lanzar excepción
    @Test
    public void testContrasenaNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid(null);
        });
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    // CASO 5: Sin números
    @Test
    public void testSinNumeros() {
        String password = "Adscurso!";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 6: Sin mayúscula
    @Test
    public void testSinMayuscula() {
        String password = "holapromedio!";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 7: Longitud menor a 8
    @Test
    public void testLongitudMenorOcho() {
        String password = "Ab1!";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 8: Longitud mayor a 64
    @Test
    public void testLongitudMayorSesentaYCuatro() {
        String password = "A1!abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 9: Espacio al final
    @Test
    public void testEspacioAlFinal() {
        String password = "Hola1234! ";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 10: Dos espacios consecutivos
    @Test
    public void testDosEspaciosConsecutivos() {
        String password = "Ho  la123!";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 11: Carácter NO permitido
    @Test
    public void testCaracterNoPermitido() {
        String password = "Hola123~"; // "~" NO está en la lista
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 12: Sin minúscula
    @Test
    public void testSinMinuscula() {
        String password = "HOLA1234!";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 13: Sin carácter especial
    @Test
    public void testSinCaracterEspecial2() {
        String password = "Hola12345";
        boolean result = PasswordValidator.isValid(password);
        assertFalse(result);
    }

    // CASO 14: Contraseña válida con 1 espacio interno
    @Test
    public void testEspacioPermitidoInterno() {
        String password = "Hola 123!";
        boolean result = PasswordValidator.isValid(password);
        assertTrue(result);
    }

}
