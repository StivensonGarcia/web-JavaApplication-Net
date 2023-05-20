<%-- 
    Document   : listar
    Created on : 19/05/2023, 4:23:28 p. m.
    Author     : hp
--%>


<%@page import="java.util.List"%>
<%@page import="udec.devweb.stivensonGarcia.modelo.entidad.Cancion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/listarCanciones.css">
    <meta charset="UTF-8">
    <title>Listar Canciones</title>
</head>
<body>
    <h1>Listar Canciones</h1>
    <%-- Mostrar mensaje si existe --%>
    <% if (request.getAttribute("mensaje") != null) { %>
        <p style="color: green;"><%= request.getAttribute("mensaje") %></p>
    <% } %>
    <%-- Mostrar mensaje de error si existe --%>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="cancion" method="get">
        <label for="usuarioCc">ID de Usuario:</label>
        <input type="text" id="usuarioCc" name="usuarioCc" required>
        <input type="hidden" name="accion" value="buscar">
        <input type="submit" value="Buscar Canciones">
    </form>
    <br>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Ritmo</th>
            <th>Duración</th>
            <th>Álbum</th>
            <th>Posición en el Álbum</th>
            <th>Banda</th>
            <th>Intérprete</th>
            <th>Autor</th>
            <th>Fecha de Lanzamiento</th>
            <th>ID de Usuario</th>
            <th>Acciones</th>
        </tr>
        <%-- Iterar sobre la lista de canciones y mostrar los datos en la tabla --%>
        <% if (request.getAttribute("canciones") != null) {
            List<Cancion> canciones = (List<Cancion>) request.getAttribute("canciones");
            for (Cancion cancion : canciones) { %>
                <tr>
                    <td><%= cancion.getId() %></td>
                    <td><%= cancion.getNombre() %></td>
                    <td><%= cancion.getRitmo() %></td>
                    <td><%= cancion.getDuracion() %></td>
                    <td><%= cancion.getAlbum() %></td>
                    <td><%= cancion.getPosicionEnAlbum() %></td>
                    <td><%= cancion.getBanda() %></td>
                    <td><%= cancion.getInterprete() %></td>
                    <td><%= cancion.getAutor() %></td>
                    <td><%= cancion.getFechaLanzamiento() %></td>
                    <td><%= cancion.getUsuariocc() %></td>
                    <td>
                        <a href="cancion?accion=editar&id=<%= cancion.getId() %>">Editar</a>
                        <a href="cancion?accion=eliminar&id=<%= cancion.getId() %>">Eliminar</a>
                    </td>
                </tr>
        <%  }
        } %>
    </table>
    <a href="index.jsp" class="btn btn-primary">Ir a Inicio</a>
</body>
</html>