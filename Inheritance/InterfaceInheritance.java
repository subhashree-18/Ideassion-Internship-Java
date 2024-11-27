public class InterfaceInheritance {
    public static void main(String[] args) {
        Developer dev = new Developer(50000, 28);

        System.out.println("Developer Salary: " + dev.getSalary() + ", Age: " + dev.getAge());
        dev.work();
    }
}
