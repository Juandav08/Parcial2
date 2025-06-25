package Decorator;

import pokemon.Pokemon;

public class TerremotoDecorator extends AtaqueDecorator {
    private static final int PUNTAJE_TERREMOTO = 100;

    public TerremotoDecorator(Pokemon pokemon) {
        super(pokemon);
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println(pokemon.getNombre() + " usa Terremoto! ");
    }

    @Override
    public int getPuntaje() {
        return super.getPuntaje() + PUNTAJE_TERREMOTO;
    }
}
