package SpringCore;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * When MixedScopeBeans is singleton and its dependent bean is prototype, you can ask dependent bean to be retrieved
 * dynamically using applicationcontextaware interface.
 */
public class MixedScopeBeans implements ApplicationContextAware {
    ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void doStuff() {
        HelloWorld object = getHelloObject();
    }

    private HelloWorld getHelloObject() {
        return context.getBean("helloWorld", HelloWorld.class);
    }
}
