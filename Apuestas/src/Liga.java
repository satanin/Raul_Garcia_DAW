
public class Liga {
	private int numEquipos;
	private String nombreLiga;
	private Equipo[] miLiga;
	private String[] equiposEspana = {"Barcelona", "Atl�tico","Real Madrid", "Villareal", "Athletic","Valencia","Espanyol","Getafe","Levante","M�laga","Betis","Granada","R.Sociedad","Sevilla","Celta","Valladolid","Elche","Almer�a","Osasuna","Rayo"};

	// constructor de Liga sin par�metros, para crear por defecto, la liga espa�ola. 
	public Liga() {
		// Establecemos el nombre
		this.nombreLiga = "Liga Espa�ola";
		// Establecemos n�mero de equipos.
		this.numEquipos = 20;
		// Aqu� establecemos el tama�o de la liga y reservamos ya el espacio de 20 items Equipo en el array miLiga.
		miLiga = new Equipo[this.numEquipos];
		// Aqu� un poco de texto, para saber que vamos haciendo
		System.out.println("Rellenando Equipos de Liga");
		// Ahora vamos a rellenar el array ligas con objetos equipo, para que ya se pueda trabajar con ellos.
		for (int i=0;i<numEquipos;i++){			
			// Aqu� muestro el equipo que voy a a�adir por consola
			System.out.println("Anadiendo al "+equiposEspana[i]+" a la liga Espa�ola");
			// Aqu� asigno a la posici�n i del vector miLiga un objeto Equipo.
			miLiga[i] = new Equipo();
			// Aqu� cambio el nombre del objecto miLiga[i] y le pongo el nombre del equipo.
			miLiga[i].setNombreEquipo(equiposEspana[i]);
		}		
	}
	// Creo un tercer constructor al que le puedes pasar por par�metros el nombre de la liga y el n�mero
	// de equipos que quieres que tenga y te la crea.
	public Liga(int numEquipos, String nombreLiga){
		this.numEquipos = numEquipos;
		this.nombreLiga = nombreLiga;
		miLiga = new Equipo[this.numEquipos];
		for (int i=0;i<numEquipos;i++){			
			miLiga[i] = new Equipo();
		}	
	}
	
	public void setNombreLiga(String nombreLiga){
		this.nombreLiga = nombreLiga;
	}

	public String getnombreLiga(){
		return nombreLiga;
	}
	
	public Equipo getEquipo(int numEquipo){
		
		return miLiga[numEquipo];
	}
	
	public void setNumEquipos(int numEquipos){
		
		miLiga = new Equipo[numEquipos];  
	}
	public int getNumEquipos(){
		return miLiga.length;
	}
	
}
