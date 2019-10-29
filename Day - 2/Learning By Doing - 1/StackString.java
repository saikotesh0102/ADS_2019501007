import java.util.*;
import java.io.*;

public class StackString{
    
    public static String pop(String[] str){
        int temp = str.length;
        return str[--temp];
    }

    public static void main(String[] args) {
        String[] str= {"it","was","-","the","best","-","of","times","-","-","-","it","was","-","the","-","-"};

        for(int i = 0; i < str.length; i++){
            if(str[i].equals("-")){
                System.out.println(pop(str));
            }
        }
    }
}