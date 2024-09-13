package modelos;
import java.util.List;

import core.*;

public class ModeloUsuarios extends Modelo<Usuario> {
	
	// Constructor
	public ModeloUsuarios(String pkTabla, String nomTabla) {
		super(pkTabla, nomTabla);
		// TODO Auto-generated constructor stub
	}
	
	
	
	// ----------------------- Metodos -----------------------
	@Override
	public List getAll() {
		return null;
	}

	@Override
	public Usuario getById(int id) {
		return null;
	}

	@Override
	public int deleteById(int id) {
		return 0;
	}

	@Override
	public int update(Usuario usuario) {
		return 0;
	}

	@Override
	public int insert(Usuario usuario) {
		return 0;
	}


}
