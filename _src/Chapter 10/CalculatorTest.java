import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/* CalculatorTest.java
 */

public class CalculatorTest extends TestCase {

    private Calculator calculator;
    
    public CalculatorTest(String name) {
        super(name);
    }

    @Before
    public void setUp()  {
        calculator = new Calculator();
    }
    
    @After
    public void tearDown()  {
        calculator = null;
    }
    
    @Test
    public void testAddition(){
        String stra = "2";
        String strb = "3";
        int expected = 5;
        int actual = calculator.addition(stra, strb);
        assertEquals(expected, actual);
    }
    
    @Test(expected = NumberFormatException.class)
    public void testAdditionEx(){
        String stra = "str";
        String strb = "3";         
        calculator.addition(stra, strb);
    }

}