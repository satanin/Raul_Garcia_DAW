import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionBBDD {
	
	private Connection conexion = null;
	private Statement instruccion = null;
	private ResultSet manejarResultados = null;


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
	
	public void leerPreguntas(){
		
	}

}
