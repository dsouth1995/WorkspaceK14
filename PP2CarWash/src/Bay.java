/**
 *  Programming Project 2: Bay class <br>
 *
 *  The Bay class keeps track of whether or
 *  not the car wash bay is available and how much
 *  longer the current wash will last.
 *
 *  <br> <br>
 *  Created: <br>
 *     [7 May 2017], [David Southwell]<br>
 *     With assistance from:  []<br>
 *  Modifications: <br>
 *     [the date], [your name(s)], [the reason]<br>
 *
 *  @author [David Southwell]   [with assistance from... or working alongside ...]
 *  @version [7 May 2017]
 */
public class Bay {
    int washTimer;
    int washLength;
    int totalMin;
    KQueue<Car> queue = new LLQueue<>();
    /**
     * Bay Constructor
     *@param length of wash
     *@param total minutes in a work day
     */
    public Bay(int length, int total) {
        washTimer=0;
        washLength=length;
        totalMin=total;
    }

    public void washCar(){
        washTimer+=washLength;
    }

    public int isEmpty(){
        if(washTimer==0)
            return 0;
        else
            return washTimer;

    }
}
