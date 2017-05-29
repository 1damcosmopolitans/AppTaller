package Models;
	import java.util.Calendar;
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
		private final String FormatoFecha = "\\d{1,2}/\\d{1,2}/\\d{4}";
		
		
		
		public Reparacion(String idRep, String matriculaRep, String fechaIni, String fechaFin, 
				String averia, String estadoAveria, String comentario) {
			super();
			setIdRep(idRep);
			setMatriculaRep(matriculaRep);
			setAveria(estadoAveria);
			setComentario(comentario);
			setEstadoAveria(estadoAveria);
			setEstadoPago(estadoAveria);
			setFechaFin(fechaFin);
			setFechaIni(fechaIni);
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
			if(idRep.equals("") || idRep == null) throw new RuntimeException("El id no puede estar vacío.");
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
			if(Pattern.matches(FormatoFecha, fechaIni)) throw new RuntimeException("Fecha de inicio incorrecta (DD/MM/AAAA).");

			this.fechaIni = fechaIni;
		}
		public String getFechaFin() {
			return fechaFin;
		}
		
		public void setComentario(String comentario){
			this.comentario= comentario;
		}
		public void setFechaFin(String fechaFin) {
			if(Pattern.matches(FormatoFecha, fechaFin)) throw new RuntimeException("Fecha de inicio incorrecta (DD/MM/AAAA)");
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
		
		
		
		

		
	
	}