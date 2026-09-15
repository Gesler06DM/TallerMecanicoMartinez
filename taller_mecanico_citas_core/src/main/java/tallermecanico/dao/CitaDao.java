package tallermecanico.dao;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import tallermecanico.modelo.Cita;

public class CitaDao {

    private static final String URL =

            "jdbc:mysql://localhost:3306/taller_mecanico_db";

    private static final String USUARIO = "root";

    private static final String PASSWORD = "";

    private Connection conectar() throws SQLException {

        return DriverManager.getConnection(URL, USUARIO, PASSWORD);

    }

    public boolean guardar(Cita cita) throws SQLException {

        String sql = "INSERT INTO citas "

                + "(cliente, fecha_hora, servicio, duracion_minutos, estado) "

                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = conectar();

             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cita.getCliente());

            ps.setTimestamp(2,

                    java.sql.Timestamp.valueOf(cita.getFechaHora()));

            ps.setString(3, cita.getServicio());

            ps.setInt(4, cita.getDuracionMinutos());

            ps.setString(5, cita.getEstado());

            return ps.executeUpdate() > 0;

        }

    }

}