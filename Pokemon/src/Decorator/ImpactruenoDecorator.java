package Decorator;

import pokemon.Pokemon;

public class ImpactruenoDecorator extends AtaqueDecorator {
    private static final int PUNTAJE_IMPACTRUENO = 80;

    public ImpactruenoDecorator(Pokemon pokemon) {
        super(pokemon);
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println(pokemon.getNombre() + " usa Impactrueno! ");
    }

    @Override
    public int getPuntaje() {
        return super.getPuntaje() + PUNTAJE_IMPACTRUENO;
    }
}
