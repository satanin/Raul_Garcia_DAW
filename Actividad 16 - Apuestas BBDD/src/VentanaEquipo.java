import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField nombreEquipo;
	private JTextField golesFavor;
	private JTextField golesEnContra;
	private JTextField partidosGanados;
	private JTextField partidosPerdidos;
	private JComboBox<Equipo> comboEquiposA;
	private Equipo miEquipoA;
	private Data misDatosA;
	private Liga miLigaA;
	
	private JButton btnGuardar;


	public VentanaEquipo(Equipo miEquipo, Data misDatos, Liga miLiga,JComboBox<Equipo> comboEquipos) {
		miEquipoA = miEquipo;
		misDatosA = misDatos;
		miLigaA = miLiga;
		comboEquiposA=comboEquipos;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				nombreEquipo.setText(miEquipoA.toString());
				golesFavor.setText(String.valueOf(miEquipoA.getGolesFavor()));
				golesEnContra.setText(String.valueOf(miEquipoA.getGolesEnContra()));
				partidosGanados.setText(String.valueOf(miEquipoA.getPartidosGanados()));
				partidosPerdidos.setText(String.valueOf(miEquipoA.getPartidosPerdidos()));
				
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 275, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Gestion Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 239, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 22, 46, 14);
		panel.add(lblNombre);
		
		nombreEquipo = new JTextField();
		nombreEquipo.setBounds(104, 19, 125, 20);
		panel.add(nombreEquipo);
		nombreEquipo.setColumns(10);
		
		golesFavor = new JTextField();
		golesFavor.setBounds(104, 50, 125, 20);
		panel.add(golesFavor);
		golesFavor.setColumns(10);
		
		golesEnContra = new JTextField();
		golesEnContra.setBounds(104, 81, 125, 20);
		panel.add(golesEnContra);
		golesEnContra.setColumns(10);
		
		partidosGanados = new JTextField();
		partidosGanados.setBounds(104, 112, 125, 20);
		panel.add(partidosGanados);
		partidosGanados.setColumns(10);
		
		partidosPerdidos = new JTextField();
		partidosPerdidos.setBounds(104, 143, 125, 20);
		panel.add(partidosPerdidos);
		partidosPerdidos.setColumns(10);
		
		JLabel lblGolesAFavor = new JLabel("Goles a Favor");
		lblGolesAFavor.setBounds(10, 53, 84, 14);
		panel.add(lblGolesAFavor);
		
		JLabel lblGolesEnContra = new JLabel("Goles en Contra");
		lblGolesEnContra.setBounds(10, 84, 84, 14);
		panel.add(lblGolesEnContra);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados");
		lblPartidosGanados.setBounds(10, 115, 84, 14);
		panel.add(lblPartidosGanados);
		
		JLabel lblPartidosPerdidos = new JLabel("Partidos Perdidos");
		lblPartidosPerdidos.setBounds(10, 146, 84, 14);
		panel.add(lblPartidosPerdidos);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miEquipoA.setNombreEquipo(nombreEquipo.getText());
				miEquipoA.setGolesFavor(Integer.valueOf(golesFavor.getText()));
				miEquipoA.setGolesEnContra(Integer.valueOf(golesEnContra.getText()));
				miEquipoA.setPartidosGanados(Integer.valueOf(partidosGanados.getText()));
				miEquipoA.setPartidosPerdidos(Integer.valueOf(partidosPerdidos.getText()));
				System.out.println(miEquipoA.getIdEquipo());
				miLigaA.addEquipo(miEquipoA);
				comboEquiposA.addItem(miEquipoA);
			}
		});
		btnGuardar.setBounds(10, 186, 219, 23);
		panel.add(btnGuardar);
	}

}
