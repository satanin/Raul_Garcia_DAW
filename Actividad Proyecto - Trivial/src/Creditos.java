import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;


public class Creditos extends JPanel {

	 // Clase para mostrar en un Jpanel los desarrolladores del juego
	public Creditos() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cr\u00E9ditos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(26, 33, 414, 14);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Desarrollado por...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 79, 379, 115);
		add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ra\u00FAl Garc\u00EDa");
		rdbtnNewRadioButton.setBounds(29, 33, 207, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnSalvadorPrez = new JRadioButton("Salvador P\u00E9rez");
		rdbtnSalvadorPrez.setBounds(29, 70, 207, 23);
		panel.add(rdbtnSalvadorPrez);

	}
}
