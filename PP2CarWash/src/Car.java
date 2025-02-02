/**
 *  Programming Project 2: Car class <br>
 *
 *  Represents a car
 *  (stores the time when the car arrived
 *  at the car wash).
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
public class Car {
private int arrivalTime;
    public Car(){
        int arrivalTime = this.getArrivalTime();
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
