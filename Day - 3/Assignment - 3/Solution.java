import java.util.*;

public class Solution{
	public int[] sortInsertion(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int min = i;
			for(int j = i + 1; j < arr.length; j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			int temp = arr[i];
			a[i] = a[min];
			a[min] = temp;
		}
		return arr;
	}
	public int[] sortSelection(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int min = i;
			for(int j = i; j > 0 && (arr[j] < arr[j - 1]); j--){
				
			}
		}
		return arr;
	}
}