package model;

public class Candidato {

	private int id;
	private String documento;
	private String apellido;
	private int numero;
	
	
	public Candidato () {
		
	}
	
	public Candidato (int id, String documento, String apellido, int numero) {
		
		this.id=id;
		this.documento=documento;
		this.apellido=apellido;
		this.numero=numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
