package main.java.com.farmacia.controladores;


import main.java.com.farmacia.modelos.Medicamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FarmaciaServlet")
public class FarmaciaServlet extends HttpServlet {

    // Simulamos una base de datos en memoria
    private List<Medicamento> inventario = new ArrayList<>();

    @Override
    public void init() {
        // Datos iniciales para que el buscador funcione
        inventario.add(new Medicamento("Paracetamol 500mg", 1500));
        inventario.add(new Medicamento("Ibuprofeno 400mg", 2000));
        inventario.add(new Medicamento("Pargeverina", 3500));
    }

    // Método GET: Para el buscador predictivo
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String terminoBusqueda = request.getParameter("busqueda");
        List<Medicamento> resultados = new ArrayList<>();

        if (terminoBusqueda != null && !terminoBusqueda.isEmpty()) {
            for (Medicamento med : inventario) {
                if (med.getNombre().toLowerCase().contains(terminoBusqueda.toLowerCase())) {
                    resultados.add(med);
                }
            }
        }

        request.setAttribute("listaResultados", resultados);
        request.setAttribute("termino", terminoBusqueda);
        request.getRequestDispatcher("resultados.jsp").forward(request, response);
    }

    // Método POST: Para insertar un nuevo medicamento
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombreMed");
        double precio = Double.parseDouble(request.getParameter("precioMed"));

        inventario.add(new Medicamento(nombre, precio));

        request.setAttribute("mensaje", "¡Medicamento " + nombre + " agregado con éxito!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}