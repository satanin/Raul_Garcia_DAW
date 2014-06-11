import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/*En esta clase aparecen todas las conexiones necesarias por parte del juego con la BBDD
 * En ella, podremos lleer las preguntas, guardar las puntuaciones, hacer el login
 * y mostrar en un Jtable las mejores puntuaciones del juego.
 */

public class ConexionBBDD {
	
	private Connection conexion = null;
	private Statement instruccion = null;
	private ResultSet manejarResultados = null;
	private Pregunta questions;
	private String miUser;
	private boolean conectado = false;

//conectar en local desde Florida "jdbc:mysql://localhost/trivial","root","tonphp"

	// conectamos con la BBDD en el constructor
	public ConexionBBDD() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/trivial", "trivial","z62cbY9LcsLY4vQj");
			System.out.println("Base de datos conectada");
			//conexion = DriverManager.getConnection("jdbc:mysql://localhost/trivial","root","");
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}	
	}
	
	//Metodo que va a leer las preguntas de la BBDD y que pasamos en un array para después usarlo comodamente
	public void leerPreguntas(ArrayList<Pregunta> misPreguntas){
		try{
			instruccion = (Statement) conexion.createStatement();
			manejarResultados = instruccion.executeQuery ("SELECT * FROM preguntas");
			while (manejarResultados.next()){
				System.out.println("Leyendo preguntas de la Base de datos");
			    questions = new Pregunta(null, null, null, null, 0, 0);
			     //Rellenamos pregunta y respuestas
			    questions.setPregunta(manejarResultados.getString("pregunta"));
			   // System.out.println(manejarResultados.getString("pregunta"));
			    questions.setRespuesta1(manejarResultados.getString("respuesta1"));
			    questions.setRespuesta2(manejarResultados.getString("respuesta2"));
			    questions.setRespuesta3(manejarResultados.getString("respuesta3"));
			    questions.setRespuestaValida(manejarResultados.getInt("respuestaValida"));
			    questions.setIdPregunta(manejarResultados.getInt("idPregunta"));
			    misPreguntas.add(questions);
			    //System.out.println("Obtenidas : "+misPreguntas.size()+" Preguntas y Respuestas");
			}
			preguntasAleatorias(misPreguntas);
			
		} catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"Error sql no se pueden leer datos");
		  }
	}
	
	//Metodo para hacer el login en el juego
	public boolean getLogin(String user, String password){

		miUser = user;
		try{
			instruccion = (Statement) conexion.createStatement();
			//System.out.println(("SELECT * FROM users WHERE `username`='"+user+"' AND `password`="+password));
			manejarResultados = instruccion.executeQuery ("SELECT * FROM users WHERE `username`='"+miUser+"' AND `password`='"+password+"'");
			//System.out.println("Leyendo usuario de la base de datos");
			manejarResultados.last();
			//If para conocer si nuestro usuario y contraseña se corresponde con el de la BBDD
			if (manejarResultados.getRow()>0)
				conectado = true;
			else
				conectado=false;		
			
		} catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"No se ha podido autenticar al usuario");
			 return conectado;
		  }
		
		return conectado;
	}
	
	//Metodo para sacar las mejores puntuaciones del juego
	public void getScores(DefaultTableModel topScores){
		try{
			instruccion = (Statement) conexion.createStatement();
			//System.out.println(("SELECT * FROM puntuaciones"));
			manejarResultados = instruccion.executeQuery ("SELECT usuario,puntos FROM puntuaciones ORDER BY puntos DESC");
			//System.out.println("Leyendo usuario de la base de datos");
			Object rankings[] = new Object[3]; //Numero de columnas de la tabla
			int j=0;
			int pos=1;
			while(manejarResultados.next()){
				rankings[j]=pos;
				//bucle for para que en la primera columna nos muestre el orden numerado de los jugadores
				for(int i=1;i<3;i++){
					rankings[i]=manejarResultados.getObject(i);
					}
				
				topScores.addRow(rankings);
				pos++;
				System.out.println(j);
			}	
		} catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"No se ha podido autenticar al usuario");
		  }		
	}
	
	//Metodo para guardar en la BBDD las puntuaciones que van haciendo los jugadores una vez concluyen la partida
	public void guardarPuntos(String usuario, String puntos){
		try{
			instruccion = (Statement) conexion.createStatement();
			//System.out.println("INSERT INTO `puntuaciones` (`usuario`, `puntos`) VALUES ('"+usuario+"','"+puntos+"')");		
			String consulta = "INSERT INTO `puntuaciones` (`usuario`, `puntos`)";
			consulta = consulta + "VALUES ('"+usuario+"','"+puntos+"')";
			instruccion.executeUpdate(consulta);
				
		} catch(SQLException e){
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null,("Fallo"));
		  }		
	}
	//Metodo con el que cambiamos el orden de las preguntas para que sea aleatorio
	public void preguntasAleatorias(ArrayList<Pregunta> misPreguntas){
		//System.out.println("Tengo "+misPreguntas.size()+" preguntas en misPreguntas");
		long seed = System.nanoTime();
		//System.out.println("Cambiando el orden de las preguntas...");
		Collections.shuffle(misPreguntas, new Random(seed));
	}
}
