package controladores;
import java.util.List;

import core.Campo;
import core.Lote;
import modelos.*;

public class ControladorCampos extends Controlador<ModeloCampos>{

	public ControladorCampos() {
		super(new ModeloCampos("id_campo", "campos"));
	}
	
	// Obtiene todos los campos asociados al productor
	public static List<Campo> obtenerCampos() {
		
		if(ControladorCampos.usuarioEnSesion == null) return null;
		
		return null;
	}
	
	// Registra un nuevo campo
	public static int registrarCampo(String nombre, String ubicacion, int hectareas) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Modifica 1 campo existente
	public static int modificarCampo(int indexCampo, String nombre, String ubicacion, int hectareas) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}
	
	// Elimina 1 campo
	public static int eliminarCampo(int indexCampo) {
		
		if(ControladorCampos.usuarioEnSesion == null) return -1;
		
		return 0;
	}

}
