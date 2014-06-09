import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ScrollPaneConstants;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class PanelComoJugar extends JPanel {
	private JTextField txtModalidadesDeJuego;
	private JTextField txtComoJugar;

	/* Clase en la que se explican las reglas del juego en un JPanel
	 */
	public PanelComoJugar() {
		setBounds(new Rectangle(10, 11, 563, 384));
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JTextPane txtpnTrivialDuelsEs = new JTextPane();
		txtpnTrivialDuelsEs.setForeground(Color.BLACK);
		txtpnTrivialDuelsEs.setBackground(Color.LIGHT_GRAY);
		txtpnTrivialDuelsEs.setText("Trivial Duels es un juego muy sencillo. \u00DAnicamente tienes que contestar lo m\u00E1s r\u00E1pido posible al mayor n\u00FAmero de preguntas durante los 30 segundos que dura Trivial Duels. Una vez concluya el tiempo ganar\u00E1 el jugador que m\u00E1s respuestas correctas haya respondido.");
		txtpnTrivialDuelsEs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnTrivialDuelsEs.setEditable(false);
		txtpnTrivialDuelsEs.setBounds(80, 69, 412, 91);
		add(txtpnTrivialDuelsEs);
		
		txtModalidadesDeJuego = new JTextField();
		txtModalidadesDeJuego.setHorizontalAlignment(SwingConstants.CENTER);
		txtModalidadesDeJuego.setText("Modalidades de juego");
		txtModalidadesDeJuego.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtModalidadesDeJuego.setColumns(10);
		txtModalidadesDeJuego.setBackground(Color.LIGHT_GRAY);
		txtModalidadesDeJuego.setBounds(40, 203, 472, 25);
		add(txtModalidadesDeJuego);
		
		JLabel lblEnSolitario = new JLabel("En Solitario");
		lblEnSolitario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEnSolitario.setBounds(110, 253, 114, 14);
		add(lblEnSolitario);
		
		JLabel lblDuelo = new JLabel("Duelo");
		lblDuelo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDuelo.setBounds(378, 253, 114, 14);
		add(lblDuelo);
		
		JTextPane txtpnJuegaEnEsta = new JTextPane();
		txtpnJuegaEnEsta.setText("Juega en esta modalidad y podr\u00E1s practicar la mec\u00E1nica de nuestro juego.  Preparate para ser el mejor de tus amigos.");
		txtpnJuegaEnEsta.setForeground(Color.BLACK);
		txtpnJuegaEnEsta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnJuegaEnEsta.setEditable(false);
		txtpnJuegaEnEsta.setBackground(Color.LIGHT_GRAY);
		txtpnJuegaEnEsta.setBounds(40, 278, 209, 91);
		add(txtpnJuegaEnEsta);
		
		JTextPane txtpnestasPreparadoPara = new JTextPane();
		txtpnestasPreparadoPara.setText("\u00BFEstas preparado para ser el mejor? Compite con tus amigos para ver quien es el m\u00E1s listo y r\u00E1pido de los dos.");
		txtpnestasPreparadoPara.setForeground(Color.BLACK);
		txtpnestasPreparadoPara.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnestasPreparadoPara.setEditable(false);
		txtpnestasPreparadoPara.setBackground(Color.LIGHT_GRAY);
		txtpnestasPreparadoPara.setBounds(325, 278, 209, 91);
		add(txtpnestasPreparadoPara);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(27, 191, 509, 182);
		add(panel_1);
		
		txtComoJugar = new JTextField();
		txtComoJugar.setText("Como jugar");
		txtComoJugar.setHorizontalAlignment(SwingConstants.CENTER);
		txtComoJugar.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtComoJugar.setColumns(10);
		txtComoJugar.setBackground(Color.LIGHT_GRAY);
		txtComoJugar.setBounds(40, 33, 472, 25);
		add(txtComoJugar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(27, 11, 509, 168);
		add(panel);

	}
}
