import java.util.NoSuchElementException;
import java.util.LinkedList;
/**
 *  MiniLab 4: KQueue <br>
 *
 *  The LLQueue class implements KQueue methods: enqueue(),
 *  dequeue(), toString(), isEmpty(), size(), and peekFront().
 *  It also uses java.util.LinkedList through an internal Node
 *  class that allows for O(1).
 *
 *  <br> <br>
 *  Created: <br>
 *     [6 May 2017], [David Southwell]<br>
 *     With assistance from:  [Raphael Wieland]<br>
 *  Modifications: <br>
 *     [the date], [your name(s)], [the reason]<br>
 *
 *  @author [David Southwell]   [with assistance from... or working alongside ...]
 *  @version [6 May 2017]
 */
public class LLQueue<T> implements KQueue<T> {
    //initializes first and last nodes
    private Node<T> head = null;
    private Node<T> tail = null;

    //Links the input data to its location in the linked list
    //and then resets the pointer next to point to the next element to be added
    private class Node<T> {
        public T data;
        public Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Adds a specified object to the "back" of this queue.
     *
     * @param item - the object to add to the queue
     **/
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty()) {head = newNode;} else {tail.next = newNode;}
        tail = newNode;
    }

    /**
     * Removes the element at the "front" of this queue.
     *
     * @throws NoSuchElementException if the queue is empty
     * @returns T the removed element
     **/
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = head.data;
        if (tail == head) {
            tail = null;
        }
        head = head.next;
        return item;
    }

    /**
     * Returns the element at the "front" of this queue, without
     * modifying the queue.
     *
     * @throws NoSuchElementException if the queue is empty
     * @returns the element at the front of the queue
     **/
    public T peekFront() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    /**
     * Returns <code>true</code> if this queue is empty;
     * <code>false</code> otherwise.
     **/
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the int size of the queue
     *
     * @throws java.util.NoSuchElementException is queue is empty
     * @returns size of list as int value
     */
    public int size() {
        int count = 0;
        if (isEmpty()) throw new NoSuchElementException();
        for (Node<T> node = head; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    /**
     * returns string description of queue elements
     *
     * @returns string of elements in queue
     */
    public String toString(){
        if (head == null) {
            return " "+null;
        }
        String result = "";
        for (Node<T> node = head; node != null; node = node.next) {
            result += node.data+", ";
        }
        return result;
    }
}