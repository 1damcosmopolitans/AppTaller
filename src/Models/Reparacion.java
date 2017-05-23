package Models;
	import java.util.Calendar;
	public class Reparacion {
		
		private int idRep;
		private String matriculaRep;
		private Calendar fechaIni;
		private Calendar fechaFin;
		private int idFactura;
		private String averia;
		
		@Override
		public String toString() {
			return "Reparacion [idRep=" + idRep + ", matriculaRep=" + matriculaRep + ", fechaIni=" + fechaIni
					+ ", fechaFin=" + fechaFin + ", idFactura=" + idFactura + ", averia=" + averia + "]";
		}
		public int getIdRep() {
			return idRep;
		}
		public void setIdRep(int idRep) {
			this.idRep = idRep;
		}
		public String getMatriculaRep() {
			return matriculaRep;
		}
		public void setMatriculaRep(String matriculaRep) {
			this.matriculaRep = matriculaRep;
		}
		public Calendar getFechaIni() {
			return fechaIni;
		}
		public void setFechaIni(Calendar fechaIni) {
			this.fechaIni = fechaIni;
		}
		public Calendar getFechaFin() {
			return fechaFin;
		}
		public void setFechaFin(Calendar fechaFin) {
			this.fechaFin = fechaFin;
		}
		public int getIdFactura() {
			return idFactura;
		}
		public void setIdFactura(int idFactura) {
			this.idFactura = idFactura;
		}
		public String getAveria() {
			return averia;
		}
		public void setAveria(String averia) {
			this.averia = averia;
		}
		
		

		
	
	}