package src.Gates.SimpleGates.OR;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Output;

public class OR_Truthtable {

    OR_Gate orGate; //The tested Gate
    Output o1, o2; //The necessary inputs to test the gates functionality

    /*
     * Initialises all needed values to a clean state
     */
    @Before //Runs right before any test is executed
    public void setup() {
        orGate = new OR_Gate();
        o1 = new Output();
        o2 = new Output();
    }

    @Test
    public void inFalseFalse() {
        o1.setOutput(false);
        o2.setOutput(false);
        orGate.setInput(o1, 0);
        orGate.setInput(o2, 1);
        //Two false values create a false value when fed into the logical OR-Gate
        assertFalse(orGate.calcOutput());
    }

    @Test
    public void inFalseTrue() {
        o1.setOutput(false);
        o2.setOutput(true);
        orGate.setInput(o1, 0);
        orGate.setInput(o2, 1);
        //A false and a true value create a true value when fed into the logical OR-Gate
        assertTrue(orGate.calcOutput());
    }

    @Test
    public void inTrueFalse() {
        o1.setOutput(true);
        o2.setOutput(false);
        orGate.setInput(o1, 0);
        orGate.setInput(o2, 1);
        //A true and a false value create a true value when fed into the logical OR-Gate
        assertTrue(orGate.calcOutput());
    }

    @Test
    public void inTrueTrue() {
        o1.setOutput(true);
        o2.setOutput(true);
        orGate.setInput(o1, 0);
        orGate.setInput(o2, 1);
        //Two true values create a true value when fed into the logical OR-Gate
        assertTrue(orGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            orGate.setInput(o1, 2); //A wrong index should lead to an Exception being thrown
        } catch(IllegalArgumentException iae) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }

    @Test
    public void inputOneNotSet() {
        boolean output = false;
        orGate.setInput(o2, 1);
        try {
            orGate.calcOutput(); //If an index was not set before the output is calculated an Exception should be thrown
        } catch(NullPointerException npe) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }

    @Test
    public void inputTwoNotSet() {
        boolean output = false;
        orGate.setInput(o1, 0);
        try {
            orGate.calcOutput(); //If an index was not set before the output is calculated an Exception should be thrown
        } catch(NullPointerException npe) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }

    @Test
    public void neitherInputSet() {
        boolean output = false;
        try {
            orGate.calcOutput(); //If an index was not set before the output is calculated an Exception should be thrown
        } catch(NullPointerException npe) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }
}
