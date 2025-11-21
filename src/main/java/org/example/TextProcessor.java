package org.example;

public class TextProcessor {

    public String reverseAndCapitalize(String input) {
        // --- Validaciones ---

        // Requerimiento: El texto no puede ser null
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        // Requerimiento: Longitud máxima 1000
        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // Requerimiento: No puede ser vacío ni solo espacios
        // Trim elimina espacios, si después de eso está vacío, es inválido.
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío ni contener solo espacios");
        }

        // --- Transformaciones ---
        // 1. Eliminar espacios al inicio/final (trim)
        // 2. Invertir (StringBuilder reverse)
        // 3. Convertir a mayúsculas (toUpperCase)

        String trimmed = input.trim();
        StringBuilder reversed = new StringBuilder(trimmed).reverse();

        return reversed.toString().toUpperCase();
    }
}
