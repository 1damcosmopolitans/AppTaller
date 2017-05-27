package Models;

public class Vehiculo {

	private String marca;
	private String modelo;
	private String dnipropietario;
	private String tipo;
	private String color;
	private String matricula;
	private String idReparacion;
	
	public Vehiculo(String marca, String modelo, String dnipropietario,
			String tipo, String color, String matricula, String idReparacion) {
		super();
		setMarca(marca);
		setModelo(modelo);
		setDnipropietario(dnipropietario);
		setTipo(tipo);
		setColor(color);
		setMatricula(matricula);
		setIdReparacion(idReparacion);
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getDnipropietario() {
		return dnipropietario;
	}

	public String getTipo() {
		return tipo;
	}

	public String getColor() {
		return color;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setDnipropietario(String dnipropietario) {
		this.dnipropietario = dnipropietario;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setMatricula(String matricula) {
		if(matricula.equals("") || matricula == null) throw new RuntimeException("La matricula no puede estar vacía");
		
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public String getIdReparacion(){
		return idReparacion;
	}
	
	public void setIdReparacion(String idReparacion){
		this.idReparacion = idReparacion;
	}
	
	
}
