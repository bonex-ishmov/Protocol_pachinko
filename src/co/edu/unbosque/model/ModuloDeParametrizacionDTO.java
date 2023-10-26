package co.edu.unbosque.model;

import java.io.Serializable;

public class ModuloDeParametrizacionDTO implements Serializable {

	private static final long serialVersionUID = 1058979530062143873L;
	private String nombreDeLaCasa;
	private int numeroDeSedes;
	private double presupuestoTotal;

	public ModuloDeParametrizacionDTO() {
		// TODO Auto-generated constructor stub
	}

	public ModuloDeParametrizacionDTO(String nombreDeLaCasa, int numeroDeSedes, double presupuestoTotal) {
		super();
		this.nombreDeLaCasa = nombreDeLaCasa;
		this.numeroDeSedes = numeroDeSedes;
		this.presupuestoTotal = presupuestoTotal;
	}

	public String getNombreDeLaCasa() {
		return nombreDeLaCasa;
	}

	public void setNombreDeLaCasa(String nombreDeLaCasa) {
		this.nombreDeLaCasa = nombreDeLaCasa;
	}

	public int getNumeroDeSedes() {
		return numeroDeSedes;
	}

	public void setNumeroDeSedes(int numeroDeSedes) {
		this.numeroDeSedes = numeroDeSedes;
	}

	public double getPresupuestoTotal() {
		return presupuestoTotal;
	}

	public void setPresupuestoTotal(double presupuestoTotal) {
		this.presupuestoTotal = presupuestoTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ModuloDeParametrizacionDTO [nombreDeLaCasa=" + nombreDeLaCasa + ", numeroDeSedes=" + numeroDeSedes
				+ ", presupuestoTotal=" + presupuestoTotal + "]";
	}

}
