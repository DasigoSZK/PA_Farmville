package modelos;

import java.time.LocalDate;
import java.util.List;

public class Hoteleria {
	private Integer id;
	private String propietario;
	private List<Bovino> bovinos;
	private Double precioPorKgGanado;
	private LocalDate fechaAdquisicion;
	private Boolean finalizado;
	private Integer fk_usuario;
	
	// Constructor
	public Hoteleria(Integer id, String propietario, List<Bovino> bovinos, Double precioPorKgGanado,
			LocalDate fechaAdquisicion, Boolean finalizado, Integer fk_usuario) {
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
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public void setPrecioPorKgGanado(Double precioPorKgGanado) {
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

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public int getFk_usuario() {
		return fk_usuario;
	}

	public void setFk_usuario(Integer fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	

	
	
	
}
