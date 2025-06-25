import java.util.*;

import pokemon.Pokemon;
import Decorator.*;

public class GestorAtaques {
    private static final int MAX_ATAQUES = 4;
    private final List<TipoAtaque> ataquesActivos;
    private final Scanner scanner;

    public GestorAtaques() {
        this.ataquesActivos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public boolean agregarAtaque(TipoAtaque nuevoAtaque) {
        if (ataquesActivos.contains(nuevoAtaque)) {
            System.out.println(" El Pokémon ya conoce el ataque " + nuevoAtaque.getNombre());
            return false;
        }

        if (ataquesActivos.size() < MAX_ATAQUES) {
            ataquesActivos.add(nuevoAtaque);
            System.out.println("" + nuevoAtaque.getNombre() + " ha sido aprendido!");
            return true;
        } else {
            return reemplazarAtaque(nuevoAtaque);
        }
    }


    private boolean reemplazarAtaque(TipoAtaque nuevoAtaque) {
        System.out.println(" El Pokémon ya conoce 4 ataques. ¿Qué ataque deseas reemplazar?");
        mostrarAtaquesActivos();
        System.out.println("0. Cancelar (no aprender " + nuevoAtaque.getNombre() + ")");
        System.out.print("Selecciona una opción (0-4): ");

        int opcion;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println(" Opción inválida. Operación cancelada.");
            return false;
        }
        if (opcion == 0) {
            System.out.println(" Operación cancelada. " + nuevoAtaque.getNombre() + " no fue aprendido.");
            return false;
        } else if (opcion >= 1 && opcion <= MAX_ATAQUES) {
            TipoAtaque ataqueReemplazado = ataquesActivos.get(opcion - 1);
            ataquesActivos.set(opcion - 1, nuevoAtaque);
            System.out.println(" " + ataqueReemplazado.getNombre() + " ha sido olvidado.");
            System.out.println(" " + nuevoAtaque.getNombre() + " ha sido aprendido!");
            return true;
        } else {
            System.out.println(" Opción inválida. Operación cancelada.");
            return false;
        }
    }

    private void mostrarAtaquesActivos() {
        for (int i = 0; i < ataquesActivos.size(); i++) {
            System.out.println((i + 1) + ". " + ataquesActivos.get(i).getNombre());
        }
    }

    public List<TipoAtaque> getAtaquesActivos() {
        return new ArrayList<>(ataquesActivos);
    }

    public Pokemon aplicarDecoratores(Pokemon pokemonBase) {
        Pokemon pokemonDecorado = pokemonBase;

        for (TipoAtaque ataque : ataquesActivos) {
            pokemonDecorado = crearDecorator(ataque, pokemonDecorado);
        }

        return pokemonDecorado;
    }

    private Pokemon crearDecorator(TipoAtaque tipo, Pokemon pokemon) {
        switch (tipo) {
            case LANZALLAMAS:
                return new LanzallamasDecorator(pokemon);
            case IMPACTRUENO:
                return new ImpactruenoDecorator(pokemon);
            case HIDROBOMBA:
                return new HidrobombaDecorator(pokemon);
            case TERREMOTO:
                return new TerremotoDecorator(pokemon);
            case PSIQUICO:
                return new PsiquicoDecorator(pokemon);
            default:
                return pokemon;
        }
    }

    /**
     * Muestra información detallada de los ataques activos
     */
    public void mostrarEstadoAtaques() {
        System.out.println("=== ATAQUES ACTIVOS ===");
        if (ataquesActivos.isEmpty()) {
            System.out.println("No hay ataques aprendidos.");
        } else {
            for (int i = 0; i < ataquesActivos.size(); i++) {
                System.out.println((i + 1) + ". " + ataquesActivos.get(i).getNombre());
            }
            System.out.println("Total de ataques: " + ataquesActivos.size() + "/" + MAX_ATAQUES);
        }
        System.out.println("======================");
    }
}
