import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Contador implements Runnable {
	private JLabel contar;
	private volatile boolean isRunning = true;
	private int contarNum=30;
	private String nombreTarea;

	
	public Contador(JLabel contar){
		nombreTarea = "Contador";
		this.contar=contar;	
		
	}
	
	public void run(){
		try{
			while(contarNum>0){
				contarNum--;
				contar.setText(String.valueOf(contarNum));
				Thread.sleep( 1000);
				if (contarNum==0){
					 JOptionPane.showMessageDialog(null, "Fin de la partida");
				}
			}
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


