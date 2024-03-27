package src.Gates.ComplexGates.NOR;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Output;

public class NOR_Truthtable {

    NOR_Gate norGate; //The tested Gate
    Output o1, o2; //The necessary inputs to test the gates functionality

    /*
     * Initialises all needed values to a clean state
     */
    @Before //Runs right before any test is executed
    public void setup() {
        norGate = new NOR_Gate();
        o1 = new Output();
        o2 = new Output();
    }

    @Test
    public void inFalseFalse() {
        o1.setOutput(false);
        o2.setOutput(false);
        norGate.setInput(o1, 0);
        norGate.setInput(o2, 1);
        //Two false values create a true value when fed into the logical NOR-Gate
        assertTrue(norGate.calcOutput());
    }

    @Test
    public void inFalseTrue() {
        o1.setOutput(false);
        o2.setOutput(true);
        norGate.setInput(o1, 0);
        norGate.setInput(o2, 1);
        //A false and a true value create a false value when fed into the logical NOR-Gate
        assertFalse(norGate.calcOutput());
    }

    @Test
    public void inTrueFalse() {
        o1.setOutput(true);
        o2.setOutput(false);
        norGate.setInput(o1, 0);
        norGate.setInput(o2, 1);
        //A true and a false value create a false value when fed into the logical NOR-Gate
        assertFalse(norGate.calcOutput());
    }

    @Test
    public void inTrueTrue() {
        o1.setOutput(true);
        o2.setOutput(true);
        norGate.setInput(o1, 0);
        norGate.setInput(o2, 1);
        //Two true values create a false value when fed into the logical NOR-Gate
        assertFalse(norGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            norGate.setInput(o1, 2); //A wrong index should lead to an Exception being thrown
        } catch(IllegalArgumentException iae) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }

    @Test
    public void inputOneNotSet() {
        boolean output = false;
        norGate.setInput(o2, 1);
        try {
            norGate.calcOutput(); //If an index was not set before the output is calculated an Exception should be thrown
        } catch(NullPointerException npe) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }

    @Test
    public void inputTwoNotSet() {
        boolean output = false;
        norGate.setInput(o1, 0);
        try {
            norGate.calcOutput(); //If an index was not set before the output is calculated an Exception should be thrown
        } catch(NullPointerException npe) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }

    @Test
    public void neitherInputSet() {
        boolean output = false;
        try {
            norGate.calcOutput(); //If an index was not set before the output is calculated an Exception should be thrown
        } catch(NullPointerException npe) {
            output = true; //If that exception is thrown, the test is successfull
        }
        assertTrue(output);
    }
}
