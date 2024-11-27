public class NonStaticExample {
    int instanceCounter = 0; 

    public void incrementInstanceCounter() { 
        instanceCounter++;
    }

    public static void main(String[] args) {
        NonStaticExample obj1 = new NonStaticExample();
        NonStaticExample obj2 = new NonStaticExample();

        obj1.incrementInstanceCounter(); 
        obj2.incrementInstanceCounter(); 

        System.out.println("Instance counter for obj1: " + obj1.instanceCounter); 
        System.out.println("Instance counter for obj2: " + obj2.instanceCounter); 
    }
}
