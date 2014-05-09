import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;


public class Liga {
	private String nombreLiga;
	private int numEquipos;
	private Equipo equipoLiga;
	private ArrayList<Equipo> misEquiposLiga;
	private ResultSet misResultadosLiga, misResultadosEquipo;
	private Data misDatos = new Data();
	private int idLiga;

	public Liga(String nombreLiga, int numEquipos, int idLiga) {
		this.idLiga = idLiga;
		this.nombreLiga = nombreLiga;
		this.numEquipos = numEquipos;
		misEquiposLiga = misDatos.leerEquipos(idLiga);
	}
	
	public Liga(){
		nombreLiga = null;
		numEquipos = 0;
		misEquiposLiga = new ArrayList<Equipo>();
	}

	@Override
	public String toString() {
		return nombreLiga;
	}
	
	public int getIdLiga(){
		
		return idLiga;
	}
	
	public ArrayList<Equipo> getEquiposLiga(){
		return misEquiposLiga;
	}
	
	public void addEquipo(Equipo miEquipo){
		
		misEquiposLiga.add(miEquipo);
		misDatos.guardarEquipo(miEquipo);
	}
	
	public void rmEquipo(int indice, Equipo miEquipo){
		misEquiposLiga.remove(indice);
		misDatos.rmEquipo(miEquipo);
		System.out.println(miEquipo.getIdEquipo());
	}
	
	public void setNombreLiga(String nombreLiga){
		this.nombreLiga = nombreLiga;
	}
	
	public void setNumEquipos(int numEquipos){
		this.numEquipos = numEquipos;
	}
	
	public String getNombreLiga(){
		return nombreLiga;		
	}
	
	public int getNumEquipos(){
		return numEquipos;
	}
	
	public void guardarLiga(Liga miLiga, JComboBox<Liga> comboLigas){
		misDatos.guardarLiga(miLiga,comboLigas);
	}
	
}
