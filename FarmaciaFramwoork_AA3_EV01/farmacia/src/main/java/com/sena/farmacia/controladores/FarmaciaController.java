package com.sena.farmacia.controladores;

import com.sena.farmacia.modelos.Medicamento;
import com.sena.farmacia.servicios.FarmaciaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * ARTEFACTO: Prototipos e Interfaces (Backend).
 * Controlador REST que expone los endpoints HTTP para que la aplicación
 * móvil o web se conecte al sistema de farmacia.
 */
@RestController
@RequestMapping("/api/farmacia")
public class FarmaciaController {

    private final FarmaciaService farmaciaService;

    // Inyección de dependencias nativa de Spring Boot
    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    /**
     * Endpoint GET: Resuelve el buscador predictivo.
     * Equivalente a @app.get en FastAPI.
     */
    @GetMapping("/buscar")
    public List<Medicamento> buscar(@RequestParam String termino) {
        return farmaciaService.buscarPredictivo(termino);
    }

    /**
     * Endpoint POST: Recibe un JSON y lo guarda en el inventario.
     * Equivalente a @app.post en FastAPI.
     */
    @PostMapping("/registrar")
    public String registrar(@RequestBody Medicamento medicamento) {
        farmaciaService.registrarMedicamento(medicamento);
        return "¡Medicamento registrado con éxito!";
    }
}