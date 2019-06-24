package java8;

interface Fly{
   default void land(){
       System.out.println("Fly::land");
   };
   default void cruise(){};
    default void fly(){};
}

interface FlyFast extends Fly{

}

interface JetFly{
    default void land(){System.out.println("JetFly::land");}
}

public class DefaultMethodInterface implements JetFly,Fly{
    @Override
    public void land(){
        JetFly.super.land();
    }
}

