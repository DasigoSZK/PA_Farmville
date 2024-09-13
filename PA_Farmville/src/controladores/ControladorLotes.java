package controladores;
import java.time.LocalDate;
import java.util.List;

import core.Bovino;
import core.Lote;
import modelos.*;


public class ControladorLotes extends Controlador<ModeloLotes>{

	public ControladorLotes() {
		super(new ModeloLotes("id_lote", "lotes"));
	}
	
	
	// Obtiene todos los Lotes asociados a un campo
	public static List<Lote> obtenerLotes(int indexCampo){
		
		if(ControladorCampos.usuarioEnSesion == null) return null;
		
		return null;
	}
	
	// Registra/Asocia un nuevo Lote
	public static int registrarLote(int indexCampo, String numLote, int hectareas, String nomImagen, String alimentacion) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Modifica 1 Lote existente
	public static int modificarLote(int indexLote, String numLote, int hectareas, String nomImagen, String alimentacion) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Elimina 1 Lote
	public static int eliminarLote(int indexLote) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}

}
