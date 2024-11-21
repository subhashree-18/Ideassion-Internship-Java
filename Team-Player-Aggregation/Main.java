public class Main {
    public static void main(String[] args) {
       
        Player player1 = new Player("Virat", "Batsman");
        Player player2 = new Player("Bumrah", "Bowler");
        Player player3 = new Player("Hardik", "All-Rounder");

        
        Team team = new Team("The Warriors");

        
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);

        
        team.displayTeamInfo();
    }
}
