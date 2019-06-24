package designpattern.decorator;

public class TestDecorator {

    public static void main(String[] args) {
        Pizza pizza = new Mozzarella(new TomatoSauce(new PlainPizza()));

        System.out.println("Ingredients: "+ pizza.getDescription());
        System.out.println("Cost: "+ pizza.getCost());
    }
}
