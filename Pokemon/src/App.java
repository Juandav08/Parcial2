import java.util.Scanner;
import pokemon.Pokemon;
import pokemon.PokemonBase;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(" SISTEMA DE ATAQUES POKÉMON ");
        System.out.println("================================");

        // Crear Pokémon base
        Pokemon pokemonBase = new PokemonBase("Pikachu");
        GestorAtaques gestor = new GestorAtaques();
        Scanner scanner = new Scanner(System.in);

        // Demostración inicial
        System.out.println("\n Estado inicial del Pokémon:");
        Pokemon pokemon = gestor.aplicarDecoratores(pokemonBase);
        pokemon.atacar();
        System.out.println("Puntaje total: " + pokemon.getPuntaje());
        gestor.mostrarEstadoAtaques();

        // Menú interactivo
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        // Agregar ataque
                        mostrarAtaquesDisponibles();
                        System.out.print("Selecciona un ataque (1-5): ");
                        int ataqueSeleccionado = scanner.nextInt();
                        scanner.nextLine();
                        if (ataqueSeleccionado >= 1 && ataqueSeleccionado <= 5) {
                            TipoAtaque[] ataques = TipoAtaque.values();
                            if (gestor.agregarAtaque(ataques[ataqueSeleccionado - 1])) {
                                // Reaplicar decoradores
                                pokemon = gestor.aplicarDecoratores(pokemonBase);
                            }
                        } else {
                            System.out.println(" Opción inválida.");
                        }
                        break;
                    case 2:
                        // Mostrar ataques y estadísticas
                        System.out.println("\n ESTADÍSTICAS ACTUALES:");
                        gestor.mostrarEstadoAtaques();
                        pokemon = gestor.aplicarDecoratores(pokemonBase);
                        System.out.println("\n Demostración de ataques:");
                        pokemon.atacar();
                        System.out.println(" Puntaje total: " + pokemon.getPuntaje());
                        break;
                    case 3:
                        // Demostración completa
                        demostracionCompleta();
                        break;
                    case 4:
                        // Salir
                        continuar = false;
                        System.out.println("¡Gracias por usar el sistema de ataques Pokémon! 👋");
                        break;
                    default:
                        System.out.println(" Opción inválida. Intenta de nuevo.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); 
            }

            if (continuar) {
                System.out.println("\nPresiona Enter para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("=".repeat(40));
        System.out.println("1.  Agregar ataque");
        System.out.println("2.  Ver estadísticas y ataques");
        System.out.println("3.  Demostración completa");
        System.out.println("4. Salir");
        System.out.println("=".repeat(40));
    }

    private static void mostrarAtaquesDisponibles() {
        System.out.println("\n⚡ ATAQUES DISPONIBLES:");
        TipoAtaque[] ataques = TipoAtaque.values();
        for (int i = 0; i < ataques.length; i++) {
            System.out.println((i + 1) + ". " + ataques[i].getNombre());
        }
    }
    private static void demostracionCompleta() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           DEMOSTRACIÓN COMPLETA");
        System.out.println("=".repeat(50));

        // Crear nuevo Pokémon para demostración
        Pokemon charizard = new PokemonBase("Charizard");
        GestorAtaques gestorDemo = new GestorAtaques();

        System.out.println("\n Creando Charizard sin ataques:");
        Pokemon pokemonDemo = gestorDemo.aplicarDecoratores(charizard);
        pokemonDemo.atacar();
        System.out.println("Puntaje: " + pokemonDemo.getPuntaje());

        // Agregar ataques progresivamente
        System.out.println("\n Aprendiendo ataques...");

        // Lanzallamas
        gestorDemo.agregarAtaque(TipoAtaque.LANZALLAMAS);
        pokemonDemo = gestorDemo.aplicarDecoratores(charizard);
        System.out.println("\nDespués de aprender Lanzallamas:");
        pokemonDemo.atacar();
        System.out.println("Puntaje: " + pokemonDemo.getPuntaje());

        // Terremoto
        gestorDemo.agregarAtaque(TipoAtaque.TERREMOTO);
        pokemonDemo = gestorDemo.aplicarDecoratores(charizard);
        System.out.println("\nDespués de aprender Terremoto:");
        pokemonDemo.atacar();
        System.out.println("Puntaje: " + pokemonDemo.getPuntaje());

        // Hidrobomba
        gestorDemo.agregarAtaque(TipoAtaque.HIDROBOMBA);
        pokemonDemo = gestorDemo.aplicarDecoratores(charizard);
        System.out.println("\nDespués de aprender Hidrobomba:");
        pokemonDemo.atacar();
        System.out.println("Puntaje: " + pokemonDemo.getPuntaje());

        // Psíquico
        gestorDemo.agregarAtaque(TipoAtaque.PSIQUICO);
        pokemonDemo = gestorDemo.aplicarDecoratores(charizard);
        System.out.println("\nDespués de aprender Psíquico (4 ataques):");
        pokemonDemo.atacar();
        System.out.println("Puntaje: " + pokemonDemo.getPuntaje());

        gestorDemo.mostrarEstadoAtaques();

        System.out.println("\n Demostración completada!");
        System.out.println("=".repeat(50));
    }
}
