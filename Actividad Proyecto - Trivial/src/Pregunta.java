
public class Pregunta {
	
	private String pregunta;
	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	private int respuestaValida;
	private int idPregunta;

	public Pregunta(String pregunta, String respuesta1, String respuesta2, String respuesta3, int respuestaValida, int idPregunta) {
		this.pregunta=pregunta;
		this.respuesta1=respuesta1;
		this.respuesta2=respuesta2;
		this.respuesta3=respuesta3;
		this.respuestaValida=respuestaValida;
		this.idPregunta=idPregunta;
	}
	
	public int getIdPregunta(){
		return idPregunta;
	}
	
	public void setIdPregunta(){
		idPregunta=idPregunta;
	}
	

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		pregunta = pregunta;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		respuesta1 = respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		respuesta2 = respuesta2;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		respuesta3 = respuesta3;
	}

	public int getRespuestaValida() {
		return respuestaValida;
	}

	public void setRespuestaValida(int respuestaValida) {
		respuestaValida = respuestaValida;
	}
	
	

}
