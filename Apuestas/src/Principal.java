import java.awt.EventQueue;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// creo el objeto miEquipo para poder pasarlo como parámetro a la ventana que creo.
				Equipo miEquipo = new Equipo("",0,0,0,0);
				Liga miLiga = new Liga();
				try {
					// paso como parámetro mi objeto "miEquipo" para poder utilizarlo dentro de la ventana.
					VentanaLiga frame = new VentanaLiga(miLiga);
//					VentanaEquipo frame = new VentanaEquipo(miEquipo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
