import java.lang.*;
import java.util.*;

public class LearningByDoing {
    static int[] arr = { 1, 1, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4 };

    public static void main(String[] args) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] == arr[i + 1]) {
                count = count + 1;
            }
        }
        System.out.println(count);
    }

}