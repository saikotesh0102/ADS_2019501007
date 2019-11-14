import java.util.Scanner;

/**
 * @author Sai Kotesh
 */

public class FarthestPair{
    /**
     * Time Complexity : O(N)
     * @param arr
     * @return Max and Min value pair from the array
     */
    public String farthestPair(double[] arr){
        if(arr.length == 0 || arr.length == 1){
            return null;
        }else{
            double max = arr[0];
        double min = arr[0];
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] < min){
                min = arr[i];
            }

            if(arr[i] > max){
                max = arr[i];
            }
        }
        return "[" + max + ","+ min + "]";
        }
    }

    public static void main(String[] args) {
        FarthestPair fp = new FarthestPair();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of Array");
        int arrLength = scan.nextInt();
        double[] arr = new double[arrLength];
        for(int i = 0; i < arrLength; i++){
            System.out.println("Enter the " + i + " element");
            arr[i] = scan.nextDouble();
        }
        System.out.println(fp.farthestPair(arr));
        scan.close();
    }
}