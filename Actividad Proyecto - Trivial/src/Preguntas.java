import java.io.Serializable;
import java.util.ArrayList;


public class Preguntas implements Serializable{
	private ArrayList<Pregunta> misPreguntasOnline;
	private String serverUser,clientUser;

	public Preguntas(ArrayList<Pregunta> preguntasOnline, String user) {
		misPreguntasOnline = preguntasOnline;
		serverUser = user;
		clientUser = "";
	}
	
	public String getServerUser(){
		return serverUser;
	}
	
	public String getClientUser(){
		return clientUser;
	}
	
	public ArrayList<Pregunta> getPreguntasOnline(){
		return misPreguntasOnline;
	}

	public String toString(){
		return "Se han leido las preguntas";
	}
	
	public void setClientUser(String clientUser){
		this.clientUser = clientUser;
	}
}
