import java.awt.EventQueue;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Equipo miEquipo = new Equipo("",0,0,0,0);
				try {
					VentanaEquipo frame = new VentanaEquipo(miEquipo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
