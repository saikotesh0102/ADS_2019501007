import java.util.*;

public class BST<Key extends Comparable<Key>, Value>{
    private class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public int count;
    
        public Node(Key key, Value value, int count){
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }
    private Node root;

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){
        if(x == null){
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(x.key);
        if(compare > 0){
            x.right = put(x.right, key, value);
        }else if(compare < 0){
            x.left = put(x.left, key, value);
        }else {
            x.value = value;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key){
        Node x = root;
        while(x != null){
            int compare = key.compareTo(x.key);
            if(compare > 0){
                x = x.right;
            } else if(compare < 0){
                x = x.left;
            }else{
                return x.value;
            }
        }
        return null;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }
        return x.count;
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key){
        if(x == null){
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0){
            return x;
        }
        if(compare < 0){
            return floor(x.left, key);
        }
        Node t = floor(x.right,key);
        if(t != null){
            return t;
        }else{
            return x;
        }
    }

    public int rank(Key key){
        return rank(key, root); 
    }

    private int rank(Key key, Node x){
        if (x == null){
            return 0;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0){
            return rank(key, x.left);
        }else if (compare > 0){
            return 1 + size(x.left) + rank(key, x.right);
        }else{
            return size(x.left);
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

    private Node deleteMax(Node x){
        if(x.right == null){
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.count = 1 + size(x.right) + size(x.left);
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null){
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0){
            x.left = delete(x.left, key);
        }else if (compare > 0){
            x.right = delete(x.right, key);
        }else {
            if (x.right == null){
                return x.left;
            }
            if (x.left == null){
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }
    
    private Node min(Node x){
        if (x.left == null){
            return x;
        }
        else{
            return min(x.left);
        }
    }

    public Key max() {
        return max(root).key;
    }
    
    private Node max(Node x){
        if (x.right == null){
            return x;
        }
        else{
            return max(x.right);
        }
    }

    public Key select(int k) {
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null){
            return null;
        } 
        int t = size(x.left); 
        if(t > k){
            return select(x.left,  k);
        }else if (t < k){
            return select(x.right, k-t-1);
        }else{
            return x;
        }
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null){
            return null;
        }
        else{
            return x.key;
        }
    }

    private Node ceiling(Node x, Key key) {
        if (x == null){
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0){
            return x;
        }
        if (compare < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null){
                return t;
            }
            else{
                return x;
            }
        } 
        return ceiling(x.right, key); 
    }
}