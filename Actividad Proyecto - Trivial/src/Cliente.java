import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Cliente {

	private Socket cliente; // socket para comunicarse con el servidor
	private String servidor; // aloja al servidor para esta aplicación
	private ObjectOutputStream salida; // flujo de salida hacia el servidor
	private ObjectInputStream entrada; // flujo de entrada del servidor
	
	public Cliente(String host) {
		servidor = host; // establece el servidor al que se conecta este cliente
	}
	
	public void conectarAlServidor() throws IOException
	{  
		System.out.println("Intentando realizar conexion\n");
		// crea objeto Socket para hacer conexión con el servidor
		cliente = new Socket( InetAddress.getByName( servidor ), 12345);
		// muestra la información de la conexión
		System.out.println("Conectado a: "+ cliente.getInetAddress().getHostName() );
		try{
			obtenerFlujos();
		}catch(IOException exception){
			System.out.println(exception);
		}
	}// fin del método conectarAlServidor
	
	// obtiene flujos para enviar y recibir datos
	private void obtenerFlujos() throws IOException
	{
		// establece flujo de salida para los objetos
		salida = new ObjectOutputStream( cliente.getOutputStream() );
		salida.flush();// vacía el búfer de salida para enviar información de encabezado

		// establece flujo de entrada para los objetos
		entrada = new ObjectInputStream( cliente.getInputStream() );

		System.out.println("\nSe obtuvieron los flujos de E/S\n");
	}// fin del método obtenerFlujos
	
	// envía un mensaje al servidor
	public void enviarDatos( String mensaje )
	{
		try// envía un objeto al servidor
		{
			salida.writeObject("CLIENTE>>> "+ mensaje );
			salida.flush();// envía todos los datos a la salida
			System.out.println("\nCLIENTE>>> "+ mensaje );
		}// fin de try
		catch( IOException excepcionES )
		{
			System.out.println("\nError al escribir objeto" );
		}// fin de catch
	}// fin del método enviarDatos
}
