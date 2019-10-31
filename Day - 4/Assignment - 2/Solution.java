import java.util.Arrays;

public class Solution{

	public static void merge(String[] arr, String[] aux, int low, int mid, int high){
		for(int x = low; x <= high; x++){
			aux[x] = arr[x];
		}
		int i = low;
		int j = mid + 1;
		for(int k = low; k <= high; k++){
			if(i > mid){
				arr[k] = aux[j++];
			}else if(j > high){
				arr[k] = aux[i++];
			}else if(aux[j].compareTo(aux[i]) < 0){
				arr[k] = aux[j++];
			}else{
				arr[k] = aux[i++];
			}
		}
	}

	public static void sort(String[] arr, String[] aux, int low, int high){
		if(high <= low){
			return;
		}
		int mid = low + (high -low)/2;
		sort(arr, aux, low, mid);
		sort(arr, aux, mid + 1, high);
		merge(arr, aux, low, mid, high);
	}

	public static String[] mergeSort(String[] arr){
		String[] aux = new String[arr.length];
		sort(arr, aux, 0, arr.length-1);
		return arr;
	}
}