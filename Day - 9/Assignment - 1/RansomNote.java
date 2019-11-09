import java.util.*;

public class RansomNote<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values

    public RansomNote() {
        this(INIT_CAPACITY);
    }

    public RansomNote(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Comparable[m];
        vals = (Value[]) new Comparable[m];
    }


    public int size() {
        return n;
    }

    private void resize(int capacity) {
        RansomNote<Key, Value> temp = new RansomNote<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int hash(Key key) {
        return (key.hashCode() &                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            0x7fffffff) % m;
    }

    public void put(Key key, Value val) {

        if (val == null) {
            delete(key);
            return;
        }

        if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null ; i = (i + 1) % m)
            if (keys[i].equals(key)){
                return vals[i];
            }
        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m/8) resize(m/2);
    }
    
    public static int wordfreq(String[] arofinput, String k){
        int freq=0;
        for(int i=0;i<arofinput.length;i++){
            if(arofinput[i].equals(k)){
                freq++;
            }
        }
        return freq;
    }
    public static void main(String[] args) {
        RansomNote<String, Integer> st = new RansomNote<String, Integer>();
        String[] arr = {"give","me","one","grand"};
        for(int i = 0; i < arr.length; i++){
            if(st.contains(arr[i])){
                st.put(arr[i], (st.get(arr[i])+1));
            }else{
                st.put(arr[i],1);
            }
        }

        System.out.println(st.get("grand"));
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int spaceCount = 0;
        s.close();
        for (char c : input.toCharArray()){
            if (c == ' '){
                spaceCount++;
            }
        }

        String[] arrOfStr = new String[spaceCount+1];
        arrOfStr = input.split(" ",10);
        boolean a= false;
        for(int i = 0; i < arrOfStr.length ; i++){
            if(!st.contains(arrOfStr[i])){
                a=false;
                System.out.println("false");
                break;
            }else if (st.contains(arrOfStr[i]) && st.get(arrOfStr[i]) >= Ransom.wordfreq(arrOfStr, arrOfStr[i]) ){
                a=true;
            }
        }
        if(a==false){
            System.out.println("not the right input");
        }else{
            System.out.println("the right input");
        }
    }
}