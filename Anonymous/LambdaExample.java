public class LambdaExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Running in lambda expression!");
        task.run();
    }
}
