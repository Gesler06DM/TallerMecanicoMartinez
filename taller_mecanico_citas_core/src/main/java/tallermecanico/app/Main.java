package tallermecanico.app;

import tallermecanico.dao.CitaDao;
import tallermecanico.modelo.Cita;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CitaDao dao = new CitaDao();
        int opcion;

        do {
            System.out.println("\n=== TALLER MECANICO MARTINEZ - CITAS ===");
            System.out.println("1. Registrar cita");
            System.out.println("2. Listar citas");
            System.out.println("3. Buscar cita por ID");
            System.out.println("4. Actualizar cita");
            System.out.println("5. Eliminar cita");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(scanner.nextLine());

            try {

                switch (opcion) {

                    case 1:
                        System.out.println("\n=== REGISTRAR CITA ===");

                        System.out.print("Nombre del cliente: ");
                        String cliente = scanner.nextLine();

                        System.out.print("Año: ");
                        int anio = Integer.parseInt(scanner.nextLine());

                        System.out.print("Mes: ");
                        int mes = Integer.parseInt(scanner.nextLine());

                        System.out.print("Dia: ");
                        int dia = Integer.parseInt(scanner.nextLine());

                        System.out.print("Hora: ");
                        int hora = Integer.parseInt(scanner.nextLine());

                        System.out.print("Minutos: ");
                        int minutos = Integer.parseInt(scanner.nextLine());

                        System.out.print("Servicio: ");
                        String servicio = scanner.nextLine();

                        System.out.print("Duracion del servicio en minutos: ");
                        int duracion = Integer.parseInt(scanner.nextLine());

                        System.out.print("Estado: ");
                        String estado = scanner.nextLine();
                        System.out.print("¿Es primera visita? (s/n): ");
                        boolean primeraVisita = scanner.nextLine().equalsIgnoreCase("s");

                        Cita nuevaCita = new Cita(
                                cliente,
                                LocalDateTime.of(anio, mes, dia, hora, minutos),
                                servicio,
                                duracion,
                                estado,
                                primeraVisita
                        );

                        if (dao.guardar(nuevaCita)) {
                            System.out.println("Cita guardada correctamente");
                        } else {
                            System.out.println("No se pudo guardar la cita");
                        }
                        break;

                    case 2:
                        System.out.println("\n=== LISTADO DE CITAS ===");

                        for (Cita cita : dao.listarTodas()) {
                            System.out.println(cita);
                        }
                        break;

                    case 3:
                        System.out.println("\n=== BUSCAR CITA POR ID ===");

                        System.out.print("Ingrese el ID: ");
                        int idBuscar = Integer.parseInt(scanner.nextLine());

                        Cita encontrada = dao.buscarPorId(idBuscar);

                        if (encontrada != null) {
                            System.out.println(encontrada);
                        } else {
                            System.out.println("Cita no encontrada");
                        }
                        break;

                    case 4:
                        System.out.println("\n=== ACTUALIZAR CITA ===");

                        System.out.print("ID de la cita: ");
                        int idActualizar = Integer.parseInt(scanner.nextLine());

                        Cita existente = dao.buscarPorId(idActualizar);

                        if (existente == null) {
                            System.out.println("Cita no encontrada");
                            break;
                        }

                        System.out.print("Nuevo nombre del cliente: ");
                        String nuevoCliente = scanner.nextLine();

                        System.out.print("Año: ");
                        int nuevoAnio = Integer.parseInt(scanner.nextLine());

                        System.out.print("Mes: ");
                        int nuevoMes = Integer.parseInt(scanner.nextLine());

                        System.out.print("Dia: ");
                        int nuevoDia = Integer.parseInt(scanner.nextLine());

                        System.out.print("Hora: ");
                        int nuevaHora = Integer.parseInt(scanner.nextLine());

                        System.out.print("Minutos: ");
                        int nuevosMinutos = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nuevo servicio: ");
                        String nuevoServicio = scanner.nextLine();

                        System.out.print("Nueva duración: ");
                        int nuevaDuracion = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nuevo estado: ");
                        String nuevoEstado = scanner.nextLine();

                        System.out.print("¿Es primera visita? (s/n): ");
                        boolean nuevaPrimeraVisita =
                                scanner.nextLine().equalsIgnoreCase("s");
                        Cita citaActualizada = new Cita(
                                idActualizar,
                                nuevoCliente,
                                LocalDateTime.of(
                                        nuevoAnio,
                                        nuevoMes,
                                        nuevoDia,
                                        nuevaHora,
                                        nuevosMinutos
                                ),
                                nuevoServicio,
                                nuevaDuracion,
                                nuevoEstado,
                                nuevaPrimeraVisita
                        );

                        if (dao.actualizar(citaActualizada)) {
                            System.out.println("Cita actualizada correctamente");
                        } else {
                            System.out.println("No se pudo actualizar la cita");
                        }

                        break;
                    case 5:
                        System.out.println("\n=== ELIMINAR CITA ===");

                        System.out.print("Ingrese el ID de la cita: ");
                        int idEliminar = Integer.parseInt(scanner.nextLine());

                        Cita citaEliminar = dao.buscarPorId(idEliminar);

                        if (citaEliminar == null) {
                            System.out.println("Cita no encontrada");
                            break;
                        }

                        System.out.println("Cita encontrada:");
                        System.out.println(citaEliminar);

                        System.out.print("¿Seguro que desea eliminarla? (s/n): ");
                        String confirmar = scanner.nextLine();

                        if (confirmar.equalsIgnoreCase("s")) {

                            if (dao.eliminar(idEliminar)) {
                                System.out.println("Cita eliminada correctamente");
                            } else {
                                System.out.println("No se pudo eliminar la cita");
                            }

                        } else {
                            System.out.println("Eliminacion cancelada");
                        }
                        break;

                    case 6:
                        System.out.println("\nPrograma finalizado");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 6);

        scanner.close();
    }
}