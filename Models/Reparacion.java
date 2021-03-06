package Models;

import java.util.regex.Pattern;
	public class Reparacion {
		
		private String idRep;
		private String matriculaRep;
		private String fechaIni;
		private String fechaFin;
		private String averia;
		private String estadoAveria;
		private String estadoPago;
		private String comentario;
		private int tiempoRep;
		private float precioTotal;
		private final String FormatoFecha = "([12][0-9]|3[01]|0?[1-9])/(0?[1-9]|1[012])/((?:19|20)\\d\\d)";
		
		
		
		public Reparacion(String idRep, String matriculaRep, String fechaIni, String fechaFin, 
				String estadoPago, String estadoAveria, String comentario, int tiempoRep, float precioTotal) {
			super();
			setIdRep(idRep);
			setMatriculaRep(matriculaRep);
			setAveria(estadoAveria);
			setComentario(comentario);
			setEstadoAveria(estadoAveria);
			setEstadoPago(estadoPago);
			setFechaFin(fechaFin);
			setFechaIni(fechaIni);
			tiempoRep = 0;
			precioTotal = 0;
		}
		
		@Override
		public String toString() {
			return "Reparacion [idRep=" + idRep + ", matriculaRep=" + matriculaRep + ", fechaIni=" + fechaIni
					+ ", fechaFin=" + fechaFin + ", averia=" + averia + ", estadoAveria="
					+ estadoAveria + "]";
		}

		public String getIdRep() {
			return idRep;
		}
		
		public String getComentario(){
			return comentario;
		}
		public void setIdRep(String idRep) {
			if(idRep.equals("") || idRep == null) throw new RuntimeException("El id no puede estar vac�o.");
			this.idRep = idRep;
		}
		public String getMatriculaRep() {
			return matriculaRep;
		}
		public void setMatriculaRep(String matriculaRep) {
			this.matriculaRep = matriculaRep;
		}
		public String getFechaIni() {
			return fechaIni;
		}
		public void setFechaIni(String fechaIni) {
			if(!Pattern.matches(FormatoFecha, fechaIni)) throw new RuntimeException("Fecha de inicio incorrecta (DD/MM/AAAA).");

			this.fechaIni = fechaIni;
		}
		public String getFechaFin() {
			return fechaFin;
		}
		
		public void setComentario(String comentario){
			this.comentario= comentario;
		}
		public void setFechaFin(String fechaFin) {
			if(!(fechaFin.equals("") || fechaFin == null))
				if(!Pattern.matches(FormatoFecha, fechaFin)) throw new RuntimeException("Fecha final incorrecta (DD/MM/AAAA)");
			this.fechaFin = fechaFin;
		}
	
		public String getAveria() {
			return averia;
		}
		public void setAveria(String averia) {
			this.averia = averia;
		}
		
		public String getEstadoAveria(){
			return estadoAveria;
		}
		
		public void setEstadoAveria(String estadoAveria){
			this.estadoAveria = estadoAveria;
		}
		
		public String getEstadoPago(){
			return estadoPago;
		}
		
		public void setEstadoPago(String estadoPago){
			this.estadoPago = estadoPago;
		}

	
		public int getTiempo(){
			return tiempoRep;
		}
		
		public float getPrecio(){
			return precioTotal;
		}
		
		public void setPrecio(float precioTotal){
			this.precioTotal = precioTotal;
		}
		
		public void incTiempo(int tiempomin){
			tiempoRep += tiempomin;
		}
		
		public void incPrecio(float precio){
			precioTotal += precio;
		}
		
	
	}