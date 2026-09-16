package tallermecanico.ui;

public class MainUI {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		        new VentanaPrincipal().setVisible(true);
		    }
		});

	}

}
