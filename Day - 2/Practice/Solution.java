import java.util.*;

public class Solution{
	public static String isMatching(String str){
		// fill you code Here
		Stack st = new Stack();
		for(int i = 0; i < str.length(); i++){
			if((str.charAt(i) == '{') || (str.charAt(i) == '(') || (str.charAt(i) == '[')){
				st.push(str.charAt(i));
			}

			if((str.charAt(i) == '}') || (str.charAt(i) == ')') || (str.charAt(i) == ']')){
				if(st.isEmpty() == false){
					st.pop();
				}
				
				if(st.isEmpty()){
					return "NO";
				}
			}
		}
		return "YES";
	}
}