import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ConexionBBDD {
	
	private Connection conexion = null;
	private Statement instruccion = null;
	private ResultSet manejarResultados = null;
	private Pregunta questions;

//conectar en local desde Florida "jdbc:mysql://localhost/trivial","root","tonphp"


	public ConexionBBDD() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// conectamos con la BBDD

			//conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/trivial", "trivial","z62cbY9LcsLY4vQj");
			System.out.println("Base de datos conectada");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/trivial","root","");
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}	
	}
	
	public void leerPreguntas(ArrayList<Pregunta> misPreguntas){
		try{
			instruccion = (Statement) conexion.createStatement();
			manejarResultados = instruccion.executeQuery ("SELECT * FROM preguntas");
			while (manejarResultados.next()){
				System.out.println("Leyendo preguntas de la Base de datos");
			    questions = new Pregunta(null, null, null, null, 0, 0);
			     //Rellenamos pregunta y respuestas
			    questions.setPregunta(manejarResultados.getString("pregunta"));
			    System.out.println(manejarResultados.getString("pregunta"));
			    questions.setRespuesta1(manejarResultados.getString("respuesta1"));
			    questions.setRespuesta2(manejarResultados.getString("respuesta2"));
			    questions.setRespuesta3(manejarResultados.getString("respuesta3"));
			    questions.setRespuestaValida(manejarResultados.getInt("respuestaValida"));
			    questions.setIdPregunta(manejarResultados.getInt("idPregunta"));
			    misPreguntas.add(questions);
			    System.out.println("Obtenidas : "+misPreguntas.size()+" Preguntas y Respuestas");

			}
		} catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"Error sql no se pueden leer datos");
		  }
	}
	
	public boolean getLogin(String user, String password){
		boolean conectado = false;
		try{
			instruccion = (Statement) conexion.createStatement();
			System.out.println(("SELECT * FROM users WHERE `username`='"+user+"' AND `password`="+password));
			manejarResultados = instruccion.executeQuery ("SELECT * FROM users WHERE `username`='"+user+"' AND `password`='"+password+"'");
			System.out.println("Leyendo usuario de la base de datos");
			manejarResultados.last();
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
	
	public void getScores(DefaultTableModel topScores){
		try{
			instruccion = (Statement) conexion.createStatement();
			System.out.println(("SELECT * FROM puntuaciones"));
			manejarResultados = instruccion.executeQuery ("SELECT usuario,puntos FROM puntuaciones ORDER BY puntos DESC");
			System.out.println("Leyendo usuario de la base de datos");
			Object rankings[] = new Object[3];
			int j=0;
			int pos=1;
			while(manejarResultados.next()){
				rankings[j]=pos;
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
	
	public void guardarPuntos(String usuario, String puntos){
		try{
			instruccion = (Statement) conexion.createStatement();
			System.out.println("INSERT INTO `puntuaciones` (`usuario`, `puntos`) VALUES ('"+usuario+"','"+puntos+"')");
			
			String consulta = "INSERT INTO `puntuaciones` (`usuario`, `puntos`)";
			consulta = consulta + "VALUES ('"+usuario+"','"+puntos+"')";
			instruccion.executeUpdate(consulta);
				
			
		} catch(SQLException e){
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null,("Fallo"));
		  }		
	}
	
}
