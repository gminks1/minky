package Practice;

public class SixDigits {
    public static void main(String[] args){
        String num = "";
        for(int i = 1; i <= 6; i++){
            int random = (int) (Math.random()*9);
            num += random;
        }
        System.out.println(num);

    }
    public static void countByTwos(){
        int x = 0;
        while (x < 100){
            System.out.println(x);
            x += 2;
        }

    }
}
