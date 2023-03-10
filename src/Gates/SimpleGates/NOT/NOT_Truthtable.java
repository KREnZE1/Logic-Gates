package src.Gates.SimpleGates.NOT;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Output;

public class NOT_Truthtable {

    NOT_Gate notGate;
    Output startValue;

    /*
     * Initialises all needed values to a clean state
     */
    @Before //Runs right before any test is executed
    public void setup() {
        notGate = new NOT_Gate();
        startValue = new Output();
    }

    @Test
    public void inFalse() {
        startValue.setOutput(false);
        notGate.setInput(startValue, 0);
        //A false value creates a true value when fed into the logical NOT-Gate
        assertTrue(notGate.calcOutput());
    }

    @Test
    public void inTrue() {
        startValue.setOutput(true);
        notGate.setInput(startValue, 0);
        //A true value creates a false value when fed into the logical NOT-Gate
        assertFalse(notGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            notGate.setInput(startValue, 1); //A wrong index should lead to an Exception being thrown
        } catch (IllegalArgumentException iae) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }

    @Test
    public void inputNotSet() {
        boolean output = false;
        try {
            notGate.calcOutput(); //If an index was not set before the output is calculated an Exception should be thrown
        } catch(NullPointerException npe) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }
}
