package tallermecanico.modelo;

import java.time.LocalDateTime;

public class Cita {

    private int id;
    private String cliente;
    private LocalDateTime fechaHora;
    private String servicio;
    private int duracionMinutos;
    private String estado;

    public Cita(int id, String cliente, LocalDateTime fechaHora,
                String servicio, int duracionMinutos, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.duracionMinutos = duracionMinutos;
        this.estado = estado;
    }

    public Cita(String cliente, LocalDateTime fechaHora,
                String servicio, int duracionMinutos, String estado) {
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.duracionMinutos = duracionMinutos;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getServicio() {
        return servicio;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getEstado() {
        return estado;
    }
    @Override
    public String toString() {
        return "Cita [id=" + id
                + ", cliente=" + cliente
                + ", fechaHora=" + fechaHora
                + ", servicio=" + servicio
                + ", duracionMinutos=" + duracionMinutos
                + ", estado=" + estado + "]";
    }
}
