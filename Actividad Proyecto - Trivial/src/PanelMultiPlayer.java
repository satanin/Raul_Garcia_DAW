import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class PanelMultiPlayer extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ConexionBBDD miConexion;

	public PanelMultiPlayer(ConexionBBDD miConexion) {
		this.miConexion = miConexion;
		setLayout(null);
		
		JLabel lblBienvenidoALa = new JLabel("Bienvenido a la Secci\u00F3n Multiplayer");
		lblBienvenidoALa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoALa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenidoALa.setBounds(64, 13, 327, 16);
		add(lblBienvenidoALa);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Conectar a Servidor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(12, 60, 210, 227);
		add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 150, 186, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblServerPassword = new JLabel("Server Password:");
		lblServerPassword.setForeground(Color.WHITE);
		lblServerPassword.setBounds(12, 121, 105, 16);
		panel.add(lblServerPassword);
		
		JLabel lblServerAddress = new JLabel("Server Address:");
		lblServerAddress.setForeground(Color.WHITE);
		lblServerAddress.setBounds(12, 36, 105, 16);
		panel.add(lblServerAddress);
		
		textField = new JTextField();
		textField.setBounds(12, 60, 186, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnConectarAPartida = new JButton("Conectar a Partida");
		btnConectarAPartida.setBounds(12, 189, 186, 25);
		panel.add(btnConectarAPartida);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Crear Servidor", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_1.setBounds(234, 60, 204, 227);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Server Password:");
		label.setBounds(12, 40, 102, 16);
		panel_1.add(label);
		label.setForeground(Color.WHITE);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 61, 139, 22);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCrearPartidaOnline = new JButton("Crear Partida Online");
		btnCrearPartidaOnline.setBounds(12, 189, 180, 25);
		panel_1.add(btnCrearPartidaOnline);

	}
}
