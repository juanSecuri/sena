package com.sena.farmacia.modelos;

/**
 * ARTEFACTO: Diagrama de Clases.
 * Esta clase representa la entidad principal del sistema de farmacia.
 * Cumple con el estándar de encapsulamiento utilizando modificadores privados (PascalCase para la clase).
 */
public class Medicamento {

    // Estándar: variables en camelCase
    private String nombre;
    private double precio;

    /**
     * Constructor vacío requerido por el Framework Spring Boot
     * para la conversión automática a formato JSON.
     */
    public Medicamento() {}

    public Medicamento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Estándar: Getters y Setters en camelCase
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}