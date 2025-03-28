package model;

import java.util.ArrayList;

public class Controller {

    private ArrayList<PokemonCard> collection;

    public Controller() {
        collection = new ArrayList<PokemonCard>();
        testData();
    }

    /**
     * Descripcion: Carga en la coleccion algunas cartas
     * pre: El arreglo collection debe estar inicializado
     * pos: El arreglo collection queda con dos cartas cargadas
     */
    public void testData() {
        collection.add(new PokemonCard("Pikachu", PokemonType.ELECTRICO, 60, new PokemonAttack("Impactrueno", 50, PokemonType.ELECTRICO)));
        collection.add(new PokemonCard("Charmander", PokemonType.FUEGO, 50, new PokemonAttack("Ascuas", 30, PokemonType.FUEGO)));
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
    public boolean savePokemonCard(String name, int type, int healthPoints, String attackName, int attackPower, int attackType) {

        if(type>PokemonType.values().length||type<0){
            type = 3;
        }

        if(attackType>PokemonType.values().length||attackType<0){
            attackType = 3;
        }

        PokemonType[] types = PokemonType.values();
        PokemonType pokemonCardType = types[type-1];
        PokemonType pokemonAttackType = types[attackType-1];

        PokemonCard newCard = new PokemonCard(name, pokemonCardType, healthPoints, new PokemonAttack(attackName, attackPower, pokemonAttackType));

        return collection.add(newCard);

    }

    public String getPokemonCardList() {

        String msg = "\nLas cartas registradas son: ";

        for (int i = 0; i < collection.size(); i++) {

            if (collection.get(i) != null) {
                msg += "\n" + (i + 1) + ". " + collection.get(i).getName();
            }
        }

        return msg + "\n";
    }

   

    public boolean modifyPokemonCard(int index, int fieldToChange, String valueToChange) {
        // Puntos de vida y poder de ataque son int
        int valueToChangeInt = 0;
        if (fieldToChange==2 || fieldToChange == 3 ) {
            valueToChangeInt = Integer.parseInt(valueToChange);
        }

        switch (fieldToChange) {
            case 1:
                collection.get(index).setName(valueToChange);
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
                collection.get(index).setType(type);
                break; 
            case 3:
                collection.get(index).setHealthPoints(valueToChangeInt);
                return true;
         
        }

        return false;
    }
}
