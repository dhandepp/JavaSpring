package Collections.POJO;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    public int compare(Employee obj1, Employee obj2){
        return obj1.getName().compareTo(obj2.getName());
    }
}
