package com.sena.farmacia.servicios;

import com.sena.farmacia.modelos.Medicamento;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ARTEFACTO: Casos de Uso (Lógica de Negocio).
 * La anotación @Service indica a Spring Boot que esta clase gestiona
 * la lógica central (Motor del buscador predictivo y base de datos simulada).
 */
@Service
public class FarmaciaService {

    private final List<Medicamento> inventario = new ArrayList<>();

    // Inicializamos el inventario con datos base
    public FarmaciaService() {
        inventario.add(new Medicamento("Paracetamol 500mg", 1500));
        inventario.add(new Medicamento("Ibuprofeno 400mg", 2000));
        inventario.add(new Medicamento("Advil Max", 3500));
    }

    /**
     * HISTORIA DE USUARIO: Como usuario quiero un buscador predictivo para encontrar medicamentos.
     * Filtra el inventario por coincidencias en el nombre.
     * @param termino Texto ingresado por el usuario.
     * @return Lista de medicamentos encontrados.
     */
    public List<Medicamento> buscarPredictivo(String termino) {
        if (termino == null || termino.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return inventario.stream()
                .filter(med -> med.getNombre().toLowerCase().contains(termino.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * HISTORIA DE USUARIO: Como farmacéutico quiero agregar stock al inventario.
     * @param medicamento Objeto medicamento a guardar.
     */
    public void registrarMedicamento(Medicamento medicamento) {
        inventario.add(medicamento);
    }
}