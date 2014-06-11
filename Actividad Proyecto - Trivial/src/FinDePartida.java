import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*En esta clase sacamos la pantalla final del juego
 */

public class FinDePartida extends JFrame {

	private JPanel contentPane;
	private PanelPreguntas pPreguntas;
	private Principal ventanaInicio;
	private ConexionBBDD miConexion;

	
	//Pasamos la clase panel preguntas para poder usarla
	public FinDePartida(PanelPreguntas pPreguntas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Evento que nos permite acabar la partida y reiniciar el juego
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JButton btn=(JButton)arg0.getSource();
	                FinDePartida fin=(FinDePartida)SwingUtilities.getRoot(btn);
	                fin.dispose();

			}
		});
		btnNewButton.setBounds(124, 104, 118, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Finalizaste el reto!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 322, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Puntuaci\u00F3n final:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 45, 132, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPuntos = new JLabel("");
		lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntos.setBounds(164, 48, 34, 28);
		contentPane.add(lblPuntos);
		
		//Cogemos la puntuación final que se muestra en la ventana llamando a un método de la clase conexionBBDD
		lblPuntos.setText(String.valueOf(pPreguntas.getPuntos()));
        miConexion = pPreguntas.getConexion();
        miConexion.guardarPuntos(pPreguntas.getUsuario(),String.valueOf(pPreguntas.getPuntos()));  

	}
	
	public FinDePartida(PanelPreguntasOnline pPreguntas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Evento que nos permite acabar la partida y reiniciar el juego
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JButton btn=(JButton)arg0.getSource();
	                FinDePartida fin=(FinDePartida)SwingUtilities.getRoot(btn);
	                fin.dispose();

			}
		});
		btnNewButton.setBounds(124, 104, 118, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Finalizaste el reto!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 322, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Puntuaci\u00F3n final:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 45, 132, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPuntos = new JLabel("");
		lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntos.setBounds(164, 48, 34, 28);
		contentPane.add(lblPuntos);
		
		//Cogemos la puntuación final que se muestra en la ventana llamando a un método de la clase conexionBBDD
		lblPuntos.setText(String.valueOf(pPreguntas.getPuntos()));
        miConexion = pPreguntas.getConexion();
        miConexion.guardarPuntos(pPreguntas.getUsuario(),String.valueOf(pPreguntas.getPuntos()));  

	}
}
