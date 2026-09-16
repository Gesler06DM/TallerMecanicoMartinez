package tallermecanico.app;

import tallermecanico.dao.CitaDao;
import tallermecanico.modelo.Cita;

public class Main {

    public static void main(String[] args) {

        CitaDao dao = new CitaDao();

        try {
            System.out.println("=== CITAS DEL TALLER ===");

            for (Cita cita : dao.listarTodas()) {
                System.out.println(cita);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}