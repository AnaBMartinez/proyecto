package clases;

public class Validar {
	
	private String solicitante;
	private String fecha_solicitada;
	private String tipo;
	private String comentario;
	private String estado;
	private String NumSol;
	private String Dni;
	
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getNumSol() {
		return NumSol;
	}
	public void setNumSol(String numSol) {
		NumSol = numSol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getFecha_solicitada() {
		return fecha_solicitada;
	}
	public void setFecha_solicitada(String fecha_solicitada) {
		this.fecha_solicitada = fecha_solicitada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Validar() {
		super();
	}

	
	
}
