package modelos;

import java.util.List;

public class Campo {
	private Integer id;
	private String nombre;
	private String ubicacion;
	private Integer hectareas;
	private List<Lote> lotes;
	private Integer fk_usuario;
	
	// Constructor
	public Campo(Integer id, String nombre, String ubicacion, Integer fk_usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.hectareas = 0;
		this.lotes = null;
		this.fk_usuario = fk_usuario;
	}
	public Campo(Integer id, String nombre, String ubicacion, Integer hectareas, Integer fk_usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.hectareas = hectareas;
		this.lotes = null;
		this.fk_usuario = fk_usuario;
	}
	public Campo(Integer id, String nombre, String ubicacion, Integer hectareas, List<Lote> lotes, Integer fk_usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.hectareas = hectareas;
		this.lotes = lotes;
		this.fk_usuario = fk_usuario;
	}
	
	
	// Metodos
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getHectareas() {
		return hectareas;
	}
	public void setHectareas(Integer hectareas) {
		this.hectareas = hectareas;
	}
	public List<Lote> getLotes() {
		return lotes;
	}
	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}
	public Integer getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(Integer fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	
	

	
	
	
	
	
	
}
