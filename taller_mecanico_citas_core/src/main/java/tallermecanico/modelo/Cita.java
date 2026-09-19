package tallermecanico.modelo;

import java.time.LocalDateTime;

public class Cita {

    private int id;
    private String cliente;
    private LocalDateTime fechaHora;
    private String servicio;
    private int duracionMinutos;
    private String estado;
    private boolean primeraVisita;

    public Cita(int id, String cliente, LocalDateTime fechaHora,
                String servicio, int duracionMinutos, String estado, boolean primeraVisita) {
        this.id = id;
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.duracionMinutos = duracionMinutos;
        this.estado = estado;
        this.primeraVisita = primeraVisita;
    }

    public Cita(String cliente, LocalDateTime fechaHora,
                String servicio, int duracionMinutos, String estado, boolean primeraVisita) {
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.duracionMinutos = duracionMinutos;
        this.estado = estado;
        this.primeraVisita = primeraVisita;
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
        public boolean isPrimeraVisita() {
            return primeraVisita;
        }

        public void setPrimeraVisita(boolean primeraVisita) {
            this.primeraVisita = primeraVisita;
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
