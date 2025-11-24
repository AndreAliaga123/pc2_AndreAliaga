package com.mycompany.pc2_andrealiaga;

public class EmailValidator {

    public static boolean isValid(String email) {

        // Escenario 1: null o vacío
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        // No espacios permitidos
        if (email.contains(" ")) {
            return false;
        }

        // Longitud mínima y máxima
        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        // Debe contener exactamente un @
        int atIndex = email.indexOf("@");
        int lastAtIndex = email.lastIndexOf("@");

        if (atIndex == -1 || atIndex != lastAtIndex) {
            return false; // no @ o múltiples @
        }

        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);

        // Validar parte local
        // - No puede iniciar ni terminar con punto
        // - No puede tener dos puntos consecutivos
        if (local.isEmpty() ||
            local.startsWith(".") ||
            local.endsWith(".") ||
            local.contains("..")) {
            return false;
        }

        // Parte local solo puede tener letras, números, puntos, guiones, guion bajo
        if (!local.matches("[A-Za-z0-9._-]+")) {
            return false;
        }

        // Validar dominio: debe tener al menos un punto
        int dotIndex = domain.indexOf(".");
        if (dotIndex == -1) {
            return false;
        }

        // Debe haber al menos 2 caracteres antes del punto
        if (dotIndex < 2) {
            return false;
        }

        // Dominio no puede tener caracteres no permitidos
        if (!domain.matches("[A-Za-z0-9.-]+")) {
            return false;
        }

        // Extensión válida: mínimo 2 caracteres
        String extension = domain.substring(domain.lastIndexOf(".") + 1);

        if (extension.length() < 2) {
            return false;
        }

        return true;
    }
}