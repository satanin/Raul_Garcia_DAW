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


public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
			}
		});
		mnNewMenu.add(mntmInicio);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Duelo");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmAyuda = new JMenuItem("Como Jugar");
		mnNewMenu_1.add(mntmAyuda);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cr\u00E9ditos");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 563, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelPreguntasSolo = new JPanel();
		panelPreguntasSolo.setBackground(Color.WHITE);
		panelPreguntasSolo.setBounds(35, 46, 488, 304);
		panel.add(panelPreguntasSolo);
		panelPreguntasSolo.setLayout(null);
		
		JLabel lblPracticaSolo = new JLabel("Practica Solo");
		lblPracticaSolo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPracticaSolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPracticaSolo.setBounds(162, 11, 164, 14);
		panelPreguntasSolo.add(lblPracticaSolo);
		
		JLabel timerPreguntas = new JLabel("New label");
		timerPreguntas.setBounds(432, 13, 46, 14);
		panelPreguntasSolo.add(timerPreguntas);
		
		JLabel Pregunta = new JLabel("De que color era el caballo blanco de san roque");
		Pregunta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Pregunta.setBounds(37, 67, 414, 41);
		panelPreguntasSolo.add(Pregunta);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido a Trivial Duels");
		lblNewLabel_1.setBounds(146, 5, 286, 31);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RaulG\\git\\Raul_Garcia_DAW\\Actividad Proyecto - Trivial\\assets\\board.JPG"));
		lblNewLabel.setBounds(0, 0, 583, 406);
		contentPane.add(lblNewLabel);
	}
}
