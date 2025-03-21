package model;

public class PokemonCard {
    
    private String name;
    private PokemonType type;
    private int healthPoints;
    private PokemonAttack[] attacks;
   
    public PokemonCard(String name, PokemonType type, int healthPoints, PokemonAttack attack){
        this.name=name;
        this.type=type;
        this.healthPoints=healthPoints;
        attacks = new PokemonAttack[2];
        addAttack(attack); 
    }

    public boolean addAttack(PokemonAttack newAttack){

        for (int i = 0; i < attacks.length; i++) {

            if(attacks[i]==null){
                attacks[i]=newAttack;
                return true;
            }
            
        }

        return false;
    }

    //Modificadores - set
    public void setName(String name){
        this.name=name;
    }

    //Analizadores - get
    public String getName(){
        return name;
    } 

    public void setType(PokemonType type){
        this.type=type;
    }

    public PokemonType getType(){
        return type;
    }

    public void setHealthPoints(int healthPoints){
        this.healthPoints=healthPoints;
    }

    public int getHealthPoints(){
        return healthPoints;
    }



   

}
