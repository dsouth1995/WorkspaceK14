import java.util.Random;
/**
 *  Programming Project 2: CarWashSimulation class <br>
 *
 *   Controls the simulation.
 *
 *for each minute of the simulation
 * if a car arrives
 * increment the number of cars that have arrived
 * note the arrival time of the car (store this with the car)
 * add the car to the queue
 *
 * if the car wash bay is empty and there is a car waiting to be washed
 * move the car from the queue to the car wash bay
 * determine how long that car was waiting and add to total wait time
 * start washing the car (bay will be occupied for next 2 minutes)
 *
 * otherwise, if there is a car already being washed
 * decrease the amount of time left before the bay is available
 *
 * Question: is there a case missing here that requires any action?
 *  <br> <br>
 *  Created: <br>
 *     [7 May 2017], [David Southwell]<br>
 *     With assistance from:  []<br>
 *  Modifications: <br>
 *     [5/11/2017], [David], [Implement calculations for report]<br>
 *
 *  @author [David Southwell]   [with assistance from Raphael Wieland]
 *  @version [11 May 2017]
 */
public class CarWashSimulation {
    public static void main() {
        //initializes random number generator
        Random rand = new Random();
        //initializes LLQueue
        KQueue<Car> line = new LLQueue<>();

    //initializes instance variables

    int totalWaitTime = 0;
    int numCarsArrived = 0;
    Bay bay = new Bay(3, 600);
    int closeTime = 600;
    int waitOverTen = 0;
    int count=0;

        //Simulates cars arriving to car wash
        //each step represents one minute in a work day
        for (int time = 0; time <= bay.totalMin; time++) {
            //Pints each individual time step (for debugging)
            //System.out.println("Time step: " + time);
            //Car arrival rate (integers 1-4)
            int arrivalRate = rand.nextInt(4);
            count++;
            int waitTime=0;
            //CAR ARRIVES
            if (arrivalRate == 0 && time <= closeTime) {
                //increments number of cars that have arrived
                numCarsArrived++;
                //initializes arriving Car
                Car car = new Car();
                //stores arrival time with Car
                car.setArrivalTime(time);
                //adds car to queue
                line.enqueue(car);
                //Prints when car X arrives, and tells how many cars are in line
                //System.out.println("\tCar:" + car.getArrivalTime() + " Arrived. The number of cars now in queue is " + line.size());
            }

            //if bay is empty...
            if (bay.isEmpty() == 0 && !line.isEmpty()) {

                //keeps Car wash open until all cars waiting in line have gone through the wash
                if(time>=closeTime)
                    bay.totalMin++;
                //remove car from queue
                Car carBeingWashed = line.dequeue();
                //calculates a car's individual wait time (to check if 10 or more minute wait)
                waitTime = (time - carBeingWashed.getArrivalTime());
                //adds up total wait time experienced by all cars in a given day
                totalWaitTime += (time - carBeingWashed.getArrivalTime());
                //increments for every car that enters the wash after waiting 10 or more minutes
                if(waitTime>=10){
                    waitOverTen++;
                }

                //"washes" car; stores wash time in waitTime
                bay.washCar();
                bay.washTimer--;
                //Prints when car X enters wash where X is the cars arrival time
                //System.out.println("\tCar:" + carBeingWashed.getArrivalTime() + " Enters Wash. wait time: "+waitTime+" The number of cars now in queue is " + line.size());
            }

            //Car arrived but bay occupied, decrease wait time by 1
            else {
                if (bay.isEmpty() > 0) {
                    bay.washTimer--;
                    //keeps Car wash open until all cars waiting in line have gone through the wash
                    if(time>=closeTime)
                        bay.totalMin++;
                }
            }

            //used to print time remaining until bay is open
            if (bay.isEmpty() != 0) {
                //System.out.println("\tBay open in " + (bay.isEmpty()) + " minutes.");
            }
        }
        //calculates average time by dividing total wait time by the total number of cars arrived in a given day
        float avgTime = ((float) totalWaitTime/numCarsArrived);
        System.out.println("Total time: "+count+"\tAvg wait time: "+avgTime+"\tNumber of cars arrived: "+numCarsArrived+"\tNum cars with 10+min wait: "+waitOverTen);

        }

        }
