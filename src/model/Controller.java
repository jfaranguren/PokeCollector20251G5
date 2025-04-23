package model;
import java.util.ArrayList; //Cambios

public class Controller {

    private ArrayList<PokemonCard> collection; //Cambios

    public Controller(){
       collection = new ArrayList<PokemonCard>(); //Cambios
       testData();
    }

    public int getCollectionSize(){
        return collection.size();
    }


    public void testData(){

        savePokemonCard("Leafeon", 80, 3, "Hoja afilada",60,3);
        savePokemonCard("Jolteon", 80, 4, "Attacktrueno",40,4);

    }

    public PokemonType calculatePokemonType(int option){

        PokemonType temp = PokemonType.AGUA;
        switch (option) {
            case 1:
                temp = PokemonType.AGUA;
                break;
            case 2:
                temp = PokemonType.FUEGO;
                break;
            case 3:
                temp = PokemonType.PLANTA;
                break;
            case 4:
                temp = PokemonType.ELECTRICO;
                break;
            default:
                temp = PokemonType.AGUA;
            break;
        }

        return temp;

    }

    /**
     * Descripcion: ...
     * pre: El arreglo collection debe estar inicializado
     * pos: PokemonCard queda añadido al arreglo collection
     * @param name String El nombre de la carta a registrar 
     * @param healthPoints int ...
     * @param pokemonTypeSelection int ...
     * @param attackPower int ...
     * @return boolean true si se añade, false si no
     */
    public boolean savePokemonCard(String name, int healthPoints, int pokemonTypeSelection, String attackName, int attackPower, int attackType){

        PokemonType pokemonType = calculatePokemonType(pokemonTypeSelection);

        PokemonCard newCard = new PokemonCard(name, healthPoints, pokemonType, new PokemonAttack(attackName, attackPower, calculatePokemonType(attackType)));    
        
        return collection.add(newCard);
    }

    /**
     * Descripcion: 
     * pre: El arreglo collection debe estar inicializado
     * @return String la lista de cartas registradas
     */
    public String getCollectionInfo(){
        String list="Las cartas registradas son:\n";

        for (int i = 0; i < collection.size(); i++) {

                list+=(i+1)+"|"+collection.get(i).toString()+"\n"; //collection[i] es un objeto PokemonCard
            
        }
        return list;
    }

    public String getPokemonTypeList(){

        String msg = "Los tipos registrados son: \n";
        PokemonType[] types = PokemonType.values();

        for (int i = 0; i < types.length; i++) {
            msg+=(i+1)+". "+types[i]+"\n";
       }

        return msg+"\n";

    }

    public boolean verifyCard(int position){

        if (position<=collection.size()&&collection.get(position)!=null){
            return true;
        }
        return false;
    }

    public void modifyCard(String name, int healthpoints, int pokemontype, String attackName, int attackPower, int attackType, int position){
        PokemonType temp=calculatePokemonType(pokemontype);
        PokemonCard newCard=new PokemonCard(name, healthpoints, temp, new PokemonAttack(attackName, attackPower, calculatePokemonType(attackType)));
        collection.set(position-1,newCard);
    }

    public boolean modifyFieldPokemonCard(int position, int option, String data) {
        int dataInteger = 0;

        if(option!=1){
            dataInteger = Integer.parseInt(data);
        }

        switch (option) {
            case 1:
                collection.get(position).setName(data);
                return true;
                case 2:
                collection.get(position).setPokemonType(calculatePokemonType(dataInteger));
                return true;
                case 3:
                collection.get(position).setHealthPoints(dataInteger);
                return true;
            default:
                break;
        }



        return false;

    }

    public PokemonCard deletePokemonCard(int position){

        return collection.remove(position);


    }



    
}
