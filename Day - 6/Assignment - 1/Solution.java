/**
 * @author SaiKotesh0102
 */

public class Solution{
	/**
	 * Time Complexity : O(LogN)
	 * @param arr
	 * @return true or false
	 */
	public static boolean isMinHeap(double[] arr){
		int len = arr.length - 1;
		if(arr.length <= 0){
			return false;
		}
		while(len > 1){
			if(arr[len] >= arr[len/2]){
				len--;
			}else{
				return false;
			}
		}
		return true;
		// int k = 0;
		// if(arr.length <= 0){
		// 	return false;
		// }

		// while(k <= ((arr.length/2) - 2)){
		// 	if(arr[k] <= arr[(2*k) + 1] && arr[k] <= arr[(2*k) + 2]){
		// 		k++;
		// 	}else{
		// 		return false;
		// 	}
		// }
		// return true;
	}
}