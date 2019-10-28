import java.util.*;

public class ThreeSum{
    public static int count(int[] arr){
        int count = 0;
        int startElement;
        int endElement;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            startElement = i + 1;
            endElement = arr.length - 1;
            while(startElement < endElement){
                if(arr[i] + arr[startElement] + arr[endElement] == 0){
                    System.out.println("Triplet is " + arr[i] + "," + arr[startElement] + "," + arr[endElement]);
                    count++;
                    startElement++;
                    endElement--;
                }else if(arr[i] + arr[startElement] + arr[endElement] < 0){
                    startElement++;
                }else{
                    endElement--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,4,0,-1,-3,-4};
        System.out.println(count(arr));
    }
}