package SpringCore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotedApplicationContextConfigurer {

    @Bean
    public HelloWorld helloWorld(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotedApplicationContextConfigurer.class);
        ctx.getBean(HelloWorld.class);


        return new HelloWorld();
    }


}
