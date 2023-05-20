<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="css/usuarioslistar.css">
</head>
<body>
    <div class="container">
        <h1>Listado de Usuarios</h1>
        
        <%-- Mensaje de éxito --%>
        <% if (request.getAttribute("exito") != null) { %>
            <div class="success-message">
                <%= request.getAttribute("exito") %>
            </div>
        <% } %>
        
        <%-- Mensaje de error --%>
        <% if (request.getAttribute("error") != null) { %>
            <div class="error-message">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>
        
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Cédula</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Género</th>
                        <th>Email</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Recorrer la lista de usuarios y mostrar los datos --%>
                    <% for (udec.devweb.stivensonGarcia.modelo.entidad.Usuario usuario 
                    : (java.util.List<udec.devweb.stivensonGarcia.modelo.entidad.Usuario>)request.getAttribute("usuarios")) { %>
                        <tr>
                            <td><%= usuario.getCc() %></td>
                            <td><%= usuario.getNombre() %></td>
                            <td><%= usuario.getApellido() %></td>
                            <td><%= usuario.getGenero() %></td>
                            <td><%= usuario.getEmail() %></td>
                            <td class="action">
                                <a href="usuario?accion=eliminar&cc=<%= usuario.getCc() %>" class="action-btn">Eliminar</a>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
        <div class="btn-container">
            <a href="index.jsp">Volver a Inicio</a>
        </div>
    </div>
</body>
</html>


