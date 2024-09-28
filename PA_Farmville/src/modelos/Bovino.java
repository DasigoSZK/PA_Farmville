package modelos;

import java.time.LocalDate;

public class Bovino {
	private Integer id;
	private Integer caravana;
	private String categoria;
	private String raza;
	private String sexo;
	private Integer edad;
	private Double peso;
	private Lote lote;
	private LocalDate fechaAdquisicion;
	private String origen;
	private Boolean vacunaAftosa;
	private LocalDate fechaAftosa;
	private Boolean vacunaBrucelosis;
	private LocalDate fechaBrucelosis;
	private String estado;
	private Integer fk_usuario;
	private Integer fk_lote;
	private Integer fk_venta;
	private Integer fk_hoteleria;
	
	// Constructor
	
	// (Constructor para jaula)
	public Bovino(String categoria,Double peso, LocalDate fechaAdquisicion, Integer fk_usuario) {
		super();
		this.id = id;
		this.caravana = 0;
		this.categoria = categoria;
		this.raza = RazaBovino.ANGUS.getValorInterno();
		
		// Declara el sexo según la categoría
		if(categoria.equals(CategoriaBovino.TERNERO.getValorInterno())
				|| categoria.equals(CategoriaBovino.NOBILLO.getValorInterno()) 
				|| categoria.equals(CategoriaBovino.TORO.getValorInterno())) {
			this.sexo = Sexo.MACHO.getValorInterno();
		}else {
			this.sexo = Sexo.HEMBRA.getValorInterno();
		}
		
		// Declara la edad según la categoría
		if(this.categoria.equals(CategoriaBovino.TERNERO.getValorInterno())
				|| this.categoria.equals(CategoriaBovino.TERNERA.getValorInterno())) this.edad = 1;
		if(this.categoria.equals(CategoriaBovino.NOBILLO.getValorInterno())) this.edad = 2;
		if(this.categoria.equals(CategoriaBovino.VAQUILLA.getValorInterno())) this.edad = 2;
		if(this.categoria.equals(CategoriaBovino.VACA.getValorInterno())) this.edad = 4;
		if(this.categoria.equals(CategoriaBovino.TORO.getValorInterno())) this.edad = 4;
		
		this.peso = peso;
		this.lote = null;
		this.fechaAdquisicion = LocalDate.now();
		this.origen = Origen.COMPRA.getValorInterno();
		this.vacunaAftosa = false;
		this.fechaAftosa = null;
		this.vacunaBrucelosis = false;
		this.fechaBrucelosis = null;
		this.estado = EstadoBovino.EN_STOCK.getValorInterno();
		this.fk_usuario = fk_usuario;
		this.fk_lote = 0;
		this.fk_venta = 0;
		this.fk_hoteleria = 0;
	}
	
	public Bovino(Integer id, Integer caravana, String categoria, String raza, String sexo, Integer edad,
			Double peso, Lote lote, LocalDate fechaAdquisicion, String origen, Boolean vacunaAftosa,
			LocalDate fechaAftosa, Boolean vacunaBrucelosis, LocalDate fechaBrucelosis, String estado,
			int fk_usuario) {
		super();
		this.id = id;
		this.caravana = caravana;
		this.categoria = categoria;
		this.raza = raza;
		this.sexo = sexo;
		this.edad = edad;
		this.peso = peso;
		this.lote = lote;
		this.fechaAdquisicion = fechaAdquisicion;
		this.origen = origen;
		this.vacunaAftosa = vacunaAftosa;
		this.fechaAftosa = fechaAftosa;
		this.vacunaBrucelosis = vacunaBrucelosis;
		this.fechaBrucelosis = fechaBrucelosis;
		this.estado = estado;
		this.fk_usuario = fk_usuario;
		this.fk_lote = 0;
		this.fk_venta = 0;
		this.fk_hoteleria = 0;
	}
	public Bovino(Integer id, Integer caravana, String categoria, String raza, String sexo, int edad,
			Double peso, Lote lote, LocalDate fechaAdquisicion, String origen, Boolean vacunaAftosa,
			LocalDate fechaAftosa, Boolean vacunaBrucelosis, LocalDate fechaBrucelosis, String estado,
			Integer fk_usuario, Integer fk_lote) {
		super();
		this.id = id;
		this.caravana = caravana;
		this.categoria = categoria;
		this.raza = raza;
		this.sexo = sexo;
		this.edad = edad;
		this.peso = peso;
		this.lote = lote;
		this.fechaAdquisicion = fechaAdquisicion;
		this.origen = origen;
		this.vacunaAftosa = vacunaAftosa;
		this.fechaAftosa = fechaAftosa;
		this.vacunaBrucelosis = vacunaBrucelosis;
		this.fechaBrucelosis = fechaBrucelosis;
		this.estado = estado;
		this.fk_usuario = fk_usuario;
		this.fk_lote = fk_lote;
		this.fk_venta = 0;
		this.fk_hoteleria = 0;
	}
	public Bovino(Integer id, Integer caravana, String categoria, String raza, String sexo, Integer edad,
			Double peso, Lote lote, LocalDate fechaAdquisicion, String origen, Boolean vacunaAftosa,
			LocalDate fechaAftosa, Boolean vacunaBrucelosis, LocalDate fechaBrucelosis, String estado,
			int fk_usuario, int fk_lote, int fk_venta) {
		super();
		this.id = id;
		this.caravana = caravana;
		this.categoria = categoria;
		this.raza = raza;
		this.sexo = sexo;
		this.edad = edad;
		this.peso = peso;
		this.lote = lote;
		this.fechaAdquisicion = fechaAdquisicion;
		this.origen = origen;
		this.vacunaAftosa = vacunaAftosa;
		this.fechaAftosa = fechaAftosa;
		this.vacunaBrucelosis = vacunaBrucelosis;
		this.fechaBrucelosis = fechaBrucelosis;
		this.estado = estado;
		this.fk_usuario = fk_usuario;
		this.fk_lote = fk_lote;
		this.fk_venta = fk_venta;
		this.fk_hoteleria = 0;
	}
	public Bovino(Integer id, int caravana, String categoria, String raza, String sexo, Integer edad,
			Double peso, Lote lote, LocalDate fechaAdquisicion, String origen, Boolean vacunaAftosa,
			LocalDate fechaAftosa, Boolean vacunaBrucelosis, LocalDate fechaBrucelosis, String estado,
			Integer fk_usuario, Integer fk_lote, Integer fk_venta, Integer fk_hoteleria) {
		super();
		this.id = id;
		this.caravana = caravana;
		this.categoria = categoria;
		this.raza = raza;
		this.sexo = sexo;
		this.edad = edad;
		this.peso = peso;
		this.lote = lote;
		this.fechaAdquisicion = fechaAdquisicion;
		this.origen = origen;
		this.vacunaAftosa = vacunaAftosa;
		this.fechaAftosa = fechaAftosa;
		this.vacunaBrucelosis = vacunaBrucelosis;
		this.fechaBrucelosis = fechaBrucelosis;
		this.estado = estado;
		this.fk_usuario = fk_usuario;
		this.fk_lote = fk_lote;
		this.fk_venta = fk_venta;
		this.fk_hoteleria = fk_hoteleria;
	}
	
	
	


	// Métodos
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCaravana() {
		return caravana;
	}
	public void setCaravana(Integer caravana) {
		this.caravana = caravana;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Lote getLote() {
		return lote;
	}
	public void setLote(Lote lote) {
		this.lote = lote;
	}
	public LocalDate getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Boolean isVacunaAftosa() {
		return vacunaAftosa;
	}
	public void setVacunaAftosa(Boolean vacunaAftosa) {
		this.vacunaAftosa = vacunaAftosa;
	}
	public LocalDate getFechaAftosa() {
		return fechaAftosa;
	}
	public void setFechaAftosa(LocalDate fechaAftosa) {
		this.fechaAftosa = fechaAftosa;
	}
	public Boolean isVacunaBrucelosis() {
		return vacunaBrucelosis;
	}
	public void setVacunaBrucelosis(Boolean vacunaBrucelosis) {
		this.vacunaBrucelosis = vacunaBrucelosis;
	}
	public LocalDate getFechaBrucelosis() {
		return fechaBrucelosis;
	}
	public void setFechaBrucelosis(LocalDate fechaBrucelosis) {
		this.fechaBrucelosis = fechaBrucelosis;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(Integer fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
	public Integer getFk_lote() {
		return fk_lote;
	}
	public void setFk_lote(Integer fk_lote) {
		this.fk_lote = fk_lote;
	}
	public Integer getFk_venta() {
		return fk_venta;
	}
	public void setFk_venta(Integer fk_venta) {
		this.fk_venta = fk_venta;
	}
	public Integer getFk_hoteleria() {
		return fk_hoteleria;
	}
	public void setFk_hoteleria(Integer fk_hoteleria) {
		this.fk_hoteleria = fk_hoteleria;
	}


}
