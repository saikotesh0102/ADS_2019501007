import java.util.*;

public class Sentinel{
    public int[] insertionSort(int[] arr){
        
        int min = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
                count++;
            }
        }
        arr[count] = arr[0];
        arr[0] = min;

        for(int i = 0; i < arr.length; i++){
			for(int j = i; arr[j] < arr[j - 1]; j--){
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j - 1] = temp;
			}
		}
		return arr;
    }

    public static void main(String[] args) {
        Sentinel sentinel = new Sentinel();
        int[] arr = {7,2,9,5,6,11};
        System.out.println(Arrays.toString(sentinel.insertionSort(arr)));
    }
}