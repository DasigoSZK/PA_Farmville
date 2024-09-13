package core;

import java.util.List;

public class Campo {
	private String id;
	private String nombre;
	private String ubicacion;
	private int hectareas;
	private List<Lote> lotes;
	private int fk_usuario;
	
	// Constructor
	public Campo(String id, String nombre, String ubicacion, int fk_usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.hectareas = 0;
		this.lotes = null;
		this.fk_usuario = fk_usuario;
	}
	public Campo(String id, String nombre, String ubicacion, int hectareas, int fk_usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.hectareas = hectareas;
		this.lotes = null;
		this.fk_usuario = fk_usuario;
	}
	public Campo(String id, String nombre, String ubicacion, int hectareas, List<Lote> lotes, int fk_usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.hectareas = hectareas;
		this.lotes = lotes;
		this.fk_usuario = fk_usuario;
	}
	
	
	// Metodos
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getHectareas() {
		return hectareas;
	}
	public void setHectareas(int hectareas) {
		this.hectareas = hectareas;
	}
	public List<Lote> getLotes() {
		return lotes;
	}
	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}
	public int getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	
	

	
	
	
	
	
	
}
