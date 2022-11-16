import java.util.Scanner;
public class Main {
    
    public static void main(String[] args){
        //initializing variables
        int x = 0;
        int y = 0;
        Player one = new Player();
        Player two = new Player();
        System.out.println("Player 1 " + one);
        System.out.println("Player 2 " + two);
        Board b1 = new Board(); 
         //infinite loop until the game is over and someone guesses the word right
        while (true){
       //player 1 turn
       while(x == 0){
        System.out.println(one.getPlayerName() + " is up \n");
        x=b1.guess(0);
        System.out.println();
        System.out.println("------------------------------");
        
        
       }
       //player 2 turn
       while(x == 1){
        System.out.println(two.getPlayerName() + " is up \n");
        y = b1.guess(0);
        System.out.println();
        System.out.println("------------------------------");
        x=0;
        //if the value is 3 someone guessed the correct letter
        if(y == 3){
            x=4;
        }
        
       }
       //player one wins
        if (x==3){
        System.out.println("Game Over.    " + one.getPlayerName() + " Wins!!");
        break;

       }
       //player two wins
       if (x==4){
        System.out.println("Game Over.    " + two.getPlayerName() + " Wins!!");
        break;

       }
    }

       //need to fix: the "answer with (y/n)" at the end of every game when the player guesses the word either right or wrong
        
        
        

    
        

        




    }
}
