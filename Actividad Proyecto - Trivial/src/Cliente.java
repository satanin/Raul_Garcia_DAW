import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Cliente {

	private Socket cliente; // socket para comunicarse con el servidor
	private String servidor; // aloja al servidor para esta aplicaci�n
	private ObjectOutputStream salida; // flujo de salida hacia el servidor
	private ObjectInputStream entrada; // flujo de entrada del servidor
	
	public Cliente(String host) {
		servidor = host; // establece el servidor al que se conecta este cliente
	}
	
	public void conectarAlServidor() throws IOException
	{  
		System.out.println("Intentando realizar conexion\n");
		// crea objeto Socket para hacer conexi�n con el servidor
		cliente = new Socket( InetAddress.getByName( servidor ), 12345);
		// muestra la informaci�n de la conexi�n
		System.out.println("Conectado a: "+ cliente.getInetAddress().getHostName() );
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
	public void enviarDatos( String mensaje )
	{
		try// env�a un objeto al servidor
		{
			salida.writeObject("CLIENTE>>> "+ mensaje );
			salida.flush();// env�a todos los datos a la salida
			System.out.println("\nCLIENTE>>> "+ mensaje );
		}// fin de try
		catch( IOException excepcionES )
		{
			System.out.println("\nError al escribir objeto" );
		}// fin de catch
	}// fin del m�todo enviarDatos
}
