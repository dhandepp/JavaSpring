package designpattern.strategy;

/**
 * To use strategy when a class can have a list of behaviours , and we would want to set
 * it dynamically. Reduces the code, hides complex logic from end users
 */
public class TestStrategy {
    public static void main(String[] args){
        Animal sparky = new Dog("Sparky");
        Animal tweety = new Bird("Tweety");

        sparky.setFlyType(new ItCannotFly());
        tweety.setFlyType(new ItFlys());

        sparky.getFlyType().fly();
        tweety.getFlyType().fly();
    }
}
