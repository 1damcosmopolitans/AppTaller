package Controllers;

import java.util.ArrayList;
import java.util.Calendar;
import Models.Reparacion;


public class ControlReparaciones {

	private static ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
	
	public static boolean Buscar(String idRep){
		Reparacion rep = Obtener(idRep);
		
		if(rep == null){
			return false;
		}else{
			return true;
		}
	}
	//	public Reparacion(int idRep, String matriculaRep, Calendar fechaIni, Calendar fechaFin, int idFactura,
	//String averia, byte estado)
	
	public static void Aniadir(String idRep, String matriculaRep, Calendar fechaIni, Calendar fechaFin, int idFactura, String averia, byte estado){
		if(Buscar(idRep)) throw new RuntimeException("No se puede añadir la reparación porque ya hay una con el mismo identificativo");
		
		listaReparaciones.add(new Reparacion(idRep, matriculaRep, fechaIni, fechaFin, idFactura, averia, estado));
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
	
	//IMPORTANTE RESPETAR EL ORDEN DE LAS INSTRUCCIONES YA QUE SI ELIMINAS DE LA LISTA ANTES DE EJECUTAR LA FUNCION ANIADIR
	//EN EL CASO DE QUE UN USUARIO INTENTE MODIFICAR UNA ID DE UNA REPARACIÓN POR OTRA NUEVA YA EXISTENTE DENTRO DE LA LISTA
	//SE BORRARÍA LA ANTERIOR Y SE SUSTITUIRÍA POR LS NUEVA
	
	public static void Editar(String idRep, String matriculaRep, Calendar fechaIni, Calendar fechaFin, int idFactura, String averia, byte estado){
		
		if(!Buscar(idRep)) throw new RuntimeException("No se encontro la reparación a editar");
		Aniadir(idRep, matriculaRep, fechaIni, fechaFin, idFactura, averia, estado);
		listaReparaciones.remove(Obtener(idRep));
	}
}
