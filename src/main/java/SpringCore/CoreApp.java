package SpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       HelloWorld object = (HelloWorld) context.getBean("helloWorld");
      // object.hello();

        HelloStaticClass object2 = (HelloStaticClass) context.getBean("helloStaticClass");
       // object2.hello();

        HelloWorldBeanInit object3 = (HelloWorldBeanInit) context.getBean("helloConstructInit");
    }
}
