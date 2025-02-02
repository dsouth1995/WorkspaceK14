
/**
 *  MiniLab 4: KQueue <br>
 *
 *  The <code>LLMain</code> class provides a main method
 *  for a program that can add and remove elements of a queue.
 *
 *  Any type of object can be added to the queue using the KQueue interface
 *  but in this case, Strings are added and removed through a series of tests
 *  that demonstrate its capabilities.
 *  <br> <br>
 *  Created: <br>
 *     [6 May 2017], [David Southwell]<br>
 *     With assistance from:  [Raphael Wieland]<br>
 *  Modifications: <br>
 *     [the date], [your name(s)], [the reason]<br>
 *
 *  @author [David Southwell]   [with assistance from Raphael Wieland]
 *  @version [6 May 2017]
 */
public class LLMain {
    /**
     *  The main function initiates execution of this program.
     **/
    public static void main(String[] args) {
        //constructs queue object
        KQueue<String> queueTest = new LLQueue<>();
            //TEST 1: adds three objects to queue
            queueTest.enqueue( "String 1");
            queueTest.enqueue( "String 2");
            queueTest.enqueue("String 3");
            //prints TEST 1
            System.out.println("TEST 1 (Initial contents):"+queueTest.toString());

            //TEST 2: removes one element from queue
            queueTest.dequeue();
            //prints contents of queue after single implementation of dequeue
            System.out.println("TEST 2 (AFTER ONE DEQUEUE):"+queueTest.toString());

            //TEST 3A: removes all elements until the queue is empty
        while ( ! queueTest.isEmpty() )
        {
            String element = queueTest.dequeue();
            //print element to be removed
            System.out.println("TEST 3A (REMOVED ELEMENT):"+element);
        }
        //TEST 3B: returns an empty queue with value null
        System.out.println("TEST 3B (Should return null):"+queueTest.toString());
        //TEST 4: adds three new elements to queue
        queueTest.enqueue( "new String 1");
        queueTest.enqueue( "newer String 2");
        queueTest.enqueue("newest String 3");
        //prints contents of queue after TEST 4
        System.out.println("TEST 4 (Final contents):"+queueTest.toString());
    }


}