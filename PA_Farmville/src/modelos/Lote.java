 package modelos;

import java.util.List;

public class Lote {
	private Integer id;
	private String nombreLote;
	private int hectareas;
	private String nombreImagen;
	private List<Bovino> bovinos;
	private String alimentacion;
	private Integer fk_campo;
	
	
	// Constructor
	public Lote(Integer id, String numero, int hectareas,int fk_campo) {
		super();
		this.id = id;
		this.nombreLote = numero;
		this.hectareas = hectareas;
		this.nombreImagen = "";
		this.bovinos = null;
		this.alimentacion = "";
		this.fk_campo = fk_campo;
	}
	public Lote(Integer id, String numero, int hectareas, String nombreImagen,int fk_campo) {
		super();
		this.id = id;
		this.nombreLote = numero;
		this.hectareas = hectareas;
		this.nombreImagen = nombreImagen;
		this.bovinos = null;
		this.alimentacion = "";
		this.fk_campo = fk_campo;
	}
	public Lote(Integer id, String numero, int hectareas, String nombreImagen, List<Bovino> bovinos,int fk_campo) {
		super();
		this.id = id;
		this.nombreLote = numero;
		this.hectareas = hectareas;
		this.nombreImagen = nombreImagen;
		this.bovinos = bovinos;
		this.alimentacion = "";
		this.fk_campo = fk_campo;
	}
	public Lote(Integer id, String numero, int hectareas, String nombreImagen, List<Bovino> bovinos, String alimentacion,
			int fk_campo) {
		super();
		this.id = id;
		this.nombreLote = numero;
		this.hectareas = hectareas;
		this.nombreImagen = nombreImagen;
		this.bovinos = bovinos;
		this.alimentacion = alimentacion;
		this.fk_campo = fk_campo;
	}
	


	// Métodos
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return nombreLote;
	}
	public void setNumero(String numero) {
		this.nombreLote = numero;
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
