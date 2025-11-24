package com.mycompany.pc2_andrealiaga;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {

        // Validar nombre no nulo ni vacío ni solo espacios
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        // Validar longitud mínima y máxima del nombre
        if (item.length() < 2 || item.length() > 50) {
            throw new IllegalArgumentException("El nombre del producto debe tener entre 2 y 50 caracteres");
        }

        // Validar cantidad mínima y máxima
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad máxima permitida es 1000");
        }

        // Si el producto YA existe, sumar cantidad
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    // Getter opcional para consultar el stock actual
    public int getStock(String item) {
        return inventory.getOrDefault(item, 0);
    }
}