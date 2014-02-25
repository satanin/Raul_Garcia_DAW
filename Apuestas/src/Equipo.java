import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Equipo implements Serializable{
private String nombreEquipo;
private int golesFavor;
private int golesEnContra;
private int partidosGanados;
private int partidosPerdidos;

	public Equipo(String miEquipo, int misGolesFavor, int misGolesEnContra, int misPartidosGanados, int misPartidosPerdidos) {
		
		nombreEquipo = miEquipo;
		golesFavor = misGolesFavor;
		golesEnContra = misGolesEnContra;
		partidosGanados = misPartidosGanados;
		partidosPerdidos = misPartidosPerdidos;
		
	}

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
