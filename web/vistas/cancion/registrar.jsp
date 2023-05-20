<%-- 
    Document   : agregar
    Created on : 19/05/2023, 4:23:17 p. m.
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/registrarCanciones.css">
    <meta charset="UTF-8">
    <title>Registrar Canción</title>
</head>
<center>
<body>
    <h1>Registrar Canción</h1>
    <%-- Mostrar mensaje si existe --%>
    <% if (request.getAttribute("mensaje") != null) { %>
        <p style="color: green;"><%= request.getAttribute("mensaje") %></p>
    <% } %>
    <%-- Mostrar mensaje de error si existe --%>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="cancion" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>

        <label for="ritmo">Ritmo:</label>
        <input type="text" id="ritmo" name="ritmo" required><br>

        <label for="duracion">Duración:</label>
        <input type="text" id="duracion" name="duracion" required><br>

        <label for="album">Álbum:</label>
        <input type="text" id="album" name="album" required><br>

        <label for="posicionEnAlbum">Posición en el Álbum:</label>
        <input type="text" id="posicionEnAlbum" name="posicionEnAlbum" required><br>

        <label for="banda">Banda:</label>
        <input type="text" id="banda" name="banda" required><br>

        <label for="interprete">Intérprete:</label>
        <input type="text" id="interprete" name="interprete" required><br>

        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor" required><br>

        <label for="fechaLanzamiento">Fecha de Lanzamiento:</label>
        <input type="text" id="fechaLanzamiento" name="fechaLanzamiento" required><br>

        <label for="usuariocc">ID de Usuario:</label>
        <input type="text" id="usuariocc" name="usuariocc" required><br>

        <input type="hidden" name="accion" value="registrar">
        <input type="submit" value="Registrar Canción">
    </form>
    <br>
<a href="index.jsp" class="btn btn-primary">Ir a Inicio</a>
</body>
</center>
</html>