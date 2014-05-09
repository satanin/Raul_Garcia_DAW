import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.mysql.jdbc.Statement;


public class Data {
	private Statement instruccion = null;
	public Connection conexion = null; // Conexión a la base de datos
	private ResultSet misResultadosLiga = null;
	private ResultSet misResultadosEquipo = null;
	private ArrayList<Liga> misLigas = new ArrayList<Liga>();
	private ArrayList<Equipo> misEquipos = new ArrayList<Equipo>();

	public Data() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://satanin.myftp.org/apuestas","apuestas","z62cbY9LcsLY4vQj");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
	public ArrayList<Liga> leerLigas() {
		misLigas.removeAll(misLigas);
		System.out.println("Leyendo Ligas");
		try{
			instruccion = (Statement) conexion.createStatement();
			misResultadosLiga = instruccion.executeQuery("SELECT * FROM ligas");
			while(misResultadosLiga.next()){
				Liga nuevaLiga = new Liga (misResultadosLiga.getString("nombre"),misResultadosLiga.getInt("numEquipos"), misResultadosLiga.getInt("idLiga"));
				misLigas.add(nuevaLiga);
				System.out.println("Liga Añadida: "+nuevaLiga);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return misLigas;
	}
	
	public ArrayList<Equipo> leerEquipos(int idLiga){
		misEquipos.removeAll(misEquipos);
		System.out.println("Añadiendo Equipos");
		try{
			instruccion = (Statement) conexion.createStatement();
			misResultadosEquipo = instruccion.executeQuery("SELECT * FROM equipos WHERE `idLiga`="+idLiga);
			while(misResultadosEquipo.next()){
				Equipo nuevoEquipo = new Equipo (misResultadosEquipo.getString("nombreEquipo"), misResultadosEquipo.getInt("golesFavor"), misResultadosEquipo.getInt("golesEnContra"),
						misResultadosEquipo.getInt("partidosGanados"), misResultadosEquipo.getInt("partidosPerdidos"), misResultadosEquipo.getInt("idEquipo"));
				misEquipos.add(nuevoEquipo);
				System.out.println("Añadido Equipo:" +nuevoEquipo);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return misEquipos;
	}
	
	public void guardarEquipo(Equipo equipoModificado){
		System.out.println(equipoModificado.getIdEquipo());
		if(equipoModificado.getIdEquipo()>0){
			try{
				instruccion = (Statement) conexion.createStatement();
				instruccion.executeUpdate("UPDATE `equipos` SET `nombreEquipo`=\""+equipoModificado.toString()+"\", `golesFavor`="+equipoModificado.getGolesFavor()+
						", `golesEnContra`="+equipoModificado.getGolesEnContra()+", `partidosGanados`="+equipoModificado.getPartidosGanados()+", `partidosPerdidos`="+equipoModificado.getPartidosPerdidos()+" WHERE `idEquipo`="+equipoModificado.getIdEquipo());
				System.out.println("Equipo Guardado");
			}catch (SQLException e){
				e.printStackTrace();
			}
		}else{
			try{
				instruccion = (Statement) conexion.createStatement();
				String sql_Strng="INSERT INTO  `apuestas`.`equipos` (`idEquipo` ,`idLiga` ,`nombreEquipo` ,`golesFavor` ,`golesEnContra` ,`partidosGanados` ,`partidosPerdidos`)";
				sql_Strng = sql_Strng+"VALUES ('"+equipoModificado.getIdEquipo()+"',  '"+equipoModificado.getIdLiga()+"',  '"+equipoModificado.toString()+"',  '"+equipoModificado.getGolesFavor()+"',  '"+equipoModificado.getGolesEnContra()+"', '"+equipoModificado.getPartidosGanados()+"', '"+equipoModificado.getPartidosPerdidos()+"');";
				System.out.println(sql_Strng);
				instruccion.executeUpdate(sql_Strng);
			}catch (SQLException e){
				e.printStackTrace();
			}
		
		}
	}
	
	public void rmEquipo(Equipo miEquipo){
		try{
			
			instruccion = (Statement) conexion.createStatement();
			String sql_Strng = "DELETE FROM `apuestas`.`equipos` WHERE `equipos`.`idEquipo` ="+miEquipo.getIdEquipo();
			System.out.println(sql_Strng);
			instruccion.executeUpdate(sql_Strng);
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void guardarLiga(Liga miLiga,JComboBox<Liga> comboLigas){
		if(miLiga.getIdLiga()>0){
			try{
				instruccion = (Statement) conexion.createStatement();
				String sql_Strng = "UPDATE `ligas` SET `nombre`=\""+miLiga.toString()+"\", `numEquipos`="+miLiga.getNumEquipos()+" WHERE `idLiga`="+miLiga.getIdLiga();
				instruccion.executeUpdate(sql_Strng);
				System.out.println(sql_Strng);
				instruccion.executeUpdate(sql_Strng);
				
			}catch (SQLException e){
				e.printStackTrace();
			}
		}else{
			try{
				instruccion = (Statement) conexion.createStatement();
				String sql_Strng="INSERT INTO  `apuestas`.`ligas` (`nombre` ,`numEquipos`)";
				sql_Strng = sql_Strng+"VALUES ('"+miLiga.getNombreLiga()+"',  '"+miLiga.getNumEquipos()+"');";
				System.out.println(sql_Strng);
				instruccion.executeUpdate(sql_Strng);
				comboLigas.addItem(miLiga);
			}catch (SQLException e){
				e.printStackTrace();
			}
			
		}
	}

}
