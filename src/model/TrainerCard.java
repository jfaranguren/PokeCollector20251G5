package model;

public class TrainerCard extends Card {

    private String effect;

    public TrainerCard(String name, String effect) {
        super(name);
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "TrainerCard [effect=" + effect + ", getName()=" + getName() + "]";
    }

    @Override
    public double calculatePrice(){

        return  20*effect.length();

    }
    

    

    
}
