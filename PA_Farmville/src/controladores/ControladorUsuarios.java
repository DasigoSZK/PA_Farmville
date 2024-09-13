package controladores;
import java.util.List;

import core.Administrador;
import core.Bovino;
import core.Campo;
import core.CondicionFiscal;
import core.Hoteleria;
import core.Usuario;
import core.Venta;
import modelos.*;


public class ControladorUsuarios extends Controlador<ModeloUsuarios>{

	public ControladorUsuarios() {
		super(new ModeloUsuarios("id_usuario", "usuarios"));
	}

	
	/*
	USUARIO
	private String id;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	private String preguntaSeguridad;
	private String respuestaSeguridad;
	
	PRODUCTOR
	private String telefono;
	private String DNI;
	private String CUIT;
	private CondicionFiscal cond;
	private String domicilioFiscal;
	private List<Campo> campos;
	private List<Bovino> bovinos;
	private List<Venta> ventas;
	private List<Hoteleria> serviciosHoteleria;
	 */
	
	
	// Registra un nuevo productor
	public static int registrarProductor(String nombre, String apellido, String correo, 
			String telefono, String DNI, String CUIT, String condFiscal, String domFiscal,
			String contrasena, String pregSeguridad, String resSeguridad) {
		
		return 0;
	}
	
	// Loguea un usuario existente
	public static boolean login(String usuario, String contrasena) {
		
		return false;
	}
	
	// Cambia la contraseña del usuario con su Pregunta de Seguridad
	public static int cambiarContrasena(String correo, String respSeguridad) {
		
		return 0;
	}
	
	// (admin) Elimina un usuario
	public static int eliminarUsuario(int indexUsuario) {
		
		// Si el usuario en sesión no es administrador, return 0
		if(!(ControladorUsuarios.usuarioEnSesion instanceof Administrador)) {
			
			return 0;
		}
		
		return 0;
	}
	
	// (admin) Obtiene todos los usuarios de Farmville
	public static List<Usuario> obtenerUsuarios() {
		
		// Si el usuario en sesión no es administrador, return null
		if(!(ControladorUsuarios.usuarioEnSesion instanceof Administrador)) {
			
			return null;
		}
		return null;
	}
	
	// Registra un nuevo administrador
	public static int registrarAdministrador(String nombre, String apellido, 
			String correo, String contrasena, String pregSeg, String resSeg) {
		
		// Si el usuario en sesión no es administrador, return 0
		if(!(ControladorUsuarios.usuarioEnSesion instanceof Administrador)) {
			
			return 0;
		}
		
		return 0;
	}
	
}
