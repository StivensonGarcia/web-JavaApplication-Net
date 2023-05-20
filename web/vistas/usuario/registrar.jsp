<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuario</title>
    <link rel="stylesheet" href="css/registrar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.9.3/css/bulma.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body>
    <div class="container">
        <div class="formulario">
            <h1>Registrar Usuario</h1>

            <!-- Agrega este código al inicio para mostrar el mensaje de éxito -->
            <center>
            <c:if test="${not empty mensaje}">
                <div class="mensaje mensaje-exito">${mensaje}</div>
            </c:if>

            <!-- Agrega este código al inicio para mostrar el mensaje de error -->
            <c:if test="${not empty error}">
                <div class="mensaje">${error}</div>
            </c:if>
            </center>
                <br>
            <form action="usuario" method="post">
                <input type="hidden" name="accion" value="registrar">
                <label for="cc">Cédula:</label>
                <input type="text" id="cc" name="cc" required>
                <label for="pass">Contraseña:</label>
                <input type="password" id="pass" name="pass" required>
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
                <label for="apellido">Apellido:</label>
                <input type="text" id="apellido" name="apellido" required>
                <label for="genero">Género:</label>
                <select id="genero" name="genero">
                    <option value="M">Masculino</option>
                    <option value="F">Femenino</option>
                    <option value="O">Otro</option>
                </select>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <input type="submit" value="Registrar">
            </form>

            <div class="enlaces">
                <a href="index.jsp">Ir a Inicio</a>
                <a href="usuario?accion=login">Ir a Login</a>
            </div>
        </div>
    </div>
</body>
</html>

