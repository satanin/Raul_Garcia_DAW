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

public class Apuestas extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnSeguimientoDeApuestas;
	private JTextField textField_1;
	public Liga miLiga = new Liga();
	

	/**
	 * Launch the application.
	 */
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
	public Apuestas() {
		setTitle("Crear Liga");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 47, 248, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdministrar = new JButton("Administrar");
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaLiga frame = new VentanaLiga(miLiga);
				frame.setVisible(true);
				
			}
		});
		btnAdministrar.setBounds(10, 98, 111, 23);
		panel.add(btnAdministrar);
		
		JButton btnGenerarApuesta = new JButton("Generar Apuesta");
		btnGenerarApuesta.setBounds(10, 169, 268, 23);
		getContentPane().add(btnGenerarApuesta);
		
		JButton btnSeguimientoDeApuestas_1 = new JButton("Seguimiento de Apuestas");
		btnSeguimientoDeApuestas_1.setBounds(10, 203, 268, 23);
		getContentPane().add(btnSeguimientoDeApuestas_1);
	}

}
