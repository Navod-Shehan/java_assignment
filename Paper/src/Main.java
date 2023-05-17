import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class Player {
    private String name;
    private int matchesPlayed;
    private int runsScored;

    public Player(String name, int matchesPlayed, int runsScored) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public abstract void printPlayer();


    public String toString() {
        return "Player [name=" + name + ", matchesPlayed=" + matchesPlayed + ", runsScored=" + runsScored + "]";
    }
}

class Batsman extends Player {
    private int numberOfCenturies;

    public Batsman(String name, int matchesPlayed, int runsScored, int numberOfCenturies) {
        super(name, matchesPlayed, runsScored);
        this.numberOfCenturies = numberOfCenturies;
    }

    public int getNumberOfCenturies() {
        return numberOfCenturies;
    }

    public void setNumberOfCenturies(int numberOfCenturies) {
        this.numberOfCenturies = numberOfCenturies;
    }

    public void printPlayer() {
        System.out.println("Batsman Details: " + this.toString());
    }


    public String toString() {
        return super.toString() + " Batsman [numberOfCenturies=" + numberOfCenturies + "]";
    }
}

class Bowler extends Player {
    private int numberOfWickets;

    public Bowler(String name, int matchesPlayed, int runsScored, int numberOfWickets) {
        super(name, matchesPlayed, runsScored);
        this.numberOfWickets = numberOfWickets;
    }

    public int getNumberOfWickets() {
        return numberOfWickets;
    }

    public void setNumberOfWickets(int numberOfWickets) {
        this.numberOfWickets = numberOfWickets;
    }

    public void printPlayer() {
        System.out.println("Bowler Details: " + this.toString());
    }


    public String toString() {
        return super.toString() + " Bowler [numberOfWickets=" + numberOfWickets + "]";
    }
}

class WicketKeeper extends Player {
    private int numberOfCatches;
    private int numberOfStumpings;

    public WicketKeeper(String name, int matchesPlayed, int runsScored, int numberOfCatches, int numberOfStumpings) {
        super(name, matchesPlayed, runsScored);
        this.numberOfCatches = numberOfCatches;
        this.numberOfStumpings = numberOfStumpings;
    }

    public int getNumberOfCatches() {
        return numberOfCatches;
    }

    public void setNumberOfCatches(int numberOfCatches) {
        this.numberOfCatches = numberOfCatches;
    }

    public int getNumberOfStumpings() {
        return numberOfStumpings;
    }

    public void setNumberOfStumpings(int numberOfStumpings) {
        this.numberOfStumpings = numberOfStumpings;
    }

    public void printPlayer() {
        System.out.println("Wicket Keeper Details: " + this.toString());
    }


    public String toString() {
        return super.toString() + " WicketKeeper [numberOfCatches=" + numberOfCatches + ", numberOfStumpings=" + numberOfStumpings + "]";
    }
}

class ClubManager {
    static ArrayList<Player> Players = new ArrayList<Player>();

    public static void addPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        System.out.print("Enter number of matches played: ");
        int matchesPlayed = scanner.nextInt();
        System.out.print("Enter runs scored: ");
        int runsScored = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Select player type:");
        System.out.println("1. Batsman");
        System.out.println("2. Bowler");
        System.out.println("3. Wicket Keeper");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        Player player;
        switch (choice) {
            case 1:
                System.out.print("Enter number of centuries: ");
                int numberOfCenturies = scanner.nextInt();
                player = new Batsman(name, matchesPlayed, runsScored, numberOfCenturies);
                break;
            case 2:
                System.out.print("Enter number of wickets: ");
                int numberOfWickets = scanner.nextInt();
                player = new Bowler(name, matchesPlayed, runsScored, numberOfWickets);
                break;
            case 3:
                System.out.print("Enter number of catches: ");
                int numberOfCatches = scanner.nextInt();
                System.out.print("Enter number of stumpings: ");
                int numberOfStumpings = scanner.nextInt();
                player = new WicketKeeper(name, matchesPlayed, runsScored, numberOfCatches, numberOfStumpings);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Batsman.");
                player = new Batsman(name, matchesPlayed, runsScored, 0);
                break;
        }

        Players.add(player);
        System.out.println("Player added successfully!");
    }

    public static void searchPlayer(String playerName) {
        boolean found = false;
        for (Player player : Players) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                player.printPlayer();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Player not found.");
        }
    }

    public static void deletePlayer(String playerName) {
        Iterator<Player> iterator = Players.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getName().equalsIgnoreCase(playerName)) {
                iterator.remove();
                count++;
            }
        }

        System.out.println(count + " player(s) deleted.");
        System.out.println("Total number of players in the club: " + Players.size());
    }

    public static void printPlayers() {
        for (Player player : Players) {
            player.printPlayer();
        }
    }

    public static void main(String[] args) {
        // Create player objects and add them to the players ArrayList
        Player player1 = new WicketKeeper("Kusal", 62, 2465, 15, 17);
        Players.add(player1);

        Player player2 = new Batsman("Mathews", 38, 1881, 7);
        Players.add(player2);

        Player player3 = new Bowler("Lahiru", 15, 450, 19);
        Players.add(player3);

        Player player4 = new Batsman("Charith", 18, 1770, 12);

        Players.add(player4);

        Player player5 = new Batsman("Chamika", 24, 1917, 7);
        Players.add(player5);

        Player player6 = new Bowler("Dushmantha", 15, 860, 17);
        Players.add(player6);

        Player player7 = new Bowler("Lasith", 18, 1518, 32);
        Players.add(player7);

        Player player8 = new Bowler("Praveen", 20, 718, 17);
        Players.add(player8);

        Player player9 = new Batsman("Dimuthu", 48, 1517, 7);
        Players.add(player9);

        Player player10 = new Batsman("Kamindu", 40, 2015, 9);
        Players.add(player10);

        // Test the functionalities of the cricket club system
        // Search for the player called Praveen and print all the details of him
        searchPlayer("Praveen");

        // The management of the club decided to remove the players having average runs below 15
        //Assumed that the average runs are calculated by dividing the runs scored by the number of matches played
        Iterator<Player> iterator = Players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getRunsScored() / player.getMatchesPlayed() < 15) {
                System.out.println("Deleting player: " + player.getName());
                iterator.remove();
            }
        }

        // Print the list of players in the club
        System.out.println("List of players in the club:");
        printPlayers();
    }
}
