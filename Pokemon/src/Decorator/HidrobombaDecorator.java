package Decorator;

import pokemon.Pokemon;

public class HidrobombaDecorator extends AtaqueDecorator {
    private static final int PUNTAJE_HIDROBOMBA = 95;

    public HidrobombaDecorator(Pokemon pokemon) {
        super(pokemon);
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println(pokemon.getNombre() + " usa Hidrobomba! ");
    }

    @Override
    public int getPuntaje() {
        return super.getPuntaje() + PUNTAJE_HIDROBOMBA;
    }
}
