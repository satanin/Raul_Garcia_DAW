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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JComboBox;

// Ahora Apuestas es nuestra ventana principal 
public class Apuestas extends JFrame {
	
	private JTextField ligaAAdministrar;
	// Creamos un objeto Liga que utilizaremos para pasar como parámetro a VentanaLiga
	private Liga miLiga = new Liga();
	private JComboBox comboLigas; 
	
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

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ligaAAdministrar.setText(miLiga.getnombreLiga());
				comboLigas.addItem(miLiga);
			}
		});
		// Establecemos el título de la ventana
		setTitle("Apuestas");
		// Le decimos a la ventana que cuando se cierre salga del programa.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 284);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Administraci\u00F3n de Ligas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 268, 147);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Liga");
		lblNombreDeLa.setBounds(10, 22, 111, 14);
		panel.add(lblNombreDeLa);
		
		ligaAAdministrar = new JTextField();
		ligaAAdministrar.setBounds(10, 40, 248, 20);
		panel.add(ligaAAdministrar);
		ligaAAdministrar.setColumns(10);
		
		JButton btnAdministrar = new JButton("Administrar");
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Abrimos la ventana VentanaLiga y le pasamos como parámetro el objeto liga miLiga.
				VentanaLiga frame = new VentanaLiga(miLiga);
				frame.setVisible(true);
				
			}
		});
		btnAdministrar.setBounds(10, 98, 111, 23);
		panel.add(btnAdministrar);
		
		comboLigas = new JComboBox<Liga>();
		comboLigas.setBounds(10, 71, 248, 20);
		panel.add(comboLigas);
		
		// El botón Generar Apuesta de momeno no hace nada
		JButton btnGenerarApuesta = new JButton("Generar Apuesta");
		btnGenerarApuesta.setBounds(10, 169, 268, 23);
		getContentPane().add(btnGenerarApuesta);
		
		// El botón Segumiento de Apuestas de momento tampoco hace nada.
		JButton btnSeguimientoDeApuestas_1 = new JButton("Seguimiento de Apuestas");
		btnSeguimientoDeApuestas_1.setBounds(10, 203, 268, 23);
		getContentPane().add(btnSeguimientoDeApuestas_1);
	}

}
