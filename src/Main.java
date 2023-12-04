import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getInputSum());
    }
    public static int getInputSum() throws FileNotFoundException {
        int sum = 0;
        ArrayList<String> strings = new ArrayList<>();

        Scanner reader = new Scanner(new File("input"));
        while(reader.hasNext()){
            strings.add(reader.next());
        }
        for(String text: strings){
            sum += findNumber(convertWordToNum(text));
        }
        return sum;
    }
    public static int findNumber(String string){
        int firstNum = 0;
        int lastNum = 0;

        for(int i = 0; i < string.length(); i++){
            String letter = string.substring(i,i+1);
            try{
                lastNum = Integer.parseInt(letter);
            }catch(Exception ignored){}
        }

        for(int i = string.length(); i > 0; i--){
            String letter = string.substring(i-1,i);
            try{
                firstNum = Integer.parseInt(letter);
            }catch(Exception ignored){}
        }
        return Integer.parseInt(firstNum + "" + lastNum);
    }
    public static String convertWordToNum(String string) {
        StringBuilder text = new StringBuilder(string);
        String[] keyWords = {"one","two","three","four","five","six","seven","eight","nine"};
        for(String keyWord:keyWords){
            while(text.indexOf(keyWord) != -1){
                int index = text.indexOf(keyWord);
                switch(keyWord){
                    case "one"-> text.insert(index+1,"1");
                    case "two"-> text.insert(index+1,"2");
                    case "three"-> text.insert(index+1,"3");
                    case "four"-> text.insert(index+1,"4");
                    case "five"-> text.insert(index+1,"5");
                    case "six"-> text.insert(index+1,"6");
                    case "seven"-> text.insert(index+1,"7");
                    case "eight"-> text.insert(index+1,"8");
                    case "nine"-> text.insert(index+1,"9");
                }
            }
        }
        return text.toString();
    }
}