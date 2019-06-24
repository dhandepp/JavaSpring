package java8.lambda;

import java.util.stream.IntStream;

public class TestPureLambdas {
    public static void main(String[] args){
        // Create our own lambda function, and it tries to match the method we have in functional interface
        MyFunctionalable function = () -> System.out.println("Hello");
       // function.apply();

       // Thread th = new Thread(()->System.out.println("gfo"));
        Thread th = new Thread(System.out::println);
        th.start();

        System.out.println(doSome().isOdd(3));
    }

    public static FunctionableTest doSome(){
        return (i) -> i %2 == 1;
    }
}
