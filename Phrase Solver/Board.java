import java.util.Scanner;
import java.io.File;
public class Board{
//constructor class
private String current;
private String guessSus;
private String letterGuess;
public String blank = "";
int fighter = 0;
boolean fig = true;
public String bank = "";
boolean end = false;
int g = 1;

//make a scanner
Scanner sc = new Scanner(System.in);


//returns a random phrase from the text document
private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    tempPhrase = "how are you";
    
    try 
    {
      
      Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/minky/Phrase Solver/phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/minky/Phrase Solver/phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    return tempPhrase;
  }
  

  Board(){
    System.out.println("A board has been created!");


    }


    
    
  


  

  String rep = "";
  Boolean replace = false;
  String phrase = loadPhrase();
  String blankPhrase;
  String wrongLetters = "";
  public String alphabet = "abcdefghijklmnopqrstuvwxyz";
  Boolean a = true;
  
  //guesser method, has everythign from if you want to guess the word to the letter, and if you an invalid character/letter
  public int guess(int guessNum){
    while(a){
      System.out.println(blankPhrase(phrase));
      a = false;
    }
    while(guessNum == 0){
    //asks you if you want to guess the word, if you say no, it prompts you to guess the letter
    Scanner guesser = new Scanner(System.in);
    System.out.print("\nDo you want to guess the word? \n     [Y]es  [N]o\n");
    System.out.println("            ]");
    System.out.print("\033[F\r          [");
    String lettersGuessed = guesser.nextLine();
    System.out.println();

    //prompt to guess the letter
    if (lettersGuessed.equals("y") || lettersGuessed.equals("Y")){
      System.out.println("\033[4m[Guess the word]\033[0m");
      System.out.println();
      System.out.print("\033[F\r  ----->");
      guessSus = guesser.nextLine();
      
      if (guessSus.equals(phrase)){
        System.out.println("Correct!");
        guessNum = 3;
        //fighter = 3;
        
      }
      else{
        System.out.println("Wrong!");
          guessNum = 1;
        
        
        
      }
    }
    //guessing the letter
    if (lettersGuessed.equals("n") || lettersGuessed.equals("N")){
      System.out.println("\033[35m\033[4m[Guess the letter]\033[0m");
      System.out.println();
      System.out.println("         ]");
      System.out.print("\033[F\r       [");
      letterGuess = guesser.nextLine(); 
      
      
      //letter is in the phrase
      if(phrase.contains(letterGuess) && letterGuess.length() == 1 && !wrongLetters.contains(letterGuess) ){
        System.out.println("This letter is in the phrase!");
        System.out.println(blankReplace(phrase));
        replace = true;
        guessNum = 0;
        wrongLetters += letterGuess;
        //if they guess all of the letters then when the phrase is completed that person wins
        if(blankReplace(phrase).equals(phrase)){
          guessNum = 3;
        }
        

        

      }
      //letter is not in the phrase
      else if(!phrase.contains(letterGuess) && letterGuess.length() == 1 && !wrongLetters.contains(letterGuess) && alphabet.contains(letterGuess)){
        System.out.println("Sorry this letter is not in the phrase");
        System.out.println(blankReplace(phrase));
        guessNum = 1;
        wrongLetters += letterGuess;
        
        

      }
      //guess again
      else if(letterGuess.length()!=1){
        System.out.println("You can only guess one letter at a time.... guess again");
        guessNum = 0;
      }
      else if(!alphabet.contains(letterGuess)){
        System.out.println("This isnt even a letter..... what are you thinking?");
        guessNum = 0;
      }
      //when the letter is already guessed
      else{
        System.out.println("This letter has already been guessed, guess again");
        guessNum = 0;


    }
  }
  //if the person does not answer the question with y or n
    else{
      if(g==0){
      System.out.println("Answer with (y/n) \n");
      guessNum = 0;
      }

    }
    

    }
    return guessNum;
  }
    

  

  //end game method
  //public void end(Boolean end){
    //while(end == true){
      //System.out.println("The end");
   // }

 // }




  String phraseOfBlanks = "";
  String guessedLetters = "";  
  
  
  //relpace the phrase with blanks
  public String blankReplace(String blankReplace){
    phraseOfBlanks = "";
    guessedLetters += letterGuess;

    for(int y = 0; y < phrase.length(); y++){
      
      String look = phrase.substring(y, y+1);

    if (look.equals(letterGuess) || guessedLetters.contains(look)){
      phraseOfBlanks += look;
    }
    else if(alphabet.contains(look)){
      phraseOfBlanks += "_";
    }
    else{
      phraseOfBlanks += phrase.substring(y,y+1);
    }
      
     }
     return phraseOfBlanks;

    }
    
    
  
  

//converts your letters into underlines
  public String blankPhrase(String blankPhrase){
    
    for(int y = 0; y < phrase.length(); y++){
      String look = phrase.substring(y, y+1);

    if (alphabet.contains(look)){
      blank += "_";
    }
    else{
      blank += phrase.substring(y,y+1);
    }

  }
    return blank;
}

//players going against each other

/*public void fight(Player x, Player y){
  while(fig){
  if(fighter == 0){
    System.out.println(x.getPlayerName() + " is up!");
    System.out.println("Money:" + x.getMoney());
    fig = false;
    fighter += 1;
  }
  if(fighter == 1){
    System.out.println(y.getPlayerName() + " is up!");
    System.out.println("Money:" + y.getMoney());
    fig = false;
    fighter -= 1;
  }
  if(fighter == 3){
    //at some point you should add who wins
    System.out.println("game is over");
    fig = false;
  }
}
  
} */





//prints when board is printed, the blank phrase is printed with the correct words filled in
  public String toString(){
    String boards = "       board: " + "\n";
    boards += "blank phrase: " + blankReplace(phrase) + "\n";
    boards += "phrase: " + phrase + "\n";
    
    return boards;
}







  }

  




 

  

  