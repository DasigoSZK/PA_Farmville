package modelos;

import java.time.LocalDate;
import java.util.List;

public class Venta {
	private Integer id;
	private LocalDate fechaVenta;
	private String comprador;
	private String numFactura;
	private String formaPago;
	private String destino;
	private List<Bovino> bovinosVendidos;
	private double importeTotal;
	private String proposito;
	private Integer rinde;
	private Integer fk_usuario;
	
	// Constructor
	public Venta(Integer id, LocalDate fechaVenta, String comprador, String numFactura, String formaPago, String destino, List<Bovino> bovinosVendidos, double importeTotal,
			String proposito, Integer rinde, Integer fk_usuario) {
		super();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.comprador = comprador;
		this.numFactura = numFactura;
		this.formaPago = formaPago;
		this.destino = destino;
		this.bovinosVendidos = bovinosVendidos;
		this.importeTotal = importeTotal;
		this.proposito = proposito;
		this.rinde = rinde;
		this.fk_usuario = fk_usuario;
	}

	
	// Métodos
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	public Integer getRinde() {
		return rinde;
	}

	public void setRinde(Integer rinde) {
		this.rinde = rinde;
	}

	public Integer getFk_usuario() {
		return fk_usuario;
	}

	public void setFk_usuario(Integer fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
	
	
	
	
}
