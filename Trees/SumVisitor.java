/**
 * Created by dsout on 5/12/2017.
 */
public class SumVisitor implements NodeVisitor
{
    int sum;
    public SumVisitor ()
    {
        sum = 0;
    }

    public void visit(Object data) {
        if (data != null) {
            sum += (Integer) data;
        }
    }
    public int sum(){

        return sum;
    }

}