package Controllers;

import java.util.ArrayList;

import Models.Vehiculo;

public class ControlVehiculos {

	private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	
	public static boolean Buscar(String matricula){
		Vehiculo vel = Obtener(matricula);
		
		if(vel == null){
			return false;
		}else{
			return true;
		}
	}
	
	public static void Aniadir(String marca, String modelo, String dnipropietario,
			String tipo, String color, String matricula){
		if(Buscar(matricula)) throw new RuntimeException("No se puede a�adir el vehiculo porque ya hay uno con la misma matricula");
		
		listaVehiculos.add(new Vehiculo(marca, modelo, dnipropietario, tipo, color, matricula));
	}	
	public static Vehiculo Obtener(String matricula){
		Vehiculo vel = null;
		
		for(Vehiculo i: listaVehiculos){
			if(i.getMatricula().equals(matricula)){
				vel = i;
			}
		}
		
		return vel;
	}
	
	//IMPORTANTE RESPETAR EL ORDEN DE LAS INSTRUCCIONES YA QUE SI ELIMINAS DE LA LISTA ANTES DE EJECUTAR LA FUNCION ANIADIR
	//EN EL CASO DE QUE UN USUARIO INTENTE MODIFICAR UNA MATRICULA POR OTRA NUEVA YA EXISTENTE DENTRO DE LA LISTA PERDER�A
	//EL VEHICULO ACTUAL Y HABR�A DOS VEHICULOS CON LA MISMA MATRICULA.
	
	public static void Editar(String marca, String modelo, String dnipropietario,
			String tipo, String color, String matricula, String matriculanueva){
		
		if(!Buscar(matricula)) throw new RuntimeException("No se encontro el vehiculo a editar");
		
		if(matricula.equals(matriculanueva)){
			Obtener(matricula).setMarca(marca);
			Obtener(matricula).setDnipropietario(dnipropietario);
			Obtener(matricula).setColor(color);
			Obtener(matricula).setTipo(tipo);
			Obtener(matricula).setModelo(modelo);
		}else{
			if(Buscar(matriculanueva)) throw new RuntimeException("La nueva matricula ya pertenece a un vehiculo existente");
			listaVehiculos.remove(Obtener(matricula));
			Aniadir(marca, modelo, dnipropietario, tipo, color, matriculanueva);
		}
	}
	
	/**
	 * Nos devuelve el tipo de vehiculo como un string
	 */
	
	public static String BuscarTipoVeh(String matricula){
	
	Vehiculo veh = Obtener(matricula);
	
		Vehiculo vel = null;
		String tipo = "";
		
		for(Vehiculo i: listaVehiculos){
			if(i.getMatricula().equals(matricula)){
				vel = i;
				tipo = vel.getTipo();
			}
		}
		
		return tipo;
}
	
	
	
	
	
}
