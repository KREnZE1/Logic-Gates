package src.Gates.ComplexGates.NOR;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Output;

public class NOR_Truthtable {

    NOR_Gate norGate = new NOR_Gate();
    Output o1, o2;

    @Before
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
        assertTrue(norGate.calcOutput());
    }

    @Test
    public void inFalseTrue() {
        o1.setOutput(false);
        o2.setOutput(true);
        norGate.setInput(o1, 0);
        norGate.setInput(o2, 1);
        assertFalse(norGate.calcOutput());
    }

    @Test
    public void inTrueFalse() {
        o1.setOutput(true);
        o2.setOutput(false);
        norGate.setInput(o1, 0);
        norGate.setInput(o2, 1);
        assertFalse(norGate.calcOutput());
    }

    @Test
    public void inTrueTrue() {
        o1.setOutput(true);
        o2.setOutput(true);
        norGate.setInput(o1, 0);
        norGate.setInput(o2, 1);
        assertFalse(norGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            norGate.setInput(o1, 2);
        } catch(IllegalArgumentException iae) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputOneNotSet() {
        boolean output = false;
        norGate.setInput(o2, 1);
        try {
            norGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputTwoNotSet() {
        boolean output = false;
        norGate.setInput(o1, 0);
        try {
            norGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void neitherInputSet() {
        boolean output = false;
        try {
            norGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }
}
