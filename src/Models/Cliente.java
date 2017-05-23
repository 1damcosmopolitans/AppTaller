package Models;

public class Cliente {
	
	private String dniCliente;
	private String nombreCli;
	private String apellido1Cli;
	private String apellido2Cli;
	private String direccion;
	private String email;
	private int telefonoCli;
	private String comentarios;
	
	@Override
	public String toString() {
		return "Cliente [dniCliente=" + dniCliente + ", nombreCli=" + nombreCli + ", apellido1Cli=" + apellido1Cli
				+ ", apellido2Cli=" + apellido2Cli + ", direccion=" + direccion + ", email=" + email + ", telefonoCli="
				+ telefonoCli + ", comentarios=" + comentarios + "]";
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombreCli() {
		return nombreCli;
	}

	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	public String getApellido1Cli() {
		return apellido1Cli;
	}

	public void setApellido1Cli(String apellido1Cli) {
		this.apellido1Cli = apellido1Cli;
	}

	public String getApellido2Cli() {
		return apellido2Cli;
	}

	public void setApellido2Cli(String apellido2Cli) {
		this.apellido2Cli = apellido2Cli;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefonoCli() {
		return telefonoCli;
	}

	public void setTelefonoCli(int telefonoCli) {
		this.telefonoCli = telefonoCli;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
	

}
