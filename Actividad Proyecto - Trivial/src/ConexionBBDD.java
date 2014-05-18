import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class ConexionBBDD {
	
	private Connection conexion = null;
	private Statement instruccion = null;
	private ResultSet manejarResultados = null;
	private Pregunta questions;


	public ConexionBBDD() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// conectamos con la BBDD
			conexion = DriverManager.getConnection("jdbc:mysql://satanin.myftp.org/trivial", "trivial","z62cbY9LcsLY4vQj");
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}	
	}
	
	public void leerPreguntaRespuestas(){
		try{
			instruccion = (Statement) conexion.createStatement();
			manejarResultados = instruccion.executeQuery ("SELECT * FROM pregutnas");
			while (manejarResultados.next()){
			    questions = new Pregunta(null, null, null, null, null, 0);
			     //Rellenamos pregunta y respuestas
			    questions.setPregunta((String)(manejarResultados.getObject("pregunta")));
			    questions.setRespuesta1((String)(manejarResultados.getObject("respuesta1")));
			    questions.setRespuesta2((String)(manejarResultados.getObject("respuesta2")));
			    questions.setRespuesta3((String)(manejarResultados.getObject("respuesta3")));
			    questions.setRespuestaValida((String)(manejarResultados.getObject("respuestaValida")));
			    questions.setIdPregunta((int)(manejarResultados.getObject("idPregunta")));
			}
		} catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"Error sql no se pueden leer datos");
		  }
	}


}
