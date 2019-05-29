package SpringCore;

public class HelloWorldBeanInit {
    private HelloWorld hello;

    public void setHello(HelloWorld hello) {
        this.hello = hello;
        hello.hello();
    }
    public HelloWorldBeanInit(int abc, String xy) {
        System.out.println(abc + xy);
    }
}
