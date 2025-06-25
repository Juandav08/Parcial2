package Decorator;

import pokemon.Pokemon;

public class LanzallamasDecorator extends AtaqueDecorator {
    private static final int PUNTAJE_LANZALLAMAS = 90;

    public LanzallamasDecorator(Pokemon pokemon) {
        super(pokemon);
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println(pokemon.getNombre() + " usa Lanzallamas! ");
    }

    @Override
    public int getPuntaje() {
        return super.getPuntaje() + PUNTAJE_LANZALLAMAS;
    }
}
