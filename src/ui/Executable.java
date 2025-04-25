package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Scanner input;
    private Controller controller; //

    public static void main(String[] args) {
        Executable exe = new Executable();
        exe.menu();
    }

    public Executable() {
        initializer();
    }

    public void initializer() {
        input = new Scanner(System.in);
        controller = new Controller(); //

    }

    public void menu() {

        int option = 0;
        do {
            System.out.println("\nBienvenido a PokeCollector");
            System.out.println("Digite una opcion");
            System.out.println("1) Registrar carta");
            System.out.println("2) Consultar coleccion");
            System.out.println("3) Modificar carta");
            System.out.println("4) Borrar carta");
            System.out.println("5) Consultar estadisticas de la coleccion");
            System.out.println("0) Salir");
            option = input.nextInt();
            switch (option) {
                case 1:
                    registerPokemonCard();

                    break;
                case 2:
                    System.out.println(controller.getCollectionInfo());

                    break;
                case 3:
                    System.out.println("Digite una opcion");
                    System.out.println("1) Para modificar TODOS los atributos de una carta ");
                    System.out.println("2) Para modificar ALGUNO de los atributos de la carta");
                    int modify = input.nextInt();
                    if (modify == 1) {
                        modifyPokemonCard();
                    } else {
                        modifyFieldPokemonCard();
                    }

                    break;
                case 4:
                    deleteCard();
                    break;
                case 5:
                    System.out.println(controller.getCollectionStatitics());
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }

            backToMenu();

        } while (option != 0);

    }

    public void backToMenu() {

        System.out.println("\nDigite 1 para volver al menu principal");
        int menu = input.nextInt();

        // Limpieza de pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public void registerPokemonCard() {

        input.nextLine();

        System.out.println("Digite el nombre");
        String name = input.nextLine();

        System.out.println("Digite los puntos de vida");
        int hp = input.nextInt();

        System.out.println(controller.getPokemonTypeList());

        System.out.println("Digite el tipo del Pokemon");
        int type = input.nextInt();

        input.nextLine();

        System.out.println("Digite el nombre del ataque");
        String attackName = input.nextLine();

        System.out.println("Digite el poder de ataque");
        int attackPower = input.nextInt();

        System.out.println(controller.getPokemonTypeList());

        System.out.println("Digite el tipo del ataque");
        int attackType = input.nextInt();

        if (controller.saveCard(name, hp, type, attackName, attackPower, attackType)) {
            System.out.println("Carta registrada exitosamente");
        } else {
            System.out.println("Coleccion llena");
        }

    }

    public void modifyPokemonCard() {

        System.out.println(controller.getCollectionInfo());
        System.out.println("Digite la posicion de la carta la cual quiere modificar");
        int position = input.nextInt();
        if ((position > 200) || (position < 0)) {
            System.out.println("Digite una posicion valida");
        } else if (controller.verifyCard(position - 1)) {

            input.nextLine();
            System.out.println("Digite el nombre del pokemon: ");
            String name = input.nextLine();

            System.out.println("Digite los puntos de vida");
            int hp = input.nextInt();

            System.out.println(controller.getPokemonTypeList());
            System.out.println("Digite el tipo de pokemon: ");
            int type = input.nextInt();

            input.nextLine();

            System.out.println("Digite el nombre del ataque");
            String attackName = input.nextLine();

            System.out.println("Digite el poder de ataque");
            int attackPower = input.nextInt();

            System.out.println(controller.getPokemonTypeList());

            System.out.println("Digite el tipo del ataque");
            int attackType = input.nextInt();

            controller.modifyCard(name, hp, type, attackName, attackPower, attackType, position);

        }

    }

    public void modifyFieldPokemonCard() {

        System.out.println(controller.getCollectionInfo());
        System.out.println("Digite la posicion de la carta la cual quiere modificar");
        int position = input.nextInt();
        if ((position > controller.getCollectionSize()) || (position < 0)) {
            System.out.println("Digite una posicion valida");
        } else if (controller.verifyCard(position - 1)) {

            System.out.println("Digite que quiere modificar \n1. Nombre\n2. Tipo\n3. Puntos de vida");
            int option = input.nextInt();
            String data = "";
            input.nextLine();

            switch (option) {
                case 1:

                    System.out.println("Digite el nuevo nombre");
                    break;
                case 2:
                    System.out.println(controller.getPokemonTypeList());
                    System.out.println("Digite el nuevo tipo");
                    break;
                case 3:
                    System.out.println("Digite los nuevos puntos de vida");
                    break;
            }
            data = input.nextLine();

            boolean result = controller.modifyFieldPokemonCard(position - 1, option, data);

            if (result) {
                System.out.println("Campo actualizado exitosamente");
            } else {

                System.out.println("Error, no fue posible actualizar el campo");
            }
        }

    }

    public void deleteCard() {

        System.out.println(controller.getCollectionInfo());
        System.out.println("Digite la posicion de la carta la cual quiere borrar");
        int position = input.nextInt();
        if ((position > controller.getCollectionSize()) || (position < 0)) {
            System.out.println("Digite una posicion valida");
        } else if (controller.verifyCard(position - 1)) {

            if (controller.deleteCard(position - 1) != null) {
                System.out.println("Carta borrada exitosamente");
            } else {
                System.out.println("La Carta no pudo ser borrada");
            }

        }

    }

}