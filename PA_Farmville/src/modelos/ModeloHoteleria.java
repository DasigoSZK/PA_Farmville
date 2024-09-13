package modelos;
import java.time.LocalDate;
import java.util.List;

import core.*;

public class ModeloHoteleria extends Modelo<Hoteleria>{
	
	// Constructor
	public ModeloHoteleria(String pkTabla, String nomTabla) {
		super(pkTabla, nomTabla);
		// TODO Auto-generated constructor stub
	}
	
	
	// ----------------------- Metodos -----------------------
	@Override
	public List getAll() {
		return null;
	}

	@Override
	public Hoteleria getById(int id) {
		return null;
	}

	@Override
	public int deleteById(int id) {
		return 0;
	}

	@Override
	public int update(Hoteleria hoteleria) {
		return 0;
	}

	@Override
	public int insert(Hoteleria hoteleria) {
		return 0;
	}


}
