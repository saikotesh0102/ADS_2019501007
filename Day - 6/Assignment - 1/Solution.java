/**
 * @author SaiKotesh0102
 */

public class Solution{
	/**
	 * 
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
	}
}