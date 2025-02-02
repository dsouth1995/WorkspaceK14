/**
 * A simple class for experimenting with stack functions.
 * @David Southwell
 *
 */
public class ParenthesisMain extends ArrayStack {

    /*Call this method by passing a string expression*/
    ArrayStack stack = new ArrayStack();
    String input;
    stack.checkParen(ValidatedInputReader(input));
    public void checkParen(String str) {
        try {
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(')
                    push(arr[i]);
                else if (arr[i] == '}' && peek() == '{')
                    pop();
                else if (arr[i] == ']' && peek() == '[')
                    pop();
                else if (arr[i] == ')' && peek() == '(')
                    pop();
            }
            if (isEmpty()) {
                System.out.println("String is balanced");
            } else {
                System.out.println("String is not balanced");
            }
        } catch (Exception e) {
            System.out.println("String not balanced");
        }

    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
