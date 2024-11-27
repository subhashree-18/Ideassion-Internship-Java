import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        String searchFruit = "Orange";
        int index = fruits.indexOf(searchFruit);

        if (index != -1) {
            System.out.println(searchFruit + " is found at index: " + index);
        } else {
            System.out.println(searchFruit + " not found.");
        }
    }
}
