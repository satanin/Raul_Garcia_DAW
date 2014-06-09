import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

/*Desde esta clase vamos a controlar la conexion en red
 * para que puedan jugar dos usuarios a la vez
 */


public class PanelMultiPlayer extends JPanel {
	private JTextField serverAddress;
	private JTextField clientePassword;
	private JTextField serverPassword;
	private ConexionBBDD miConexion;
	private JLabel lblOnline,lblClienteOnline;

	//Pasamos BBDD por el constructor
	public PanelMultiPlayer(ConexionBBDD miConexion) {
		this.miConexion = miConexion;
		setLayout(null);
		
		JLabel lblBienvenidoALa = new JLabel("Bienvenido a la Secci\u00F3n Multiplayer");
		lblBienvenidoALa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoALa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenidoALa.setBounds(64, 13, 327, 16);
		add(lblBienvenidoALa);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBackground(Color.GRAY);
		panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Conectar a Servidor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelCliente.setBounds(12, 60, 210, 227);
		add(panelCliente);
		panelCliente.setLayout(null);
		
		clientePassword = new JTextField();
		clientePassword.setBounds(12, 114, 186, 22);
		panelCliente.add(clientePassword);
		clientePassword.setColumns(10);
		
		JLabel lblServerPassword = new JLabel("Server Password:");
		lblServerPassword.setForeground(Color.WHITE);
		lblServerPassword.setBounds(12, 95, 105, 16);
		panelCliente.add(lblServerPassword);
		
		JLabel lblServerAddress = new JLabel("Server Address:");
		lblServerAddress.setForeground(Color.WHITE);
		lblServerAddress.setBounds(12, 36, 105, 16);
		panelCliente.add(lblServerAddress);
		
		serverAddress = new JTextField();
		serverAddress.setBounds(12, 60, 186, 22);
		panelCliente.add(serverAddress);
		serverAddress.setColumns(10);
		
		//Evento que nos permite conectarnos con una partida.
		JButton btnConectarAPartida = new JButton("Conectar a Partida");
		btnConectarAPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente(serverAddress.getText(),clientePassword.getText(),lblClienteOnline);
				try {
					cliente.conectarAlServidor();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConectarAPartida.setBounds(12, 189, 186, 25);
		panelCliente.add(btnConectarAPartida);
		
		JLabel lblEstado_1 = new JLabel("Estado");
		lblEstado_1.setForeground(Color.WHITE);
		lblEstado_1.setBounds(12, 144, 56, 16);
		panelCliente.add(lblEstado_1);
		
		lblClienteOnline = new JLabel("Offline");
		lblClienteOnline.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClienteOnline.setForeground(Color.RED);
		lblClienteOnline.setBounds(80, 144, 56, 16);
		panelCliente.add(lblClienteOnline);
		
		JPanel panelServidor = new JPanel();
		panelServidor.setBackground(Color.GRAY);
		panelServidor.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Crear Servidor", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panelServidor.setBounds(234, 60, 204, 227);
		add(panelServidor);
		panelServidor.setLayout(null);
		
		JLabel label = new JLabel("Server Password:");
		label.setBounds(12, 40, 102, 16);
		panelServidor.add(label);
		label.setForeground(Color.WHITE);
		
		serverPassword = new JTextField();
		serverPassword.setBounds(12, 61, 139, 22);
		panelServidor.add(serverPassword);
		serverPassword.setColumns(10);
		
		//Evento al que le pasamos el tread con el que realizar la conexión en red
		JButton btnCrearPartidaOnline = new JButton("Crear Partida Online");
		btnCrearPartidaOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread servidor = new Thread( new Servidor(serverPassword.getText(), lblOnline));
				servidor.start();
			}
		});
		btnCrearPartidaOnline.setBounds(12, 189, 180, 25);
		panelServidor.add(btnCrearPartidaOnline);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setBounds(12, 107, 56, 16);
		panelServidor.add(lblEstado);
		
		lblOnline = new JLabel("Offline");
		lblOnline.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOnline.setForeground(Color.RED);
		lblOnline.setBackground(Color.RED);
		lblOnline.setBounds(80, 107, 61, 16);
		panelServidor.add(lblOnline);

	}
}
