import java.util.*;

public class Solution{
	
	public static int[] quickSort(int[] arr){
		RandomizeArray(arr);
		sort(arr, 0, arr.length - 1);
		return arr;
	}

	public static int partition(int[] arr, int low, int high){
		int i = low;
		int j = high + 1;
		while(true){
			while(arr[++i] < arr[low]){
				if(i == high){
					break;
				}
			}

			while(arr[low] < arr[--j]){
				if(j == low){
					break;
				}
			}

			if(i >= j){
				break;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		int temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;
		return j;
	}

	public static void sort(int[] arr, int low, int high){
		if(high <= low){
			return;
		}
		int j =  partition(arr, low, high);
		sort(arr, low, j - 1);
		sort(arr, j + 1, high);
	}

	public static int[] RandomizeArray(int[] arr){
		Random rand = new Random(); 		
 
		for (int i = 0; i < arr.length; i++) {
		    int randomPosition = rand.nextInt(arr.length);
		    int temp = arr[i];
		    arr[i] = arr[randomPosition];
		    arr[randomPosition] = temp;
		}
		return arr;
	}
}