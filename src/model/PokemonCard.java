package model;

public class PokemonCard {
    
    private String name;
    private PokemonType type;
    private int healthPoints;
    private int attackPower;

    public PokemonCard(String name, PokemonType type, int healthPoints, int attackPower){
        this.name=name;
        this.type=type;
        this.healthPoints=healthPoints;
        this.attackPower=attackPower;  
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

    public void setAttackPower(int attackPower){
        this.attackPower=attackPower;
    }

    public int getAttackPower(){
        return attackPower;
    }


}
