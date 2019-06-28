package Collections.Set;


import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {
    private static class Person {
        public Person(int id) {
            this.id = id;
        }

        public Person() {
        }

        int id;
    }

    public static void main(String[] args) {
        HashSet<Person> tSet = new HashSet<>();
        Person same = new Person(2);
        tSet.add(same);
        tSet.add(same);

        tSet.forEach(p -> System.out.println(p.id));
    }
}