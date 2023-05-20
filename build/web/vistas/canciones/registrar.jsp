<%-- 
    Document   : agregar
    Created on : 19/05/2023, 4:23:17 p. m.
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Canción</title>
</head>
<body>
    <h1>Registrar Canción</h1>

    <form action="cancion" method="post">
        <input type="hidden" name="accion" value="registrar">

        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" required><br>

        <label for="ritmo">Ritmo:</label>
        <input type="text" name="ritmo" id="ritmo" required><br>

        <label for="duracion">Duración:</label>
        <input type="text" name="duracion" id="duracion" required><br>

        <label for="album">Álbum:</label>
        <input type="text" name="album" id="album" required><br>

        <label for="posicionEnAlbum">Posición en el álbum:</label>
        <input type="text" name="posicionEnAlbum" id="posicionEnAlbum" required><br>

        <label for="banda">Banda:</label>
        <input type="text" name="banda" id="banda" required><br>

        <label for="interprete">Intérprete:</label>
        <input type="text" name="interprete" id="interprete" required><br>

        <label for="autor">Autor:</label>
        <input type="text" name="autor" id="autor" required><br>

        <label for="fechaLanzamiento">Fecha de Lanzamiento:</label>
        <input type="text" name="fechaLanzamiento" id="fechaLanzamiento" required><br>

        <label for="usuarioCc">Usuario CC:</label>
        <input type="text" name="usuarioCc" id="usuarioCc" required><br>

        <input type="submit" value="Registrar">
    </form>
</body>
</html>