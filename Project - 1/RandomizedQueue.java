/**
 * @author SaiKotesh0102
 */

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item>{
    private class Node<Item>{
        Item item;
        Node<Item> next;
        Node<Item> prev;

        Node(Item item){
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<Item> head;        // beginning of the Queue
    private Node<Item> tail;        // end of the queue
    private int size;         // stores the number of elements in the queue
    /**
     * Constructor which initializes Randomized queue
     */
    public RandomizedQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * checks whether the queue is empty or not
     * @return true if empty else false
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * checks the size of the queue
     * @return the number of elements in the queue
     */
    public int size(){
        return size;
    }
    /**
     * Enqueues the item at the last
     * if the item is null, it throws a new Illegal argument exception
     * if the queue is empty, the head and tail becomes the same
     * or else we just add the Item and update the tail.
     */
    public void enqueue(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        Node<Item> node = new Node<>(item);
        if(head == null && tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    /**
     * Dequeues the item randomly from the queue
     * if the queue is empty it throws a new No Such element Exception
     * if there is only one element head and tail becomes null
     * or else we just remove the item and then update the head and tail
     * @return
     */
    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Random rand = new Random();
        int index = rand.nextInt(size);
        Node<Item> node = head;
        int i = 0;
        while(i < index ){
            node = node.next;
            i++;
        }
        if(node == head && tail == node){
            head = null;
            tail = null;
        }else if(node == head){
            head = node.next;
        }else if(node == tail){
            tail = tail.prev;
            tail.next = null;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        size--;
        return node.item;
    }
    /**
     * returns a random item and it does not remove it from the queue
     * @return an item randomly
     */
    public Item sample(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Random rand = new Random();
        int index = rand.nextInt(size);
        Node<Item> node = head;
        int i = 0;
        while(i < index){
            node = node.next;
            i++;
        }
        return node.item;
    }

    /**
     * returns an iterator on the queue in random order
     */
    public Iterator<Item> iterator(){
    	return new ListIterator<Item>(head);
    }

    private class ListIterator<Item> implements Iterator<Item>{
        private Node<Item> current;
        public ListIterator(Node<Item> first){
            current = first;
        }

        public boolean hasNext(){
            return current != null;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Item next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            
            Node<Item> item = current;
            item = item.next;
            return item.item;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(5);
        rq.dequeue();
        rq.size();
        rq.isEmpty();
        rq.enqueue(27);
        rq.dequeue();
    }
}