package controladores;

import core.*;
import modelos.*;

public abstract class Controlador<T> {

	private T modelo;
	protected static Usuario usuarioEnSesion;
	
	public Controlador(T modelo) {
		
		this.modelo = modelo;
		this.usuarioEnSesion = null;
	}

	public T getModelo() {
		return modelo;
	}

	public void setModelo(T modelo) {
		this.modelo = modelo;
	}

	public Usuario getUsuarioEnSesion() {
		return usuarioEnSesion;
	}

	public void setUsuarioEnSesion(Usuario usuarioEnSesion) {
		this.usuarioEnSesion = usuarioEnSesion;
	}
	
	
}
