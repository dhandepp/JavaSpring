package designpattern.decorator;

public class TomatoSauce extends ToppingDecorator {
    public TomatoSauce(Pizza pizza) {
        super(pizza);
        System.out.println("Adding TomatoSauce");
    }

    public String getDescription(){
        return pizza.getDescription() + ", TomatoSauce";
    }

    public double getCost(){
        return pizza.getCost() + 0.15;
    }
}
