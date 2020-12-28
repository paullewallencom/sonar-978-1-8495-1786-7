/* 
 * Calculator.java
 */

public class Calculator {

    /**
     * Converts passed arguments to integers
     * and performs addition.
     * @param stra first argument
     * @param strb second argument
     * @return addition result of arguments
     * @throws NumberFormatException
     */
    public int addition(final String stra, 
            final String strb) 
					throws NumberFormatException{
        
        final int a = Integer.valueOf(stra);
        final int b = Integer.valueOf(strb);
        return a + b;
    }
}