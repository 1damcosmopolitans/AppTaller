package Controllers;

import java.util.ArrayList;

import Models.Cliente;
import Models.Vehiculo;


public class ControlClientes {
	
private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public static boolean Buscar(String dni){
		Cliente cli = Obtener(dni);
		
		if(cli == null){
			return false;
		}else{
			return true;
		}
	}
	
	public static void Aniadir(String dni, String nombre, String apellido1,
			String apellido2, String direccion, String email, String telefono, String comentarios){
		if(Buscar(dni)) throw new RuntimeException("No se puede añadir el cliente porque ya hay uno con el mismo dni");
		
		listaClientes.add(new Cliente(dni, nombre, apellido1, apellido2, direccion, email, telefono, comentarios));
	}
	
	public static Cliente Obtener(String dni){
		Cliente cli = null;
		
		for(Cliente i: listaClientes){
			if(i.getDniCliente().equals(dni)){
				cli = i;
			}
		}
		
		return cli;
	}
	
	public static void Editar(String dni, String dninuevo, String nombre, String apellido1,
			String apellido2, String direccion, String email, String telefono, String comentarios){
		
		if(!Buscar(dni)) throw new RuntimeException("No se encontro el vehiculo a editar");

		if(dni.equals(dninuevo)){
			Obtener(dni).setApellido1Cli(apellido1);
			Obtener(dni).setApellido2Cli(apellido2);
			Obtener(dni).setComentarios(comentarios);
			Obtener(dni).setDireccion(direccion);
			Obtener(dni).setEmail(email);
			Obtener(dni).setTelefonoCli(telefono);
			Obtener(dni).setNombreCli(nombre);
		}else{
			if(Buscar(dninuevo)) throw new RuntimeException("No se puede cambiar la matricula porque la matricula nueva esta ya ocupada");
			
			listaClientes.add(new Cliente(dninuevo, nombre, apellido1, apellido2, direccion, email, telefono, comentarios));
			listaClientes.remove(Obtener(dni));
			}
	}

}
