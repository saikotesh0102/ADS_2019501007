/**
 * @author SaiKotesh0102
 * 
 * This class implements a circular queue where we use only one pointer
 * and connect them in a way that the links are not broken.
 */
public class Queue{
    private class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node tail;
    int size;
    /**
     * Construtor which initializes an empty queue
     */
    public Queue(){
        this.tail = null;
        this.size = 0;
    }
    /**
     * checks whether the queue is empty or not
     * @return true if empty and false if not
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * @return size of the queue
     */
    public int size(){
        return size;
    }
    /**
     * Inserts an element at the last
     * if the queue is empty last and first becomes the same
     * @param data
     */
    public void enqueue(int data){
        Node x = new Node(data);
        if(isEmpty()){
            tail = x;
            tail.next = tail;
        }else{
            Node temp = tail;
            tail = x;
            tail.next = temp.next;
            temp.next = tail;
        }
        size++;
    }
    /**
     * removes an element from the front and connects the next element to the last
     * @return the value of the removed element
     */
    public int dequeue(){
        if(isEmpty()){
            return -1;
        }else if(size == 1){
            Node temp = tail;
            tail = null;
            size--;
            return temp.data;
        }else{
            Node x = tail.next;
            tail.next = tail.next.next;
            size--;
            return x.data;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(1);
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }
}