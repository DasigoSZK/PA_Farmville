package modelos;
import java.time.*;
import java.util.List;
import core.*;


public class ModeloBovino extends Modelo<Bovino>{

	// Constructor
	public ModeloBovino(String pkTabla, String nomTabla) {
		super(pkTabla, nomTabla);
	}

	
	
	// ---------------------------- Métodos ----------------------------
	@Override
	public List getAll() {
		return null;
	}

	@Override
	public Bovino getById(int id) {
		return null;
	}

	@Override
	public int deleteById(int id) {
		return 0;
	}

	@Override
	public int update(Bovino bovino) {
		return 0;
	}

	@Override
	public int insert(Bovino bovino) {
		return 0;
	}
	
	

	


}
