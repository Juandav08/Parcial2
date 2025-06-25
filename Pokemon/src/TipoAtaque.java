public enum TipoAtaque {
    LANZALLAMAS("Lanzallamas"),
    IMPACTRUENO("Impactrueno"),
    HIDROBOMBA("Hidrobomba"),
    TERREMOTO("Terremoto"),
    PSIQUICO("Psíquico");

    private final String nombre;

    TipoAtaque(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
