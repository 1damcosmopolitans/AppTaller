package Controllers;

import java.util.ArrayList;
import java.util.Calendar;
import Models.Reparacion;
import Models.Vehiculo;


public class ControlReparaciones {

	private static ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();//SE INSERTA EN ESTA LISTA SOLO SI SE INTRODUCE LA FECHA DE ENTREGA, ES DECIR QUE SE HA PAGADO LA REPARACIÓN :)
	
	public static boolean Buscar(String idRep){
		Reparacion rep = Obtener(idRep);
		
		if(rep == null){
			return false;
		}else{
			return true;
		}
	}

	public static void Aniadir(String idRep, String matriculaRep, String fechaIni, String fechaFin,  String averia, String estadoAveria){
		if(Buscar(idRep)) throw new RuntimeException("No se puede añadir la reparación porque ya hay una con el mismo identificativo");
		
		listaReparaciones.add(new Reparacion(idRep, matriculaRep, fechaIni, fechaFin, averia, estadoAveria));
	}	
	public static Reparacion Obtener(String idRep){
		Reparacion rep = null;
		
		for(Reparacion i: listaReparaciones){
			if(i.getIdRep()== idRep){
				rep = i;
			}
		}
		
		return rep;
	}
	
	public ArrayList<Reparacion> listaReparados(String matricula){
		ArrayList<Reparacion> aux = new ArrayList<Reparacion>();
		for(Reparacion i: listaTotal(matricula)){
			if(i.getEstadoAveria().equals("Reparado")){
				aux.add(i);
			}
		}
		
		return aux;
	}
	
	public ArrayList<Reparacion> listaAverias(String matricula){
		ArrayList<Reparacion> aux = new ArrayList<Reparacion>();
		for(Reparacion i: listaTotal(matricula)){
			if(!i.getEstadoAveria().equals("Reparado")){
				aux.add(i);
			}
		}
		
		return aux;
	}
	
	public ArrayList<Reparacion> listaTotal(String matricula){
		ArrayList<Reparacion> aux = new ArrayList<Reparacion>();
		for(Reparacion i: listaReparaciones){
			if(i.getMatriculaRep().equals(matricula)){
				aux.add(i);
			}
		}
		
		return aux;
	}
	
	//IMPORTANTE RESPETAR EL ORDEN DE LAS INSTRUCCIONES YA QUE SI ELIMINAS DE LA LISTA ANTES DE EJECUTAR LA FUNCION ANIADIR
	//EN EL CASO DE QUE UN USUARIO INTENTE MODIFICAR UNA ID DE UNA REPARACIÓN POR OTRA NUEVA YA EXISTENTE DENTRO DE LA LISTA
	//SE BORRARÍA LA ANTERIOR Y SE SUSTITUIRÍA POR LS NUEVA
	
	public static void Editar(String idRep, String matriculaRep, String fechaIni, String fechaFin, String averia, String estadoAveria){
		
		if(!Buscar(idRep)) throw new RuntimeException("No se encontro la reparación a editar");
		Aniadir(idRep, matriculaRep, fechaIni, fechaFin, averia, estadoAveria);
		listaReparaciones.remove(Obtener(idRep));
	}
	
	/*
	 * 2 CASO : SE INGRESA LA FECHA DE SALIDA Y SE ALMACENA LA FICHA DE REPARACION EN LA SEGUNDA LISTA --LAS REPARACIONES PAGADAS
	 */
	
}
