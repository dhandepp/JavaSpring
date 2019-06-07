package SpringCore.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HelloWorldAspect {

    @Before("execution(public void hello())")
    public void helloAdvice(){
        System.out.println("Hello advice");
    }
}
