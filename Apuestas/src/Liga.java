
public class Liga {
	private int numEquipos;
	private String nombreLiga;
	private Equipo[] miLiga;
	private String[] equiposEspana = {"Barcelona", "Atlético","Real Madrid", "Villareal", "Athletic","Valencia","Espanyol","Getafe","Levante","Málaga","Betis","Granada","R.Sociedad","Sevilla","Celta","Valladolid","Elche","Almería","Osasuna","Rayo"};

	public Liga() {
		this.nombreLiga = "Liga Española";
		this.numEquipos = 20;
		miLiga = new Equipo[this.numEquipos];
		System.out.println("Rellenando Equipos de Liga");
		// Ahora vamos a rellenar el array ligas con objetos equipo, para que ya se pueda trabajar con ellos.
		for (int i=0;i<numEquipos;i++){			
			System.out.println("Anadiendo al "+equiposEspana[i]+" a la liga Española");
			miLiga[i] = new Equipo();
			miLiga[i].setNombreEquipo(equiposEspana[i]);
		}		
	}
	// Creo un tercer constructor al que le puedes pasar por parámetros el nombre de la liga y el número
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
