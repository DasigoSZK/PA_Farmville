package modelos;
import java.sql.*;
import java.util.*;

import core.*;

public abstract class Modelo<T> {

	private String pkTabla;
	private String nomTabla;
	private Connection miConexion;
	
	// Constructor
	public Modelo(String pkTabla, String nomTabla) {
		this.pkTabla = pkTabla;
		this.nomTabla = nomTabla;
		this.miConexion = Conexion.getConexion();
	}
	
	// Métodos abstractos
	public abstract List<T> getAll();
	
	public abstract T getById(int id);
	
	public abstract int deleteById(int id);
	
	public abstract int update(T object);
	
	public abstract int insert(T object);
	
}
