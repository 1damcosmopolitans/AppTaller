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
		if(Buscar(matricula)) throw new RuntimeException("No se puede añadir el vehiculo porque ya hay uno con la misma matricula");
		
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
	
	public static void Editar(String marca, String modelo, String dnipropietario,
			String tipo, String color, String matricula){
		
		if(!Buscar(matricula)) throw new RuntimeException("No se encontro ningún vehiculo con esa matricula.");
		
		listaVehiculos.remove(Obtener(matricula));
		
		Aniadir(marca, modelo, dnipropietario, tipo, color, matricula);
	}
}
