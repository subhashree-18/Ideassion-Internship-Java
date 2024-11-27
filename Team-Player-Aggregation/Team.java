import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Player> players; 

    
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
    }

    
    public void addPlayer(Player player) {
        players.add(player);
    }

    
    public void displayTeamInfo() {
        System.out.println("Team: " + teamName);
        System.out.println("Players:");
        for (Player player : players) {
            player.displayPlayerInfo();
        }
    }
}
