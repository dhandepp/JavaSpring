package SpringCore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(HelloWorld.class, HelloWorld.class);
        ctx.register(HelloWorld.class);
        ctx.refresh();
        ctx.scan("SpringCore");
        ctx.refresh();
        HelloWorld myService = ctx.getBean(HelloWorld.class);
    }
}
