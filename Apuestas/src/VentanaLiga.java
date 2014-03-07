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


public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private JTextField nombreLiga;
	private Liga nuevaLiga;
	private JComboBox<String> comboBox;
	private JTextField numEquipos;
	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga miLiga) {
	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				nombreLiga.setText(nuevaLiga.getnombreLiga());
				
				for (int i=0;i<nuevaLiga.getNumEquipos();i++){
					comboBox.addItem(nuevaLiga.getEquipo(i).getNombreEquipo());
					
				}
				numEquipos.setText(String.valueOf(comboBox.getItemCount()));
			}
			
		});
		setTitle("Crear Liga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 200);
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
		btnGuardarLiga.setBounds(10, 127, 256, 23);
		contentPane.add(btnGuardarLiga);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 62, 256, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Editar Equipo Liga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaEquipo frame = new VentanaEquipo(nuevaLiga.getEquipo(comboBox.getSelectedIndex()));
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 93, 256, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNEquipos = new JLabel("N\u00BA Equipos");
		lblNEquipos.setBounds(204, 11, 62, 14);
		contentPane.add(lblNEquipos);
		
		numEquipos = new JTextField();
		numEquipos.setBounds(236, 31, 30, 20);
		contentPane.add(numEquipos);
		numEquipos.setColumns(10);
		
		nuevaLiga = miLiga;
	}
}
