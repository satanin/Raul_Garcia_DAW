import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Equipo implements Serializable{
	//declaro todas las variables que voy a necesitar
	private String nombreEquipo;
	private int golesFavor;
	private int golesEnContra;
	private int partidosGanados;
	private int partidosPerdidos;
	private String escudoEquipo;
	

	// constructor, le paso diferentes argumentos.
	public Equipo(String miEquipo, int misGolesFavor, int misGolesEnContra, int misPartidosGanados, int misPartidosPerdidos) {
		
		nombreEquipo = miEquipo;
		golesFavor = misGolesFavor;
		golesEnContra = misGolesEnContra;
		partidosGanados = misPartidosGanados;
		partidosPerdidos = misPartidosPerdidos;
		escudoEquipo = nombreEquipo;
		
	}
	
	public Equipo() {
		
		nombreEquipo = "";
		golesFavor = 0;
		golesEnContra = 0;
		partidosGanados = 0;
		partidosPerdidos = 0;
		
	}
	
	public Equipo(String nombreEquipo) {
		
		this.nombreEquipo = nombreEquipo;
		golesFavor = 0;
		golesEnContra = 0;
		partidosGanados = 0;
		partidosPerdidos = 0;
		
	}
	// Getters y Setters, los he generado automáticamente con eclipse.
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getGolesFavor() {
		return golesFavor;
	}

	public void setGolesFavor(int golesFavor) {
		this.golesFavor = golesFavor;
	}

	public int getGolesEnContra() {
		return golesEnContra;
	}

	public void setGolesEnContra(int golesEnContra) {
		this.golesEnContra = golesEnContra;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}


}
