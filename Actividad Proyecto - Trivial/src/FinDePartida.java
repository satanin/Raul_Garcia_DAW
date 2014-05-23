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


public class FinDePartida extends JFrame {

	private JPanel contentPane;
	private PanelPreguntas pPreguntas;
	private Principal ventanaInicio;

	

	public FinDePartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(34, 55, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPuntos = new JLabel("");
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuntos.setBounds(145, 41, 34, 28);
		contentPane.add(lblPuntos);
	}
	
}
