package core;

public enum Sexo {
	MACHO("macho"),
	HEMBRA("hembra");
	
    private final String valorInterno;

    private Sexo(String valorInterno) {
        this.valorInterno = valorInterno;
    }

    public String getValorInterno() {
        return this.valorInterno;
    }
}
