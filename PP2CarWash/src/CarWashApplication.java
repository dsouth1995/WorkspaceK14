/**
 *  Programming Project 2: Car Wash Program <br>
 *
 *  The <code>CarWashApplication</code> Contains the main method.
 *
 *  <br> <br>
 *  Created: <br>
 *     [7 May 2017], [David Southwell]<br>
 *     With assistance from:  []<br>
 *  Modifications: <br>
 *     [the date], [your name(s)], [the reason]<br>
 *
 *  @author [David Southwell]   [with assistance from Raphael Wieland]
 *  @version [11 May 2017]
 */
public class CarWashApplication {
    /**
     * The main function initiates execution of this program.
     **/

    public static void main(String[] args) {
        CarWashSimulation sim = new CarWashSimulation();
        for(int i=0; i<7; i++){
            sim.main();
        }
    }
}
