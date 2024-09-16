package test;
import core.*;
import modelos.*;
import controladores.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import javax.swing.JOptionPane;


public class Maqueta {
	
	static List<Usuario> usuariosRegistrados = new LinkedList<Usuario>();
	static int userCount = 2;
	static Usuario userSesion = null;
	
	// ------------------------------------------------------------ Main ------------------------------------------------------------
	public static void main(String[] args) {
		
		// Usuarios Test
		Productor productorTest = new Productor("1", "Dasigo", "Szkamarda", "dasigo@hotmail.com", "steyskal123",
				"¿Cuál fue el nombre de tu primer perro?", "lulu", "3644643942", "43887305", "20438873057", 
				CondicionFiscal.EXENTO.getValorInterno(), "Pampa Florida", null, null, null, null);
		Administrador adminTest = new Administrador("1", "Leandro", "Steyskal", "admin@hotmail.com", "admin123",
				"¿Cuál fue tu primera consola?", "Nintendo 64");
		
		usuariosRegistrados.add(productorTest);
		usuariosRegistrados.add(adminTest);
		
		
		// Test
		Maqueta.menuInicial();
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------
	
	// Menu 1
	public static void menuInicial() {
		
		int opMenuInicial = JOptionPane.showOptionDialog(null, "Bienvenido a Farmville", "Menu Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, new String[] {"Registrarse", "Loguearse","Olvidé mi Contraseña", "Salir"}, "Salir");
		
		// Registrarse
		if(opMenuInicial == 0) {
			
			Maqueta.registrarse();
			
		// Loguearse	
		}else if(opMenuInicial == 1) {
			
			Maqueta.login();
			
		// Salir	
		}else if(opMenuInicial == 2){
			
			Maqueta.cambiarContrasena();
			
		}else {
			System.exit(0);
		}
	}

	private static void cambiarContrasena() {
		
		Usuario usuario = null;
		String correo = JOptionPane.showInputDialog("Ingrese el correo para recuperar su contraseña.");
		
		// Buscamos el usuario entre los registros
		for(Usuario user : usuariosRegistrados) {
			
			if(user.getCorreo().equalsIgnoreCase(correo)) {
				usuario = user;
			}
		}
		
		if(usuario == null) {
			JOptionPane.showMessageDialog(null, "El correo ingresado no se encuentra registrado.\nIntentelo nuevamente o registrese.");
			Maqueta.menuInicial();
		}
		
		String resSeguridad = JOptionPane.showInputDialog("Hola " + usuario.getNombre() + "\n" + usuario.getPreguntaSeguridad());
		boolean resCorrecta = false;
		int intentos = 0;
		
		while(!resCorrecta && intentos < 3) {
			if(resSeguridad.equalsIgnoreCase(usuario.getRespuestaSeguridad())) {
				
				resCorrecta = true;
				String nuevaPass = "";
				String confirmacion = ".";
				
				while(!nuevaPass.equals(confirmacion)) {
					
					nuevaPass = JOptionPane.showInputDialog("Ingrese la nueva contraseña para \"" + usuario.getCorreo() + "\"");
					
					confirmacion = JOptionPane.showInputDialog("Confirme la contraseña ingresada");
					
					if(!nuevaPass.equals(confirmacion)) {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.\nVuelva a intentar.");
					}
				}
				
				usuario.setContrasena(nuevaPass);
				JOptionPane.showMessageDialog(null, "Se restableció tu contraseña.\nPrueba loguearte.");
				Maqueta.menuInicial();
					
			}else {
				intentos++;
				int opCC = JOptionPane.showOptionDialog(null, "La respuesta no es correcta.\n¿Quieres volver a intentar?\n" + intentos + "/3 intentos",
						"Menu Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
						null, new String[] {"Volver a intentar", "Salir"}, "Salir");
				
				if(opCC == 0) {
					resSeguridad = JOptionPane.showInputDialog(usuario.getPreguntaSeguridad());
				}else {
					Maqueta.menuInicial();
					
				}
			}	
		}
		
		JOptionPane.showMessageDialog(null, "Demasiados intentos.");
		Maqueta.menuInicial();
		
		
	}

	// Registrar un usuario
	private static void registrarse() {
		
		String correo = JOptionPane.showInputDialog("Ingrese un correo electrónico");
		String contrasena = JOptionPane.showInputDialog("Ingrese una contraseña");
		userCount++;
		
		Productor usuarioGenerico = new Productor(String.valueOf(userCount), "Genérico"+String.valueOf(userCount), "", 
				correo, contrasena,
				"¿Cuál es tu nombre de usuario?", "generico", "1234123456", "12123123", "12121231231", 
				CondicionFiscal.EXENTO.getValorInterno(), "Domicilio Genérico", null, null, null, null);
		
		usuariosRegistrados.add(usuarioGenerico);
		JOptionPane.showMessageDialog(null, "Usuario registrado.\nPrueba Ingresar con: \"" + correo + "\"");
		Maqueta.menuInicial();
	}
	
	
	// Loguearse
	private static void login() {
		
		Usuario usuario = null;
		String correo = JOptionPane.showInputDialog("Ingrese su correo");
		
		// Buscamos el usuario entre los registros
		for(Usuario user : usuariosRegistrados) {
			
			if(user.getCorreo().equalsIgnoreCase(correo)) {
				usuario = user;
			}
		}
		
		if(usuario == null) {
			JOptionPane.showMessageDialog(null, "El correo ingresado no se encuentra registrado.\nIntentelo nuevamente o registrese.");
			Maqueta.menuInicial();
		}
		
		// Validamos contraseña
		String contrasena = JOptionPane.showInputDialog("Hola " + usuario.getNombre() + ".\nIngrese su contraseña:");
		
		if(contrasena.equals(usuario.getContrasena())) {
			
			Maqueta.userSesion = usuario;
			
			if(usuario instanceof Productor) {
				
				Maqueta.menuUser();
				
			}else if(usuario instanceof Administrador) {
				
				Maqueta.menuAdmin();
			}
			
		}else {
			
			JOptionPane.showMessageDialog(null, "La contraseña ingresada no es correcta.");
			Maqueta.menuInicial();
		}
	}

	private static void menuAdmin() {
		
		// Eliminar usuario / Registrar Usuario Admin / Cambiar Contraseña
		String usuariosRegistradosString = "";
		int count = 0;
		for(Usuario user : Maqueta.usuariosRegistrados) {
			usuariosRegistradosString += ++count +"_"+ user.getCorreo() + "\n";
		}
		
		
		
		int opMenuAdmin = JOptionPane.showOptionDialog(null, usuariosRegistradosString, "Menu Admin", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, new String[] {"Eliminar Usuario", "Registrar Admin","Cambiar Contraseña", "Salir"}, "Salir");
		
		if(opMenuAdmin == 0) {
			
			JOptionPane.showMessageDialog(null, "Se elimina un usuario seleccionado");
			Maqueta.menuAdmin();
		}else if(opMenuAdmin == 1) {
			
			String correo = JOptionPane.showInputDialog("Correo del nuevo admin");
			String contrasena = JOptionPane.showInputDialog("Contraseña del nuevo admin");
			userCount++;
			
			Administrador adminGenerico = new Administrador(String.valueOf(userCount), "AdminGen"+String.valueOf(userCount), "",
					correo, contrasena, "¿Pregunta genérica?", "generico");
			
			usuariosRegistrados.add(adminGenerico);
			JOptionPane.showMessageDialog(null, "Admin registrado");
			Maqueta.menuAdmin();
		}else if(opMenuAdmin == 2) {
			Maqueta.cambiarContrasenaLogued();
		}else {
			Maqueta.menuInicial();
		}
		
	}

	private static void menuUser() {
		
		int opMenuUsuario = JOptionPane.showOptionDialog(null, "Hola " + Maqueta.userSesion.getNombre() +"", 
				"Menu Usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, new String[] {"Mi Cuenta", "Hacienda", "Campos", "Ventas", "Hotelería", "Cerrar Sesión"}, "Cerrar Sesión");
		
		if(opMenuUsuario == 0) {
			
			Maqueta.miCuenta();
		}else if(opMenuUsuario == 1) {
			
			Maqueta.hacienda();
		}else if(opMenuUsuario == 2) {
			
			Maqueta.campos();
		}else if (opMenuUsuario == 3) {
			
			Maqueta.ventas();
		}else if (opMenuUsuario == 4) {
			
			Maqueta.hoteleria();
		}else {
			
			Maqueta.menuInicial();
		}
		
	}

	private static void hoteleria() {
		
		// Registrar hoteleria / modificar hoteleria / eliminar hotelería / finalizar hotelería
		
	}

	private static void ventas() {
		
		// Registrar venta / Ver detalles de venta / Eliminar venta
		
	}

	private static void campos() {
		
		Productor usuario = (Productor)Maqueta.userSesion;
		
		// Muestra listado de campos registrados
		String listadoCampos = "";
		if(usuario.getCampos() == null || usuario.getCampos().isEmpty()) {
			usuario.setCampos(new LinkedList<Campo>());
			listadoCampos = "Aún no tienes campos registrados, prueba registrar uno.";
		}else {
			int count1 = 0;
			for(Campo campo : usuario.getCampos()) {
				
				listadoCampos += ++count1 + "_" + campo.getNombre() + " - " + campo.getUbicacion() + " - " + campo.getHectareas() + " hectareas\n";
			}	
		}
		
		int opMenuCampo = JOptionPane.showOptionDialog(null, listadoCampos, "Campos",
				JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, new String[] {"Registrar Campo", "Modificar Campo","Eliminar Campo","Asociar Lote", "Modificar Lote", "Eliminar Lote", "Volver"}, "Volver");
		
		
		// Registrar un campo
		if(opMenuCampo == 0) {
			
			Maqueta.registrarCampo(usuario);
			
		// Modificar campo	
		}else if(opMenuCampo == 1) {
			
			Maqueta.modificarCampo(usuario);
			
		// Eliminar un campo	
		}else if(opMenuCampo == 2) {
			
			Maqueta.eliminarCampo(usuario);
		
		// Asociar un Lote
		}else if(opMenuCampo == 3) {
			
		// Modificar un Lote	
		}else if(opMenuCampo == 4) {
			
		// Eliminar un Lote	
		}else if(opMenuCampo == 5) {
			
		// Volver	
		}else {
			Maqueta.menuUser();
		}
		
	}

	private static void hacienda() {
		
		// Stock Actual / Historial de Bajas / Registrar Bovino / Registrar Jaula
		JOptionPane.showMessageDialog(null, "Aquí se podrá gestionar los servicios de hotelería.\n(Escapan del MVP)");
		
	}

	private static void miCuenta() {
		
		Productor usuario = (Productor)Maqueta.userSesion;
		String misDatos = "";
		misDatos += "Nombre: " + usuario.getNombre() + " " + usuario.getApellido() + "\n";
		misDatos += "Correo: " + usuario.getCorreo() + "\n";
		misDatos += "DNI: " + usuario.getDNI() + "\n";
		misDatos += "CUIT: " + usuario.getCUIT() + "\n";
		misDatos += "Condición Fiscal: " + usuario.getCond() + "\n";
		misDatos += "Teléfono: " + usuario.getTelefono() + "\n";
		misDatos += "Domicilio Fiscal: " + usuario.getDomicilioFiscal() + "\n";
		misDatos += "Pregunta de Seguridad: " + usuario.getPreguntaSeguridad() + "\n";
		
		int opMiCuenta = JOptionPane.showOptionDialog(null, misDatos, "Mi Cuenta", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, new String[] {"Cambiar Contraseña", "Volver"}, "Volver");
		
		if(opMiCuenta == 0) {
			
			Maqueta.cambiarContrasenaLogued();
			
		}else {
			Maqueta.menuUser();
		}
		
	}

	private static void cambiarContrasenaLogued() {
		
		Usuario usuario = Maqueta.userSesion;
		
		String passIngresada = JOptionPane.showInputDialog("Ingresa tu contraseña actual.");
		boolean resCorrecta = false;
		int intentos = 0;
		
		while(!resCorrecta && intentos < 3) {
			if(passIngresada.equalsIgnoreCase(usuario.getContrasena())) {
				
				resCorrecta = true;
				String nuevaPass = "";
				String confirmacion = ".";
				
				while(!nuevaPass.equals(confirmacion)) {
					
					nuevaPass = JOptionPane.showInputDialog("Ingrese su nueva contraseña.");
					
					confirmacion = JOptionPane.showInputDialog("Confirme la contraseña ingresada");
					
					if(!nuevaPass.equals(confirmacion)) {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.\nVuelva a intentar.");
					}
				}
				
				usuario.setContrasena(nuevaPass);
				JOptionPane.showMessageDialog(null, "Se restableció tu contraseña.");
				if( usuario instanceof Productor) {
					
					Maqueta.menuUser();
				}else {
					Maqueta.menuAdmin();
				}
					
			}else {
				intentos++;
				int opCC = JOptionPane.showOptionDialog(null, "La contraseña ingresada no es correcta.\n" + intentos + "/3 intentos",
						"Menu Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
						null, new String[] {"Volver a intentar", "Volver"}, "Volver");
				
				if(opCC == 0) {
					passIngresada = JOptionPane.showInputDialog(usuario.getPreguntaSeguridad());
				}else {
					if( usuario instanceof Productor) {
						
						Maqueta.menuUser();
					}else {
						Maqueta.menuAdmin();
					}
					
				}
			}	
		}
		
		JOptionPane.showMessageDialog(null, "Demasiados intentos, por seguridad de tu cuenta debes volver a ingresar.\nSi has olvidado tu contraseña prueba cambiar tu contraseña con tu pregunta de seguridad.");
		if( usuario instanceof Productor) {
			
			Maqueta.menuUser();
		}else {
			Maqueta.menuAdmin();
		}
		
	}

	// ----------------- Utilidades CRUD ------------------
	private static void registrarCampo(Productor usuario) {
		
		String idCampo = usuario.getCampos() == null ? "1" : String.valueOf(usuario.getCampos().size()+1);
		String nombreCampo = JOptionPane.showInputDialog("Ingrese el nombre del campo");
		String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación del campo");
		int hectareas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las hectareas estimadas del campo \"" + nombreCampo + "\"."));
		
		Campo nuevoCampo = new Campo(idCampo, nombreCampo, ubicacion, hectareas, Integer.parseInt(usuario.getId()));
		
		usuario.getCampos().add(nuevoCampo);
		
		JOptionPane.showMessageDialog(null, "Nuevo campo registrado.");
		Maqueta.campos();
	}
	private static void modificarCampo(Productor usuario) {
		// Listamos los campos
		int count = 0;
		Campo campoAModificar = null;
		String camposUsuario = "Ingrese el nombre del campo a modificar:\n";
		for(Campo campo : usuario.getCampos()) {
			
			camposUsuario += ++count + "_" + campo.getNombre() + "\n";
		}
		
		String nombreCampoModificar = JOptionPane.showInputDialog(camposUsuario);
		
		// Buscamos entre los campos del usuario
		for(Campo campo : usuario.getCampos()) {
			
			if(nombreCampoModificar.equalsIgnoreCase(campo.getNombre())) {
				campoAModificar = campo;
			}
		}
		
		// No se encontró el campo
		if(campoAModificar == null) {
			JOptionPane.showMessageDialog(null, "El campo \"" + nombreCampoModificar + "\" no se encuentra registrado.\nRevise su ortografía");
			Maqueta.campos();
		}else {
		// Modificamos el campo
			String nombreCampo = JOptionPane.showInputDialog("Ingrese el nuevo nombre para el campo " + campoAModificar.getNombre() + " o deje el campo vacío para no modificarlo.");
			String ubicacion = JOptionPane.showInputDialog("Ingrese la nueva ubicación del campo o deje el espacio vacío para no modificarlo.");
			String hectareas = JOptionPane.showInputDialog("Ingrese la nueva cantidad de hectareas del campo o deje el espacio vacío para no modificarlo.");
			
			nombreCampo = nombreCampo.length() == 0 ? campoAModificar.getNombre() : nombreCampo;
			ubicacion = ubicacion.length() == 0 ? campoAModificar.getUbicacion() : ubicacion;
			int parsedHectareas = hectareas.length() == 0 ? campoAModificar.getHectareas() : Integer.parseInt(hectareas);
			
			campoAModificar.setNombre(nombreCampo);
			campoAModificar.setUbicacion(ubicacion);
			campoAModificar.setHectareas(parsedHectareas);
			
			JOptionPane.showMessageDialog(null, "Campo " + campoAModificar.getId() + " modificado.");
			Maqueta.campos();
		}
	}
	private static void eliminarCampo(Productor usuario) {
		// Listamos los campos
		int count = 0;
		Campo campoAEliminar = null;
		String camposUsuario = "Ingrese el nombre del campo a eliminar:\n";
		for(Campo campo : usuario.getCampos()) {
			
			camposUsuario += ++count + "_" + campo.getNombre() + "\n";
		}
		
		String nombreCampoEliminar = JOptionPane.showInputDialog(camposUsuario);
		
		// Buscamos entre los campos del usuario
		for(Campo campo : usuario.getCampos()) {
			
			if(nombreCampoEliminar.equalsIgnoreCase(campo.getNombre())) {
				campoAEliminar = campo;
			}
		}
		
		// No se encontró el campo
		if(campoAEliminar == null) {
			JOptionPane.showMessageDialog(null, "El campo \"" + nombreCampoEliminar + "\" no se encuentra registrado.\nRevise su ortografía");
			Maqueta.campos();
		}else {
			
			// Eliminamos el campo
			usuario.getCampos().remove(campoAEliminar);
			
			JOptionPane.showMessageDialog(null, "Campo " + nombreCampoEliminar + " eliminado.");
			Maqueta.campos();
		}
	}
}
