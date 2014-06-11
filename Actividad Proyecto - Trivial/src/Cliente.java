import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;

/*En esta clase podemos ver el código necesario para 
 * que nuestro juego haga de cliente y pueda conectarse
 * en red con otros jugadores
 */

public class Cliente {

	private Socket cliente; // socket para comunicarse con el servidor
	private String servidor; // aloja al servidor para esta aplicación
	private ObjectOutputStream salida; // flujo de salida hacia el servidor
	private ObjectInputStream entrada; // flujo de entrada del servidor
	private PanelPreguntas objetoPreguntas; //objeto preguntas
	private JLabel lblClienteOnline; //etiqueta saber si esta online
	private Principal miframe;
	private Preguntas misPreguntasOnline;
	
	public Cliente(String host, String password, JLabel lblClienteOnline) {
		servidor = host;
		this.lblClienteOnline=lblClienteOnline;// establece el servidor al que se conecta este cliente
	}
	
	public void conectarAlServidor(Principal frame) throws IOException
	{  
		System.out.println("Intentando realizar conexion\n");
		// crea objeto Socket para hacer conexión con el servidor
		cliente = new Socket( InetAddress.getByName( servidor ), 12345);
		System.out.println("Conectado a: "+ cliente.getInetAddress().getHostName() );
		lblClienteOnline.setText("Online");
		lblClienteOnline.setForeground(Color.GREEN);

		try{
			miframe=frame;
			obtenerFlujos(miframe);

		}catch(IOException exception){
			System.out.println(exception);
		}
	}// fin del método conectarAlServidor
	
	// obtiene flujos para enviar y recibir datos
	private void obtenerFlujos(Principal miframe) throws IOException
	{
		// establece flujo de salida para los objetos
		salida = new ObjectOutputStream( cliente.getOutputStream() );
		salida.writeObject(miframe.getUser());
		System.out.println("Enviando al Servidor: "+miframe.getUser());
		salida.flush();// vacía el búfer de salida para enviar información de encabezado

		// establece flujo de entrada para los objetos
		entrada = new ObjectInputStream( cliente.getInputStream() );
		try {
			misPreguntasOnline = (Preguntas) entrada.readObject();
			System.out.println(misPreguntasOnline);
			
			miframe.lanzarPartidaMultiplayer(misPreguntasOnline);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nSe obtuvieron los flujos de E/S\n");

	}// fin del método obtenerFlujos
	
	// envía un mensaje al servidor
	public void enviarDatos(){
		try// envía un objeto al servidor
		{	
			salida.writeObject("CLIENTE>>> ");
			salida.flush();// envía todos los datos a la salida
			System.out.println("\nCLIENTE>>> ");
		}// fin de try
		catch( IOException excepcionES )
		{
			System.out.println("\nError al escribir objeto" );
		}// fin de catch
	}// fin del método enviarDatos
}
