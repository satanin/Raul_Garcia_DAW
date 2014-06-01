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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;


public class Principal extends JFrame {

	private Contador miContador;
	private JLabel labelContador,lblUserLogged;
	public PanelPreguntas miPanelPreguntas;
	private JPanel contentPane,panelPrincipal,miPanelMultiPlayer,panelLogin;
	private ConexionBBDD miConexion;
	private PanelComoJugar miPanelComoJugar;
	private Creditos misCreditos;
	private Pregunta pregunta;
	private static Principal frame;
	private JTable table_1;
	private ArrayList<JPanel> misComponentesActivos;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	
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
		misComponentesActivos = new ArrayList<JPanel>();
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
				misComponentesActivos.add(miPanelPreguntas);
				limpiarVentana(miPanelPreguntas,misComponentesActivos);

			}
		});
		mnNewMenu.add(mntmInicio);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Multiplayer");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miPanelMultiPlayer = new PanelMultiPlayer(miConexion);
				miPanelMultiPlayer.setBounds(10, 11, 563, 384);
				misComponentesActivos.add(miPanelMultiPlayer);
				limpiarVentana(miPanelMultiPlayer,misComponentesActivos);
			}
		});
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
				misComponentesActivos.add(miPanelComoJugar);
				limpiarVentana(miPanelComoJugar, misComponentesActivos);
			}
		});
		mnNewMenu_1.add(mntmAyuda);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cr\u00E9ditos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				misCreditos = new Creditos();
				misCreditos.setBounds(10, 11, 563, 384);
				misComponentesActivos.add(misCreditos);
				limpiarVentana(misCreditos, misComponentesActivos);
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
		misComponentesActivos.add(panelPrincipal);
		
		
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
		
		table_1 = new JTable();
		table_1.setBounds(294, 95, 230, 256);
		panelPrincipal.add(table_1);
		
		JLabel lblHighScores = new JLabel("High Scores");
		lblHighScores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHighScores.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScores.setBounds(344, 47, 192, 33);
		panelPrincipal.add(lblHighScores);
		
		panelLogin = new JPanel();
		panelLogin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Logueate para Guardar Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLogin.setBounds(12, 131, 249, 204);
		panelPrincipal.add(panelLogin);
		panelLogin.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(31, 131, 116, 22);
		panelLogin.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 102, 75, 16);
		panelLogin.add(lblPassword);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(31, 67, 116, 22);
		panelLogin.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(31, 166, 75, 25);
		panelLogin.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean conectado = miConexion.getLogin(textFieldUser.getText(),String.valueOf(passwordField.getPassword()));
				System.out.println(conectado);
				if (conectado==true){
					lblUserLogged.setText(textFieldUser.getText());
					panelPrincipal.remove(panelLogin);
					contentPane.repaint();
					
					
				}
			}
		});
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setBounds(31, 38, 110, 16);
		panelLogin.add(lblNombreDeUsuario);
		
		JLabel lblLogueadoComo = new JLabel("Logueado Como: ");
		lblLogueadoComo.setBounds(31, 131, 110, 16);
		panelPrincipal.add(lblLogueadoComo);
		
		lblUserLogged = new JLabel("");
		lblUserLogged.setBounds(138, 131, 56, 16);
		panelPrincipal.add(lblUserLogged);
		
		System.out.println(panelPrincipal.isEnabled());
//		System.out.println(misCreditos.isEnabled());
//		System.out.println(miPanelPreguntas.isEnabled());
//		System.out.println(miPanelComoJugar.isEnabled());
	
	}
	
	public void CerrarVentana(){
		frame.dispose();
	}
	
	public static Principal getPrincipal(){
		return frame;
	}
	
	private void limpiarVentana(JPanel miVentanaActual, ArrayList<JPanel> misComponentesActivos){
		for (int i=0;i<misComponentesActivos.size();i++){
			contentPane.remove(misComponentesActivos.get(i));
			misComponentesActivos.remove(i);
		}
		contentPane.add(miVentanaActual);
		contentPane.repaint();
	}
}