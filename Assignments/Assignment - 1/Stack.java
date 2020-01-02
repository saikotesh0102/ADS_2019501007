public class Stack<Item> {
    private int size;
    private Node first;

    private class Node{
        private Node next;
        private Item item;
    }

    public Stack(){
        this.first = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(Item item){
        Node temp = new Node();
        temp.item = item;
        temp.next = first;
        first = temp;
        size++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }
}