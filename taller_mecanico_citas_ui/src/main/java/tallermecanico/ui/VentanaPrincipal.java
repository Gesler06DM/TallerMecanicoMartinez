package tallermecanico.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import tallermecanico.modelo.Cita;
import tallermecanico.dao.CitaDao;

public class VentanaPrincipal extends JFrame {
	
	private CitaDao citaDao = new CitaDao();
    private JTable tablaCitas;
    private DefaultTableModel modeloTabla;

    private JTextField txtCliente;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtServicio;
    private JTextField txtDuracion;
    private JTextField txtEstado;

    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    // COLORES
    private final Color AZUL = new Color(41, 98, 160);
    private final Color AZUL_OSCURO = new Color(31, 78, 130);
    private final Color FONDO = new Color(245, 247, 250);
    private final Color BLANCO = Color.WHITE;
    private final Color TEXTO = new Color(55, 65, 81);
    private final Color VERDE = new Color(46, 170, 95);
    private final Color ROJO = new Color(220, 75, 75);
    private final Color GRIS = new Color(108, 117, 125);

    public VentanaPrincipal() {

        // =========================
        // CONFIGURACIÓN DE VENTANA
        // =========================

        setTitle("Taller Mecánico Martínez - Sistema de Citas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Abre maximizada
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setMinimumSize(new Dimension(1000, 650));
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(FONDO);
        setContentPane(panelPrincipal);

        // =========================
        // ENCABEZADO
        // =========================

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setBackground(AZUL_OSCURO);
        encabezado.setBorder(new EmptyBorder(25, 20, 25, 20));

        JLabel titulo = new JLabel("TALLER MECÁNICO MARTÍNEZ");
        titulo.setForeground(BLANCO);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Sistema de Gestión de Citas");
        subtitulo.setForeground(new Color(225, 235, 245));
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        encabezado.add(titulo);
        encabezado.add(Box.createVerticalStrut(7));
        encabezado.add(subtitulo);

        panelPrincipal.add(encabezado, BorderLayout.NORTH);

        // =========================
        // CONTENIDO CENTRAL
        // =========================

        JPanel contenido = new JPanel(new BorderLayout(80, 0));
        contenido.setBackground(FONDO);
        contenido.setBorder(new EmptyBorder(30, 70, 30, 70));

        // =========================
        // FORMULARIO IZQUIERDO
        // =========================

        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBackground(BLANCO);
        panelIzquierdo.setPreferredSize(new Dimension(430, 500));
        panelIzquierdo.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    new Color(220, 225, 230), 1
                ),
                new EmptyBorder(25, 30, 25, 30)
            )
        );

        JLabel tituloFormulario = new JLabel("Datos de la cita");
        tituloFormulario.setFont(
            new Font("Arial", Font.BOLD, 22)
        );
        tituloFormulario.setForeground(AZUL_OSCURO);
        tituloFormulario.setBorder(
            new EmptyBorder(0, 0, 20, 0)
        );

        panelIzquierdo.add(
            tituloFormulario,
            BorderLayout.NORTH
        );

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBackground(BLANCO);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 0;

        txtCliente = crearCampo();
        txtFecha = crearCampo();
        txtHora = crearCampo();
        txtServicio = crearCampo();
        txtDuracion = crearCampo();
        txtEstado = crearCampo();
        txtEstado.setText("pendiente");

        agregarCampo(
            formulario,
            gbc,
            0,
            "Cliente:",
            txtCliente
        );

        agregarCampo(
            formulario,
            gbc,
            1,
            "Fecha (AAAA-MM-DD):",
            txtFecha
        );

        agregarCampo(
            formulario,
            gbc,
            2,
            "Hora (HH:MM):",
            txtHora
        );

        agregarCampo(
            formulario,
            gbc,
            3,
            "Servicio:",
            txtServicio
        );

        agregarCampo(
            formulario,
            gbc,
            4,
            "Duración (minutos):",
            txtDuracion
        );

        agregarCampo(
            formulario,
            gbc,
            5,
            "Estado:",
            txtEstado
        );

        panelIzquierdo.add(formulario, BorderLayout.CENTER);

        // =========================
        // BOTONES
        // =========================

        JPanel panelBotones = new JPanel(
            new GridLayout(2, 2, 12, 12)
        );

        panelBotones.setBackground(BLANCO);
        panelBotones.setBorder(
            new EmptyBorder(20, 0, 0, 0)
        );

        btnGuardar = crearBoton(
            "Guardar",
            VERDE
        );

        btnActualizar = crearBoton(
            "Actualizar",
            new Color(52, 152, 219)
        );

        btnEliminar = crearBoton(
            "Eliminar",
            ROJO
        );

        btnLimpiar = crearBoton(
            "Limpiar",
            GRIS
        );

        panelBotones.add(btnGuardar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        panelIzquierdo.add(
            panelBotones,
            BorderLayout.SOUTH
        );

        // =========================
        // PANEL DERECHO
        // =========================

        JPanel panelDerecho = new JPanel(
            new BorderLayout(0, 15)
        );

        panelDerecho.setBackground(BLANCO);
        panelDerecho.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    new Color(220, 225, 230), 1
                ),
                new EmptyBorder(25, 25, 25, 25)
            )
        );

        JLabel tituloTabla = new JLabel(
            "Citas registradas"
        );

        tituloTabla.setFont(
            new Font("Arial", Font.BOLD, 22)
        );

        tituloTabla.setForeground(AZUL_OSCURO);

        panelDerecho.add(
            tituloTabla,
            BorderLayout.NORTH
        );

        // =========================
        // TABLA
        // =========================

        String[] columnas = {
            "ID",
            "Cliente",
            "Fecha y hora",
            "Servicio",
            "Duración",
            "Estado"
        };

        modeloTabla = new DefaultTableModel(
            columnas,
            0
        ) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(
                int row,
                int column
            ) {
                return false;
            }
        };

        tablaCitas = new JTable(modeloTabla);

        tablaCitas.setFont(
            new Font("Arial", Font.PLAIN, 14)
        );

        tablaCitas.setRowHeight(35);

        tablaCitas.setSelectionBackground(
            new Color(210, 230, 250)
        );

        tablaCitas.setSelectionForeground(TEXTO);

        tablaCitas.setGridColor(
            new Color(225, 225, 225)
        );

        tablaCitas.setShowVerticalLines(false);

        tablaCitas.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        tablaCitas.getTableHeader().setBackground(AZUL);
        tablaCitas.getTableHeader().setForeground(BLANCO);
        tablaCitas.getTableHeader().setPreferredSize(
            new Dimension(0, 40)
        );

        DefaultTableCellRenderer centrado =
            new DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        tablaCitas.getColumnModel()
                  .getColumn(0)
                  .setCellRenderer(centrado);

        tablaCitas.getColumnModel()
                  .getColumn(4)
                  .setCellRenderer(centrado);

        tablaCitas.getColumnModel()
                  .getColumn(5)
                  .setCellRenderer(centrado);

        JScrollPane scroll =
            new JScrollPane(tablaCitas);

        scroll.setBorder(
            BorderFactory.createLineBorder(
                new Color(220, 225, 230)
            )
        );

        scroll.getViewport().setBackground(BLANCO);

        panelDerecho.add(
            scroll,
            BorderLayout.CENTER
        );

        // =========================
        // AGREGAR PANELES
        // =========================

        contenido.add(
            panelIzquierdo,
            BorderLayout.WEST
        );

        contenido.add(
            panelDerecho,
            BorderLayout.CENTER
        );

        panelPrincipal.add(
            contenido,
            BorderLayout.CENTER
        );

        // =========================
        // EVENTOS
        // =========================
        btnGuardar.addActionListener(e -> {
            try {
                String cliente = txtCliente.getText().trim();
                String fecha = txtFecha.getText().trim();
                String hora = txtHora.getText().trim();
                String servicio = txtServicio.getText().trim();
                String duracionTexto = txtDuracion.getText().trim();
                String estado = txtEstado.getText().trim();

                if (cliente.isEmpty() || fecha.isEmpty() || hora.isEmpty()
                        || servicio.isEmpty() || duracionTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Completa todos los campos es obligatorio"
                    );
                    return;
                }
                int duracion; 
                try {
                	duracion=Integer.parseInt(duracionTexto);
                }catch (NumberFormatException ex) {
                	JOptionPane.showMessageDialog(
                			this, "La duracion debe ser un numero entero");
                	return;
                }

                if (duracion <= 0) {
                    JOptionPane.showMessageDialog(
                        this,
                        "La duración debe ser mayor a 0 minutos"
                    );
                    return;
                }

                if (!estado.equalsIgnoreCase("pendiente")
                        && !estado.equalsIgnoreCase("confirmada")
                        && !estado.equalsIgnoreCase("cancelada")) {
                    JOptionPane.showMessageDialog(
                        this,
                        "El estado debe ser: pendiente, confirmada o cancelada"
                    );
                    return;
                }
                LocalDateTime fechaHora =
                        LocalDateTime.parse(fecha + "T" + hora);

                if (fechaHora.isBefore(LocalDateTime.now())) {
                    JOptionPane.showMessageDialog(
                        this,
                        "La fecha y hora de la cita no pueden estar en el pasado"
                    );
                    return;
                }
                Cita cita = new Cita(
                        cliente,
                        fechaHora,
                        servicio,
                        duracion,
                        estado
                );

                if (citaDao.guardar(cita)) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Cita guardada correctamente"
                    );

                    limpiarCampos();
                    cargarCitas();
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "No se pudo guardar la cita"
                    );
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al guardar: " + ex.getMessage()
                );
            }
        });
        btnActualizar.addActionListener(e -> {
            try {
                int fila = tablaCitas.getSelectedRow();

                if (fila < 0) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Seleccione una cita para actualizar"
                    );
                    return;
                }

                int id = Integer.parseInt(
                    modeloTabla.getValueAt(fila, 0).toString()
                );

                String cliente = txtCliente.getText().trim();
                String fecha = txtFecha.getText().trim();
                String hora = txtHora.getText().trim();
                String servicio = txtServicio.getText().trim();
                String duracionTexto = txtDuracion.getText().trim();
                String estado = txtEstado.getText().trim();
                if (cliente.isEmpty() || fecha.isEmpty() || hora.isEmpty()
                        || servicio.isEmpty() || duracionTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Completa todos los campos obligatorios"
                    );
                    return;
                }

                int duracion;

                try {
                    duracion = Integer.parseInt(duracionTexto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        this,
                        "La duración debe ser un número entero"
                    );
                    return;
                }
                if (duracion <= 0) {
                    JOptionPane.showMessageDialog(
                        this,
                        "La duración debe ser mayor a 0 minutos"
                    );
                    return;
                }

                LocalDateTime fechaHora;

                try {
                    fechaHora = LocalDateTime.parse(fecha + "T" + hora);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Fecha u hora incorrecta. Use AAAA-MM-DD y HH:MM"
                    );
                    return;
                }

                if (!estado.equalsIgnoreCase("pendiente")
                        && !estado.equalsIgnoreCase("confirmada")
                        && !estado.equalsIgnoreCase("cancelada")) {
                    JOptionPane.showMessageDialog(
                        this,
                        "El estado debe ser: pendiente, confirmada o cancelada"
                    );
                    return;
                }

                if (fechaHora.isBefore(LocalDateTime.now())) {
                    JOptionPane.showMessageDialog(
                        this,
                        "La fecha y hora de la cita no pueden estar en el pasado"
                    );
                    return;
                }

                Cita cita = new Cita(
                    id,
                    cliente,
                    fechaHora,
                    servicio,
                    duracion,
                    estado
                );

                if (citaDao.actualizar(cita)) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Cita actualizada correctamente"
                    );

                    limpiarCampos();
                    cargarCitas();
                } else {
                    JOptionPane.showMessageDialog(
                        this,
                        "No se pudo actualizar la cita"
                    );
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Error al actualizar: " + ex.getMessage()
                );
            }
        });
        btnEliminar.addActionListener(e -> {
            try {
                int fila = tablaCitas.getSelectedRow();

                if (fila < 0) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Seleccione una cita para eliminar"
                    );
                    return;
                }

                int id = Integer.parseInt(
                    modeloTabla.getValueAt(fila, 0).toString()
                );

                int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de eliminar esta cita?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    if (citaDao.eliminar(id)) {
                        JOptionPane.showMessageDialog(
                            this,
                            "Cita eliminada correctamente"
                        );

                        limpiarCampos();
                        cargarCitas();
                    } else {
                        JOptionPane.showMessageDialog(
                            this,
                            "No se pudo eliminar la cita"
                        );
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Error al eliminar: " + ex.getMessage()
                );
            }
        }); 
        btnLimpiar.addActionListener(e -> limpiarCampos());

        tablaCitas.getSelectionModel()
                  .addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                int fila = tablaCitas.getSelectedRow();

                if (fila >= 0) {

                    txtCliente.setText(
                        modeloTabla.getValueAt(fila, 1).toString()
                    );

                    String fechaHora =
                        modeloTabla.getValueAt(fila, 2).toString();

                    if (fechaHora.contains("T")) {

                        String[] partes =
                            fechaHora.split("T");

                        txtFecha.setText(partes[0]);
                        txtHora.setText(partes[1]);

                    } else {

                        txtFecha.setText(fechaHora);
                    }

                    txtServicio.setText(
                        modeloTabla.getValueAt(fila, 3).toString()
                    );

                    txtDuracion.setText(
                        modeloTabla.getValueAt(fila, 4).toString()
                    );

                    txtEstado.setText(
                        modeloTabla.getValueAt(fila, 5).toString()
                    );
                }
            }
        });
        cargarCitas();
    }
    

    // =========================
    // CREAR CAMPOS
    // =========================

    private JTextField crearCampo() {

        JTextField campo = new JTextField();

        campo.setFont(
            new Font("Arial", Font.PLAIN, 15)
        );

        campo.setPreferredSize(
            new Dimension(210, 38)
        );

        campo.setForeground(TEXTO);
        campo.setBackground(Color.WHITE);

        campo.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    new Color(195, 205, 215)
                ),
                new EmptyBorder(5, 10, 5, 10)
            )
        );

        return campo;
    }

    // =========================
    // AGREGAR CAMPO
    // =========================

    private void agregarCampo(
        JPanel panel,
        GridBagConstraints gbc,
        int fila,
        String texto,
        JTextField campo
    ) {

        JLabel label = new JLabel(texto);

        label.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        label.setForeground(TEXTO);

        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0.40;

        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.60;

        panel.add(campo, gbc);
    }

    // =========================
    // CREAR BOTONES
    // =========================

    private JButton crearBoton(
        String texto,
        Color color
    ) {

        JButton boton = new JButton(texto);

        boton.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        boton.setForeground(Color.WHITE);
        boton.setBackground(color);

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);

        boton.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );

        boton.setPreferredSize(
            new Dimension(150, 45)
        );

        return boton;
    }

    // =========================
    // LIMPIAR
    // =========================

    private void limpiarCampos() {

        txtCliente.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtServicio.setText("");
        txtDuracion.setText("");
        txtEstado.setText("pendiente");

        tablaCitas.clearSelection();

        txtCliente.requestFocus();
    }
    private void cargarCitas() {
        try {
            modeloTabla.setRowCount(0);

            for (Cita cita : citaDao.listarTodas()) {
                modeloTabla.addRow(new Object[] {
                    cita.getId(),
                    cita.getCliente(),
                    cita.getFechaHora(),
                    cita.getServicio(),
                    cita.getDuracionMinutos(),
                    cita.getEstado()
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                this,
                "Error al cargar las citas: " + ex.getMessage()
            );
        }
    }
}
