package Decorator;

import pokemon.Pokemon;

public abstract class AtaqueDecorator implements Pokemon {
    protected Pokemon pokemon;

    public AtaqueDecorator(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public void atacar() {
        pokemon.atacar();
    }

    @Override
    public int getPuntaje() {
        return pokemon.getPuntaje();
    }

    @Override
    public String getNombre() {
        return pokemon.getNombre();
    }
}
