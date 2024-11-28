public class Player {
    private String name;
    private String role;

    
    public Player(String name, String role) {
        this.name = name;
        this.role = role;
    }

    
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    
    public void displayPlayerInfo() {
        System.out.println("Player: " + name + " | Role: " + role);
    }
}
