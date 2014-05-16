
public class Pregunta {
	
	private String Pregunta;
	private String Respuesta1;
	private String Respuesta2;
	private String Respuesta3;
	private String RespuestaValida;

	public Pregunta(String Pregunta, String Respuesta1, String Respuesta2, String Respuesta3, String RespuestaValida) {
		this.Pregunta=Pregunta;
		this.Respuesta1=Respuesta1;
		this.Respuesta2=Respuesta2;
		this.Respuesta3=Respuesta3;
		this.RespuestaValida=RespuestaValida;
	}
	

	public String getPregunta() {
		return Pregunta;
	}

	public void setPregunta(String pregunta) {
		Pregunta = pregunta;
	}

	public String getRespuesta1() {
		return Respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		Respuesta1 = respuesta1;
	}

	public String getRespuesta2() {
		return Respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		Respuesta2 = respuesta2;
	}

	public String getRespuesta3() {
		return Respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		Respuesta3 = respuesta3;
	}

	public String getRespuestaValida() {
		return RespuestaValida;
	}

	public void setRespuestaValida(String respuestaValida) {
		RespuestaValida = respuestaValida;
	}
	
	

}
