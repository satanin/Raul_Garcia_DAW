import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;


public class Principal extends JFrame {

	private JPanel contentPane;
	private static Principal frame;
	private Contador miContador;
	private JLabel labelContador;
	private PanelPreguntas miPanelPreguntas;
	private JPanel panelPrincipal;
	private ConexionBBDD miConexion;
	private JTable table;
	private PanelComoJugar miPanelComoJugar;
	private Creditos misCreditos;
	private Pregunta pregunta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		miConexion = new ConexionBBDD();
		
		setTitle("Trivial Duels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 465);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmInicio = new JMenuItem("Practica Solo");
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				miPanelPreguntas = new PanelPreguntas(miConexion);
				miPanelPreguntas.setBounds(10, 11, 563, 384);
				contentPane.remove(panelPrincipal);
				contentPane.add(miPanelPreguntas);
				contentPane.repaint();
			}
		});
		mnNewMenu.add(mntmInicio);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Duelo");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CerrarVentana();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmAyuda = new JMenuItem("Como Jugar");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miPanelComoJugar = new PanelComoJugar();
				miPanelComoJugar.setBounds(10, 11, 563, 384);
				contentPane.remove(panelPrincipal);
				contentPane.add(miPanelComoJugar);
				contentPane.repaint();
			}
		});
		mnNewMenu_1.add(mntmAyuda);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cr\u00E9ditos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				misCreditos = new Creditos();
				misCreditos.setBounds(10, 11, 563, 384);
				contentPane.add(misCreditos);
				contentPane.remove(panelPrincipal);
				contentPane.repaint();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(10, 11, 563, 384);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido a Trivial Duels");
		lblNewLabel_1.setBounds(146, 5, 286, 31);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelPrincipal.add(lblNewLabel_1);
		
		labelContador = new JLabel("");
		labelContador.setForeground(new Color(128, 0, 0));
		labelContador.setHorizontalAlignment(SwingConstants.CENTER);
		labelContador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContador.setBounds(215, 308, 132, 31);
		panelPrincipal.add(labelContador);
		
		
		
		
		JButton btnProbarTimer = new JButton("Probar Timer");
		btnProbarTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread miContador = new Thread( new Contador(labelContador));
				miContador.start();
			}
		});
		btnProbarTimer.setBounds(215, 350, 132, 23);
		panelPrincipal.add(btnProbarTimer);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(10, 259, 543, -202);
		panelPrincipal.add(table);
	
	}
	
	private void CerrarVentana(){
		frame.dispose();
	}
	

}
