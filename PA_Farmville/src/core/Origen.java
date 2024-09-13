package core;

public enum Origen {
	PROPIO("propio"),
	COMPRA("compra"),
	ENGORDE("engorde");
	
    private final String valorInterno;

    private Origen(String valorInterno) {
        this.valorInterno = valorInterno;
    }

    public String getValorInterno() {
        return this.valorInterno;
    }
}
