<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.com.farmacia.modelos.Medicamento" %>
<html>
<head>
    <title>SENA - Resultados</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #eef2f5; color: #333; margin: 0; padding: 20px; }
        .container { max-width: 600px; margin: 0 auto; }
        .card { background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); }
        .header-title { color: #0056b3; border-bottom: 2px solid #eee; padding-bottom: 15px; margin-top: 0; }
        .result-list { list-style-type: none; padding: 0; }
        .result-item { background-color: #f8f9fa; border-left: 5px solid #0056b3; padding: 15px; margin-bottom: 10px; border-radius: 4px; display: flex; justify-content: space-between; align-items: center;}
        .med-name { font-size: 1.1em; font-weight: bold; color: #444; }
        .med-price { background: #28a745; color: white; padding: 5px 10px; border-radius: 20px; font-weight: bold;}
        .no-results { color: #dc3545; background-color: #f8d7da; padding: 15px; border-radius: 5px; border: 1px solid #f5c6cb; text-align: center;}
        .btn-back { display: block; width: 100%; text-align: center; background-color: #6c757d; color: white; padding: 12px; border-radius: 5px; text-decoration: none; font-weight: bold; margin-top: 25px; transition: 0.3s;}
        .btn-back:hover { background-color: #5a6268; }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <h2 class="header-title">Resultados para: "<%= request.getAttribute("termino") %>"</h2>

            <%
                // Lógica de Java incrustada (Elemento JSP exigido por SENA)
                List<Medicamento> resultados = (List<Medicamento>) request.getAttribute("listaResultados");

                if (resultados != null && !resultados.isEmpty()) {
            %>
                    <ul class="result-list">
                        <% for (Medicamento med : resultados) { %>
                            <li class="result-item">
                                <span class="med-name"><%= med.getNombre() %></span>
                                <span class="med-price">$ <%= med.getPrecio() %></span>
                            </li>
                        <% } %>
                    </ul>
            <%
                } else {
            %>
                    <div class="no-results">
                        <strong>¡Lo sentimos!</strong> No se encontraron medicamentos que coincidan con esa búsqueda en el inventario.
                    </div>
            <%
                }
            %>

            <a href="index.jsp" class="btn-back">⬅ Volver al Buscador</a>
        </div>
    </div>
</body>
</html>