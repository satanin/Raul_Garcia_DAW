import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Liga {
	private int numEquipos;
	private String nombreLiga;
	private ArrayList<Equipo> miLiga = new ArrayList<Equipo>();
	private Equipo miEquipo;
	private ResultSet miResultSetLiga;
	private ResultSet miResultSetEquipo;
	private Conectar conexion;
	private int indiceLiga;
	// constructor de Liga sin parámetros, para crear por defecto, la liga española. 
	public Liga(int indiceLiga, Conectar conexion) {
		this.indiceLiga = indiceLiga;
		this.conexion = conexion;
		miResultSetLiga = this.conexion.leerLiga(indiceLiga);
		miResultSetEquipo = this.conexion.leerEquipos(indiceLiga);
		
		try {
			// Establecemos el nombre
			miResultSetLiga.first();
			this.nombreLiga = miResultSetLiga.getString("Nombre");
			// Establecemos número de equipos.
			this.numEquipos = miResultSetLiga.getInt("numEquipos");
			System.out.println("Rellenando Equipos de Liga");
			
			while(miResultSetEquipo.next()){
				miEquipo = new Equipo(miResultSetEquipo.getString("nombreEquipo"),miResultSetEquipo.getInt("golesFavor"),miResultSetEquipo.getInt("golesEnContra"),miResultSetEquipo.getInt("partidosGanados"),miResultSetEquipo.getInt("partidosPerdidos"));
				// Ahora vamos a rellenar el ArrayList liga con objetos equipo, para que ya se pueda trabajar con ellos.
				miLiga.add(miEquipo);			
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}

			

			
	}		
	
	// Creo un tercer constructor al que le puedes pasar por parámetros el nombre de la liga y el número
	// de equipos que quieres que tenga y te la crea.
	public Liga(int idLiga, String nombreLiga, int numEquipos){
		this.numEquipos = numEquipos;
		this.nombreLiga = nombreLiga;
		for (int i=0;i<this.numEquipos;i++){
			miEquipo = new Equipo();
			miLiga.add(miEquipo);
		}	
	}
	
	public void setNombreLiga(String nombreLiga){
		this.nombreLiga = nombreLiga;
		conexion.setNombreLiga(this.indiceLiga, this.nombreLiga);
	}

	public String getnombreLiga(){
		return nombreLiga;
	}
	
	public Equipo getEquipo(int numEquipo){
		
		return miLiga.get(numEquipo);
	}
	
	public void setNumEquipos(int numEquipos){
		conexion.setNumeroEquipos(this.indiceLiga,numEquipos);
	}
	public int getNumEquipos(){
		return miLiga.size();
	}
	
	public Equipo addEquipo(){
		miEquipo = new Equipo();
		miLiga.add(miEquipo);
		return miEquipo;
	}
	
	public void removeEquipo(Equipo equipoAEliminar){
		miLiga.remove(equipoAEliminar);
	}

	@Override
	public String toString() {
		return nombreLiga;
	}
	
	
	
}
