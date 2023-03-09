package src.Gates.ComplexGates.XOR;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Output;

public class XOR_Truthtable {
    XOR_Gate xorGate;
    Output o1, o2;

    @Before
    public void setup() {
        xorGate = new XOR_Gate();
        o1 = new Output();
        o2 = new Output();
    }

    @Test
    public void inFalseFalse() {
        o1.setOutput(false);
        o2.setOutput(false);
        xorGate.setInput(o1, 0);
        xorGate.setInput(o2, 1);
        assertFalse(xorGate.calcOutput());
    }

    @Test
    public void inFalseTrue() {
        o1.setOutput(false);
        o2.setOutput(true);
        xorGate.setInput(o1, 0);
        xorGate.setInput(o2, 1);
        assertTrue(xorGate.calcOutput());
    }

    @Test
    public void inTrueFalse() {
        o1.setOutput(true);
        o2.setOutput(false);
        xorGate.setInput(o1, 0);
        xorGate.setInput(o2, 1);
        assertTrue(xorGate.calcOutput());
    }

    @Test
    public void inTrueTrue() {
        o1.setOutput(true);
        o2.setOutput(true);
        xorGate.setInput(o1, 0);
        xorGate.setInput(o2, 1);
        assertFalse(xorGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            xorGate.setInput(o1, 2);
        } catch(IllegalArgumentException iae) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputOneNotSet() {
        boolean output = false;
        xorGate.setInput(o2, 1);
        try {
            xorGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputTwoNotSet() {
        boolean output = false;
        xorGate.setInput(o1, 0);
        try {
            xorGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void neitherInputSet() {
        boolean output = false;
        try {
            xorGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }
}
