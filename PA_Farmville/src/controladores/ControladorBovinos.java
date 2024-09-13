package controladores;
import java.time.LocalDate;
import java.util.List;

import core.Bovino;
import core.Lote;
import modelos.*;

public class ControladorBovinos extends Controlador<ModeloBovino>{

	public ControladorBovinos() {
		super(new ModeloBovino("id_bovino", "bovinos"));
	}

	
	// Obtiene todos los bovinos con estado "en stock" del usuario
	public static List<Bovino> obtenerStock(){
		
		if(ControladorBovinos.usuarioEnSesion == null) return null;
		
		return null;
	}
	
	// Registra 1 bovino
	public static int registrarBovino(int caravana, String categoria, String raza, String sexo, 
			int edad, double peso, LocalDate fechaAdquisicion, String origen, boolean vacunaAftosa, 
			LocalDate fechaAftosa, boolean vacunaBrucelosis, LocalDate fechaBrucelosis, String estado, int fk_lote) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Registra "n" cantidad de bovinos
	public static int registrarJaula(int cantTerneros, int pesoTerneros, int cantTerneras, int pesoTerneras,
			int cantNobillos, int pesoNobillos, int cantVaquillas, int pesoVaquillas,
			int cantVacas, int pesoVacas, int cantToros, int pesoToros) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Modifica 1 bovino
	public static int modificarBovino(int indexBovino, int caravana, String categoria, String sexo,
			String raza, int edad, double peso, String fechaAdq, String origen, Lote lote, 
			boolean vacunaAftosa, LocalDate fechaAftosa, boolean vacunaBrucelosis, LocalDate fechaBrucelosis) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Elimina (mueve al historial de bajas) 1 Bovino
	public static int eliminarBovino(int indexBovino, String causa) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Elimina (mueve al historial de bajas) "n" cantidad de bovinos
	public static int eliminarBovinos(List<Integer> indexBovinos, String causa) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Recupera/mueve del historial de bajas --> stock actual 1 bovino
	public static int recuperarBovino(int indexBovino) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Recuera/mueve del historial de bajas --> stock actual "n" cantidad de bovions
	public static int recuperarBovinos(List<Integer> indexBovinos) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
}
