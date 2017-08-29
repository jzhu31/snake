/*  Name: Jiawen Zhu and Yunhee Hyun
 *  PennKey: jiawenz and yuhy
 *  Recitation: 215 and 213
 *
 *  Compilation:  java LinkedList.java
 *  Execution: java LinkedList
 * 
 *  A LinkedList<T> is a type of List that implements the List interface.
 *  LinkedList<T> is a generic, so it can contain any data type (as an object)
 *  in place of the generic type <T> everywhere in the code. The LinkedList<T>
 *  class also has an inner Node class because the LinkedList<T> is represented
 *  as a list of Nodes. A LinkedList<T> has a head Node and a size. 
 */

public class LinkedList<T> implements List<T> {
    
    private Node head;
    private int size;
    
    private class Node {
        
        private T element;
        private Node next;
        
        /**
         * Input: an element and the next Node
         * Output: a Node with the given element and a given next
         * Description: a constructor that creates a Node
         */
        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
    
    /**
     * Input: the element x
     * Output: true
     * Description: adds the element x to the end of the list
     */
    public boolean add(T x) {
        
        // special case: empty LinkedList
        if (size == 0) {
            head = new Node(x, null);
            size = 1;
            return true;
        }
        
        // find the last Node in the list
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        
        // create a new Node to add and increase the size
        Node newNode = new Node(x, null);
        cur.next = newNode;
        size++;
        return true;
    }
    
    /**
     * Input: the index of the position to add the element and the element x
     * Output: true if the operation succeeded, false otherwise
     * Description: adds the element x at the given position
     */
    public boolean add(int index, T x) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index cannot be less than 0 " +
                                               "and it cannot be longer than " +
                                               "the currentlength of the list");
        }
        
        // special case: empty LinkedList
        if (size == 0) {
            head = new Node(x, null);
            size = 1;
            return true;
        }
        
        // special case: index is 0 and it is not an empty LinkedList
        else if (index == 0 && size != 0) {
            Node newN = new Node(x, head);
            head = newN;
            size++;
            return true;
        }
        
        // normal case: index is greater than 0 and less than/equal to the size
        else if (index > 0 && index <= size) {
            int counter = 0;
            Node cur = head;
            
            // find the Node right before the specified index
            while (counter < index - 1) {
                cur = cur.next;
                counter++;
            }
            
            // create a new Node to add and increase the size
            Node newNode = new Node(x, cur.next);
            cur.next = newNode;
            size++;
            return true;
        }
        
        else {
            return false;
        }
    }
    
    /**
     * Input: none
     * Output: the number of elements currently in the list
     * Description: returns the number of elements in this list
     */
    public int size() {
        return size;
    }
    
    /**
     * Input: the index of the specified position
     * Output: the element at the given position
     * Description: returns the element at the specified position in this list
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index cannot be less than 0 " +
                                               "and it cannot be longer than " +
                                               "the number of elements in " +
                                               "the list");
        }
        int counter = 0;
        Node cur = head;
        while (counter < index) {
            cur = cur.next;
            counter++;
        }
        return cur.element;
    }
    
    /**
     * Input: the index of the specified position and the new element x
     * Output: the previous value of the element at the given index
     * Description: replaces the object at the given index with the new element
     * x, and returns the previous value of the object before the replacement
     */
    public T set(int index, T x) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index cannot be less than 0 " +
                                               "and it cannot be longer than " +
                                               "the number of elements in " +
                                               "the list");
        }
        int counter = 0;
        Node cur = head;
        while (counter < index) {
            cur = cur.next;
            counter++;
        }
        T temp = cur.element;
        cur.element = x;
        return temp;
    }
    
    /**
     * Input: the index of the position to remove
     * Output: removed object 
     * Description: removes and returns the object at the specified position
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index cannot be less than 0 " +
                                               "and it cannot be longer than " +
                                               "the number of elements in " +
                                               "the list");
        }
        
        // special case: index is 0
        if (index == 0) {
            T element = head.element;
            head = head.next;
            size--;
            return element;
        }
        
        // find the Node right before the specified index
        int counter = 0;
        Node cur = head;
        while (counter < index - 1) {
            cur = cur.next;
            counter++;
        }
        
        // remove the Node and decrease the size
        T temp = cur.next.element;
        cur.next = cur.next.next;
        size--;
        return temp;
    }
    
    /**
     * Input: none 
     * Output: true if the LinkedList is empty, false otherwise
     * Description: tests if this list has no elements
     */
    public boolean isEmpty() {
        return size == 0; 
    }
    
    /**
     * Input: element whose presence in the List needs to be tested
     * Output: boolean true if the LinkedList contains the specified element;
     * false otherwise
     * Description: checks if this list contains the specified element
     */
    public boolean contains(T element) {
        for (Node current = head; current != null; current = current.next) {
            if (current.element.equals(element)) {
                return true;
            } 
        }
        return false;
    }
    
    /** 
     * Input: the element we are looking for
     * Output: int index of the element we are looking for 
     * Description: returns the index of the specified element if it exists;
     * if the element is not contained within the list, return -1
     */
    public int indexOf(T element) {
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            if (current.element.equals(element)) { 
                break;
            }
            index++;
        }
        
        // looped through the entire list and the given element was not found
        if (index == size) {
            index = -1;
        }
        
        return index;
    }
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Hello");
        list.add("Hi");
        list.add("Amanda");
        list.add(1, "LL");
        list.add(3, "qwerty");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.remove(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.set(3, "JIAWEN");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.isEmpty());
        System.out.println(list.contains("LL"));
        System.out.println(list.indexOf("LL")); 
        System.out.println(list.contains("qwerty"));
        System.out.println(list.indexOf("qwerty")); 
        System.out.println(list.size()); 
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        System.out.println(list2.isEmpty());
    }
    
}