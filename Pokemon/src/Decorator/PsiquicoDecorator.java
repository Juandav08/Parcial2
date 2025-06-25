package Decorator;

import pokemon.Pokemon;

public class PsiquicoDecorator extends AtaqueDecorator {
    private static final int PUNTAJE_PSIQUICO = 85;

    public PsiquicoDecorator(Pokemon pokemon) {
        super(pokemon);
    }
    @Override
    public void atacar() {
        super.atacar();
        System.out.println(pokemon.getNombre() + " usa Psíquico! ");
    }
    @Override
    public int getPuntaje() {
        return super.getPuntaje() + PUNTAJE_PSIQUICO;
    }
}
