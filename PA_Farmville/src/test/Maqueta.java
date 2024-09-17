package test;
import core.*;
import modelos.*;
import controladores.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import javax.swing.JOptionPane;


public class Maqueta {
	
	static List<Usuario> usuariosRegistrados = new LinkedList<Usuario>();
	static int userCount = 2;
	static Usuario userSesion = null;
	
	// ------------------------------------------------------------ Main ------------------------------------------------------------
	public static void main(String[] args) {
		
		// Usuarios Test
		Productor productorTest = new Productor("1", "Dasigo", "Szkamarda", "user@hotmail.com", "user123",
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
	
	// Funciones Principales
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
		JOptionPane.showMessageDialog(null, "Aquí se podrá gestionar los servicios de hotelería.\n(Funcionalidad que escapa del MVP)");
		Maqueta.menuUser();
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
				
				listadoCampos += ++count1 + "_" + campo.getNombre() + " - " + campo.getUbicacion() 
				+ " - " + campo.getHectareas() + " hectareas";
				
				// Si tiene lotes asociados
				if(campo.getLotes() != null && !campo.getLotes().isEmpty()) {
					// Añadimos los lotes del campo
					listadoCampos += " | Lotes: ";
					String listadoLotes = "";
					for(Lote lote : campo.getLotes()) {
						listadoLotes += lote.getNumero() + ", ";
					}
					listadoLotes = listadoLotes.substring(0, listadoLotes.length()-2);
					listadoCampos += listadoLotes + "\n";
				}else {
					listadoCampos += "\n";
				}
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
			if(usuario.getCampos() == null || usuario.getCampos().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No tienes campos registrados que modificar, prueba registrar uno primero.");
				Maqueta.campos();
			}else {	
				Maqueta.modificarCampo(usuario);
			}
			
		// Eliminar un campo	
		}else if(opMenuCampo == 2) {
			// Validaciones
			if(usuario.getCampos() == null || usuario.getCampos().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No tienes campos registrados que eliminar, prueba registrar uno primero.");
				Maqueta.campos();
			}else {				
				Maqueta.eliminarCampo(usuario);
			}
		
		// Asociar un Lote
		}else if(opMenuCampo == 3) {
			
			// Validaciones
			if(usuario.getCampos() == null || usuario.getCampos().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No tienes campos registrados (por lo que no puedes asociar lotes), prueba registrar uno primero.");
				Maqueta.campos();
			}else {
				// Seleccionamos el campo al que se asociará el lote
				int numCampo = Maqueta.listarCampos("Ingrese el número del campo al que desea asociarle un nuevo lote:\n");
				Campo campoSeleccionado = Maqueta.buscarCampoPorNum(numCampo);
				if(campoSeleccionado.getLotes() == null) {
					campoSeleccionado.setLotes(new LinkedList<Lote>());
				}
				
				// Creamos un nuevo lote
				String id = campoSeleccionado.getLotes().isEmpty() ? "1" : String.valueOf(campoSeleccionado.getLotes().size());
				String numero = JOptionPane.showInputDialog("Ingrese el número u nombre del lote.");
				int hectareas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de hectareas del lote " + numero));
				int fk_campo = Integer.parseInt(campoSeleccionado.getId());
				Lote nuevoLote = new Lote(id, numero, hectareas, fk_campo);
				
				// Asociamos el lote al campo
				campoSeleccionado.getLotes().add(nuevoLote);
				Maqueta.campos();
			}
			
			
		// Modificar un Lote	
		}else if(opMenuCampo == 4) {
			
			if(usuario.getCampos() == null || usuario.getCampos().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No tienes campos registrados (por lo que tampoco lotes), prueba registrar uno primero.");
				Maqueta.campos();
			}else {
				// Seleccionamos el campo al que pertenece el lote
				int numCampo = Maqueta.listarCampos("Ingrese el número de campo al que pertenece el lote:\n");
				Campo campoSeleccionado = usuario.getCampos().get(numCampo-1);
				if(campoSeleccionado.getLotes() == null || campoSeleccionado.getLotes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El campo seleccionado aún no tiene lotes asociados para modificar.\nPrueba asociar uno.");
					Maqueta.campos();
				}else {
					// Seleccionamos el lote a modificar
					Lote loteSeleccionado = null;
					while(loteSeleccionado == null) {				
						String numLote = Maqueta.listarLotes(campoSeleccionado, "Ingrese el número de lote que desea modificar");
						loteSeleccionado = Maqueta.buscarLotePorNumero(campoSeleccionado, numLote);
					}
					// Modificamos los datos del lote
					Maqueta.modificarLote(loteSeleccionado);
					Maqueta.campos();
				}
			}
			
		// Eliminar un Lote	
		}else if(opMenuCampo == 5) {
			
			if(usuario.getCampos() == null || usuario.getCampos().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No tienes campos registrados (por lo que tampoco lotes), prueba registrar uno primero.");
				Maqueta.campos();
			}else {
				// Seleccionamos el campo al que pertenece el lote
				int numCampo = Maqueta.listarCampos("Ingrese el número de campo al que pertenece el lote:\n");
				Campo campoSeleccionado = usuario.getCampos().get(numCampo-1);
				if(campoSeleccionado.getLotes() == null || campoSeleccionado.getLotes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El campo seleccionado aún no tiene lotes asociados para modificar.\nPrueba asociar uno.");
					Maqueta.campos();
				}else {
					// Seleccionamos el lote a modificar
					Lote loteSeleccionado = null;
					while(loteSeleccionado == null) {				
						String numLote = Maqueta.listarLotes(campoSeleccionado, "Ingrese el número de lote que desea eliminar");
						loteSeleccionado = Maqueta.buscarLotePorNumero(campoSeleccionado, numLote);
					}
					
					String numLote = loteSeleccionado.getNumero();
					campoSeleccionado.getLotes().remove(loteSeleccionado);
					JOptionPane.showMessageDialog(null, "Lote " + numLote + " eliminado");
					Maqueta.campos();
				}
				
			}
			
			
			
		// Volver	
		}else {
			Maqueta.menuUser();
		}
		
	}

	private static void hacienda() {
		 
		// Stock Actual --> Registrar Bovino / Modificar Bovino / Eliminar Bovino / Registrar Jaula
		// Historial de Bajas --> Recuperar Bovino
		Productor usuario = (Productor)Maqueta.userSesion;
		String listaStock = Maqueta.listarStock(usuario);
		
		int opMenuBovino = JOptionPane.showOptionDialog(null, listaStock, "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, new String[] {"Registrar Bovino", "Modificar Bovino","Eliminar Bovino","Registrar Jaula", "Historial de Bajas", "Volver"}, "Volver");
		
		// Registrar Bovino
		if(opMenuBovino == 0) {
			
			Maqueta.registrarBovino(usuario);
			
		// Modificar Bovino	
		}else if(opMenuBovino == 1) {
			
			// Validaciones
			if(Maqueta.devolverStockActual(usuario).isEmpty()) {
				JOptionPane.showMessageDialog(null, "No tienes bovinos en tu stock actual para modificar."
						+ "\nPrueba registrar uno, o recuperar uno de tu historial de bajas.");
				Maqueta.hacienda();
			}else {
				
				Maqueta.modificarBovino(usuario);
				
			}
			
		// Eliminar Bovino	
		}else if(opMenuBovino == 2) {
			
			// Validaciones
			if(Maqueta.devolverStockActual(usuario).isEmpty()) {
				JOptionPane.showMessageDialog(null, "No tienes bovinos en tu stock actual para eliminar."
						+ "\nPrueba registrar uno, o recuperar uno de tu historial de bajas.");
				Maqueta.hacienda();
			}else {
				
				Maqueta.eliminarBovino(usuario);
			}
			
		// Registrar Jaula	
		}else if(opMenuBovino == 3) {
			
			Maqueta.registrarJaula(usuario);
			
		// Historial de Bajas		
		}else if(opMenuBovino == 4) {
			
			Maqueta.historialDeBajas(usuario);
			
		}else {
			
			Maqueta.menuUser();
		}
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
					passIngresada = JOptionPane.showInputDialog("Ingresa tu contraseña actual.");
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
	// Campos
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
		
		if(usuario.getCampos() == null || usuario.getCampos().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Aún no tienes campos registrados.\nPrueba registrar uno primero.");
			Maqueta.campos();
		}
		
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

		if(usuario.getCampos() == null || usuario.getCampos().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Aún no tienes campos registrados.\nPrueba registrar uno primero.");
			Maqueta.campos();
		}
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

	
	private static int listarCampos(String enunciado) {
		
		Productor usuario = (Productor)Maqueta.userSesion;
		// Listamos los campos
		int count = 0;
		String camposUsuario = enunciado;
		for(Campo campo : usuario.getCampos()) {
			
			camposUsuario += ++count + "_" + campo.getNombre() + "\n";
		}
		
		int numCampo = 0;
		boolean numValido = false;
		
		while(!numValido) {
			
			String campo = JOptionPane.showInputDialog(camposUsuario);
			try {
				numCampo = Integer.parseInt(campo);
				if(numCampo > usuario.getCampos().size()) {
					throw new NumberFormatException();
				}
				numValido = true;
			}catch(NumberFormatException e) {
				
				JOptionPane.showMessageDialog(null, "El valor ingresado debe ser un número y debe corresponder a un campo existente.");
			}
			
		}
		
		return numCampo;
	}
	private static Campo buscarCampoPorNum(int numCampo) {
		
		Productor usuario = (Productor)Maqueta.userSesion;
		
		return usuario.getCampos().get(numCampo-1);
	}
	
	// Lotes
	private static String listarLotes(Campo campo, String enunciado) {
		
		String listaLotes = "";
		for(Lote lote : campo.getLotes()) {
			
			listaLotes += "Lote: "+lote.getNumero() + "\n";
		}
		
		String numLote = JOptionPane.showInputDialog(enunciado + "\n" + listaLotes);
		
		return numLote;
	}
	private static Lote buscarLotePorNumero(Campo campo, String numLote) {
		
		for(Lote lote : campo.getLotes()) {
			
			if(numLote.equalsIgnoreCase(lote.getNumero())) {
				return lote;
			}
		}
		
		JOptionPane.showMessageDialog(null, "El número de lote ingresado no corresponde a ningún lote registrado.\nInténtelo nuevamente");
		
		return null;
	}
	private static void modificarLote(Lote loteSeleccionado) {
	
		/* (String id, String numero, int hectareas,int fk_campo*/
		String nuevoNumero = JOptionPane.showInputDialog("Ingrese el nuevo número de lote o deje el campo vacío para no modificarlo");
		String nuevasHectareas = JOptionPane.showInputDialog("Ingrese el nuevo número de hectareas o deje el campo vacío para no modificarlo");
		nuevoNumero = nuevoNumero.length() == 0 ? loteSeleccionado.getNumero() : nuevoNumero;
		int inthectareas = nuevasHectareas.length() == 0 ? loteSeleccionado.getHectareas() : Integer.parseInt(nuevasHectareas); 
		
		loteSeleccionado.setNumero(nuevoNumero);
		loteSeleccionado.setHectareas(inthectareas);
		
		JOptionPane.showMessageDialog(null, "Lote " + loteSeleccionado.getNumero() + " modificado con éxito.");
	}

	// Bovinos
	private static String listarStock(Productor usuario) {
		
		String listaBovinos = "";
		
		// Si tiene bovinos registrados
		if(usuario.getBovinos() != null) {
			for(Bovino bovino : usuario.getBovinos()) {
				
				// Si el bovino esta en el stock
				if(bovino.getEstado().equalsIgnoreCase(EstadoBovino.EN_STOCK.getValorInterno())) {
					listaBovinos += "Bovino n°" + bovino.getId() + " | " + bovino.getCategoria() + " | " + bovino.getRaza() + " | " + bovino.getPeso() + "kg | " 
							+ bovino.getEdad() + " años" + "\n";
				}
			}
		// Si nunca registró un bovino
		}else if(usuario.getBovinos() == null) {
			
			usuario.setBovinos(new LinkedList<Bovino>());
			listaBovinos = "Aún no tienes bovinos registrados en tu stock...";
			
		// Si su stock esta vacío
		}else if(usuario.getBovinos().isEmpty()) {
			
			listaBovinos = "Tu stock se encuentra vacío.";
		}
		
		return listaBovinos;		
	}
	private static void registrarBovino(Productor usuario) {
		
		try {
			// Datos del Nuevo Bovino
			// id
			String id = String.valueOf(usuario.getBovinos().size());
			// caravana
			int caravana = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de caravana (solo números)"));
			// categoria
			String[] opcionesCat = {
					CategoriaBovino.TERNERA.getValorInterno(),
					CategoriaBovino.TERNERO.getValorInterno(),
					CategoriaBovino.NOBILLO.getValorInterno(),
					CategoriaBovino.VAQUILLA.getValorInterno(),
					CategoriaBovino.VACA.getValorInterno(),
					CategoriaBovino.TORO.getValorInterno(),};
			int opCat = JOptionPane.showOptionDialog(null, "Seleccione una categoría", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
					null, opcionesCat, opcionesCat[0]);
			String categoria = opcionesCat[opCat];
			// raza
			String[] opcionesRaza = {
					RazaBovino.ANGUS.getValorInterno(),
					RazaBovino.BRAFORD.getValorInterno(),
					RazaBovino.BRAHMAN.getValorInterno(),
					RazaBovino.BRANGUS.getValorInterno(),
					RazaBovino.CRIOLLO.getValorInterno(),
					RazaBovino.HEREFORD.getValorInterno(),
					RazaBovino.LIMOUSIN.getValorInterno(),
			};
			int opRaza = JOptionPane.showOptionDialog(null, "Seleccione una raza", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
					null, opcionesRaza, opcionesRaza[0]);
			String raza = opcionesRaza[opRaza];
			// sexo
			String sexo = "";
			if(categoria.equals(CategoriaBovino.TERNERA.getValorInterno()) || categoria.equals(CategoriaBovino.VAQUILLA.getValorInterno())
					|| categoria.equals(CategoriaBovino.VACA.getValorInterno())) {
				sexo = Sexo.HEMBRA.getValorInterno();
			}else {
				sexo = Sexo.MACHO.getValorInterno();
			}
			// edad
			int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del bovino (solo números)."));
			double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del bovino "+ id +" (solo números)"));
			// Lote (escapa del MVP)
			Lote lote = null;
			// Fecha adquisición
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String stringFecha = JOptionPane.showInputDialog("Ingrese la fecha de adquisición \"dd/MM/yyyy\" (Ejemplo 17/09/2024):");
			LocalDate fechaAdquisicion = LocalDate.parse(stringFecha, formatter);
			// Origen
			String[] opcionesOrigen = {
					Origen.PROPIO.getValorInterno(),
					Origen.COMPRA.getValorInterno(),
					Origen.ENGORDE.getValorInterno(),					
			};
			int opOrigen = JOptionPane.showOptionDialog(null, "¿Cuál es el origen del bovino?", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
					null, opcionesOrigen, opcionesOrigen[0]);
			String origen = opcionesOrigen[opOrigen];
			// Vacuna Aftosa
			int opAftosa = JOptionPane.showConfirmDialog(null, "¿Fué vacunado contra la aftosa?", "Registro Bovino", JOptionPane.YES_NO_OPTION);
			boolean vacunaAftosa = opAftosa == JOptionPane.YES_OPTION ? true : false;
			LocalDate fechaAftosa = LocalDate.now();
			// Vacuna Brucelosis
			int opBrucelosis = JOptionPane.showConfirmDialog(null, "¿Fué vacunado contra la brucelosis?", "Registro Bovino", JOptionPane.YES_NO_OPTION);
			boolean vacunBrucelosis = opAftosa == JOptionPane.YES_OPTION ? true : false;
			LocalDate fechaBrucelosis = LocalDate.now();
			// Estado y usuario asociado
			String estado = EstadoBovino.EN_STOCK.getValorInterno();
			int fk_usuario = Integer.parseInt(usuario.getId());
			
			// Registramos el nuevo bovino
			Bovino nuevoBovino = new Bovino(id, caravana, categoria, raza, sexo, edad, peso, lote, fechaAdquisicion, origen,
					vacunaAftosa, fechaAftosa, vacunBrucelosis, fechaBrucelosis, estado, fk_usuario);
			usuario.getBovinos().add(nuevoBovino);
			JOptionPane.showMessageDialog(null, "Bovino " + nuevoBovino.getId() + " registrado.");
			Maqueta.hacienda();
			
		} catch (NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Ingresó un caracter que no es un número.\n"
					+ "Debe respetar el tipo de dato especificado para registrar un bovino.");
			Maqueta.hacienda();
		} catch (DateTimeParseException e2) {
			
			JOptionPane.showMessageDialog(null, "El formato de fecha ingresado no es válido, intentelo nuevamente.");
			Maqueta.hacienda();
		}
		
	}
	private static List<Bovino> devolverStockActual(Productor usuario){

		List<Bovino> stock = new LinkedList<>();
		
		for(Bovino bovino : usuario.getBovinos()) {
			
			if(bovino.getEstado().equalsIgnoreCase(EstadoBovino.EN_STOCK.getValorInterno())) {
				stock.add(bovino);
			}
		}
		
		return stock;
	}
	private static void modificarBovino(Productor usuario) {
		
		int volverIntentar = -100;
		Bovino bovino = null;
		
		// Recuperamos el bovino con su ID
		while(bovino == null && volverIntentar != JOptionPane.YES_OPTION) {
			String listaStock = Maqueta.listarStock(usuario);
			String idBovino = JOptionPane.showInputDialog("Ingrese el \"id\" del bovino que desea movidicar:\n"+listaStock);
			bovino = Maqueta.buscarBovino(idBovino, usuario.getBovinos());
			if(bovino == null) {
				volverIntentar = JOptionPane.showConfirmDialog(null, "El bovino con id \"" + idBovino + "\" no se encuentra en tu stock.\n"
						+ "¿Quiere intentar ingresarlo nuevamente?", "Modificar Bovino", JOptionPane.YES_NO_OPTION);
				if(volverIntentar == JOptionPane.YES_OPTION) {				
					idBovino = JOptionPane.showInputDialog("Ingrese el \"id\" del bovino que desea movidicar:\n"+listaStock);
				}else {
					Maqueta.hacienda();
				}
			}
		}
		
		// Modificamos los datos
		try {
			// caravana
			String sCaravana = JOptionPane.showInputDialog("Ingrese el nuevo número de caravana (solo números)"
					+ "\nO deje el campo vacío para no modificar la caravana.");
			int caravana = sCaravana.length() == 0 ? bovino.getCaravana() : Integer.parseInt(sCaravana);
			// categoria
			String[] opcionesCat = {
					CategoriaBovino.TERNERA.getValorInterno(),
					CategoriaBovino.TERNERO.getValorInterno(),
					CategoriaBovino.NOBILLO.getValorInterno(),
					CategoriaBovino.VAQUILLA.getValorInterno(),
					CategoriaBovino.VACA.getValorInterno(),
					CategoriaBovino.TORO.getValorInterno(),
					"No modificar"};
			int opCat = JOptionPane.showOptionDialog(null, "Seleccione una nueva categoría u \"No modificar\"", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
					null, opcionesCat, opcionesCat[0]);
			String categoria = opcionesCat[opCat];
			categoria = categoria.equalsIgnoreCase("No modificar") ? bovino.getCategoria() : categoria;
			// raza
			String[] opcionesRaza = {
					RazaBovino.ANGUS.getValorInterno(),
					RazaBovino.BRAFORD.getValorInterno(),
					RazaBovino.BRAHMAN.getValorInterno(),
					RazaBovino.BRANGUS.getValorInterno(),
					RazaBovino.CRIOLLO.getValorInterno(),
					RazaBovino.HEREFORD.getValorInterno(),
					RazaBovino.LIMOUSIN.getValorInterno(),
					"No modificar"
			};
			int opRaza = JOptionPane.showOptionDialog(null, "Seleccione una raza u \"No modificar\"", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
					null, opcionesRaza, opcionesRaza[0]);
			String raza = opcionesRaza[opRaza];
			raza = raza.equalsIgnoreCase("No modificar") ? bovino.getRaza() : raza;
			// sexo
			String sexo = "";
			if(categoria.equals(CategoriaBovino.TERNERA.getValorInterno()) || categoria.equals(CategoriaBovino.VAQUILLA.getValorInterno())
					|| categoria.equals(CategoriaBovino.VACA.getValorInterno())) {
				sexo = Sexo.HEMBRA.getValorInterno();
			}else {
				sexo = Sexo.MACHO.getValorInterno();
			}
			// edad
			String sEdad = JOptionPane.showInputDialog("Ingrese la edad del bovino (solo números)"
					+ "\n o deje el campo vacío si no quiere modificar su edad actual ("+bovino.getEdad()+")");
			int edad = sEdad.length() == 0 ? bovino.getEdad() : Integer.parseInt(sEdad);
			String sPeso = JOptionPane.showInputDialog("Ingrese el peso del bovino "+ bovino.getId() +" (solo números)"
					+ "\n o deje el campo vacío para no modificar su peso actual ("+bovino.getPeso()+").");
			double peso = sPeso.length() == 0 ? bovino.getPeso() : Double.parseDouble(sPeso);
			// Lote (escapa del MVP)
			Lote lote = null;
			// Fecha adquisición
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String stringFecha = JOptionPane.showInputDialog("Ingrese la fecha de adquisición \"dd/MM/yyyy\" (Ejemplo 17/09/2024)"
					+ "\n o deje el campo vacío para no modificar la fecha actual ("+bovino.getFechaAdquisicion().format(formatter)+")");
			LocalDate fechaAdquisicion = stringFecha.length()==0 ? bovino.getFechaAdquisicion() : LocalDate.parse(stringFecha, formatter);
			// Origen
			String[] opcionesOrigen = {
					Origen.PROPIO.getValorInterno(),
					Origen.COMPRA.getValorInterno(),
					Origen.ENGORDE.getValorInterno(),
					"No modificar"					
			};
			int opOrigen = JOptionPane.showOptionDialog(null, "¿Cuál es el origen del bovino?", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
					null, opcionesOrigen, opcionesOrigen[0]);
			String origen = opcionesOrigen[opOrigen];
			origen = origen.equalsIgnoreCase("No modificar") ? bovino.getOrigen() : origen;
			// Vacuna Aftosa
			String vacunado = bovino.isVacunaAftosa() ? "\n(El valor actual es vacunado para aftosa)" : "\n(Actualmente no se registró vacuna de aftosa)";
			int opAftosa = JOptionPane.showConfirmDialog(null, "¿Fué vacunado contra la aftosa?"+vacunado, "Registro Bovino", JOptionPane.YES_NO_OPTION);
			boolean vacunaAftosa = opAftosa == JOptionPane.YES_OPTION ? true : false;
			LocalDate fechaAftosa = LocalDate.now();
			// Vacuna Brucelosis
			vacunado = bovino.isVacunaBrucelosis() ? "\n(El valor actual es vacunado para brucelosis)" : "\n(Actualmente no se registró vacuna de brucelosis)";
			int opBrucelosis = JOptionPane.showConfirmDialog(null, "¿Fué vacunado contra la brucelosis?"+vacunado, "Registro Bovino", JOptionPane.YES_NO_OPTION);
			boolean vacunBrucelosis = opAftosa == JOptionPane.YES_OPTION ? true : false;
			LocalDate fechaBrucelosis = LocalDate.now();
			// Estado y usuario asociado
			String[] opcionesEstado = {
					EstadoBovino.EN_STOCK.getValorInterno(),
					EstadoBovino.MUERTO.getValorInterno(),
					EstadoBovino.PERDIDO.getValorInterno(),
					EstadoBovino.ROBADO.getValorInterno(),
					EstadoBovino.VENDIDO.getValorInterno()
			};
			int opEstado = JOptionPane.showOptionDialog(null, "¿Desea actualizar el estado del bovino?"
					+ "\nActualmente se encuentra registrado en el stock actual."
					+ "\n(Cambiar su estado lo moverá del stock al historial de bajas)", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
					null, opcionesEstado, opcionesEstado[0]);
			String estado = opcionesEstado[opEstado];
			
			// Modificamos los datos
			bovino.setCaravana(caravana);
			bovino.setCategoria(categoria);
			bovino.setRaza(raza);
			bovino.setSexo(sexo);
			bovino.setEdad(edad);
			bovino.setPeso(peso);
			bovino.setFechaAdquisicion(fechaAdquisicion);
			bovino.setOrigen(origen);
			bovino.setVacunaAftosa(vacunaAftosa);
			bovino.setFechaAftosa(fechaAftosa);
			bovino.setVacunaBrucelosis(vacunBrucelosis);
			bovino.setFechaBrucelosis(fechaBrucelosis);
			bovino.setEstado(estado);
			
			JOptionPane.showMessageDialog(null, "Bovino " + bovino.getId() + " modificado.");
			Maqueta.hacienda();
			
		}  catch (NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Ingresó un caracter que no es un número.\n"
					+ "Debe respetar el tipo de dato especificado para registrar un bovino.");
			Maqueta.hacienda();
		} catch (DateTimeParseException e2) {
			
			JOptionPane.showMessageDialog(null, "El formato de fecha ingresado no es válido, intentelo nuevamente.");
			Maqueta.hacienda();
		}
		
		
	}
	private static Bovino buscarBovino(String idBovino, List<Bovino> bovinos) {
		
		for(Bovino bovino : bovinos){
			if(bovino.getId().equalsIgnoreCase(idBovino)) {
				return bovino;
			}
		}
		
		return null;
	}
	private static void eliminarBovino(Productor usuario) {
		
		int volverIntentar = -100;
		Bovino bovino = null;
		
		// Recuperamos el bovino con su ID
		while(bovino == null && volverIntentar != JOptionPane.YES_OPTION) {
			String listaStock = Maqueta.listarStock(usuario);
			String idBovino = JOptionPane.showInputDialog("Ingrese el número (n°) del bovino que desea eliminar:\n"+listaStock);
			bovino = Maqueta.buscarBovino(idBovino, usuario.getBovinos());
			if(bovino == null) {
				volverIntentar = JOptionPane.showConfirmDialog(null, "El bovino con id \"" + idBovino + "\" no se encuentra en tu stock.\n"
						+ "¿Quiere intentar ingresarlo nuevamente?", "Modificar Bovino", JOptionPane.YES_NO_OPTION);
				if(volverIntentar == JOptionPane.YES_OPTION) {				
					idBovino = JOptionPane.showInputDialog("Ingrese el \"id\" del bovino que desea movidicar:\n"+listaStock);
				}else {
					Maqueta.hacienda();
				}
			}
		}
		
		
		// Registramos la causa de la baja
		String[] opcionesEstado = {
				EstadoBovino.MUERTO.getValorInterno(),
				EstadoBovino.PERDIDO.getValorInterno(),
				EstadoBovino.ROBADO.getValorInterno(),
				EstadoBovino.VENDIDO.getValorInterno(),
				"Error de registro"
		};
		int opEstado = JOptionPane.showOptionDialog(null, "¿Cuál es la causa de la baja del bovino?"
				+ "\n(Si seleccionas \"Error de registro\" no se moverá al historial de bajas, sinó que se eliminará completamente)", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, opcionesEstado, opcionesEstado[0]);
		String estado = opcionesEstado[opEstado];
		
		// Eliminamos
		if(estado.equalsIgnoreCase("Error de registro")) {
			
			usuario.getBovinos().remove(bovino);
			JOptionPane.showMessageDialog(null, "El bovino fué eliminado completamente de tus registros.");
			Maqueta.hacienda();
		}else {
			
			bovino.setEstado(estado);
			JOptionPane.showMessageDialog(null, "El bovino "+bovino.getId()+" se marcó como "+estado+" y ya no aparecerá en tu stock actual."
					+ "\n(El registro permanecerá en tu historial de bajas)");
			Maqueta.hacienda();
		}
	}
	private static void registrarJaula(Productor usuario) {
		
		List<Bovino> jaula = new LinkedList<Bovino>();
		int registrarOtro = JOptionPane.YES_OPTION;
		boolean primerRegistro = true;
		LocalDate fechaAdquisicion = LocalDate.now();
		
		/*String categoria,double peso, LocalDate fechaAdquisicion, int fk_usuario*/
		while(registrarOtro == JOptionPane.YES_OPTION) {
			try {
				// categoria
				String[] opcionesCat = {
						CategoriaBovino.TERNERA.getValorInterno(),
						CategoriaBovino.TERNERO.getValorInterno(),
						CategoriaBovino.NOBILLO.getValorInterno(),
						CategoriaBovino.VAQUILLA.getValorInterno(),
						CategoriaBovino.VACA.getValorInterno(),
						CategoriaBovino.TORO.getValorInterno(),};
				int opCat = JOptionPane.showOptionDialog(null, "Seleccione una categoría para registrar un grupo de la jaula", "Menu Bovinos", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
						null, opcionesCat, opcionesCat[0]);
				String categoria = opcionesCat[opCat];
				
				// cantidad
				int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de " + categoria + "s de la jaula"));
				
				// peso promedio
				double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso PROMEDIO de los/as " + categoria + "s"));
				
				// fecha adquisición
				if(primerRegistro) {					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String stringFecha = JOptionPane.showInputDialog("Ingrese la fecha de adquisición de la jaula \"dd/MM/yyyy\" (Ejemplo 17/09/2024):");
					fechaAdquisicion = LocalDate.parse(stringFecha, formatter);
					primerRegistro = false;
				}
				
				for(int i=0; i<cantidad; i++) {
					Bovino nuevoBovino = new Bovino(categoria, peso, fechaAdquisicion, Integer.parseInt(usuario.getId()));
					nuevoBovino.setId(String.valueOf(usuario.getBovinos().size() + jaula.size()));
					jaula.add(nuevoBovino);
				}
				
				registrarOtro = JOptionPane.showConfirmDialog(null, "¿Quieres registrar otro grupo en la misma jaula?", "Registro Jaula", JOptionPane.YES_NO_OPTION);
				
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El formato del dato ingresado no es válido."
						+ "\nVuelva a intentarlo respetando lo que se le especifica.");
				Maqueta.hacienda();
			}
			
		}
		
		for(Bovino bovino : jaula) {
			usuario.getBovinos().add(bovino);
		}
		JOptionPane.showMessageDialog(null, "Jaula registrada.\nRevisa tu stock actual para ver los nuevos registros.");
		Maqueta.hacienda();
		
		
	}
	private static void historialDeBajas(Productor usuario) {
		
		String listaBajas = Maqueta.getHistorialDeBajas(usuario);
		int opMenuBajas = JOptionPane.showOptionDialog(null, listaBajas, "Campos",
				JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, new String[] {"Recuperar Bovino", "Volver"}, "Volver");
		
		// Recuperar Bovino
		if(opMenuBajas == 0) {
			Maqueta.recuperarBovino(usuario);
		// Volver	
		}else {
			Maqueta.hacienda();
		}
		
	}
	private static String getHistorialDeBajas(Productor usuario) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String listaBajas = "";
		// Si tiene bovinos registrados
		if(!usuario.getBovinos().isEmpty()) {
			for(Bovino bovino : usuario.getBovinos()) {
				
				// Si el bovino esta en el stock
				if(!bovino.getEstado().equalsIgnoreCase(EstadoBovino.EN_STOCK.getValorInterno())) {
					listaBajas += "Bovino n°" + bovino.getId() + " | Caravana: " + bovino.getCaravana() 
					+ " | Causa de baja: " + bovino.getEstado() + " | Fecha: " + bovino.getFechaAdquisicion().format(formatter) + "\n";
				}
			}
			return listaBajas;
		// Si nunca registró un bovino
		}else {
			
			return "No tienes ningún bovino en tu historial de bajas aún.";
		}
	}
	private static void recuperarBovino(Productor usuario) {
		
		String listaBajas = getHistorialDeBajas(usuario);
		String idBovino = JOptionPane.showInputDialog("Ingresa el número (n°) del bovino a recuperar:\n" + listaBajas);
		
		Bovino bovinoRecuperar = buscarBovino(idBovino, usuario.getBovinos());
		bovinoRecuperar.setEstado(EstadoBovino.EN_STOCK.getValorInterno());
		JOptionPane.showMessageDialog(null, "Se movió el bovino " + bovinoRecuperar.getId() + " nuevamente a tu stock.");
		Maqueta.historialDeBajas(usuario);
	}
}
