package core;

public enum PropositoVenta {
	GENETICA("genetica"),
	INVERNADA("invernada"),
	CRIA("cria"),
	RECRIA("recria"),
	FEEDLOT("feedlot"),
	CONSERVA("conserva");
	
	private final String valorInterno;

    private PropositoVenta(String valorInterno) {
        this.valorInterno = valorInterno;
    }

    public String getValorInterno() {
        return this.valorInterno;
    }
}
