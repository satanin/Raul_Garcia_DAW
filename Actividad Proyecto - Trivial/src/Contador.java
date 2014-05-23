import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Contador implements Runnable {
	private JLabel contar;
	private volatile boolean isRunning = true;
	private int contarNum=3;
	private String nombreTarea;
	private FinDePartida finalPartida;
	private Principal p;

	
	public Contador(JLabel contar, Principal p){
		nombreTarea = "Contador";
		this.contar=contar;	
		this.p=p;
		
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
                        FinDePartida frame = new FinDePartida();
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


