public class Developer implements Employee {
    private double salary;
    private int age;

    public Developer(double salary, int age) {
        this.salary = salary;
        this.age = age;
    }

    public void work() {
        System.out.println("Developer is coding");
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
