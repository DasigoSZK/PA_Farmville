package modelos;

public enum CondicionFiscal {
	
	MONOTRIBUTISTA("monotributista"),
	RESPONSABLE_INSCRIPTO("responsable inscripto"),
	EXENTO("exento");
	
    private final String valorInterno;

    private CondicionFiscal(String valorInterno) {
        this.valorInterno = valorInterno;
    }

    public String getValorInterno() {
        return this.valorInterno;
    }
}
