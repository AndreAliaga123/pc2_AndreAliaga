package com.mycompany.pc2_andrealiaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    // CASO 1: Producto menor a 2 caracteres
    @Test
    public void testProductoMenorA2Caracteres() {
        InventoryManager manager = new InventoryManager();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem("a", 5); // 1 caracter
        });

        assertEquals("El nombre del producto debe tener entre 2 y 50 caracteres", ex.getMessage());
    }

    // CASO 2: Producto con valor null
    @Test
    public void testProductoNull() {
        InventoryManager manager = new InventoryManager();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem(null, 5);
        });

        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    // CASO 3: Cantidad menor a 1 (0 o negativo)
    @Test
    public void testCantidadMenorA1() {
        InventoryManager manager = new InventoryManager();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem("PC", 0);
        });

        assertEquals("La cantidad debe ser mayor a 0", ex.getMessage());
    }

    // CASO 4: Cantidad válida (>0)
    @Test
    public void testCantidadMayorA0() {
        InventoryManager manager = new InventoryManager();

        manager.addItem("PC", 20);

        assertEquals(20, manager.getStock("PC")); // stock correcto
    }

    // CASO 5: Nombre entre 2 y 50 caracteres
    @Test
    public void testProductoNombreValido() {
        InventoryManager manager = new InventoryManager();

        manager.addItem("Cosedora", 10);

        assertEquals(10, manager.getStock("Cosedora"));
    }

    // CASO 6: Cantidad mayor a 1000
    @Test
    public void testCantidadMayorA1000() {
        InventoryManager manager = new InventoryManager();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem("PC", 1001);
        });

        assertEquals("La cantidad máxima permitida es 1000", ex.getMessage());
    }
}