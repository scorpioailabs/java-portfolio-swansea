import java.io.StreamTokenizer;

// Try this example:
// 1 2 +		=> returns (1 + 2) = 3
// 3 4 2 + *	=> returns (3 * ( 4 + 2)) = 18

public class ReversePolish {
    public static void main(String [] args) throws Exception 
    {
        ArrayStack stack = new ArrayStack(100);
        Double a,b;
        double va,vb,vv=0;
        char ch;
        StreamTokenizer parser = new StreamTokenizer(System.in);
        parser.ordinaryChar('/');
        System.out.println(" type in postfix expression: ");
        while ( parser.nextToken() != StreamTokenizer.TT_EOF ) {
            if  ( parser.ttype == StreamTokenizer.TT_NUMBER ) {
                System.out.println( " read a number:  " + parser.nval );
                stack.push(new Double(parser.nval));
            }
            else {
                System.out.println( " read:  " + (char) parser.ttype);
                ch = (char) parser.ttype;
                if ((ch == '+') || (ch == '-') ||
                    (ch == '*')|| (ch == '/')) {
                    a = (Double) stack.pop();
                    b = (Double) stack.pop();
                    va = a.doubleValue();
                    vb = b.doubleValue();
                    switch(ch) {
                        case '+': vv = vb + va; break;
                        case '-': vv = vb - va; break;
                        case '*': vv = vb * va; break;
                        case '/': vv = vb / va; break;
                    }
                    stack.push(new Double(vv));
                    System.out.println(" =  "+vv);
                }
                else {
                    throw new Exception(ch + "  is an invalid character ");
                }
            }
        }
        a = (Double) stack.pop();
        System.out.println(" result =  "+a);
    }
}
