package modelos;

public class Administrador extends Usuario{

	public Administrador(Integer id, String nombre, String apellido, String correo, String contrasena,
			String preguntaSeguridad, String respuestaSeguridad) {
		super(id, nombre, apellido, correo, contrasena, preguntaSeguridad, respuestaSeguridad);
	}

}
