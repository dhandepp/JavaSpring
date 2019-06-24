package designpattern.decorator;

public class PlainPizza implements Pizza{

    public String getDescription(){
       return "Plain Dough";
    }

    public double getCost(){
        return 0.40;
    }
}
