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
	private PanelPreguntas miPanelPreguntas;
	private JPanel panelPrincipal;
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
				
				miPanelPreguntas = new PanelPreguntas();
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
		mnNewMenu_1.add(mntmAyuda);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cr\u00E9ditos");
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
		labelContador.setBounds(215, 268, 132, 31);
		panelPrincipal.add(labelContador);
		
		
		
		
		JButton btnProbarTimer = new JButton("Probar Timer");
		btnProbarTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread miContador = new Thread( new Contador(labelContador));
				miContador.start();
			}
		});
		btnProbarTimer.setBounds(215, 310, 132, 23);
		panelPrincipal.add(btnProbarTimer);
		
		
		
	}
	
	private void CerrarVentana(){
		frame.dispose();
	}
}
