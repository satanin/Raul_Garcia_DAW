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
import java.util.Collections;
import java.util.Random;


public class PanelPreguntas extends JPanel {
	private JLabel labelContador;
	private ArrayList<Pregunta> misPreguntas, misPreguntasRandom;
	private ConexionBBDD miConexion;
	private Pregunta pregunta;
	private JTextPane txtPregunta;
	private JRadioButton radioResp1, radioResp2, radioResp3;
	private int cont=0;
	private int respuesta=0;
	private JLabel labelResultado;
	private int puntos = 0;
	private JLabel labelPuntos;
	private PanelPreguntas panelPreguntas;
	private Random aleatorio;

	/**
	 * Create the panel.
	 */
	public PanelPreguntas(ConexionBBDD miConexion) {
		this.panelPreguntas=this;
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
		radioResp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioResp1.isSelected()){
					radioResp2.setSelected(false);
					radioResp3.setSelected(false);
				}
			}
		});
		radioResp1.setBackground(Color.LIGHT_GRAY);
		radioResp1.setBounds(10, 159, 543, 23);
		add(radioResp1);
		
		radioResp2 = new JRadioButton("Respuesta 2");
		radioResp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioResp2.isSelected()){
					radioResp1.setSelected(false);
					radioResp3.setSelected(false);
				}
			}
		});
		radioResp2.setBackground(Color.LIGHT_GRAY);
		radioResp2.setBounds(10, 207, 543, 23);
		add(radioResp2);
		
		radioResp3 = new JRadioButton("Respuesta 3");
		radioResp3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioResp3.isSelected()){
					radioResp2.setSelected(false);
					radioResp1.setSelected(false);
				}
			}
		});
		radioResp3.setBackground(Color.LIGHT_GRAY);
		radioResp3.setBounds(10, 254, 543, 23);
		add(radioResp3);
		
		
		
		labelContador = new JLabel("30");
		labelContador.setForeground(Color.WHITE);
		labelContador.setHorizontalAlignment(SwingConstants.CENTER);
		labelContador.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelContador.setBounds(507, 11, 46, 34);
		add(labelContador);
		
		Thread miContador = new Thread( new Contador(labelContador,Principal.getPrincipal(), this.panelPreguntas));
		miContador.start();
		
			
		misPreguntas = new ArrayList<Pregunta>();
		this.miConexion = miConexion;
		this.miConexion.leerPreguntas(misPreguntas);
		System.out.println(misPreguntas.size());
		misPreguntas = preguntasAleatorias(misPreguntas);
		
		txtPregunta.setText(misPreguntas.get(cont).getPregunta());
		radioResp1.setText(misPreguntas.get(cont).getRespuesta1());
		radioResp2.setText(misPreguntas.get(cont).getRespuesta2());
		radioResp3.setText(misPreguntas.get(cont).getRespuesta3());
		
		labelPuntos = new JLabel("0");
		labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		labelPuntos.setForeground(Color.WHITE);
		labelPuntos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelPuntos.setBounds(10, 345, 46, 23);
		add(labelPuntos);
		
		JLabel lblPuntuacion = new JLabel("Puntuaci\u00F3n");
		lblPuntuacion.setForeground(Color.WHITE);
		lblPuntuacion.setBounds(10, 320, 73, 14);
		add(lblPuntuacion);
	
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckRespuesta();
				if(respuesta == 0){
					labelResultado.setForeground(Color.RED);
					labelResultado.setText("Tienes que seleccionar una respuesta!");
				}else {
					System.out.println("contador: "+cont+", Size: "+misPreguntas.size());
					if(cont<misPreguntas.size()){
						//hola
						if(misPreguntas.get(cont).getRespuestaValida() == respuesta){
							labelResultado.setForeground(Color.GREEN);
							labelResultado.setText("Respuesta Correcta! Sumas 5 puntos!");
							puntos = puntos +5;
							labelPuntos.setText(String.valueOf(puntos));
						}else {
							labelResultado.setForeground(Color.RED);
							labelResultado.setText("Respuesta Incorrecta, Pardillo! ");
							labelPuntos.setText(String.valueOf(puntos));
						}
					}				
					cont++;
					if(cont<misPreguntas.size()){
					System.out.println("Contador actualizado a valor:"+cont);
					resetRadioButtons();
					txtPregunta.setText(misPreguntas.get(cont).getPregunta());
					radioResp1.setText(misPreguntas.get(cont).getRespuesta1());
					radioResp2.setText(misPreguntas.get(cont).getRespuesta2());
					radioResp3.setText(misPreguntas.get(cont).getRespuesta3());
					}
				}
				
			}
		});
		btnSiguiente.setBounds(464, 350, 89, 23);
		add(btnSiguiente);
		
		labelResultado = new JLabel("");
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelResultado.setBounds(10, 284, 543, 25);
		add(labelResultado);
		
		//System.out.println(misPreguntas.get(0).getPregunta());
		


	}
	
	private void CheckRespuesta(){
		
		if(radioResp1.isSelected()){
			respuesta = 1;
		}else if(radioResp2.isSelected()){
			respuesta = 2;
		}else if(radioResp3.isSelected()){
			respuesta = 3;
		}else{
			respuesta = 0;
		}
	}
	
	private void resetRadioButtons(){
		radioResp1.setSelected(false);
		radioResp2.setSelected(false);
		radioResp3.setSelected(false);
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	public ArrayList<Pregunta> preguntasAleatorias(ArrayList<Pregunta> misPreguntas){
		
		System.out.println("Tengo "+misPreguntas.size()+" preguntas en misPreguntas");
		long seed = System.nanoTime();
		System.out.println("Cambiando el orden de las preguntas...");
		Collections.shuffle(misPreguntas, new Random(seed));
		return misPreguntas;
	}

}
