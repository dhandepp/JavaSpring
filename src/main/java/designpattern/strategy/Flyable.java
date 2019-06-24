package designpattern.strategy;

public interface Flyable {
    void fly();
}

class ItFlys implements Flyable{
    @Override
    public void fly() {
        System.out.println("Flying high");
    }
}

class ItCannotFly implements Flyable{
    @Override
    public void fly() {
        System.out.println("Can't fly");
    }
}
