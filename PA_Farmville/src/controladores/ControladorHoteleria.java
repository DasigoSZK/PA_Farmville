package controladores;
import java.time.LocalDate;
import java.util.List;

import core.Bovino;
import core.Hoteleria;
import modelos.*;


public class ControladorHoteleria extends Controlador<ModeloHoteleria>{

	public ControladorHoteleria() {
		super(new ModeloHoteleria("id_hoteleria", "hoteleria"));
	}
	
	// Obtiene todos los servicios de hotelería del productor
	public static List<Hoteleria> obtenerServiciosHoteleria(){
		
		if(ControladorCampos.usuarioEnSesion == null) return null;
		
		return null;
	}
	
	// Registra un nuevo servicio de hotelería
	public static int registrarServicioHoteleria(String propietario, int cantNobillos, int pesoNobillos, 
			int cantVaquillas, int pesoVaquillas,int cantVacas, int pesoVacas, int cantToros, int pesoToros, 
			double precioPorKgGanado, LocalDate fechaAdquisicion) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Modificar 1 servicio de Hotelería
	public static int modificarServicioHoteleria(int indexServicio, double precioPorKgGanado) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return -1;
	}
	
	// Elimina un Servicio de Hoteleria (elimina el registro y elimina los bovinos)
	public static int eliminarServicioHoteleria(int indexServicio) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;

		return 0;
	}
	
	// Marca como "finalizado" el servicio de hotelería (marca los bovinos como vendido y finaliza el servicio)
	public static int finalizarServicioHoteleria(int indexServicio) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;

		return 0;
	}
}
