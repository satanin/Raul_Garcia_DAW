import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;


public class PanelPreguntas extends JPanel {
	private JLabel labelContador;
	private ArrayList<Pregunta> misPreguntas;
	private ConexionBBDD miConexion;
	private Pregunta pregunta;
	private JTextPane txtPregunta;
	private JRadioButton radioResp1, radioResp2, radioResp3;

	/**
	 * Create the panel.
	 */
	public PanelPreguntas(ConexionBBDD miConexion) {
		setBounds(new Rectangle(10, 11, 563, 384));
		
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel labelTituloPregunta = new JLabel("T\u00EDtulo de la Pregunta");
		labelTituloPregunta.setForeground(Color.WHITE);
		labelTituloPregunta.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTituloPregunta.setBounds(10, 32, 474, 14);
		add(labelTituloPregunta);
		
		txtPregunta = new JTextPane();
		txtPregunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPregunta.setEditable(false);
		txtPregunta.setText("Aqui iria el texto de la pregunta lo que no s\u00E9 es si la pregunta es muy larga que pasar\u00EDa con el texto, quiz\u00E1 deber\u00EDa poner otra cosa");
		txtPregunta.setBounds(10, 57, 543, 68);
		add(txtPregunta);
		
		radioResp1 = new JRadioButton("Respuesta 1");
		radioResp1.setBackground(Color.LIGHT_GRAY);
		radioResp1.setBounds(10, 159, 543, 23);
		add(radioResp1);
		
		radioResp2 = new JRadioButton("Respuesta 2");
		radioResp2.setBackground(Color.LIGHT_GRAY);
		radioResp2.setBounds(10, 207, 543, 23);
		add(radioResp2);
		
		radioResp3 = new JRadioButton("Respuesta 3");
		radioResp3.setBackground(Color.LIGHT_GRAY);
		radioResp3.setBounds(10, 254, 543, 23);
		add(radioResp3);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSiguiente.setBounds(464, 350, 89, 23);
		add(btnSiguiente);
		
		labelContador = new JLabel("30");
		labelContador.setForeground(Color.WHITE);
		labelContador.setHorizontalAlignment(SwingConstants.CENTER);
		labelContador.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelContador.setBounds(507, 11, 46, 34);
		add(labelContador);
		
		Thread miContador = new Thread( new Contador(labelContador));
		miContador.start();
		
			
		misPreguntas = new ArrayList<Pregunta>();
		this.miConexion = miConexion;
		this.miConexion.leerPreguntas(misPreguntas);
		
		pregunta = misPreguntas.get(1);
		txtPregunta.setText(pregunta.getPregunta());
		//System.out.println(misPreguntas.get(0).getPregunta());
		
		txtPregunta.repaint();

	}
}
