package modelos;

import java.util.List;

public class Productor extends Usuario{
	private String telefono;
	private String DNI;
	private String CUIT;
	private String cond;
	private String domicilioFiscal;
	private List<Campo> campos;
	private List<Bovino> bovinos;
	private List<Venta> ventas;
	private List<Hoteleria> serviciosHoteleria;
	
	// Constructor
	public Productor(Integer id, String nombre, String apellido, String correo, String contrasena,
			String preguntaSeguridad, String respuestaSeguridad, String telefono, String DNI, String CUIT,
			String cond, String domicilioFiscal, List<Campo> campos, List<Bovino> bovinos, List<Venta> ventas,
			List<Hoteleria> serviciosHoteleria) {
		super(id, nombre, apellido, correo, contrasena, preguntaSeguridad, respuestaSeguridad);
		this.telefono = telefono;
		DNI = DNI;
		CUIT = CUIT;
		this.cond = cond;
		this.domicilioFiscal = domicilioFiscal;
		this.campos = campos;
		this.bovinos = bovinos;
		this.ventas = ventas;
		this.serviciosHoteleria = serviciosHoteleria;
	}
	
	
	

	// Métodos
	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getCUIT() {
		return CUIT;
	}


	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}


	public String getCond() {
		return cond;
	}


	public void setCond(String cond) {
		this.cond = cond;
	}


	public String getDomicilioFiscal() {
		return domicilioFiscal;
	}


	public void setDomicilioFiscal(String domicilioFiscal) {
		this.domicilioFiscal = domicilioFiscal;
	}


	public List<Campo> getCampos() {
		return campos;
	}


	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}


	public List<Bovino> getBovinos() {
		return bovinos;
	}


	public void setBovinos(List<Bovino> bovinos) {
		this.bovinos = bovinos;
	}


	public List<Venta> getVentas() {
		return ventas;
	}


	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}


	public List<Hoteleria> getServiciosHoteleria() {
		return serviciosHoteleria;
	}


	public void setServiciosHoteleria(List<Hoteleria> serviciosHoteleria) {
		this.serviciosHoteleria = serviciosHoteleria;
	}
	
	
}
