package main.java.com.farmacia.modelos;

public class Medicamento {
    private String nombre;
    private double precio;

    public Medicamento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}