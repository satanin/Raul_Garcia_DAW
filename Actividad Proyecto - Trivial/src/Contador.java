import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Contador implements Runnable {
	private JLabel contar;
	private volatile boolean isRunning = true;
	private int contarNum=30;
	private String nombreTarea;
	private FinDePartida finalPartida;
	private Principal p;
	private PanelPreguntas pPreguntas2;
	private PanelPreguntasOnline pPreguntasOnline;
	private ConexionBBDD miConexion;
	private boolean partidaOnline=false;
	
	/*Desde esta clase vamos a controlar el contador del juego, un thread que al llegar a
	 * cero dará la partida por finalizada. En primer lugar inicializamos en el constructor
	 * todas las clases y objetos necesarios para el correcto funcionamiento*/

	//Pasamos varias clases y un Jlabel para poder usarlas en esta clase
	public Contador(JLabel contar, Principal p, PanelPreguntas pPreguntas){
		nombreTarea = "Contador";
		this.contar=contar;	
		this.p=p;
		pPreguntas2 = pPreguntas;
		this.miConexion=pPreguntas2.getConexion();
	}
	
	public Contador(JLabel contar, Principal p, PanelPreguntasOnline pPreguntas){
		nombreTarea = "Contador";
		this.contar=contar;	
		this.p=p;
		pPreguntasOnline = pPreguntas;
		this.miConexion=pPreguntasOnline.getConexion();
		partidaOnline = true;
	}
	
	//Codigo del contador para que haga la cuenta atrás
	public void run(){
		try{
            while(contarNum>0){
                contarNum--;
                contar.setText(String.valueOf(contarNum));
                Thread.sleep( 1000);
            }
            EventQueue.invokeLater(new Runnable() {
            	/*Codigo para lanzar la ventana de fin de partida una vez el contador llega a cero
            	 * Además, repitamos la pantalla de inicio una vez concluido el juego para que el
            	 * jugador vuelva a jugar una nueva partida si lo desea */
                public void run() {
                    try {         
                    	if(partidaOnline){
                    		FinDePartida frame = new FinDePartida(pPreguntasOnline);
                            frame.setVisible(true);
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            Principal.getPrincipal().remove(Principal.getPrincipal().miPanelPreguntas);
                            Principal.getPrincipal().repaint();
                    	}else {
                    		FinDePartida frame = new FinDePartida(pPreguntas2);
                            frame.setVisible(true);
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            Principal.getPrincipal().remove(Principal.getPrincipal().miPanelPreguntas);
                            Principal.getPrincipal().repaint();
                    	}
                        

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
		}catch( InterruptedException excepcion ){
			//System.out.println(excepcion);
			isRunning = false;
			//System.out.printf("%s %s\n", nombreTarea,"termino en forma prematura, debido a la interrupcion");
		} 
	}

	public void kill() {
	     isRunning = false;
	}

}


