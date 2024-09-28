package modelos;

public enum CategoriaBovino {

	TERNERO("ternero"),
	TERNERA("ternera"),
	NOBILLO("nobillo"),
	VAQUILLA("vaquilla"),
	VACA("vaca"),
	TORO("toro");
	
    private final String valorInterno;

    private CategoriaBovino(String valorInterno) {
        this.valorInterno = valorInterno;
    }

    public String getValorInterno() {
        return this.valorInterno;
    }
}
