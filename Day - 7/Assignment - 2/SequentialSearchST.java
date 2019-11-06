import java.util.*;

public class SequentialSearchST<Key extends Comparable<Key>, Value>{
    private Node head;

    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value)  {
            this.key  = key;
            this.value  = value;
        }
    }

    public void put(Key key, Value value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while(current != null){
            if(current.key.compareTo(key) == 0){
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node oldHead = head;
        head = new Node(key, value);
        head.next = oldHead;
    }

    private Value exchange(Node current){
        Node temp = current.next;
        Value value = temp.value;
        current.next = current.next.next;
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = temp;
        temp.next =null;
        return value;
    }

    public Value get(Key key){
        if(key == null){
            return null;
        }
        if(head.key.compareTo(key) == 0){
            return exchange(head);
        }
        Node current = head;
        while(current != null){
            if(current.next.key.compareTo(key) == 0){
                return exchange(current);
            }
            current = current.next;
        }
        return null;
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        Node current = head;
        while(current != null){
            queue.enqueue(current.key);
            current = current.next;
        }
        return queue;
    }
}