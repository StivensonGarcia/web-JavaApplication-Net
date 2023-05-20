<%-- 
    Document   : eliminar
    Created on : 19/05/2023, 4:23:35 p. m.
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="css/editarCanciones.css">
    <meta charset="UTF-8">
    <title>Editar Canción</title>
</head>
<body>
<center>
    <h1>Editar Canción</h1>
    <%-- Mostrar mensaje si existe --%>
    <% if (request.getAttribute("mensaje") != null) { %>
        <p style="color: green;"><%= request.getAttribute("mensaje") %></p>
    <% } %>
    <%-- Mostrar mensaje de error si existe --%>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="cancion" method="post">
        <input type="hidden" name="accion" value="editar">
        <input type="hidden" name="id" value="${cancion.id}">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${cancion.nombre}" required>
        <br>
        <label for="ritmo">Ritmo:</label>
        <input type="text" id="ritmo" name="ritmo" value="${cancion.ritmo}" required>
        <br>
        <label for="duracion">Duración:</label>
        <input type="text" id="duracion" name="duracion" value="${cancion.duracion}" required>
        <br>
        <label for="album">Álbum:</label>
        <input type="text" id="album" name="album" value="${cancion.album}" required>
        <br>
        <label for="posicionEnAlbum">Posición en el Álbum:</label>
        <input type="text" id="posicionEnAlbum" name="posicionEnAlbum" value="${cancion.posicionEnAlbum}" required>
        <br>
        <label for="banda">Banda:</label>
        <input type="text" id="banda" name="banda" value="${cancion.banda}" required>
        <br>
        <label for="interprete">Intérprete:</label>
        <input type="text" id="interprete" name="interprete" value="${cancion.interprete}" required>
        <br>
        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor" value="${cancion.autor}" required>
        <br>
        <label for="fechaLanzamiento">Fecha de Lanzamiento:</label>
        <input type="text" id="fechaLanzamiento" name="fechaLanzamiento" value="${cancion.fechaLanzamiento}" required>
        <br>
        <label for="usuariocc">Usuario ID:</label>
        <input type="text" id="usuariocc" name="usuariocc" value="${cancion.usuariocc}" required>
        <br>
        <input type="submit" value="Guardar">
    </form>
</center>
</body>
</html>