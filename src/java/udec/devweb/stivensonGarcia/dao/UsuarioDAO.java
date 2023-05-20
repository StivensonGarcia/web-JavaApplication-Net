package udec.devweb.stivensonGarcia.dao;

/*
autor: Stivenson Garcia Romero
*/

import udec.devweb.stivensonGarcia.modelo.entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private final Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (cc, pass, nombre, apellido, genero, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, usuario.getCc());
            statement.setString(2, usuario.getPass());
            statement.setString(3, usuario.getNombre());
            statement.setString(4, usuario.getApellido());
            statement.setString(5, usuario.getGenero());
            statement.setString(6, usuario.getEmail());

            int filasInsertadas = statement.executeUpdate();

            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean editarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET pass = ?, nombre = ?, apellido = ?, genero = ?, email = ? WHERE cc = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, usuario.getPass());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getApellido());
            statement.setString(4, usuario.getGenero());
            statement.setString(5, usuario.getEmail());
            statement.setInt(6, usuario.getCc());

            int filasActualizadas = statement.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean eliminarUsuario(int cc) {
        String sql = "DELETE FROM usuarios WHERE cc = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cc);

            int filasEliminadas = statement.executeUpdate();

            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Usuario obtenerUsuarioPorCC(int cc) {
        String sql = "SELECT * FROM usuarios WHERE cc = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cc);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String pass = resultSet.getString("pass");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String genero = resultSet.getString("genero");
                    String email = resultSet.getString("email");

                    return new Usuario(cc, pass, nombre, apellido, genero, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int cc = resultSet.getInt("cc");
                String pass = resultSet.getString("pass");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String genero = resultSet.getString("genero");
                String email = resultSet.getString("email");

                Usuario usuario = new Usuario(cc, pass, nombre, apellido, genero, email);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public Usuario loginUsuario(int cc, String pass) {
        String sql = "SELECT * FROM usuarios WHERE cc = ? AND pass = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cc);
            statement.setString(2, pass);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String genero = resultSet.getString("genero");
                    String email = resultSet.getString("email");

                    return new Usuario(cc, pass, nombre, apellido, genero, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
