package SpringCore;

public class HelloStaticClass {
    private static HelloStaticClass staticClass = new HelloStaticClass();
    private HelloStaticClass(){}

    public static HelloStaticClass createInstance(){
        return staticClass;
    }
/*
    public void hello(){
        System.out.println("Hello world");
    }*/
}
