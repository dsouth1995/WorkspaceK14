import java.util.NoSuchElementException;

/**
 * 
 * A very basic list class.  Elements can only be added at the beginning at
 * the beginning of the list, and can only be removed according to their
 * index.
 * @Author Nathan Sprague
 * @Modified David Southwell
 * @version April 15, 2017
 *
 */
public class List<T> {

	private Node<T> first;
	private Node<T> last;
	private int size;
	
	/**
	 * Create an empty list.
	 */
	public List() {
		first = null;
		last = null;
		size = 0;

	}
    /**
     * Returns true if list is empty.
     *
     * @return true if list is empty.
     */
    private boolean isEmpty() {
        return this.size() == 0;
    }
    /**
     * Clears the list and sets first and last nodes to null
     *
     * Used to remove last element in list
     *
     * @return first element.
     */
    public T clear() {
        T data = this.get(1);
        first = null;
        last = null;
        size = 0;
        return data;
    }
    /**
     * Adds a new element AT THE BEGINNING of the list.
     * @param element - The element to add
     */
    public void addElement(T element) {
        Node<T> newNode = new Node<>(element);
        if (this.isEmpty()) {
            first = newNode;
            last = first;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
        size++;
    }
    /**
     * Returns element at specified index
     *
     * @param index - index of element to be returned
     * @return element at specified index
     */
    public T get(int index) {
        if (index <= 0 || index > size()) {
            return null;
        }

        Node<T> current = first;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }
    /**
     * Remove the last element in the list
     *
     * @return element in last node
     */
    public T removeTail() {

        if (this.isEmpty()) {
            return null;
        } else if (this.size() == 1) {
            return this.clear();
        } else {

            Node<T> previousNode = first;
            for (int i = 1; i < size()-1; i++) {
                previousNode = previousNode.getNext();
            }

            T returnData = get(this.size());
            previousNode.setNext(null);
            last = previousNode;
            size--;
            return returnData;
        }
    }
    /**
     * Remove first element of list
     *
     * @return element in first node
     */
    public T removeHead() {
        // If nothing inside of the LinkedList
        if (isEmpty()) {
            return null;
        } else if (size() == 1) {
            return clear();
        } else {
            T headData = get(1);
            first = first.getNext();
            size--;
            return headData;
        }
    }
    /**
     * Removes and returns the element at the specified index. Throws
     * a noSuchElementException if the index is out of bounds.
     *
     * @param index - position of the element to remove
     * @return the element that was removed
     * @throws NoSuchElementException
     */
    public T removeElement(int index) throws NoSuchElementException {
        if(size == 0){
            throw new NoSuchElementException("LIST IS EMPTY");
        }else if(index < 0){
            throw new NoSuchElementException("CANNOT REMOVE ELEMENT AT NEGATIVE INDEX");
        }else if(index > size){
            throw new NoSuchElementException("CANNOT REMOVE ELEMENT AT INDEX GREATER THAN LIST SIZE");
        }
        //remove first element
        if (index == 0) {
            return removeHead();
        } else if (index >= size()) {
            return removeTail();
        } else {
            Node<T> previousNode = first;

// Reaches to the previous of the node we  want to remove
            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.getNext();
            }
            T nodeData = previousNode.getNext().getElement();
            previousNode.setNext(previousNode.getNext().getNext());
            size--;
            return nodeData;
        }
    }

        /**
         * Returns the number of elements in the list.
         */
	public int size()
	{
		return size;
	}
	
}
