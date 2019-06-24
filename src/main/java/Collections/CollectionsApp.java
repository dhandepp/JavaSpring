package Collections;

import Collections.POJO.Employee;
import Collections.POJO.EmployeeComparator;
import Collections.POJO.HashHash;

import java.util.*;

public class CollectionsApp {
    public static void main(String[] args){
        //testComparateble();
       // testBinarySearch();
        testHashSet();
    }

    public static void testHashCodeCollectionTest(){
        HashHash obj1 = new HashHash(10002,27000,1444);
        HashHash obj2 = new HashHash(10002,27000,1444);
    }

    public static void testComparateble(){
        Employee mayur = new Employee("1444", "Mayur Dhande");
        Employee mrinal = new Employee("1445", "Mrinal Mittal");
        Employee rahul = new Employee("1404", "Rahul Gupta");
        Employee hanumant = new Employee("1255", "Hanumant Shinde");

        List<Employee> employeeList = new ArrayList();
        employeeList.add(mayur);
        employeeList.add(mrinal);
        employeeList.add(rahul);
        employeeList.add(hanumant);

        System.out.println("Before sort method");
        System.out.println(employeeList);
        Collections.sort(employeeList);
      /*  System.out.println("After comparable method");
        System.out.println(employeeList);*/

        // Try with comparator
        EmployeeComparator comparator = new EmployeeComparator();

        Collections.sort(employeeList,comparator);
        System.out.println("After comparator method");
        System.out.println(employeeList);

    }

    public static void testBinarySearch(){
        ReverseStringCompare rs = new ReverseStringCompare();
        String[] nums = {"one","two","three","quatro"};
        System.out.println("Binary search without sorting array");
        System.out.println(Arrays.binarySearch(nums,"one"));
        System.out.println("Sorting array");
        Arrays.sort(nums,rs);
        System.out.println("Binary search after sorting array");
        System.out.println(Arrays.binarySearch(nums,"one"));
        System.out.println(Arrays.binarySearch(nums,"one",rs));

    }

    public static void testIterator(){
        List<String> strings = new ArrayList<String>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        Iterator<String> i = strings.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }

    public static void testHashSet(){
        Set s = new HashSet();
       // Set s = new TreeSet();        This won't work and would throw runtime exception, trying to compare "a" with Integer
        System.out.println(s.add("a"));
        System.out.println(s.add(new Integer(1)));
        System.out.println(s.add("b"));
        System.out.println(s.add("c"));
        System.out.println(s.add("a"));

        for(Object o : s){
            System.out.println(o.toString());
        }
    }

    static class ReverseStringCompare implements Comparator<String>{
        public int compare(String a, String b){
            return b.compareTo(a);
        }
    }
}
