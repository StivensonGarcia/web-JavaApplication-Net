<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <meta charset="UTF-8">
    <title>Página de Inicio</title>
</head>
<body>
    <h1>Bienvenido :: Formulario de Canciones</h1>
    <ul>
        <center>
            <br>
            <br>
            <br>
            <h2>Menu de Opciones</h2>

            <h3>De Click Sobre Alguno de estos para Acceder</h3>
            <br>
            <%-- Verificar si el usuario ha iniciado sesión --%>
            <% if (session.getAttribute("usuario") != null) { %>
                <a href="cancion?accion=listar">Lista de Canciones</a>
                <br>
                <a href="cancion?accion=registrar">Registro de Cancion</a>
                <br>
                <a href="usuario?accion=listar">Listado de Usuarios</a>
                <br>
            <% } else { %>
                <a href="usuario?accion=login">Iniciar Sesión</a>
                <br>
                <a href="usuario?accion=registrar">Registro de Usuario</a>
            <% } %>
        </center>
    </ul>
</body>
</html>
