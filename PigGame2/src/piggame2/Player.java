package piggame2;

import java.util.Scanner;

public class Player {

    Scanner scan = new Scanner(System.in);

    private String name = "";

    private int totalPoints = 0;

    public Player() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
