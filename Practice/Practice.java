package Practice;

public class Practice {
    public static void main(String[] args)
  {
    String s1 = "what do you want";
    String output = "";
    for(int i = 0; i < s1.length(); i++){

        if (s1.substring(i, i+1).equals("a") || s1.substring(i, i+1).equals("e") || s1.substring(i, i+1).equals("i") || s1.charAt(i)==('o') || s1.charAt(i) == ('u')){
            output += "z";
            
        } else if (s1.substring(i, i+1).equals("y")){
            output += "q";

        }
        else {
            output += s1.substring(i, i+1);
        }
    }
    System.out.println(output);
    






  }
  

}
