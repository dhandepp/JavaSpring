package designpattern.decorator;

public class Mozzarella extends ToppingDecorator {
    public Mozzarella(Pizza pizza) {
        super(pizza);
        System.out.println("Adding dough");
        System.out.println("Adding Mozzarella");
    }

    public String getDescription(){
        return pizza.getDescription() + ", Mozzarella";
    }

    public double getCost(){
        return pizza.getCost() + 0.5;
    }
}
