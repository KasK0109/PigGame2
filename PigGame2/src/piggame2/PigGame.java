package piggame2;

import java.util.Scanner;

public class PigGame {

    DiceThrower thrower = new DiceThrower();

    Scanner scanner = new Scanner(System.in);

    private String wantsToPlay = "";

    private String newName = "";

    private String rollAgain = "";

    private boolean won = false;

    private boolean someoneWon = false;

    private int turnScore = 0;

    private int endGoal = 100;

    public void play() {

        System.out.print("Do you wish to play? (y/n) ");
        wantsToPlay = scanner.next();

        if (wantsToPlay.equalsIgnoreCase("n")) {

            System.out.println("Sad, you didn't want to play this time. Maybe another time then!");

        } else {

            System.out.println("Create two players.");
            Player p1 = new Player();
            Player p2 = new Player();

            System.out.print("Enter the name of player 1: ");
            newName = scanner.next();
            p1.setName(newName);
            System.out.print("Enter the name of player 2: ");
            newName = scanner.next();
            p2.setName(newName);

            System.out.println();
            System.out.println("piggame2.Player 1 name: " + p1.getName());
            System.out.println("piggame2.Player 2 name: " + p2.getName());

            System.out.println();
            System.out.print("Set end goal: ");
            endGoal = scanner.nextInt();
            System.out.println();


            while (!someoneWon) {

                System.out.println("------------------------------");
                System.out.println("It is now " + p1.getName() + "'s turn!");
                System.out.println("------------------------------");
                turnScore = 0;
                thrower.roll();
                System.out.println(p1.getName() + " has rolled a: " + thrower.rollDescription());
                if (thrower.sum() == 1) {
                    System.out.println();
                    System.out.println("You rolled a 1. Therefore your turn is over!");
                    System.out.println();
                    turnScore = 0;
                } else {
                    if (turnScore + p1.getTotalPoints() >= endGoal) {
                        System.out.println(p1.getName() + " reached the end goal and won!");
                        someoneWon = true;
                    } else {
                        turnScore += thrower.sum();
                        System.out.println();
                        System.out.println("Current turn score: " + turnScore);
                        if (turnScore + p1.getTotalPoints() >= endGoal) {
                            System.out.println();
                            System.out.println("====================================================================================================");
                            System.out.println(p1.getName() + " rolled a: " + thrower.rollDescription() + " which gives him/her a total of: " + (turnScore + p1.getTotalPoints()));
                            System.out.println("Therefore " + p1.getName() + " reached the end goal and WON!");
                            System.out.println("====================================================================================================");
                            System.out.println();
                            someoneWon = true;
                        }
                        System.out.println();
                        System.out.println("If you stop now you will have: " + (turnScore + p1.getTotalPoints()) + " points.");
                        System.out.println();
                        while (true) {
                            System.out.println();
                            System.out.print("Do you want to roll again? (y/n) ");
                            rollAgain = scanner.next();
                            System.out.println();
                            if (rollAgain.equalsIgnoreCase("n")) {
                                p1.setTotalPoints(p1.getTotalPoints() + turnScore);
                                System.out.println();
                                System.out.println("==============================");
                                System.out.println("You have ended your turn!");
                                System.out.println("Your total points are now: " + p1.getTotalPoints());
                                System.out.println("==============================");
                                System.out.println();
                                break;
                            } else {
                                thrower.roll();
                                System.out.println("You rolled a: " + thrower.rollDescription());
                                if (thrower.sum() == 1) {
                                    System.out.println();
                                    System.out.println("You rolled a 1. Therefore your turn is over!");
                                    System.out.println();
                                    turnScore = 0;
                                    break;
                                } else {
                                    if (turnScore + p1.getTotalPoints() >= endGoal) {
                                        System.out.println();
                                        System.out.println("====================================================================================================");
                                        System.out.println(p1.getName() + " rolled a: " + thrower.rollDescription() + " which gives him/her a total of: " + (turnScore + p1.getTotalPoints()));
                                        System.out.println("Therefore " + p1.getName() + " reached the end goal and WON!");
                                        System.out.println("====================================================================================================");
                                        System.out.println();
                                        someoneWon = true;
                                        break;
                                    } else {
                                        turnScore += thrower.sum();
                                        System.out.println();
                                        System.out.println("Current turn score: " + turnScore);
                                        System.out.println();
                                        if (turnScore + p1.getTotalPoints() >= endGoal) {
                                            System.out.println(p1.getName() + " reached the end goal and won!");
                                            someoneWon = true;
                                            break;
                                        }
                                        System.out.println("If you stop now you will have: " + (turnScore + p1.getTotalPoints()) + " points.");
                                    }
                                }
                            }
                        }

                    }
                }

                if (someoneWon) {

                } else {

                    System.out.println("------------------------------");
                    System.out.println("It is now " + p2.getName() + "'s turn");
                    System.out.println("------------------------------");
                    turnScore = 0;
                    thrower.roll();
                    System.out.println(p2.getName() + " has rolled a: " + thrower.rollDescription());
                    if (thrower.sum() == 1) {
                        System.out.println();
                        System.out.println("You rolled a 1. Therefore your turn is over!");
                        System.out.println();
                        turnScore = 0;
                    } else {
                        if (turnScore + p2.getTotalPoints() >= endGoal) {
                            System.out.println();
                            System.out.println("====================================================================================================");
                            System.out.println(p2.getName() + " rolled a: " + thrower.rollDescription() + " which gives him/her a total of: " + (turnScore + p2.getTotalPoints()));
                            System.out.println("Therefore " + p2.getName() + " reached the end goal and WON!");
                            System.out.println("====================================================================================================");
                            System.out.println();
                            someoneWon = true;
                        } else {
                            turnScore += thrower.sum();
                            System.out.println();
                            System.out.println("Current turn score: " + turnScore);
                            System.out.println();
                            System.out.println("If you stop now you will have: " + (turnScore + p2.getTotalPoints()) + " points.");
                            while (true) {
                                System.out.println();
                                System.out.print("Do you want to roll again? (y/n) ");
                                System.out.println();
                                rollAgain = scanner.next();
                                if (rollAgain.equalsIgnoreCase("n")) {
                                    p2.setTotalPoints(p2.getTotalPoints() + turnScore);
                                    System.out.println();
                                    System.out.println("==============================");
                                    System.out.println("You have ended your turn!");
                                    System.out.println("Your total points are now: " + p2.getTotalPoints());
                                    System.out.println("==============================");
                                    System.out.println();
                                    break;
                                } else {
                                    thrower.roll();
                                    System.out.println("You rolled a: " + thrower.rollDescription());
                                    if (thrower.sum() == 1) {
                                        System.out.println();
                                        System.out.println("You rolled a 1. Therefore your turn is over!");
                                        System.out.println();
                                        turnScore = 0;
                                        break;
                                    } else {
                                        if (turnScore + p2.getTotalPoints() >= endGoal) {
                                            System.out.println();
                                            System.out.println("====================================================================================================");
                                            System.out.println(p2.getName() + " rolled a: " + thrower.rollDescription() + " which gives him/her a total of: " + (turnScore + p2.getTotalPoints()));
                                            System.out.println("Therefore " + p2.getName() + " reached the end goal and WON!");
                                            System.out.println("====================================================================================================");
                                            System.out.println();
                                            someoneWon = true;
                                        } else {
                                            turnScore += thrower.sum();
                                            System.out.println();
                                            System.out.println("Current turn score: " + turnScore);
                                            System.out.println();
                                            System.out.println("If you stop now you will have: " + (turnScore + p2.getTotalPoints()) + " points.");
                                            System.out.println();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void printRules() {
        System.out.println("==========================================================================================");
        System.out.println("Welcome to the game of pigs!");
        System.out.println("The rules are as follows: ");
        System.out.println("Two players take turn rolling a die");
        System.out.println("If you role a 1 your turn ends and the other player rolls");
        System.out.println("If you role anything else, the number of the side you roll is added to your turn score");
        System.out.println("If you decide to roll again and get a ONE your turn score is set to ZERO and the turns goes to the other player");
        System.out.println("If you roll anything but a ONE the number of the side is again added to your turn score");
        System.out.println("You can take as many rolls as you want as long as you don't hit a one");
        System.out.println("If you decide to stop your turn score is added to your total points");
        System.out.println("The first player to reach the end goal, being the set goal of the game, WINS!");
        System.out.println("==========================================================================================");
    }
}
