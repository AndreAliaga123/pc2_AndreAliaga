package com.mycompany.pc2_andrealiaga;

public class TextProcessor {

    public static String reverseAndCapitalize(String input) {

        // Validación: null
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        // Validación: vacío o solo espacios
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        // Validar límite máximo (1000 caracteres)
        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // Quitar espacios al inicio y fin
        String trimmed = input.trim();

        // Invertir el texto
        String reversed = new StringBuilder(trimmed).reverse().toString();

        // Convertir a mayúsculas
        return reversed.toUpperCase();
    }
}