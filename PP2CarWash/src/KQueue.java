import java.util.NoSuchElementException;

/** The KQueue interface specifies the methods for a <i>queue</i>
 *  data structure.
 *  <ul>
 *    <li>The enqueue method adds an element to the "back" of the
 *        data structure.
 *    <li>The dequeue method acts as follows:
 *        <ul>
 *        <li>If the queue is empty, an exception is thrown.
 *        <li>If the queue contains one element, dequeue returns that element,
 *          leaving the queue empty.
 *        <li>If the queue contains multiple elements, dequeue returns the
 *          element at the "front" of the queue, the one that has been there
 *          longest.
 *        </ul>
 *  </ul>
 **/

public interface KQueue<T> {
    /**
     * Returns <code>true</code> if this queue is empty;
     * <code>false</code> otherwise.
     **/
    boolean isEmpty();

    /**
     * Adds a specified object to the "back" of this queue.
     *
     * @param item - the object to add to the queue
     **/
    void enqueue(T item);

    /**
     * Removes the element at the "front" of this queue.
     *
     * @throws NoSuchElementException if the queue is empty
     * @returns T the removed element
     **/
    T dequeue();

    /**
     * Returns the element at the "front" of this queue, without
     * modifying the queue.
     *
     * @throws NoSuchElementException if the queue is empty
     * @returns the element at the front of the queue
     **/
    T peekFront();

    /**
     * Returns the int size of the queue
     *
     * @throws java.util.NoSuchElementException is queue is empty
     * @returns size of list as int value
     */
    int size();

    /**
     * returns string description of queue elements
     *
     * @returns string of queue elements
     */
    String toString();
}