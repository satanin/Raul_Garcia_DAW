import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import com.mysql.jdbc.Statement;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VentanaLiga extends JFrame {
	// Declaramos los objetos necesarios.
	private JPanel contentPane;
	private JTextField nombreLiga;
	private Liga miLiga;
	private JComboBox comboEquipos;
	private JTextField numEquipos;
	private int liga;
	private Conectar conexion;
	private ResultSet misResultadosLiga,misResultadosEquipo;

	// creamos la ventana
	public VentanaLiga(int indiceLiga,int crearNuevaLiga, Conectar conexion) {
		liga = indiceLiga;
		if (crearNuevaLiga == 0){
			// Asignamos a nuevaLiga la liga que le hemos pasado por parámetros para poder trabajar con ella.			
			miLiga = new Liga(indiceLiga,conexion);
						
		}		
		// Establecemos un listener para que cuando la ventana gane el foco llame a refreshCombo para que inicialice y actualice el combobox
		//  y además se actualice el nombre de la liga y el número de equipos
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				// llamamos a la función refreshCombo.
				refreshData();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});	
		
		setTitle("Crear Liga");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 298, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Liga");
		lblNombreDeLa.setBounds(10, 11, 193, 14);
		contentPane.add(lblNombreDeLa);
		
		nombreLiga = new JTextField();
		nombreLiga.setBounds(10, 31, 216, 20);
		contentPane.add(nombreLiga);
		nombreLiga.setColumns(10);
		
		JButton btnGuardarLiga = new JButton("Guardar Liga");
		btnGuardarLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				miLiga.setNombreLiga(nombreLiga.getText());
				miLiga.setNumEquipos(Integer.valueOf(numEquipos.getText()));
						
			}
		});
		btnGuardarLiga.setBounds(10, 130, 256, 23);
		contentPane.add(btnGuardarLiga);
		
		comboEquipos = new JComboBox<Equipo>();
		comboEquipos.setBounds(10, 62, 256, 20);
		contentPane.add(comboEquipos);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo frame = new VentanaEquipo(comboEquipos.getSelectedIndex());
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 93, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNEquipos = new JLabel("N\u00BA Eq.");
		lblNEquipos.setBounds(236, 11, 46, 14);
		contentPane.add(lblNEquipos);
		
		numEquipos = new JTextField();
		numEquipos.setBounds(236, 31, 30, 20);
		contentPane.add(numEquipos);
		numEquipos.setColumns(10);
		
		JButton btnEliminarEquipoLiga = new JButton("+");
		btnEliminarEquipoLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo frame = new VentanaEquipo(-1);
				frame.setVisible(true);
			}
		});
		btnEliminarEquipoLiga.setBounds(137, 93, 57, 23);
		contentPane.add(btnEliminarEquipoLiga);
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button.setBounds(204, 93, 59, 23);
		contentPane.add(button);
		
		
	}
	
	// función para refreshcar el comboBox
	public void refreshData (){
		comboEquipos.removeAllItems();		

		System.out.println("Estoy en RefreshData");
		for(int i=0;i<miLiga.getNumEquipos();i++){
				comboEquipos.addItem(miLiga.getEquipo(i));
				}		
		nombreLiga.setText(miLiga.getnombreLiga());
		numEquipos.setText(String.valueOf(comboEquipos.getItemCount()));
		System.out.println(comboEquipos.getItemCount());
	}
}
