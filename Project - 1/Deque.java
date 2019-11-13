/**
 * @author SaiKotesh0102
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque <Item> implements Iterable<Item>{
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

    private Node<Item> first;         // beginning of queue
    private Node<Item> last;          // end of queue
    private int size;           // number of elements in queue
    /**
     * Constructor which initializes an empty Deque
     */
    public Deque(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    /**
     * is this queue empty??
     * @return true if this queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * checks the size of the queue
     * @return the number of elements in queue
     */
    public int size(){
        return size;
    }
    /**
     * add an item at the start of the queue
     * if the item is null it throws an illegal argument exception
     * if there is no element to add, it becomes the head and tail itself
     * or else we just add new element and update head
     * @param item
     */
    public void addFirst(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        Node<Item> node = new Node<>(item);
        if(first == null && last == null){
            first = node;
            last = node;
        }else{
            node.next = first;
            first.prev = node;
            first = node;
        }
        size++;
    }
    /**
     * add an item at the last of the queue
     * if the item is null it throws an illegal argument exception
     * if there is no element to add, it becomes the head and tail itself
     * or else we just add new element and update tail 
     * @param item
     */
    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        Node<Item> node = new Node<>(item);
        if(first == null && last == null){
            first = node;
            last = node;
        }else{
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }
    /**
     * removes an item from the first of the queue
     * if the queue is empty it throws No such element exception
     * @return value in the deleted node
     */
    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node<Item> node = first;
        first = first.next;
        if(first != null){
            first.prev = null;
        }else{
            last = null;
        }
        size--;
        return node.item;
    }
    /**
     * removes an item from the last of the queue
     * if the queue is empty it throws No such element exception
     * @return value in the deleted node
     */
    public Item removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node<Item> node = last;
        last = last.prev;
        if(last != null){
            last.next = null;
        }else{
            first = null;
        }
        size--;
        return node.item;
    }
    /**
     * returns an iterator on the queue from first to last
     */
    public Iterator<Item> iterator(){
    	return new ListIterator<Item>(first);
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
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.isEmpty();
        deque.addFirst(3);
        deque.addLast(4);
        deque.removeFirst();
        deque.addFirst(8);
        deque.removeLast();
    }
}