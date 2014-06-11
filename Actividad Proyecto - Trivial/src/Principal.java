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
import javax.swing.JScrollPane;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*Esta es la clase principal del proyecto trivial desde el cual 
 * vamos a hacer las interacciones con todas las ventanas, en este caso Jpanel
 * con los que vamos a mejorar la experiencia del usuario, pues la única ventana
 * que se le abrirá es la de final de partida 
 */

public class Principal extends JFrame {

	private Contador miContador;
	private JLabel lblUserLogged,labelError;
	public PanelPreguntas miPanelPreguntas;
	private JPanel contentPane,panelPrincipal,miPanelMultiPlayer,panelLogin, miPanelPreguntasOnline;
	private ConexionBBDD miConexion;
	private PanelComoJugar miPanelComoJugar;
	private Creditos misCreditos;
	private Pregunta pregunta;
	private static Principal frame;
	private JTable topScores;
	private ArrayList<JPanel> misComponentesActivos;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private DefaultTableModel miTableModel;
	private String clientUser;
	
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				contentPane.add(panelPrincipal);
				contentPane.repaint();
			}
		}); 
		//Inicializamos arraylist de Jpanel para hacer las transiciones entre ellas y la BBDD
		misComponentesActivos = new ArrayList<JPanel>();
		miConexion = new ConexionBBDD();
		
		setTitle("Trivial Duels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 465);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		//Botón para practicar en solitario, lanzando el correspondiente jpanel
		JMenuItem mntmInicio = new JMenuItem("Practica Solo");
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				miPanelPreguntas = new PanelPreguntas(miConexion, lblUserLogged.getText());
				miPanelPreguntas.setBounds(10, 11, 563, 384);
				misComponentesActivos.add(miPanelPreguntas);
				limpiarVentana(miPanelPreguntas,misComponentesActivos);

			}
		});
		
		//Botón para volver al inicio para poder loguear y ver los top scores
		JMenuItem mntmInicio_1 = new JMenuItem("Inicio");
		mntmInicio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPrincipal.setVisible(true);
				misComponentesActivos.add(panelPrincipal);
				limpiarVentana(panelPrincipal,misComponentesActivos);
			}
		});
		mnNewMenu.add(mntmInicio_1);
		mnNewMenu.add(mntmInicio);
		
		//Boton para iniciar el juego multiplayer
		JMenuItem mntmNewMenuItem = new JMenuItem("Multiplayer");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miPanelMultiPlayer = new PanelMultiPlayer(miConexion, frame);
				miPanelMultiPlayer.setBounds(10, 11, 563, 384);
				misComponentesActivos.add(miPanelMultiPlayer);
				limpiarVentana(miPanelMultiPlayer,misComponentesActivos);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		//Botón para salir y cerrar la ventana del juego
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CerrarVentana();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_1);
		
		//Botón para conocer la ayuda del juego y conocer las instrucciones
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
		
		//Botón para conocer a los desarrolladores del juego
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
		//Objeto necesrio para el jscroll en el que mostramos los mejores resultados
		miTableModel = new DefaultTableModel(null, tableModel());
		
		
		JLabel lblHighScores = new JLabel("High Scores");
		lblHighScores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHighScores.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScores.setBounds(316, 63, 192, 33);
		panelPrincipal.add(lblHighScores);
		
		panelLogin = new JPanel();
		panelLogin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Logueate para Guardar Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLogin.setBounds(12, 95, 249, 256);
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
		
		/*Evento en el que capturamos el usuario y contraseña que introduce el jugador
		 * y que si es correcto nos muestra el nombre del usuario que se ha registrado
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(31, 166, 75, 25);
		panelLogin.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean conectado = miConexion.getLogin(textFieldUser.getText(),String.valueOf(passwordField.getPassword()));
				//System.out.println(conectado);
				if (conectado==true){
					lblUserLogged.setText(textFieldUser.getText());
					panelPrincipal.remove(panelLogin);
					contentPane.repaint();
			
				}else {
					labelError.setText("Usuario o Password Incorrecto");
				}
			}
		});
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setBounds(31, 38, 110, 16);
		panelLogin.add(lblNombreDeUsuario);
		
		labelError = new JLabel("");
		labelError.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelError.setForeground(Color.RED);
		labelError.setBounds(31, 211, 206, 32);
		panelLogin.add(labelError);
		
		JLabel lblLogueadoComo = new JLabel("Logueado Como: ");
		lblLogueadoComo.setBounds(31, 131, 110, 16);
		panelPrincipal.add(lblLogueadoComo);
		
		lblUserLogged = new JLabel("");
		lblUserLogged.setBounds(138, 131, 56, 16);
		panelPrincipal.add(lblUserLogged);
		
		
		miConexion.getScores(miTableModel);
		topScores = new JTable();
		topScores.setModel(miTableModel);
		topScores.setBounds(294, 95, 230, 256);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 107, 280, 244);
		scrollPane.add(topScores);

		
		scrollPane.setViewportView(topScores);
		panelPrincipal.add(scrollPane);
		
	}
	
	//Metodo para cerrar la ventana
	public void CerrarVentana(){
		frame.dispose();
	}
	
	//Metodo para iniciar la ventana principal
	public static Principal getPrincipal(){
		return frame;
	}
	
	//Metodo que nos permite limpiar y repintar las ventanas según vamos interactuando con ellas
	private void limpiarVentana(JPanel miVentanaActual, ArrayList<JPanel> misComponentesActivos){
		for (int i=0;i<misComponentesActivos.size();i++){
			contentPane.remove(misComponentesActivos.get(i));
			misComponentesActivos.remove(i);
		}
		contentPane.add(miVentanaActual);
		contentPane.repaint();
	}
	//Metodo con el que pintamos la cabecera de las mejores puntuaciones del jscroll
	private String[] tableModel(){
	    String columna[]=new String[]{"Rank","Name","Points"};
	    return columna;
	}
	
	public void lanzarPartidaMultiplayer(Preguntas misPreguntasOnline){
//		clientUser = misPreguntasOnline.getClientUser();
		System.out.println("Ahora se debería lanzar el nuevo panel multijugador");	
		miPanelPreguntasOnline = new PanelPreguntasOnline(misPreguntasOnline, miConexion);
		miPanelPreguntasOnline.setBounds(10, 11, 563, 384);
		misComponentesActivos.add(miPanelPreguntasOnline);
		limpiarVentana(miPanelPreguntasOnline,misComponentesActivos);
		System.out.println("Deberíamos estar viendo el panel Multiplayer");	
	}
	
	public String getUser(){
		return lblUserLogged.getText();
	}
}