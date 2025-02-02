/**
 * A simple class for experimenting with stack functions.
 * @author 
 *
 */
public class StackMain {

	/**
	 * Read a sentence in from the user and then:
	 * <p>
	 * 1. Print the words in the sentence in reverse order.
	 * (order. reverse in sentence the in words the Print)
	 * <p>
	 * 2. Print the letters in each word in reverse order,
	 * while keeping the words in the original order.
	 * (tnirP eht srettel ni hcae drow ni esrever ,redro)
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		//user input string
		//String input = ValidatedInputReader.getString("Enter a sentence.", "");
		String input = "Hi My Name Is David";
		String wordOutput;
		String charOutput;
		Reverser rev = new Reverser(input);
		//REVERSES WORDS WITHIN AN INPUT STRING
		wordOutput = rev.reverseWord();
		System.out.println("OUTPUT OF WORD REVERSER:" + wordOutput);
		//REVERSES CHARACTERS WITHIN WORDS OF AN INPUT STRING
		Reverser rev2 = new Reverser(wordOutput);
		charOutput = rev2.reverseChar();
		System.out.println("OUTPUT OF WORD REVERSER:" + charOutput);
	}
}
