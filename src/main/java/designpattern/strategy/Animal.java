package designpattern.strategy;

public class Animal {
    private String name;
    private String favFood;
    private double weight;

    private Flyable flyType;

    public void setFlyType(Flyable flyType){
        this.flyType = flyType;
    }

    public Flyable getFlyType(){
        return flyType;
    }

    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
