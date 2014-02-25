import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	// defino los items y variables que voy a necesitar luego
	private JTextField nombreEquipo;
	private JTextField golesAFavor;
	private JTextField golesEnContra;
	private JTextField partidosGanados;
	private JTextField partidosPerdidos;
	private Equipo equipo;

	/**
	 * Create the frame.
	 */
	// Modifico el constructor para poder ponerle como parámetro o argumento el objeto de clase Equipo
	public VentanaEquipo(Equipo equipoAModificar) {
		setTitle("Guardar Equipos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreEquipo = new JLabel("Nombre Equipo");
		lblNombreEquipo.setBounds(10, 11, 79, 14);
		contentPane.add(lblNombreEquipo);
		
		nombreEquipo = new JTextField();
		nombreEquipo.setBounds(109, 8, 152, 20);
		contentPane.add(nombreEquipo);
		nombreEquipo.setColumns(10);
		
		JLabel lblGolesAFavor = new JLabel("Goles a Favor");
		lblGolesAFavor.setBounds(10, 42, 79, 14);
		contentPane.add(lblGolesAFavor);
		
		golesAFavor = new JTextField();
		golesAFavor.setColumns(10);
		golesAFavor.setBounds(109, 39, 152, 20);
		contentPane.add(golesAFavor);
		
		JLabel lblGolesEnContra = new JLabel("Goles En Contra");
		lblGolesEnContra.setBounds(10, 70, 79, 14);
		contentPane.add(lblGolesEnContra);
		
		golesEnContra = new JTextField();
		golesEnContra.setColumns(10);
		golesEnContra.setBounds(109, 67, 152, 20);
		contentPane.add(golesEnContra);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados");
		lblPartidosGanados.setBounds(10, 98, 89, 14);
		contentPane.add(lblPartidosGanados);
		
		partidosGanados = new JTextField();
		partidosGanados.setColumns(10);
		partidosGanados.setBounds(109, 95, 152, 20);
		contentPane.add(partidosGanados);
		
		JLabel lblPartidosPerdidos = new JLabel("Partidos Perdidos");
		lblPartidosPerdidos.setBounds(10, 126, 89, 14);
		contentPane.add(lblPartidosPerdidos);
		
		partidosPerdidos = new JTextField();
		partidosPerdidos.setColumns(10);
		partidosPerdidos.setBounds(109, 123, 152, 20);
		contentPane.add(partidosPerdidos);
		
		JButton btnGuardarEquipo = new JButton("Guardar Equipo");
		btnGuardarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Asigno a cada variable del objeto equipo un valor que obtengo de la ventana.
				equipo.setNombreEquipo(nombreEquipo.getText());
				equipo.setGolesFavor(Integer.valueOf(golesAFavor.getText()));
				equipo.setGolesEnContra(Integer.valueOf(golesEnContra.getText()));
				equipo.setPartidosGanados(Integer.valueOf(partidosGanados.getText()));
				equipo.setPartidosPerdidos(Integer.valueOf(partidosPerdidos.getText()));
				
				// Llamo al método guardar en fichero.
				guardarEnFichero();
			}
		});
		btnGuardarEquipo.setBounds(10, 164, 251, 23);
		contentPane.add(btnGuardarEquipo);
		
		equipo = equipoAModificar;
	}
	
	private void guardarEnFichero(){
		ObjectOutputStream salida;
		try
		{
			salida = new ObjectOutputStream(new FileOutputStream("clientes.ser"));
			salida.writeObject(equipo);
			if (salida!= null)
				salida.close();
		}
		catch(IOException ioException)
		{
			System.err.println("Error al abrir el archivo");
		}
	}
}
