package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private static Scanner input;
    private static Controller control;

    public static void main(String[] args) {
        initializer();
        menu();
    }

    public static void initializer() {
        input = new Scanner(System.in);
        control = new Controller();

    }

    public static void menu() {

        int opt = 0;
        do {

            System.out.println("Bienvenido a PokeCollector");
            System.out.println("Digite una opcion");
            System.out.println("1. Registrar carta");
            System.out.println("2. Mostrar listado de cartas");
            System.out.println("3. Modificar carta");
            System.out.println("0. Salir");
            opt = input.nextInt();

            switch (opt) {
                case 1:
                    registerPokemonCard();
                    break;
                case 2:
                    System.out.println(control.getPokemonCardList());
                    break;
                case 3:
                    modifyPokemonCard();
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } while (opt != 0);
    }

    
    public static void registerPokemonCard() {
        input.nextLine();

        System.out.println("Digite el nombre de la carta");
        String name = input.nextLine();

        System.out.println(control.getPokemonTypeList());

        System.out.println("Digite el tipo de la carta");
        int type = input.nextInt();

        System.out.println("Digite los puntos de vida de la carta");
        int hP = input.nextInt();

        input.nextLine();

        System.out.println("Digite el nombre del ataque la carta");
        String attackName = input.nextLine();

        System.out.println("Digite los puntos de ataque del ataque la carta");
        int aP = input.nextInt();

        System.out.println("Digite el tipo del ataque de la carta");
        int attackType = input.nextInt();

        boolean resultado = control.savePokemonCard(name, type, hP, attackName, aP, attackType);

        if (resultado) {
            System.out.println("Carta guardada exitosamente");
        } else {
            System.out.println("Error, Memoria llena");
        }

    }

    public static void modifyPokemonCard() {

        // Mostrar la lista de elementos registrados
        System.out.println(control.getPokemonCardList());

        System.out.println("Digite el consecutivo de la carta a modificar");
        int index = input.nextInt();

        // Preguntar que quiero modificar y capturar informacion
        int option = 0; // ¿Que quiero cambiar?
        String change = ""; // Valor de lo que quiero cambiar

        System.out.println(
                "Que quiere modificar? \n1. Nombre\n2. Tipo\n3. Puntos de vida\n0. Volver al menu principal");
        option = input.nextInt();

        switch (option) {
            case 1:
                System.out.println("Cual es el nuevo nombre?");
                break;
            case 2:
                 System.out.println("Cual es el nuevo tipo?");
                 System.out.println(control.getPokemonTypeList());
                break;
            case 3:
                System.out.println("Cuales son los nuevos puntos de vida");
                break;
           
            default:
                System.out.println("Opcion invalida");
                break;
        }

        input.nextLine(); // Limpieza del buffer
        change = input.nextLine();

        // Llamar al metodo para cambiar el valor en la memoria

        boolean result = control.modifyPokemonCard(index - 1, option, change);

        // Mostrar mensaje de confirmacion

        if (result) {
            System.out.println("Cambio exitoso");
        } else {
            System.out.println("Error, el cambio no pudo ser aplicado");
        }

    }

}