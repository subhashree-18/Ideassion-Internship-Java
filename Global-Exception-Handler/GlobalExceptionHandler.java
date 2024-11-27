public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Global Exception Handler:");
        System.out.println("Thread: " + t.getName());
        System.out.println("Exception: " + e.getClass().getName());
        System.out.println("Message: " + e.getMessage());
    }
}
