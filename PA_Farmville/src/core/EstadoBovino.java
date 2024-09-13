package core;

public enum EstadoBovino {
	EN_STOCK("en stock"),
	VENDIDO("vendido"),
	ROBADO("robado"),
	PERDIDO("perdido"),
	MUERTO("muerto"),
	ERROR_CONTABLE("-");
	
    private final String valorInterno;

    private EstadoBovino(String valorInterno) {
        this.valorInterno = valorInterno;
    }

    public String getValorInterno() {
        return this.valorInterno;
    }
}
