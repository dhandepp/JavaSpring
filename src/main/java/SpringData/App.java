package SpringData;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("transactional-beans.xml");

    //    TraditionalPGRepo repo = new TraditionalPGRepo();
     //   repo.list().forEach(System.out::println);

        SpringPGRepo springRepo = context.getBean("springPGRepo",SpringPGRepo.class);
      //  springRepo.list().forEach(System.out::println);
       // System.out.println(springRepo.employeeCount());
      //  System.out.println(springRepo.retrieve(2));
        Employee employee = new Employee();
        employee.setName("CHei");
        employee.setPractice("Gad");
        employee.setProject("ASD");
        System.out.println(springRepo.create(employee));
    }
}
