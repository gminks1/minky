/*
 * Activity 2.4.1
 */
import java.util.Scanner;

public class MinMax
{
  public static void main(String[] args)
  {
    Scanner num = new Scanner(System.in);
    System.out.print("How many numbers do you want to enter?: ");
    int numNum = num.nextInt();
    int x = 0;
    System.out.println("Enter " + numNum + " numbers: ");
    int sum = 0;
    while(numNum > x){
      Scanner sc = new Scanner(System.in);
      int number = sc.nextInt();
      sum = sum + number;
      x++;
    }
    System.out.println("The sum of the numbers: " + sum);
    System.out.println("The average of the numbers: " + sum/numNum);

  }
}