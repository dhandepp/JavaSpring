package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaFirst {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 23, 4, 6, 7, 3, 7);

        // Using inner class
        values.forEach(new Consumer<Integer>() {
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        // Using Lambdas
        values.forEach(value -> System.out.println(value));
        values.forEach(System.out::println);

        
        // Find total of doubled element
        System.out.println(values.stream()
                .map(e -> e * 2)
                .reduce(0, (c, e) -> c + e)
        );


        // Calling a function by passing lambda function
        addValues(values, e -> e % 2 == 0);
        addValues(values, e -> e % 2 == 1);
        addValues(values, e -> e > 3);


        // Lazy streams
        values.stream()
                .filter(integer -> integer > 3)
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer * integer)
                .findFirst()
                .orElse(0);
    }

    /*
    Method accepting a lambda, predicate that defines the way we want our function to work
     */
    public static Integer addValues(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .reduce(0, (c, e) -> c + e);
    }
}
