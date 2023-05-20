package udec.devweb.stivensonGarcia.controlador;

/*
autor: Stivenson Garcia Romero
*/


import udec.devweb.stivensonGarcia.dao.ConexionBD;
import udec.devweb.stivensonGarcia.dao.UsuarioDAO;
import udec.devweb.stivensonGarcia.modelo.entidad.Usuario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorUsuario", urlPatterns = {"/usuario"})
public class ControladorUsuario extends HttpServlet {

    private final UsuarioDAO usuarioDAO;

    public ControladorUsuario() {
        super();
        usuarioDAO = new UsuarioDAO(ConexionBD.getConnection());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "registrar":
                    mostrarFormularioRegistro(request, response);
                    break;
                case "listar":
                    listarUsuarios(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicion(request, response);
                    break;
                case "eliminar":
                    eliminarUsuario(request, response);
                    break;
                case "login":
                    mostrarFormularioLogin(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "registrar":
                    registrarUsuario(request, response);
                    break;
                case "editar":
                    editarUsuario(request, response);
                    break;
                case "eliminar":
                    eliminarUsuario(request, response);
                    break;
                case "login":
                    loginUsuario(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }

    private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para mostrar el formulario de registro (registrar.jsp)
        request.getRequestDispatcher("vistas/usuario/registrar.jsp").forward(request, response);
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para mostrar el formulario de edición (editar.jsp)
        int cc = Integer.parseInt(request.getParameter("cc"));
        Usuario usuario = usuarioDAO.obtenerUsuarioPorCC(cc);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("vistas/usuario/editar.jsp").forward(request, response);
    }

    private void mostrarFormularioLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para mostrar el formulario de inicio de sesión (login.jsp)
        request.getRequestDispatcher("vistas/usuario/login.jsp").forward(request, response);
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para registrar un nuevo usuario en la base de datos
        int cc = Integer.parseInt(request.getParameter("cc"));
        String pass = request.getParameter("pass");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String genero = request.getParameter("genero");
        String email = request.getParameter("email");

        Usuario usuario = new Usuario(cc, pass, nombre, apellido, genero, email);
        boolean registrado = usuarioDAO.registrarUsuario(usuario);

        if (registrado) {
            request.setAttribute("mensaje", "Usuario creado exitosamente");
            request.getRequestDispatcher("vistas/usuario/registrar.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Error al registrar el usuario");
            request.getRequestDispatcher("vistas/usuario/registrar.jsp").forward(request, response);
        }
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para editar un usuario existente en la base de datos
        int cc = Integer.parseInt(request.getParameter("cc"));
        String pass = request.getParameter("pass");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String genero = request.getParameter("genero");
        String email = request.getParameter("email");

        Usuario usuario = new Usuario(cc, pass, nombre, apellido, genero, email);
        boolean editado = usuarioDAO.editarUsuario(usuario);

        if (editado) {
            response.sendRedirect("usuario?accion=listar");
        } else {
            mostrarError(request, response, "Error al editar el usuario");
        }
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para eliminar un usuario de la base de datos
        int cc = Integer.parseInt(request.getParameter("cc"));
        boolean eliminado = usuarioDAO.eliminarUsuario(cc);

        if (eliminado) {
            response.sendRedirect("usuario?accion=listar");
        } else {
            mostrarError(request, response, "Error al eliminar el usuario");
        }
    }

    private void loginUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para autenticar al usuario y redirigirlo a la página de inicio
        int cc = Integer.parseInt(request.getParameter("cc"));
        String pass = request.getParameter("pass");

        Usuario usuario = usuarioDAO.loginUsuario(cc, pass);
        if (usuario != null) {
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error", "Usuario no registrado o contraseña equivocada");
            request.getRequestDispatcher("vistas/usuario/login.jsp").forward(request, response);
        }
    }


    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        // Implementa la lógica para mostrar un mensaje de error en una página de error personalizada
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para obtener y mostrar la lista de usuarios (listar.jsp)
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("vistas/usuario/listar.jsp").forward(request, response);
    }
}
