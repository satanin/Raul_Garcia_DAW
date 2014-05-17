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


public class Principal extends JFrame {

	private JPanel contentPane;
	private static Principal frame;
	private Contador miContador;
	private JLabel labelContador;
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
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CerrarPrograma();
			}
		});
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
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido a Trivial Duels");
		lblNewLabel_1.setBounds(146, 5, 286, 31);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel_1);
		
		labelContador = new JLabel("");
		labelContador.setForeground(Color.GREEN);
		labelContador.setHorizontalAlignment(SwingConstants.CENTER);
		labelContador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContador.setBounds(215, 285, 132, 14);
		panel.add(labelContador);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RaulG\\git\\Raul_Garcia_DAW\\Actividad Proyecto - Trivial\\assets\\board.JPG"));
		lblNewLabel.setBounds(0, 0, 583, 406);
		contentPane.add(lblNewLabel);
		
		//Thread subproceso1 = new Thread( new Hilo( "tarea1") );
		
		
		JButton btnProbarTimer = new JButton("Probar Timer");
		btnProbarTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread miContador = new Thread( new Contador(labelContador));
				miContador.start();
			}
		});
		btnProbarTimer.setBounds(215, 310, 132, 23);
		panel.add(btnProbarTimer);
		
		
		
	}
	
	private void CerrarPrograma(){
		frame.dispose();
	}
}
