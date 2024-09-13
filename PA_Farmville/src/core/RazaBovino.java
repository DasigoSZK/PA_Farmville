package core;

public enum RazaBovino {
	ANGUS("angus"),
	HEREFORD("hereford"),
	BRAHMAN("brahman"),
	BRANGUS("brangus"),
	BRAFORD("braford"),
	LIMOUSIN("limousin"),
	CRIOLLO("criollo");
	
    private final String valorInterno;

    private RazaBovino(String valorInterno) {
        this.valorInterno = valorInterno;
    }

    public String getValorInterno() {
        return this.valorInterno;
    }
}
