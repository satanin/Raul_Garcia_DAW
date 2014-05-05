import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

// Ahora Apuestas es nuestra ventana principal 
public class Apuestas extends JFrame {

	private JComboBox<Liga> comboLigas;
	private ResultSet misResultados = null; // Resultados devueltos por la consulta.
	private Conectar conexion;
	private Liga miLiga;
	
	// Main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apuestas frame = new Apuestas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Ventana
	public Apuestas() {
		
		// Creo un objeto de tipo Conectar para poder obtener resultados de la base de datos.
		conexion = new Conectar();
		// Aquí almaceno los datos de la tabla ligas para ver de que ligas dispongo.
		misResultados = conexion.leerLigas();
		try {
				while(misResultados.next()){
				miLiga = new Liga(misResultados.getInt("idLiga"), misResultados.getString("nombre"), misResultados.getInt("numEquipos"));
				comboLigas.addItem(miLiga);
			} 
		}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
		// Establecemos el título de la ventana
		setTitle("Apuestas");
		// Le decimos a la ventana que cuando se cierre salga del programa.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 227);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Administraci\u00F3n de Ligas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 268, 93);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAdministrar = new JButton("Editar Liga");
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Abrimos la ventana VentanaLiga y le pasamos como parámetro el objeto liga miLiga.
				VentanaLiga frame = new VentanaLiga(comboLigas.getSelectedIndex(),0, conexion);
				frame.setVisible(true);
				
			}
		});
		btnAdministrar.setBounds(10, 56, 121, 23);
		panel.add(btnAdministrar);
		
		comboLigas = new JComboBox<Liga>();
		comboLigas.setModel(new DefaultComboBoxModel(new String[] {"Selecciona Liga"}));
		comboLigas.setBounds(10, 25, 248, 20);
		panel.add(comboLigas);
		
		JButton btnAgregarLiga = new JButton("Agregar Liga");
		btnAgregarLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrimos la ventana VentanaLiga y le pasamos como parámetro el objeto liga miLiga.
				VentanaLiga frame = new VentanaLiga(comboLigas.getSelectedIndex(),1, conexion);
				frame.setVisible(true);
			}
		});
		btnAgregarLiga.setBounds(141, 56, 117, 23);
		panel.add(btnAgregarLiga);
		
		// El botón Generar Apuesta de momeno no hace nada
		JButton btnGenerarApuesta = new JButton("Generar Apuesta");
		btnGenerarApuesta.setBounds(10, 115, 268, 23);
		getContentPane().add(btnGenerarApuesta);
		
		// El botón Segumiento de Apuestas de momento tampoco hace nada.
		JButton btnSeguimientoDeApuestas_1 = new JButton("Seguimiento de Apuestas");
		btnSeguimientoDeApuestas_1.setBounds(10, 149, 268, 23);
		getContentPane().add(btnSeguimientoDeApuestas_1);
	}
}
