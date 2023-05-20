package udec.devweb.stivensonGarcia.dao;
/*
autor: Stivenson Garcia Romero
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import udec.devweb.stivensonGarcia.modelo.entidad.Cancion;
import udec.devweb.stivensonGarcia.modelo.entidad.Usuario;

public class CancionDAO {
    private final Connection connection;

    public CancionDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean registrarCancion(Cancion cancion) {
        String query = "INSERT INTO canciones (nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete, autor, fechaLanzamiento, usuariocc) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cancion.getNombre());
            statement.setString(2, cancion.getRitmo());
            statement.setString(3, cancion.getDuracion());
            statement.setString(4, cancion.getAlbum());
            statement.setString(5, cancion.getPosicionEnAlbum());
            statement.setString(6, cancion.getBanda());
            statement.setString(7, cancion.getInterprete());
            statement.setString(8, cancion.getAutor());
            statement.setString(9, cancion.getFechaLanzamiento());
            statement.setInt(10, cancion.getUsuariocc());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarCancion(Cancion cancion) {
        String query = "UPDATE canciones SET nombre = ?, ritmo = ?, duracion = ?, album = ?, posicionEnAlbum = ?, " +
                "banda = ?, interprete = ?, autor = ?, fechaLanzamiento = ?, usuariocc = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cancion.getNombre());
            statement.setString(2, cancion.getRitmo());
            statement.setString(3, cancion.getDuracion());
            statement.setString(4, cancion.getAlbum());
            statement.setString(5, cancion.getPosicionEnAlbum());
            statement.setString(6, cancion.getBanda());
            statement.setString(7, cancion.getInterprete());
            statement.setString(8, cancion.getAutor());
            statement.setString(9, cancion.getFechaLanzamiento());
            statement.setInt(10, cancion.getUsuariocc());
            statement.setInt(11, cancion.getId());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCancion(int id) {
        String query = "DELETE FROM canciones WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cancion> listarCanciones() {
        String query = "SELECT * FROM canciones";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            List<Cancion> canciones = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String ritmo = resultSet.getString("ritmo");
                String duracion = resultSet.getString("duracion");
                String album = resultSet.getString("album");
                String posicionEnAlbum = resultSet.getString("posicionEnAlbum");
                String banda = resultSet.getString("banda");
                String interprete = resultSet.getString("interprete");
                String autor = resultSet.getString("autor");
                String fechaLanzamiento = resultSet.getString("fechaLanzamiento");
                int usuariocc = resultSet.getInt("usuariocc");

                Cancion cancion = new Cancion(id, nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete,
                        autor, fechaLanzamiento, usuariocc);

                canciones.add(cancion);
            }

            return canciones;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuario> listarUsuarios() {
        String query = "SELECT * FROM Usuarios";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            List<Usuario> usuarios = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                Usuario usuario = new Usuario(id, nombre);

                usuarios.add(usuario);
            }

            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cancion obtenerCancionPorId(int id) {
        String query = "SELECT * FROM canciones WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String ritmo = resultSet.getString("ritmo");
                    String duracion = resultSet.getString("duracion");
                    String album = resultSet.getString("album");
                    String posicionEnAlbum = resultSet.getString("posicionEnAlbum");
                    String banda = resultSet.getString("banda");
                    String interprete = resultSet.getString("interprete");
                    String autor = resultSet.getString("autor");
                    String fechaLanzamiento = resultSet.getString("fechaLanzamiento");
                    int usuariocc = resultSet.getInt("usuariocc");

                    return new Cancion(id, nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete,
                            autor, fechaLanzamiento, usuariocc);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cancion> obtenerCanciones(int usuariocc) {
        String query = "SELECT * FROM canciones WHERE usuariocc = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, usuariocc);

            try (ResultSet resultSet = statement.executeQuery()) {
                List<Cancion> canciones = new ArrayList<>();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String ritmo = resultSet.getString("ritmo");
                    String duracion = resultSet.getString("duracion");
                    String album = resultSet.getString("album");
                    String posicionEnAlbum = resultSet.getString("posicionEnAlbum");
                    String banda = resultSet.getString("banda");
                    String interprete = resultSet.getString("interprete");
                    String autor = resultSet.getString("autor");
                    String fechaLanzamiento = resultSet.getString("fechaLanzamiento");

                    Cancion cancion = new Cancion(id, nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete,
                            autor, fechaLanzamiento, usuariocc);

                    canciones.add(cancion);
                }

                return canciones;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}