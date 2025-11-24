package com.mycompany.pc2_andrealiaga;

public class PasswordValidator {

    public static boolean isValid(String password) {

        // Escenario 1: null o vacío
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        // Longitud mínima y máxima
        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        // No espacios al inicio o final
        if (password.startsWith(" ") || password.endsWith(" ")) {
            return false;
        }

        // No permitir 2 o más espacios consecutivos
        if (password.contains("  ")) {
            return false;
        }

        // Caracteres especiales permitidos
        String allowedSpecials = "!@#$%^&*()_\\-+=\\{}\\[\\]|\\\\:;\"'<>,.?/";

        // Regex que permite letras, números, un espacio, y especiales válidos
        String allowedRegex = "A-Za-z0-9 " + allowedSpecials;

        // Validar que solo tenga caracteres permitidos
        if (!password.matches("[" + allowedRegex + "]+")) {
            return false;
        }

        // Al menos una mayúscula
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Al menos una minúscula
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Al menos un número
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Al menos un carácter especial permitido
        if (!password.matches(".*[" + allowedSpecials + "].*")) {
            return false;
        }

        return true;
    }
}