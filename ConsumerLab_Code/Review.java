import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 

  
  private static final String SPACE = " ";
  public static void main(String[] args){
   /* System.out.println(sentimentVal("happily"));
    System.out.println(sentimentVal("sad"));
    System.out.println(sentimentVal("mad"));
    double num = sentimentVal("warm");
    System.out.println(num); */
    System.out.println("Total Sentiment: " + totalSentiment("/workspace/minky/ConsumerLab_Code/SimpleReview.txt"));
    System.out.println("Star Rating:" + starRating("/workspace/minky/ConsumerLab_Code/SimpleReview.txt"));
    System.out.println("Fake Revview :" + fakeReview("/workspace/minky/ConsumerLab_Code/SimpleReview.txt"));


  }
  public static double totalSentiment(String fileName){
    double val = 0;
    String store = "";
    String review = textToString(fileName);
    review = removePunctuation(review)+" ";

    while(0 < review.length()){
      int i = review.indexOf(" ");
      store = review.substring(0, i);
      //System.out.println(sentimentVal(store));
      val += sentimentVal(store);
      review = review.substring(i+1);



    }
    return val;
  }

    public static int starRating(String fileName){
      double totalSentiment = totalSentiment(fileName);
      if(totalSentiment > 10){
        return 5;
      }
      else if(totalSentiment > 5){
        return 4;
      }
      else if(totalSentiment > 0){
        return 3;
      }
      else if(totalSentiment > -5){
        return 2;
      }
      else if(totalSentiment > -10){
        return 1;
      }
      else{
        return 0;
      }



    }
    public static String fakeReview(String fileName){
      String out = "";
      String review = textToString(fileName);
      review = removePunctuation(review);

      for(int v = 0;v < review.length(); v++){
        int i = v+review.indexOf(" ");
        String count = review.substring(v,v+1);
        String look = review.substring(v+1, i);
        if(count.equals("*")){
          out += review.replace(look, randomAdjective());

        }
        else{
          out += review.substring(v, v+1);


        }
        System.out.println(out);

      }
      return out;

    }

  
  static{
    try {
      Scanner input = new Scanner(new File("/workspace/minky/ConsumerLab_Code/cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  

  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/workspace/minky/ConsumerLab_Code/positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/workspace/minky/ConsumerLab_Code/negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

      /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
 
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
}
