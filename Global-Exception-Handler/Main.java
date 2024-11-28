public class Main {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
        
        File1 file1 = new File1();
        File2 file2 = new File2();
        File3 file3 = new File3();
        
        try {
            file1.method1();
        } catch (Exception e) {
            System.out.println("Caught exception in File1: " + e);
        }

        try {
            file2.method2();
        } catch (Exception e) {
            System.out.println("Caught exception in File2: " + e);
        }

        try {
            file3.method3();
        } catch (Exception e) {
            System.out.println("Caught exception in File3: " + e);
        }
    }
}
