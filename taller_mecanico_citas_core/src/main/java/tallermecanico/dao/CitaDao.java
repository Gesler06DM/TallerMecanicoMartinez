package tallermecanico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tallermecanico.modelo.Cita;

public class CitaDao {

    private static final String URL =

    		"jdbc:mariadb://localhost:3306/taller_mecanico_db";

    private static final String USUARIO = "root";

    private static final String PASSWORD = "Lucio0806";

    private Connection conectar() throws SQLException {

        return DriverManager.getConnection(URL, USUARIO, PASSWORD);

    }

    public boolean guardar(Cita cita) throws SQLException {

        String sql = "INSERT INTO citas "

+ "(cliente, fecha_hora, servicio, duracion_minutos, estado, primera_visita) "
+ "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = conectar();

             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cita.getCliente());

            ps.setTimestamp(2,

                    java.sql.Timestamp.valueOf(cita.getFechaHora()));

            ps.setString(3, cita.getServicio());

            ps.setInt(4, cita.getDuracionMinutos());

            ps.setString(5, cita.getEstado());
            
            ps.setBoolean(6, cita.isPrimeraVisita());

            return ps.executeUpdate() > 0;

        }

    }
    public List<Cita> listarTodas() throws SQLException {

        List<Cita> citas = new ArrayList<>();

        String sql = "SELECT * FROM citas ORDER BY fecha_hora";

        try (Connection conexion = conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cita cita = new Cita(
                        rs.getInt("id"),
                        rs.getString("cliente"),
                        rs.getTimestamp("fecha_hora").toLocalDateTime(),
                        rs.getString("servicio"),
                        rs.getInt("duracion_minutos"),
                        rs.getString("estado"),
                        rs.getBoolean("primera_visita")
                );

                citas.add(cita);
            }
        }

        return citas;
    }
    
    public Cita buscarPorId(int id) throws SQLException {

        String sql = "SELECT * FROM citas WHERE id = ?";

        try (Connection conexion = conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Cita(
                            rs.getInt("id"),
                            rs.getString("cliente"),
                            rs.getTimestamp("fecha_hora").toLocalDateTime(),
                            rs.getString("servicio"),
                            rs.getInt("duracion_minutos"),
                            rs.getString("estado"),
                            rs.getBoolean("primera_visita")
                    );
                }
            }
        }

        return null;
    }
    public boolean actualizar(Cita cita) throws SQLException {

        String sql = "UPDATE citas SET cliente = ?, fecha_hora = ?, "
                + "servicio = ?, duracion_minutos = ?, estado = ?, primera_visita = ? "
                + "WHERE id = ?";

        try (Connection conexion = conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cita.getCliente());
            ps.setTimestamp(2,
                    java.sql.Timestamp.valueOf(cita.getFechaHora()));
            ps.setString(3, cita.getServicio());
            ps.setInt(4, cita.getDuracionMinutos());
            ps.setString(5, cita.getEstado());
            ps.setInt(6, cita.getId());
            ps.setInt(7, cita.getId());

            return ps.executeUpdate() > 0;
        }
    }
    public boolean eliminar(int id) throws SQLException {

        String sql = "DELETE FROM citas WHERE id = ?";

        try (Connection conexion = conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        }
    }
}