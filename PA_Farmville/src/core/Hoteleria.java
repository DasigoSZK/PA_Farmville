package core;

import java.time.LocalDate;
import java.util.List;

public class Hoteleria {
	private int id;
	private String propietario;
	private List<Bovino> bovinos;
	private double precioPorKgGanado;
	private LocalDate fechaAdquisicion;
	private boolean finalizado;
	private int fk_usuario;
	
	// Constructor
	public Hoteleria(int id, String propietario, List<Bovino> bovinos, double precioPorKgGanado,
			LocalDate fechaAdquisicion, boolean finalizado, int fk_usuario) {
		super();
		this.id = id;
		this.propietario = propietario;
		this.bovinos = bovinos;
		this.precioPorKgGanado = precioPorKgGanado;
		this.fechaAdquisicion = fechaAdquisicion;
		this.finalizado = finalizado;
		this.fk_usuario = fk_usuario;
	}
	
	
	
	
	// Métodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public List<Bovino> getBovinos() {
		return bovinos;
	}

	public void setBovinos(List<Bovino> bovinos) {
		this.bovinos = bovinos;
	}

	public double getPrecioPorKgGanado() {
		return precioPorKgGanado;
	}

	public void setPrecioPorKgGanado(double precioPorKgGanado) {
		this.precioPorKgGanado = precioPorKgGanado;
	}

	public LocalDate getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public int getFk_usuario() {
		return fk_usuario;
	}

	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	

	
	
	
}
