package co.edu.unbosque.model;

import java.io.Serializable;

public class ModuloDeParametrizacionJuegosDTO extends ModuloDeParametrizacionDTO implements Serializable {

	private static final long serialVersionUID = 3861383955921841535L;
	private String nombreDelJuego;
	private String tipoDeJuego;
	private double PresupuestoAsignadoAlJuego;

	public ModuloDeParametrizacionJuegosDTO() {
		// TODO Auto-generated constructor stub
	}

	public ModuloDeParametrizacionJuegosDTO(String nombreDelJuego, String tipoDeJuego,
			double presupuestoAsignadoAlJuego) {
		super();
		this.nombreDelJuego = nombreDelJuego;
		this.tipoDeJuego = tipoDeJuego;
		PresupuestoAsignadoAlJuego = presupuestoAsignadoAlJuego;
	}

	public ModuloDeParametrizacionJuegosDTO(String nombreDeLaCasa, int numeroDeSedes, double presupuestoTotal) {
		super(nombreDeLaCasa, numeroDeSedes, presupuestoTotal);
		// TODO Auto-generated constructor stub
	}

	public ModuloDeParametrizacionJuegosDTO(String nombreDeLaCasa, int numeroDeSedes, double presupuestoTotal,
			String nombreDelJuego, String tipoDeJuego, double presupuestoAsignadoAlJuego) {
		super(nombreDeLaCasa, numeroDeSedes, presupuestoTotal);
		this.nombreDelJuego = nombreDelJuego;
		this.tipoDeJuego = tipoDeJuego;
		PresupuestoAsignadoAlJuego = presupuestoAsignadoAlJuego;
	}

	public String getNombreDelJuego() {
		return nombreDelJuego;
	}

	public void setNombreDelJuego(String nombreDelJuego) {
		this.nombreDelJuego = nombreDelJuego;
	}

	public String getTipoDeJuego() {
		return tipoDeJuego;
	}

	public void setTipoDeJuego(String tipoDeJuego) {
		this.tipoDeJuego = tipoDeJuego;
	}

	public double getPresupuestoAsignadoAlJuego() {
		return PresupuestoAsignadoAlJuego;
	}

	public void setPresupuestoAsignadoAlJuego(double presupuestoAsignadoAlJuego) {
		PresupuestoAsignadoAlJuego = presupuestoAsignadoAlJuego;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ModuloDeParametrizacionJuegosDTO [nombreDelJuego=" + nombreDelJuego + ", tipoDeJuego=" + tipoDeJuego
				+ ", PresupuestoAsignadoAlJuego=" + PresupuestoAsignadoAlJuego + "]";
	}

}
