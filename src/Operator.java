import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;
import java.util.HashMap;
public abstract class Operator {

    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );
    static final HashMap<String, Operator> operators = new HashMap<>();

    public abstract int priority();
    static{
        operators.put("+", new AdditionOperator());
        operators.put("-", new SubtractionOperator());
        operators.put("*", new MultiplicationOperator());
        operators.put("/", new DivisionOperator());
        operators.put("^", new PowerOperator());
        operators.put("(", new LeftParaOperator());
        operators.put(")", new RightParaOperator());
        operators.put("!", new ExclamationParaOperator());
        operators.put("#", new StartExpressionOperator());
    }
    public abstract Operand execute( Operand op1, Operand op2 );

    public static boolean check( String token ) {

         if((token.equals("+")|| token.equals("-")||token.equals("*") ||
                token.equals("/")||token.equals("^")||token.equals("(")||token.equals(")")|| token.equals("!"))){
             return true;
         }
         return false;
    }

    public static Operator getOperator(String token){
        return operators.get(token);
    }

    public static class AdditionOperator extends Operator {

        public AdditionOperator() {
        }

        @Override
        public int priority() {
            return 2; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Operand execute(Operand op1, Operand op2) {
           Operand ans = new Operand(op1.getValue() + op2.getValue());
        return ans; //To change body of generated methods, choose Tools | Templates.
        }
    }
    

    private static class SubtractionOperator extends Operator {

        public SubtractionOperator() {
        }

        @Override
        public int priority() {
            return 1;  //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Operand execute(Operand op1, Operand op2) {
            Operand ans = new Operand(op1.getValue() - op2.getValue());
        return ans; //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class MultiplicationOperator extends Operator {

        public MultiplicationOperator() {
        }

        @Override
        public int priority() {
            return 3;  //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Operand execute(Operand op1, Operand op2) {
             Operand ans = new Operand(op1.getValue() * op2.getValue());
        return ans; //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class DivisionOperator extends Operator {

        public DivisionOperator() {
        }

        @Override
        public int priority() {
            return 4; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Operand execute(Operand op1, Operand op2) {
            Operand ans = new Operand(op1.getValue() / op2.getValue());
        return ans; //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class PowerOperator extends Operator {

        public PowerOperator() {
        }

        @Override
        public int priority() {
            return 5; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Operand execute(Operand op1, Operand op2) {
            Operand ans;
            ans = new Operand((int) power(op1.getValue(),op2.getValue() ));
        return ans; //To change body of generated methods, choose Tools | Templates.
        }
    }

    

    

    private static class RightParaOperator extends Operator {

        public RightParaOperator() {
        }

        @Override
        public int priority() {
            return 1; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Operand execute(Operand op1, Operand op2) {
            return null; //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class ExclamationParaOperator extends Operator {

        public ExclamationParaOperator() {
        }

        @Override
        public int priority() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Operand execute(Operand op1, Operand op2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}