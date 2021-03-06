import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;

/*En esta clase podemos ver el c�digo necesario para 
 * que nuestro juego haga de cliente y pueda conectarse
 * en red con otros jugadores
 */

public class Cliente {

	private Socket cliente; // socket para comunicarse con el servidor
	private String servidor; // aloja al servidor para esta aplicaci�n
	private ObjectOutputStream salida; // flujo de salida hacia el servidor
	private ObjectInputStream entrada; // flujo de entrada del servidor
	private PanelPreguntas objetoPreguntas; //objeto preguntas
	private JLabel lblClienteOnline; //etiqueta saber si esta online
	
	public Cliente(String host, String password, JLabel lblClienteOnline) {
		servidor = host;
		this.lblClienteOnline=lblClienteOnline;// establece el servidor al que se conecta este cliente
	}
	
	public void conectarAlServidor() throws IOException
	{  
		System.out.println("Intentando realizar conexion\n");
		// crea objeto Socket para hacer conexi�n con el servidor
		cliente = new Socket( InetAddress.getByName( servidor ), 12345);
		System.out.println("Conectado a: "+ cliente.getInetAddress().getHostName() );
		lblClienteOnline.setText("Online");
		lblClienteOnline.setForeground(Color.GREEN);
		try{
			obtenerFlujos();

		}catch(IOException exception){
			System.out.println(exception);
		}
	}// fin del m�todo conectarAlServidor
	
	// obtiene flujos para enviar y recibir datos
	private void obtenerFlujos() throws IOException
	{
		// establece flujo de salida para los objetos
		salida = new ObjectOutputStream( cliente.getOutputStream() );
		salida.flush();// vac�a el b�fer de salida para enviar informaci�n de encabezado

		// establece flujo de entrada para los objetos
		entrada = new ObjectInputStream( cliente.getInputStream() );

		System.out.println("\nSe obtuvieron los flujos de E/S\n");
	}// fin del m�todo obtenerFlujos
	
	// env�a un mensaje al servidor
	public void enviarDatos( ArrayList <Pregunta> misPreguntas )
	{
		try// env�a un objeto al servidor
		{
			objetoPreguntas.preguntasAleatorias(misPreguntas);
			
			salida.writeObject("CLIENTE>>> "+ objetoPreguntas.preguntasAleatorias(misPreguntas) );
			salida.flush();// env�a todos los datos a la salida
			System.out.println("\nCLIENTE>>> "+ objetoPreguntas.preguntasAleatorias(misPreguntas) );
		}// fin de try
		catch( IOException excepcionES )
		{
			System.out.println("\nError al escribir objeto" );
		}// fin de catch
	}// fin del m�todo enviarDatos
}
