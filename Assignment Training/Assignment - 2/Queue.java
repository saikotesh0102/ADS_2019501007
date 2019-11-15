/**
 * @author SaiKotesh0102
 */

public class Queue{
    private class Node{
        Node next;
        int value;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    Node last;
    int size;

    public Queue(){
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(int value){
        Node x = new Node(value);
        if(isEmpty()){
            last = x;
            last.next = last;
        }else{
            Node temp = last;
            last = temp;
            last.next = temp.next;
        }
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            return 0;
        }else{
            Node x = last.next;
            last.next = last.next.next;
            size--;
            return x.value;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(12);
        queue.enqueue(1);
        queue.isEmpty();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}