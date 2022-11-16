package Practice;
import java.util.Scanner;
public class SpecificChar {
    public static void main(String[] args){

    
    Scanner sc = new Scanner(System.in);
    System.out.println("Which character do you want to find?");
    String input = sc.nextLine();
    String adam = "adam admdam dadamad adamad damda";
    int counter = 0;
    for(int i = 0; i < adam.length(); i++){
        if(input.equals(adam.substring(i,i+1))){
            counter+=1;
        } 
        }
        System.out.println(counter);

    }
    
}

