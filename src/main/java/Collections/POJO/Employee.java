package Collections.POJO;

public class Employee implements Comparable<Employee>{
    private String empId;
    private String name;

    public Employee(){}

    public Employee(String empId, String name){
        this.empId = empId;
        this.name = name;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return empId + "- "+ name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Employee && ((Employee) obj).getEmpId().equals(empId)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Integer.parseInt(empId);
    }

    public int compareTo(Employee employee){
       if(Integer.parseInt(empId) > Integer.parseInt(employee.getEmpId()))
           return 1;
       else if(Integer.parseInt(empId) < Integer.parseInt(employee.getEmpId()))
           return -1;
       else
           return 0;
    }
}
