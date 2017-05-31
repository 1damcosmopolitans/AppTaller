package Models;

public class Empleado {
	
	private String usuario;
	private String nombre  ;
	private String apellido1;
	private String apellido2;
	private String departamento;
	private int password;
	
	/**
	 * Asignacion de los campos de la UI
	 */
	
	public Empleado(String usuarioEmp, String nombre, String apellido1, String apellido2, String  departamento){
			 
		super();
		this.usuario = usuarioEmp;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.departamento = departamento;
		
	}

	public String getUsuarioEmp() {
		return usuario;
	}

	@Override
	public String toString() {
		return "Empleado [usuarioEmp=" + usuario + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", departamento=" + departamento + "]";
	}

	public void setUsuarioEmp(String usuarioEmp) {
		this.usuario = usuarioEmp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
}
