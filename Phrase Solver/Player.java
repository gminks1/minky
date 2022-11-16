
import java.util.Scanner;

public class Player {


    //initialize
    private String name;
    private int money;




    //constructor for player
    Player(){
        Scanner getName = new Scanner(System.in);
        System.out.println("What is your name?: ");
        name = getName.nextLine();
        money = 100;
    }


    
    //getters
    public String getPlayerName(){
        return name;
    }
    public int getMoney(){
        return money;
    }

    //modifiers
    public void guessCorrect(){
        money += 10;
    }

    //returns everything after player is initalized
    public String toString(){
        String stats = "Player: " + name + "\n";
        stats += "Bank account: $" + money;
        return stats;
    }





}


