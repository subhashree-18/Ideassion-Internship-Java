public class Encapsulation {
    private String name;

    public Encapsulation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Encapsulation person = new Encapsulation("Alice");
        System.out.println("Name: " + person.getName());
        person.setName("Bob");
        System.out.println("Updated Name: " + person.getName());
    }
}
