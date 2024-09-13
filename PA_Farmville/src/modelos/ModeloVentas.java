package modelos;
import java.time.LocalDate;
import java.util.List;

import core.*;

public class ModeloVentas extends Modelo<Venta>{
	
	// Constructor
	public ModeloVentas(String pkTabla, String nomTabla) {
		super(pkTabla, nomTabla);
		// TODO Auto-generated constructor stub
	}
	
	
	
	// ----------------------- Metodos -----------------------
	@Override
	public List getAll() {
		return null;
	}

	@Override
	public Venta getById(int id) {
		return null;
	}

	@Override
	public int deleteById(int id) {
		return 0;
	}

	@Override
	public int update(Venta venta) {
		return 0;
	}

	@Override
	public int insert(Venta venta) {
		return 0;
	}
	


}
