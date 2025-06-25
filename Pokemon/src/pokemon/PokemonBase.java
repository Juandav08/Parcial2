package pokemon;

public class PokemonBase implements Pokemon {
    private final String nombre;

    public PokemonBase(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " no tiene ataques aprendidos.");
    }

    @Override
    public int getPuntaje() {
        return 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
