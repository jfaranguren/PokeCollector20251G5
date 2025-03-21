package model;

public class Controller {

    private PokemonCard[] collection;

    public Controller() {
        collection = new PokemonCard[185];
        testData();
    }


    /**
     * Descripcion: Carga en la coleccion algunas cartas
     * pre: El arreglo collection debe estar inicializado
     * pos: El arreglo collection queda con dos cartas cargadas
     */
    public void testData() {
        collection[0] = new PokemonCard("Pikachu", PokemonType.ELECTRICO, 60, 30);
        collection[1] = new PokemonCard("Charmander", PokemonType.FUEGO, 50, 40);
    }

    public String getPokemonTypeList(){

        PokemonType[] types = PokemonType.values();

        String list = "Tipos registrados:\n";

        for (int i = 0; i < types.length; i++) {
            list += (i+1)+". "+types[i]+"\n";
        }

        return list;

    }

    /**
     * Descripcion: Guarda una carta en el arreglo collection
     * pre: El arreglo collection debe estar inicializado
     * pos: El arreglo collection queda con una nueva carta agregada
     * @param name String, el nombre de la carta
     * @param type int, el tipo de la carta
     * @param healthPoints int, los puntos de vida de la carta
     * @param attackPower int, los puntos de ataque de la carta
     * @return boolean, true si lo logra agregar la carta, false en caso contrario (memoria llena)
     */
    public boolean savePokemonCard(String name, int type, int healthPoints, int attackPower) {

        if(type>PokemonType.values().length||type<0){
            type = 3;
        }

        PokemonType[] types = PokemonType.values();
        PokemonType temp = types[type-1];
        PokemonCard newCard = new PokemonCard(name, temp, healthPoints, attackPower);

        for (int index = 0; index < collection.length; index++) {

            if (collection[index] == null) {
                collection[index] = newCard;
                return true;
            }

        }
        return false;
    }

    public String getPokemonCardList() {

        String msg = "\nLas cartas registradas son: ";

        for (int i = 0; i < collection.length; i++) {

            if (collection[i] != null) {
                msg += "\n" + (i + 1) + ". " + collection[i].getName();
            }
        }

        return msg + "\n";
    }

   

    public boolean modifyPokemonCard(int index, int fieldToChange, String valueToChange) {
        // Puntos de vida y poder de ataque son int
        int valueToChangeInt = 0;
        if (fieldToChange==2 || fieldToChange == 3 || fieldToChange == 4) {
            valueToChangeInt = Integer.parseInt(valueToChange);
        }

        switch (fieldToChange) {
            case 1:
                collection[index].setName(valueToChange);
                return true;
            case 2:
                PokemonType type = PokemonType.AGUA;
                switch(valueToChangeInt){
                    case 1:
                    type = PokemonType.AGUA;
                    break;
                    case 2: 
                    type = PokemonType.PLANTA;
                    break;
                    case 3: 
                    type = PokemonType.FUEGO;
                    break;
                    case 4: 
                    type = PokemonType.ELECTRICO;
                    break;
                    default:
                    type = PokemonType.FUEGO;
                    break;
                }
                collection[index].setType(type);
                break; 
            case 3:
                collection[index].setHealthPoints(valueToChangeInt);
                return true;
            case 4:
                collection[index].setAttackPower(valueToChangeInt);
                break;

        }

        return false;
    }
}
