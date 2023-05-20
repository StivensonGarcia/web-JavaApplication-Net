package udec.devweb.stivensonGarcia.controlador;
/*
autor: Stivenson Garcia Romero
*/
import udec.devweb.stivensonGarcia.dao.ConexionBD;
import udec.devweb.stivensonGarcia.dao.CancionDAO;
import udec.devweb.stivensonGarcia.modelo.entidad.Cancion;
import udec.devweb.stivensonGarcia.modelo.entidad.Usuario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorCancion", urlPatterns = {"/cancion"})
public class ControladorCancion extends HttpServlet {

    private final CancionDAO cancionDAO;

    public ControladorCancion() {
        super();
        cancionDAO = new CancionDAO(ConexionBD.getConnection());
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
                    listarCanciones(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicion(request, response);
                    break;
                case "eliminar":
                    eliminarCancion(request, response);
                    break;
                case "buscar":
                    buscarCanciones(request, response);
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
                    registrarCancion(request, response);
                    break;
                case "editar":
                    editarCancion(request, response);
                    break;
                case "eliminar":
                    eliminarCancion(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }


    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para mostrar el formulario de edición de canción (editarCancion.jsp)
        int id = Integer.parseInt(request.getParameter("id"));
        Cancion cancion = cancionDAO.obtenerCancionPorId(id);
        List<Usuario> usuarios = cancionDAO.listarUsuarios();
        request.setAttribute("cancion", cancion);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("vistas/cancion/editar.jsp").forward(request, response);
    }

   private void registrarCancion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String ritmo = request.getParameter("ritmo");
    String duracion = request.getParameter("duracion");
    String album = request.getParameter("album");
    String posicionEnAlbum = request.getParameter("posicionEnAlbum");
    String banda = request.getParameter("banda");
    String interprete = request.getParameter("interprete");
    String autor = request.getParameter("autor");
    String fechaLanzamiento = request.getParameter("fechaLanzamiento");
    String usuarioccStr = request.getParameter("usuariocc");

    if (usuarioccStr != null) {
        int usuariocc = Integer.parseInt(usuarioccStr);

        Cancion cancion = new Cancion(0, nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete,
                autor, fechaLanzamiento, usuariocc);

        boolean registrado = cancionDAO.registrarCancion(cancion);

        if (registrado) {
            request.setAttribute("mensaje", "Canción registrada exitosamente");
        } else {
            request.setAttribute("error", "Error al registrar la canción");
        }
    } else {
        request.setAttribute("error", "Faltan parámetros");
    }

    mostrarFormularioRegistro(request, response);
}

private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Implementa la lógica para mostrar el formulario de registro de canción (vistas/cancion/registrar.jsp)
    List<Usuario> usuarios = cancionDAO.listarUsuarios();
    request.setAttribute("usuarios", usuarios);
    request.getRequestDispatcher("vistas/cancion/registrar.jsp").forward(request, response);
}

   private void editarCancion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Implementa la lógica para editar una canción en la base de datos
    int id = Integer.parseInt(request.getParameter("id"));
    String nombre = request.getParameter("nombre");
    String ritmo = request.getParameter("ritmo");
    String duracion = request.getParameter("duracion");
    String album = request.getParameter("album");
    String posicionEnAlbum = request.getParameter("posicionEnAlbum");
    String banda = request.getParameter("banda");
    String interprete = request.getParameter("interprete");
    String autor = request.getParameter("autor");
    String fechaLanzamiento = request.getParameter("fechaLanzamiento");

    String usuarioccStr = request.getParameter("usuariocc");
    int usuariocc = 0; // Valor predeterminado en caso de que el parámetro sea nulo

    if (usuarioccStr != null) {
        usuariocc = Integer.parseInt(usuarioccStr);
    }

    Cancion cancion = new Cancion(id, nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete,
            autor, fechaLanzamiento, usuariocc);

    boolean actualizado = cancionDAO.actualizarCancion(cancion);

    if (actualizado) {
        request.setAttribute("mensaje", "Canción actualizada exitosamente");
    } else {
        request.setAttribute("error", "Error al actualizar la canción");
    }

    listarCanciones(request, response);
}

    private void eliminarCancion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para eliminar una canción de la base de datos
        int id = Integer.parseInt(request.getParameter("id"));

        boolean eliminado = cancionDAO.eliminarCancion(id);

        if (eliminado) {
            request.setAttribute("mensaje", "Canción eliminada exitosamente");
        } else {
            request.setAttribute("error", "Error al eliminar la canción");
        }

        listarCanciones(request, response);
    }

    private void listarCanciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para obtener y mostrar todas las canciones de la base de datos
        List<Cancion> canciones = cancionDAO.listarCanciones();
        request.setAttribute("canciones", canciones);
        request.getRequestDispatcher("vistas/cancion/listar.jsp").forward(request, response);
    }

    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }

    private void buscarCanciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementa la lógica para buscar canciones por usuario
        int usuarioCc = Integer.parseInt(request.getParameter("usuarioCc"));
        List<Cancion> canciones = cancionDAO.obtenerCanciones(usuarioCc);
        request.setAttribute("canciones", canciones);
        request.getRequestDispatcher("vistas/cancion/listar.jsp").forward(request, response);
    }
}