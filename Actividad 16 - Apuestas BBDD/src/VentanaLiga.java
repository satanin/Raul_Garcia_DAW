import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private JTextField nombreLiga;
	private JTextField numEquipos;
	private JComboBox<Equipo> comboEquipos;
	private Liga miLiga;
	private Equipo miEquipo;
	private Data misDatos;
	private ArrayList<Equipo> misEquiposLiga;

	
	public VentanaLiga(final Liga miLiga, final Data misDatos) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				refreshData();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		this.miLiga = miLiga;
		this.misDatos = misDatos;
				
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 406, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Editor Ligas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 369, 234);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nombreLiga = new JTextField();
		nombreLiga.setBounds(10, 42, 254, 20);
		panel.add(nombreLiga);
		nombreLiga.setColumns(10);
		
		JLabel lblLiga = new JLabel("Liga");
		lblLiga.setBounds(10, 23, 46, 14);
		panel.add(lblLiga);
		
		numEquipos = new JTextField();
		numEquipos.setBounds(274, 42, 86, 20);
		panel.add(numEquipos);
		numEquipos.setColumns(10);
		
		JLabel lblNEquipos = new JLabel("N\u00BA Equipos");
		lblNEquipos.setBounds(274, 23, 86, 14);
		panel.add(lblNEquipos);
		
		comboEquipos = new JComboBox<Equipo>();
		comboEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboEquipos.getSelectedIndex());
			}
		});
		comboEquipos.setBounds(10, 86, 350, 20);
		panel.add(comboEquipos);
		
		JButton btnGuardarLiga = new JButton("Guardar Liga");
		btnGuardarLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miLiga.setNombreLiga(nombreLiga.getText());
				miLiga.setNumEquipos(Integer.valueOf(numEquipos.getText()));
				miLiga.guardarLiga(miLiga);
				
			}
		});
		btnGuardarLiga.setBounds(242, 200, 117, 23);
		panel.add(btnGuardarLiga);
		
		JButton btnAgregarEquipo = new JButton("Agregar Equipo");
		btnAgregarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miLiga.setNombreLiga(nombreLiga.getText());
				miEquipo = new Equipo(miLiga.getIdLiga());
				System.out.println(misEquiposLiga.size());
				VentanaEquipo frame = new VentanaEquipo(miEquipo, misDatos,miLiga);
				frame.setVisible(true);
			}
		});
		btnAgregarEquipo.setBounds(127, 145, 118, 23);
		panel.add(btnAgregarEquipo);
		
		JButton btnBorrarEquipo = new JButton("Borrar Equipo");
		btnBorrarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miEquipo = misEquiposLiga.get(comboEquipos.getSelectedIndex());
				System.out.println(comboEquipos.getSelectedItem());
				miLiga.rmEquipo(comboEquipos.getSelectedIndex(), miEquipo);
				
				refreshData();
			}
		});
		btnBorrarEquipo.setBounds(255, 145, 105, 23);
		panel.add(btnBorrarEquipo);
		
		JButton btnEditarEquipo = new JButton("Editar Equipo");
		btnEditarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				miEquipo = misEquiposLiga.get(comboEquipos.getSelectedIndex());
				System.out.println(miEquipo.toString());
				VentanaEquipo frame = new VentanaEquipo(miEquipo, misDatos, miLiga);
				frame.setVisible(true);
			}
		});
		btnEditarEquipo.setBounds(10, 145, 105, 23);
		panel.add(btnEditarEquipo);
	}
	
	private void refreshData(){
		comboEquipos.removeAllItems();
		misEquiposLiga = miLiga.getEquiposLiga();
		nombreLiga.setText(miLiga.toString());
		numEquipos.setText(String.valueOf(misEquiposLiga.size()));
		for(int i=0;i<misEquiposLiga.size();i++){
			comboEquipos.addItem(misEquiposLiga.get(i));
		}
				
	}
}
