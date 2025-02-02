import javax.lang.model.element.Element;

/**
 * Created by dsout on 4/21/2017.
 */
public class Reverser {
    //user input string
    String input;
    String output;
    String phrase;

    public Reverser(String in) {
        input = in;
    }

    public String reverseWord() {
        int stackSize = input.split(" ").length;
        ArrayStack array = new ArrayStack();
        String[] word = input.split(" ");
        System.out.println("word:" + word);
        //input
        for (String i : word) {
            array.push(i);
        }

        output = "";
        while (!array.isEmpty()) {

            for (int i = 0; i < stackSize; i++) {
                String phrase = (String) array.pop();
                output += phrase + " ";
            }

        }
        return output;
    }

    public String reverseChar() {
        int stackSize = input.split(" ").length;
        ArrayStack array = new ArrayStack();
        String[] word = input.split(" ");



        for (String i : word) {
            int wordSize = i.length();
            for (int j = 0; j < wordSize; j++) {
                char c = i.charAt(j);
                array.push(c);
            }
            array.push(" ");
        }
        //System.out.println("STACK:" + array);
        output = "";
        while(!array.isEmpty()) {
                //char c = (char) array.pop();
                output = output+array.pop();

            }

        return output;

        }

    }




