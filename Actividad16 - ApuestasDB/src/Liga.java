import java.util.ArrayList;


public class Liga {
	private int numEquipos;
	private String nombreLiga;
	private ArrayList<Equipo> miLiga = new ArrayList<Equipo>();
	private String[] equiposEspana = {"Barcelona", "Atl�tico","Real Madrid", "Villareal", "Athletic","Valencia","Espanyol","Getafe","Levante","M�laga","Betis","Granada","R.Sociedad","Sevilla","Celta","Valladolid","Elche","Almer�a","Osasuna","Rayo"};
	private Equipo miEquipo;

	// constructor de Liga sin par�metros, para crear por defecto, la liga espa�ola. 
	public Liga() {
		// Establecemos el nombre
		this.nombreLiga = "Liga Espa�ola";
		// Establecemos n�mero de equipos.
		this.numEquipos = 20;
		// Aqu� establecemos el tama�o de la liga y reservamos ya el espacio de 20 items Equipo en el ArrayList miLiga.
		// miLiga = new Equipo[this.numEquipos];
		// Aqu� un poco de texto, para saber que vamos haciendo
		System.out.println("Rellenando Equipos de Liga");
		// Ahora vamos a rellenar el ArrayList liga con objetos equipo, para que ya se pueda trabajar con ellos.
		for (int i=0;i<this.numEquipos;i++){			
			// Aqu� muestro el equipo que voy a a�adir por consola
			System.out.println("Anadiendo al "+equiposEspana[i]+" a la liga Espa�ola");
			// Aqu� asigno a la posici�n i del vector miLiga un objeto Equipo.
			miEquipo = new Equipo(equiposEspana[i]);
			miLiga.add(miEquipo);
			// Aqu� cambio el nombre del objecto miLiga[i] y le pongo el nombre del equipo.
			
		}		
	}
	// Creo un tercer constructor al que le puedes pasar por par�metros el nombre de la liga y el n�mero
	// de equipos que quieres que tenga y te la crea.
	public Liga(int numEquipos, String nombreLiga){
		this.numEquipos = numEquipos;
		this.nombreLiga = nombreLiga;
		for (int i=0;i<this.numEquipos;i++){
			miEquipo = new Equipo();
			miLiga.add(miEquipo);
		}	
	}
	
	public void setNombreLiga(String nombreLiga){
		this.nombreLiga = nombreLiga;
	}

	public String getnombreLiga(){
		return nombreLiga;
	}
	
	public Equipo getEquipo(int numEquipo){
		
		return miLiga.get(numEquipo);
	}
	
	public void setNumEquipos(int numEquipos){
		
		for (int i=0;i<numEquipos;i++){
			miEquipo = new Equipo();
			miLiga.add(miEquipo);
		}
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
	
}
