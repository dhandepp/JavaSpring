package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class TestStreamCollect {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 23, 54, 13, 4, 2);

        List<Person> personList = new ArrayList<>();

/*        personList.stream()
                .collect(groupingBy(Person::getName), mapping(person -> person.age));

        list.stream()
                .filter(e -> e % 2 == 0)
                .sum()
                .sorted()
                .distinct()
                .collect(groupingBy(e -> e.toString()),
                        mapping(e -> e % 2 == 0));*/
        //       .collect(toSet());
        //      .collect(Collectors.toList());

        IntStream.iterate(0 , e -> e + 1)
                  .limit(3)
                .sum();
    }
}

class Person {
    String name;
    int age;

    public String getName(){
        return name;
    }


    enum gender {
        MALE,
        FEMALE
    }

    ;
}
