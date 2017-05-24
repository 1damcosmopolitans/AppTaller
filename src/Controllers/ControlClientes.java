package Controllers;

import java.util.ArrayList;

import Models.Cliente;


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
	
	public static void Editar(String dni, String nombre, String apellido1,
			String apellido2, String direccion, String email, String telefono, String comentarios){
		
		if(!Buscar(dni)) throw new RuntimeException("No se encontro ningún cliente con ese dni.");
		
		listaClientes.remove(Obtener(dni));
		
		Aniadir(dni, nombre, apellido1, apellido2, direccion, email, telefono, comentarios);
	}

}
