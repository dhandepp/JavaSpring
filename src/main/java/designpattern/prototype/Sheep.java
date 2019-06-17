package designpattern.prototype;

public class Sheep implements Animal {
    @Override
    public Animal makeCopy() {
        Sheep sheep = null;
        try {
             sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
