package modelos;
import java.util.List;

import core.*;

public class ModeloLotes extends Modelo<Lote> {
	
	// Constructor
	public ModeloLotes(String pkTabla, String nomTabla) {
		super(pkTabla, nomTabla);
		// TODO Auto-generated constructor stub
	}
	
	
	// ----------------------- Metodos -----------------------
	@Override
	public List getAll() {
		return null;
	}

	@Override
	public Lote getById(int id) {
		return null;
	}

	@Override
	public int deleteById(int id) {
		return 0;
	}

	@Override
	public int update(Lote lote) {
		return 0;
	}

	@Override
	public int insert(Lote lote) {
		return 0;
	}
	

}
