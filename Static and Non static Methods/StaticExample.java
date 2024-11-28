public class StaticExample {
    static int staticCounter = 0; 

    public static void incrementStaticCounter() { 
        staticCounter++;
    }

    public static void main(String[] args) {
        StaticExample.incrementStaticCounter(); 
        StaticExample.incrementStaticCounter(); 

        System.out.println("Static counter: " + StaticExample.staticCounter); 
    }
}
