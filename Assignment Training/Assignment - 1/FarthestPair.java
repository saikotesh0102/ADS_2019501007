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
        double max = arr[arr.length - 1];
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

    public static void main(String[] args) {
        FarthestPair fp = new FarthestPair();
        double[] arr = {10.0,5.1,2.0,26.0,100.0,90.0};
        System.out.println(fp.farthestPair(arr));
    }
}