
public class Equipo {
	private String nombreEquipo;
	private int golesFavor, golesEnContra, partidosGanados, partidosPerdidos, idEquipo, idLiga;

	public Equipo(String nombreEquipo, int golesFavor, int golesEnContra, int partidosGanados, int partidosPerdidos, int idEquipo){
		
		this.nombreEquipo = nombreEquipo;
		this.golesFavor = golesFavor;
		this.golesEnContra = golesEnContra;
		this.partidosGanados = partidosGanados;
		this.partidosPerdidos = partidosPerdidos;
		this.idEquipo = idEquipo;	
		
	}
	
	public Equipo(int idLiga){
		this.nombreEquipo = null;
		this.golesFavor = 0;
		this.golesEnContra = 0;
		this.partidosGanados = 0;
		this.partidosPerdidos = 0;
		this.idLiga = idLiga;
	}
	
	public Equipo(){
		this.nombreEquipo = null;
		this.golesFavor = 0;
		this.golesEnContra = 0;
		this.partidosGanados = 0;
		this.partidosPerdidos = 0;
	}

	@Override
	public String toString() {
		return nombreEquipo;
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
	
	public void setNombreEquipo(String nombreEquipo){
		this.nombreEquipo = nombreEquipo;
	}
	
	public void guardarEquipo(){
		
		
	}
	public int getIdEquipo(){
		return this.idEquipo;
	}
	
	public int getIdLiga(){
		return this.idLiga;
	}
}
