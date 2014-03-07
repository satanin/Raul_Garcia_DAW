import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;


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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				nombreEquipo.setText(equipo.getNombreEquipo());
				golesAFavor.setText(String.valueOf(equipo.getGolesFavor()));
				golesEnContra.setText(String.valueOf(equipo.getGolesEnContra()));
				partidosGanados.setText(String.valueOf(equipo.getPartidosGanados()));
				partidosPerdidos.setText(String.valueOf(equipo.getPartidosPerdidos()));
			}
		});
		setTitle("Guardar Equipos");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 290, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreEquipo = new JLabel("Nombre Equipo");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombreEquipo.setBounds(10, 11, 79, 14);
		contentPane.add(lblNombreEquipo);
		
		nombreEquipo = new JTextField();
		nombreEquipo.setEditable(false);
		nombreEquipo.setBounds(109, 8, 152, 20);
		contentPane.add(nombreEquipo);
		nombreEquipo.setColumns(10);
		
		JLabel lblGolesAFavor = new JLabel("Goles a Favor");
		lblGolesAFavor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGolesAFavor.setBounds(10, 42, 79, 14);
		contentPane.add(lblGolesAFavor);
		
		golesAFavor = new JTextField();
		golesAFavor.setColumns(10);
		golesAFavor.setBounds(109, 39, 152, 20);
		contentPane.add(golesAFavor);
		
		JLabel lblGolesEnContra = new JLabel("Goles En Contra");
		lblGolesEnContra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGolesEnContra.setBounds(10, 70, 79, 14);
		contentPane.add(lblGolesEnContra);
		
		golesEnContra = new JTextField();
		golesEnContra.setColumns(10);
		golesEnContra.setBounds(109, 67, 152, 20);
		contentPane.add(golesEnContra);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados");
		lblPartidosGanados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPartidosGanados.setBounds(10, 98, 89, 14);
		contentPane.add(lblPartidosGanados);
		
		partidosGanados = new JTextField();
		partidosGanados.setColumns(10);
		partidosGanados.setBounds(109, 95, 152, 20);
		contentPane.add(partidosGanados);
		
		JLabel lblPartidosPerdidos = new JLabel("Partidos Perdidos");
		lblPartidosPerdidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
				// guardarEnFichero();
			}
		});
		btnGuardarEquipo.setBounds(10, 201, 251, 23);
		contentPane.add(btnGuardarEquipo);
		
		JButton btnNewButton = new JButton("Guardar Archivo");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				equipo.setNombreEquipo(nombreEquipo.getText());
				equipo.setGolesFavor(Integer.valueOf(golesAFavor.getText()));
				equipo.setGolesEnContra(Integer.valueOf(golesEnContra.getText()));
				equipo.setPartidosGanados(Integer.valueOf(partidosGanados.getText()));
				equipo.setPartidosPerdidos(Integer.valueOf(partidosPerdidos.getText()));
				// Llamo al método guardar en fichero.
				guardarEnFichero();
			}
		});
		btnNewButton.setBounds(10, 167, 125, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLeerDeArchivo = new JButton("Leer Archivo");
		btnLeerDeArchivo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLeerDeArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerDeFichero();
				nombreEquipo.setText(equipo.getNombreEquipo());
				golesAFavor.setText(String.valueOf(equipo.getGolesFavor()));
				golesEnContra.setText(String.valueOf(equipo.getGolesEnContra()));
				partidosGanados.setText(String.valueOf(equipo.getPartidosGanados()));
				partidosPerdidos.setText(String.valueOf(equipo.getPartidosPerdidos()));
			}
		});
		btnLeerDeArchivo.setBounds(136, 167, 125, 23);
		contentPane.add(btnLeerDeArchivo);
		
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
	
	private Equipo leerDeFichero(){
		FileInputStream entrada = null;
		
			try {
				entrada = new FileInputStream("clientes.ser");
				
				ObjectInputStream miObjeto = new ObjectInputStream(entrada);
				Object objeto = miObjeto.readObject();
				
				if (objeto instanceof Equipo){
					
					equipo = (Equipo) objeto;
					miObjeto.close();
					
				}
			}catch (Exception e){
					System.out.println("Ha habido un error leyendo el Equipo");
			}
			return equipo;
	
	}
}
