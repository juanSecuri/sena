<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SENA - Sistema de Farmacia</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #eef2f5; color: #333; margin: 0; padding: 20px; }
        .container { max-width: 600px; margin: 0 auto; }
        .header { text-align: center; color: #0056b3; margin-bottom: 30px; }
        .card { background: white; padding: 25px; border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); margin-bottom: 25px; border-top: 4px solid #28a745; }
        .card-title { margin-top: 0; color: #444; font-size: 1.2em; border-bottom: 2px solid #f0f0f0; padding-bottom: 10px; margin-bottom: 15px; }
        label { font-weight: bold; font-size: 0.9em; color: #555; }
        input[type="text"], input[type="number"] { width: 100%; padding: 10px; margin: 8px 0 20px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; }
        input[type="text"]:focus, input[type="number"]:focus { border-color: #0056b3; outline: none; }
        .btn { width: 100%; background-color: #0056b3; color: white; border: none; padding: 12px; border-radius: 5px; font-size: 1em; cursor: pointer; font-weight: bold; transition: 0.3s; }
        .btn-green { background-color: #28a745; }
        .btn:hover { opacity: 0.9; }
        .alert { background-color: #d4edda; color: #155724; padding: 15px; border-radius: 5px; margin-bottom: 20px; border: 1px solid #c3e6cb; text-align: center; }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="header">💊 Módulo de Gestión de Farmacia</h1>

        <%-- Mensaje de éxito al guardar --%>
        <% if(request.getAttribute("mensaje") != null) { %>
            <div class="alert">
                <b><%= request.getAttribute("mensaje") %></b>
            </div>
        <% } %>

        <div class="card" style="border-top-color: #0056b3;">
            <h2 class="card-title">🔍 Buscador Predictivo (Consulta GET)</h2>
            <form action="FarmaciaServlet" method="GET">
                <label for="busqueda">Nombre del medicamento:</label>
                <input type="text" id="busqueda" name="busqueda" placeholder="Ej. Paracetamol, Ibuprofeno..." required autocomplete="off">
                <button type="submit" class="btn">Buscar Medicamento</button>
            </form>
        </div>

        <div class="card">
            <h2 class="card-title">📦 Agregar al Inventario (Inserción POST)</h2>
            <form action="FarmaciaServlet" method="POST">
                <label for="nombreMed">Nombre comercial:</label>
                <input type="text" id="nombreMed" name="nombreMed" placeholder="Ej. Amoxicilina 500mg" required>

                <label for="precioMed">Precio Unitario ($):</label>
                <input type="number" id="precioMed" name="precioMed" placeholder="Ej. 1500" required>

                <button type="submit" class="btn btn-green">Guardar en Inventario</button>
            </form>
        </div>
    </div>
</body>
</html>