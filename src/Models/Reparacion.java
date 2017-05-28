package Models;
	import java.util.Calendar;
	public class Reparacion {
		
		private String idRep;
		private String matriculaRep;
		private String fechaIni;
		private String fechaFin;
		private String averia;
		private String estadoAveria;				//0 :inicial, 1:intermedio, 2:Avanzado, 3:reparado
		private String estadoPago;
		
		
		
		
		public Reparacion(String idRep, String matriculaRep, String fechaIni, String fechaFin, 
				String averia, String estadoAveria) {
			super();
			this.idRep = idRep;
			this.matriculaRep = matriculaRep;
			this.fechaIni = fechaIni;
			this.fechaFin = fechaFin;
		
			this.averia = averia;					//Comentarios
			this.estadoAveria = estadoAveria;		//Pendiente o pagado
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
		public void setIdRep(String idRep) {
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
			this.fechaIni = fechaIni;
		}
		public String getFechaFin() {
			return fechaFin;
		}
		public void setFechaFin(String fechaFin) {
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