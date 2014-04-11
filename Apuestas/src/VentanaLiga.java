import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;


public class VentanaLiga extends JFrame {
	// Declaramos los objetos necesarios.
	private JPanel contentPane;
	private JTextField nombreLiga;
	private Liga nuevaLiga;
	private JComboBox<Equipo> comboBox;
	private JTextField numEquipos;

	// creamos la ventana
	public VentanaLiga(Liga miLiga) {
		// Asignamos a nuevaLiga la liga que le hemos pasado por parámetros para poder trabajar con ella.
		nuevaLiga = miLiga;
		
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
		
		JButton btnGuardarLiga = new JButton("Cambiar Nombre Liga");
		btnGuardarLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				nuevaLiga.setNombreLiga(nombreLiga.getText());

				
			}
		});
		btnGuardarLiga.setBounds(10, 130, 256, 23);
		contentPane.add(btnGuardarLiga);
		
		comboBox = new JComboBox<Equipo>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nombreLiga.setText(nuevaLiga.getnombreLiga());
				numEquipos.setText(String.valueOf(comboBox.getItemCount()));
				
			}
		});
		comboBox.setBounds(10, 62, 256, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo frame = new VentanaEquipo(nuevaLiga,comboBox.getSelectedIndex(),comboBox);
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 93, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNEquipos = new JLabel("N\u00BA Equipos");
		lblNEquipos.setBounds(204, 11, 62, 14);
		contentPane.add(lblNEquipos);
		
		numEquipos = new JTextField();
		numEquipos.setBounds(236, 31, 30, 20);
		contentPane.add(numEquipos);
		numEquipos.setColumns(10);
		
		JButton btnEliminarEquipoLiga = new JButton("+");
		btnEliminarEquipoLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo frame = new VentanaEquipo(nuevaLiga,-1,comboBox);
				frame.setVisible(true);
			}
		});
		btnEliminarEquipoLiga.setBounds(137, 93, 57, 23);
		contentPane.add(btnEliminarEquipoLiga);
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaLiga.removeEquipo(nuevaLiga.getEquipo(comboBox.getSelectedIndex())); 
				comboBox.removeItem(comboBox.getSelectedItem());
			}
		});
		button.setBounds(204, 93, 59, 23);
		contentPane.add(button);
		
		nuevaLiga = miLiga;
	}
	
	// función para refreshcar el comboBox
	public void refreshData (){
		comboBox.removeAllItems();
		for (int i=0;i<nuevaLiga.getNumEquipos();i++){
			comboBox.addItem(nuevaLiga.getEquipo(i));
			
		}
		
		nombreLiga.setText(nuevaLiga.getnombreLiga());
		numEquipos.setText(String.valueOf(comboBox.getItemCount()));
		
	}
}
