package controladores;
import java.time.LocalDate;
import java.util.List;

import core.Bovino;
import core.PropositoVenta;
import core.Venta;
import modelos.*;


public class ControladorVentas extends Controlador<ModeloVentas> {

	public ControladorVentas() {
		super(new ModeloVentas("id_venta", "ventas"));
	}
	
	// Obtiene todas las ventas del Productor
	public static List<Venta> obtenerVentas(){
		
		if(ControladorCampos.usuarioEnSesion == null) return null;
		
		return null;
	}
	
	// Registra una nueva venta
	public static int registrarVenta(LocalDate fechaVenta, String comprador, String numFactura, String formaPago,
			String campoOrigen, String destino, List<Integer> indexBovinos, double importeTotal, String proposito, 
			int rinde) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Elimina una venta (mueve los bovinos al stock actual, y elimina el registro de venta)
	public static int eliminarVenta(int indexVenta) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	

}
