package core;

import java.time.LocalDate;
import java.util.List;

public class Venta {
	private String id;
	private LocalDate fechaVenta;
	private String comprador;
	private String numFactura;
	private String formaPago;
	private String campoOrigen;
	private String destino;
	private List<Bovino> bovinosVendidos;
	private double importeTotal;
	private PropositoVenta proposito;
	private int rinde;
	private int fk_usuario;
	
	// Constructor
	public Venta(String id, LocalDate fechaVenta, String comprador, String numFactura, String formaPago,
			String campoOrigen, String destino, List<Bovino> bovinosVendidos, double importeTotal,
			PropositoVenta proposito, int rinde, int fk_usuario) {
		super();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.comprador = comprador;
		this.numFactura = numFactura;
		this.formaPago = formaPago;
		this.campoOrigen = campoOrigen;
		this.destino = destino;
		this.bovinosVendidos = bovinosVendidos;
		this.importeTotal = importeTotal;
		this.proposito = proposito;
		this.rinde = rinde;
		this.fk_usuario = fk_usuario;
	}

	
	// Métodos
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getCampoOrigen() {
		return campoOrigen;
	}

	public void setCampoOrigen(String campoOrigen) {
		this.campoOrigen = campoOrigen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public List<Bovino> getBovinosVendidos() {
		return bovinosVendidos;
	}

	public void setBovinosVendidos(List<Bovino> bovinosVendidos) {
		this.bovinosVendidos = bovinosVendidos;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public PropositoVenta getProposito() {
		return proposito;
	}

	public void setProposito(PropositoVenta proposito) {
		this.proposito = proposito;
	}

	public int getRinde() {
		return rinde;
	}

	public void setRinde(int rinde) {
		this.rinde = rinde;
	}

	public int getFk_usuario() {
		return fk_usuario;
	}

	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
	
	
	
	
}
