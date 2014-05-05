import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class Conectar {
	private Statement instruccion = null;
	public Connection conexion = null; // Conexión a la base de datos
	private ResultSet miResultSet = null;

	public Conectar() {
		// Cargamos el driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","apuestas","z62cbY9LcsLY4vQj");
			instruccion = (Statement) conexion.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	public ResultSet leerLigas(){
		
		try{
			instruccion = (Statement) conexion.createStatement();
			miResultSet = instruccion.executeQuery("SELECT idLiga, Nombre, numEquipos FROM ligas");
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return miResultSet;
		
	}
	
	public ResultSet leerLiga(int idLiga){
		
		try{
			instruccion = (Statement) conexion.createStatement();
			miResultSet = instruccion.executeQuery("SELECT Nombre,numEquipos FROM ligas WHERE idLiga="+idLiga);
		
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return miResultSet;
		
	}
	
	public ResultSet leerEquipos(int idLiga){
		try{
			instruccion = (Statement) conexion.createStatement();
			miResultSet = instruccion.executeQuery("SELECT nombreEquipo,golesFavor,golesEnContra,partidosGanados,partidosPerdidos FROM equipos WHERE idLiga="+idLiga);
		
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return miResultSet;
		
	}
	
	public void setNombreLiga(int indiceLiga, String nombreLiga){
		try{
			instruccion = (Statement) conexion.createStatement();
			instruccion.executeUpdate("UPDATE `ligas` SET `nombre`=\""+nombreLiga+"\" WHERE idLiga="+indiceLiga);
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void setNumeroEquipos(int indiceLiga, int numeroEquipos){
		try{
			instruccion = (Statement) conexion.createStatement();
			instruccion.executeUpdate("UPDATE `ligas` SET `numEquipos`=\""+numeroEquipos+"\" WHERE idLiga="+indiceLiga);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
