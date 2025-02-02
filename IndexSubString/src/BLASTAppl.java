import java.util.ArrayList;

public class BLASTAppl {


/**
 * BLASTAppl
 *
 * @author David Southwell
 * @version 9 June 2017
 */

    /** The main function asks user for file name. */
    public static void main(String[] args)

    {
        Debug.turnOn();
        String suggested = new String("TestData.txt");
        Simulation simulation = new Simulation(suggested,5);
        simulation.indexDataBase();




        //ArrayList dataArray = new ArrayList(dnaReader.readData());
        //for(int i=0; i<dataArray.size(); i++){
        //	Debug.println("DNASequence Object("+i+"):"+dataArray.get(i));
        //}
        //System.out.println(new Location(0,4));
        //Debug.println("ArrayList:"+dataArray.get(2));


    }
}

