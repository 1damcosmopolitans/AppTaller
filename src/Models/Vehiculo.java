package Models;

public class Vehiculo {

	private String marca;
	private String modelo;
	private String dnipropietario;
	private String tipo;
	private String color;
	private String matricula;
	
	public Vehiculo(String marca, String modelo, String dnipropietario,
			String tipo, String color, String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.dnipropietario = dnipropietario;
		this.tipo = tipo;
		this.color = color;
		this.matricula = matricula;
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

	public String getMatricula() {
		return matricula;
	}
	
	
}
