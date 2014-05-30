import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Contador implements Runnable {
	private JLabel contar;
	private volatile boolean isRunning = true;
	private int contarNum=10;
	private String nombreTarea;
	private FinDePartida finalPartida;
	private Principal p;
	private PanelPreguntas pPreguntas2;
	

	
	public Contador(JLabel contar, Principal p, PanelPreguntas pPreguntas){
		nombreTarea = "Contador";
		this.contar=contar;	
		this.p=p;
		pPreguntas2 = pPreguntas;
	}
	
	public void run(){
		try{
            while(contarNum>0){
                contarNum--;
                contar.setText(String.valueOf(contarNum));
                Thread.sleep( 1000);
            }
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        FinDePartida frame = new FinDePartida(pPreguntas2);
                        frame.setVisible(true);
                        Principal.getPrincipal().remove(Principal.getPrincipal().miPanelPreguntas);
                        Principal.getPrincipal().repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
		}catch( InterruptedException excepcion ){
			System.out.println(excepcion);
			isRunning = false;
			System.out.printf("%s %s\n", nombreTarea,"termino en forma prematura, debido a la interrupcion");
		} 
	}

	public void kill() {
	     isRunning = false;
	}

}


