import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Apuestas extends JFrame {

	private JPanel contentPane;
	private JComboBox<Liga> comboLigas;
	private Data misDatos = new Data();
	private ArrayList<Liga> misLigas;
	private Liga miLiga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apuestas frame = new Apuestas();
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
	public Apuestas() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				refreshData();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Selecciona una Liga", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 242, 132);
		contentPane.add(panel);
		panel.setLayout(null);
		
		comboLigas = new JComboBox<Liga>();
		comboLigas.setBounds(10, 21, 222, 20);
		panel.add(comboLigas);
		
		JButton btnNewButton = new JButton("Editar Liga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miLiga = misLigas.get(comboLigas.getSelectedIndex());
				VentanaLiga frame = new VentanaLiga(miLiga, misDatos);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 52, 111, 23);
		panel.add(btnNewButton);
		
		JButton btnAgregarLiga = new JButton("Agregar Liga");
		btnAgregarLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miLiga = new Liga();
				VentanaLiga frame = new VentanaLiga(miLiga, misDatos);
				frame.setVisible(true);
			}
		});
		btnAgregarLiga.setBounds(121, 52, 111, 23);
		panel.add(btnAgregarLiga);
	}
	
	private void refreshData(){
		comboLigas.removeAllItems();
		misLigas = misDatos.leerLigas();
		if(misLigas.size()==0){
			System.out.println("No hay Ligas");
		}else {
			
			for(int i=0; i<misLigas.size();i++){
				comboLigas.addItem(misLigas.get(i));
		}
		
		}
	}

}
