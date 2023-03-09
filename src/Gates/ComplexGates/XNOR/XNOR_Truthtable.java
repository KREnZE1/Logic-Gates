package src.Gates.ComplexGates.XNOR;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Output;

public class XNOR_Truthtable {
    XNOR_Gate xnorGate;
    Output o1, o2;

    @Before
    public void setup() {
        xnorGate = new XNOR_Gate();
        o1 = new Output();
        o2 = new Output();
    }

    @Test
    public void inFalseFalse() {
        o1.setOutput(false);
        o2.setOutput(false);
        xnorGate.setInput(o1, 0);
        xnorGate.setInput(o2, 1);
        assertTrue(xnorGate.calcOutput());
    }

    @Test
    public void inFalseTrue() {
        o1.setOutput(false);
        o2.setOutput(true);
        xnorGate.setInput(o1, 0);
        xnorGate.setInput(o2, 1);
        assertFalse(xnorGate.calcOutput());
    }

    @Test
    public void inTrueFalse() {
        o1.setOutput(true);
        o2.setOutput(false);
        xnorGate.setInput(o1, 0);
        xnorGate.setInput(o2, 1);
        assertFalse(xnorGate.calcOutput());
    }

    @Test
    public void inTrueTrue() {
        o1.setOutput(true);
        o2.setOutput(true);
        xnorGate.setInput(o1, 0);
        xnorGate.setInput(o2, 1);
        assertTrue(xnorGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            xnorGate.setInput(o1, 2);
        } catch(IllegalArgumentException iae) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputOneNotSet() {
        boolean output = false;
        xnorGate.setInput(o2, 1);
        try {
            xnorGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputTwoNotSet() {
        boolean output = false;
        xnorGate.setInput(o1, 0);
        try {
            xnorGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void neitherInputSet() {
        boolean output = false;
        try {
            xnorGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }
}
