public class MyLinkedList {

    public Node head;

    /**
     * Constructs an empty list with size initialized to zero.
     */
    public MyLinkedList() {
        head = null;
    }
    /**
     * Appends the specified element to the end of this list.
     *
     * @param data  The data
     */
    public void add(String data){
        Node newNode = new Node(data);
        newNode.data = data;
        newNode.next = null; //optional because it is already null in Node class

        if (head == null){
            head = newNode;
        } else{
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            n.next = newNode;
        }
    }
    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param data  The data
     */
    public void addFirst(String data){
        Node newNode = new Node(data);
        newNode.data = data;
        
        newNode.next = head;
        head = newNode;
    }
    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        head = null;
    }
    /**
     * Returns true if this list contains the specified element.
     *
     * @param data  The data
     *
     * @return { description_of_the_return_value }
     */
    public boolean contains(String data) { 
        if(head != null){
            Node n = head;
            while(n != null){
                if((n.data).equals(data)){
                    return true;
                } 
                n = n.next;
            }
        }
        return false; 
    }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index  The index
     *
     * @return { description_of_the_return_value }
     */
    public String get(int index){
        Node n = head;
        for (int i = 1 ; i < index ; i++ ){
            n = n.next;
        }
        if(n != null){
            return n.data;
        } else{
            return null;
        }
    }
    /**
     * Returns the first element in this list.
     *
     * @return     The first.
     */
    public String getFirst() { 
        if(head != null){
            return head.data;
        }else{
            return null;
        } 
    }
    /**
     * Returns the last element in this list.
     *
     * @return     The last.
     */
    public String getLast() {
        if(head == null){
            return null;
        }
        Node n = head;
        while(n.next != null){
            n = n.next;
        } 
        return n.data;
    }
    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return     { description_of_the_return_value }
     */
    public String remove() {
        Node n = head;
        if(n == null){
            return "LinkedList is empty";
        }
            head = n.next;
            n.next = null;
            return n.data;
        }
        
    /**
     * Removes and returns the last element from this list.
     *
     * @return     { description_of_the_return_value }
     */
    public String removeLast() { 
        if(head == null) return "";
        if(head.next == null){
            String store = head.data;
            head = null;
            return store;
        }
        Node n = head;
        while(n.next.next != null){
            n = n.next;
        }
        String store = n.next.data;
        n.next = null;
        return store;
    } 
    
    /**
     * Returns the number of elements in this list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() { 
        Node n = head;
        int size = 0;
        if (head != null){
            while(n != null){
                n = n.next;
                size++;
            }
            return size;
        }
        return 0; }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() { 
        String string = "";
        Node n = head;
        if(head != null){
            while(n != null){
                string = string + "[" + n.data + "]";
                n = n.next;
            }
            return string; 
        } else{
            return "LinkedList is empty"; 
        }  
    }
}

