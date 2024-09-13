 package core;

import java.util.List;

public class Lote {
	private String id;
	private String numero;
	private int hectareas;
	private String nombreImagen;
	private List<Bovino> bovinos;
	private String alimentacion;
	private int fk_campo;
	
	
	// Constructor
	public Lote(String id, String numero, int hectareas,int fk_campo) {
		super();
		this.id = id;
		this.numero = numero;
		this.hectareas = hectareas;
		this.nombreImagen = "";
		this.bovinos = null;
		this.alimentacion = "";
		this.fk_campo = fk_campo;
	}
	public Lote(String id, String numero, int hectareas, String nombreImagen,int fk_campo) {
		super();
		this.id = id;
		this.numero = numero;
		this.hectareas = hectareas;
		this.nombreImagen = nombreImagen;
		this.bovinos = null;
		this.alimentacion = "";
		this.fk_campo = fk_campo;
	}
	public Lote(String id, String numero, int hectareas, String nombreImagen, List<Bovino> bovinos,int fk_campo) {
		super();
		this.id = id;
		this.numero = numero;
		this.hectareas = hectareas;
		this.nombreImagen = nombreImagen;
		this.bovinos = bovinos;
		this.alimentacion = "";
		this.fk_campo = fk_campo;
	}
	public Lote(String id, String numero, int hectareas, String nombreImagen, List<Bovino> bovinos, String alimentacion,
			int fk_campo) {
		super();
		this.id = id;
		this.numero = numero;
		this.hectareas = hectareas;
		this.nombreImagen = nombreImagen;
		this.bovinos = bovinos;
		this.alimentacion = alimentacion;
		this.fk_campo = fk_campo;
	}
	


	// Métodos
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getHectareas() {
		return hectareas;
	}
	public void setHectareas(int hectareas) {
		this.hectareas = hectareas;
	}
	public String getNombreImagen() {
		return nombreImagen;
	}
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	public List<Bovino> getBovinos() {
		return bovinos;
	}
	public void setBovinos(List<Bovino> bovinos) {
		this.bovinos = bovinos;
	}
	public String getAlimentacion() {
		return alimentacion;
	}
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}
	public int getFk_campo() {
		return fk_campo;
	}
	public void setFk_campo(int fk_campo) {
		this.fk_campo = fk_campo;
	}


	
	
	
}
