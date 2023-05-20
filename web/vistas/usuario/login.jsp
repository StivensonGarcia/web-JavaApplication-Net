<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="container">
        <h1>Iniciar Sesión</h1>
        <form action="usuario" method="post">
            <input type="hidden" name="accion" value="login">
            <div class="input-group">
                <label for="cc">Cédula:</label>
                <input type="text" id="cc" name="cc" required>
            </div>
            <div class="input-group">
                <label for="pass">Contraseña:</label>
                <input type="password" id="pass" name="pass" required>
            </div>
            <button type="submit">Iniciar Sesión</button>
        </form>
        <p class="error-message">
            <c:if test="${not empty error}">${error}</c:if>
        </p>
        <p class="register-link">¿No tienes una cuenta? <a href="usuario?accion=registrar">Regístrate aquí</a></p>
    </div>
</body>
</html>
