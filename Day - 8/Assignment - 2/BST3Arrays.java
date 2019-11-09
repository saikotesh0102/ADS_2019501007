import java.util.*;

/**
 * @author SaiKotesh0102
 */
/**
 * BST3Arrays class to have 3 Arrays 
 * One with the elements of the Search tree
 * The Second with the Indices of the Lesser elements to Parent
 * The Third with the indices of the greater elements to the Parent
 */
public class BST3Arrays<Key extends Comparable<Key>, Value>{

    Key[] rootArr;
    Integer[] leftArr;
    Integer[] rightArr;
    int rootPtr = 1;
    int leftPtr = 1;
    int rightPtr = 1;

    public BST3Arrays(){
        rootArr = (Key[])new Comparable[40];
        leftArr = new Integer[10];
        rightArr = new Integer[10];
    }
    /**
     * Insert method to insert the keys and respective indices into their arrays
     * Time Complexity : O(N)
     * @param key
     * @param value
     */
    public void insert(Key key) {
        if (rootArr[1] == null) {
            rootArr[1] = key;
            return;
        }
        for (int i = 1; i < rootArr.length; ) {
            if (rootArr[i] != null && key.compareTo(rootArr[i]) > 0) {
                i = (2 * i) + 1;
            } else if (rootArr[i] != null && key.compareTo(rootArr[i]) < 0) {
                i = 2 * i;
            } else {
                rootArr[i] = key;
                if (i % 2 == 0) {
                    leftArr[leftPtr++] = i;
                } 
                else {
                    rightArr[rightPtr++] = i;
                }
                break;
            }
        }
    }
    /**
     * checks if the element is in BST
     * returns true if present else false.
     * @param key key to be searched.
     * @return boolean.
     */
    public boolean contains(Key key) {
        for (int i = 1; i < rootArr.length; ) {
            if (rootArr[i] != null && key.compareTo(rootArr[i]) > 0) {
                i = 2 * i;
                i = i + 1;
            } else if (rootArr[i] != null && key.compareTo(rootArr[i]) < 0) {
                i = 2 * i;
            } else {
                if (rootArr[i] == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        BST3Arrays bstArr = new BST3Arrays();
        bstArr.insert(6);
        bstArr.insert(4);
        bstArr.insert(12);
        bstArr.insert(5);
        bstArr.insert(9);
        bstArr.insert(13);
        bstArr.insert(11);
        bstArr.insert(5);
        bstArr.insert(2);
        bstArr.insert(3);
        bstArr.insert(6);
        bstArr.insert(1);

        System.out.println("-------------------------------------------");
        System.out.println("root = " + bstArr.toString(bstArr.rootArr));
        System.out.println("left = " + bstArr.toString(bstArr.leftArr)); 
        System.out.println("right = " + bstArr.toString(bstArr.rightArr));
        System.out.println("-------------------------------------------");
    }
    /**
     * displays the array.
     * @param key array of keys.
     * @return
     */
    String toString(Key[] key) {
        String str = "";
        for (int i = 1; i < key.length; i++) {
            if (key[i] == null || key[i].equals(new Integer(0))) {
                str = str + -1 + " ";
                continue;
            }
            str = str + key[i] + " ";
        }
        return str;
    }
}