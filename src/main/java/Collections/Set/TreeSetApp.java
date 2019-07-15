package Collections.Set;

import java.util.TreeSet;

public class TreeSetApp {
    private static class Person {
        public Person(int id) {
            this.id = id;
        }

        public Person() {
        }

        int id;
    }

    public static void main(String[] args) {


        TreeSet<Person> tSet = new TreeSet<>();
        tSet.add(new Person(2));
        tSet.add(new Person(1));

        tSet.forEach(p -> System.out.println(p.id));

    }
}
