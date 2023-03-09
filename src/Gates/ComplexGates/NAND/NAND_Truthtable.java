package src.Gates.ComplexGates.NAND;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Output;

public class NAND_Truthtable {

    NAND_Gate nandGate;
    Output o1, o2;

    @Before
    public void setup() {
        nandGate = new NAND_Gate();
        o1 = new Output();
        o2 = new Output();
    }

    @Test
    public void inFalseFalse() {
        o1.setOutput(false);
        o2.setOutput(false);
        nandGate.setInput(o1, 0);
        nandGate.setInput(o2, 1);
        assertTrue(nandGate.calcOutput());
    }

    @Test
    public void inFalseTrue() {
        o1.setOutput(false);
        o2.setOutput(true);
        nandGate.setInput(o1, 0);
        nandGate.setInput(o2, 1);
        assertTrue(nandGate.calcOutput());
    }

    @Test
    public void inTrueFalse() {
        o1.setOutput(true);
        o2.setOutput(false);
        nandGate.setInput(o1, 0);
        nandGate.setInput(o2, 1);
        assertTrue(nandGate.calcOutput());
    }

    @Test
    public void inTrueTrue() {
        o1.setOutput(true);
        o2.setOutput(true);
        nandGate.setInput(o1, 0);
        nandGate.setInput(o2, 1);
        assertFalse(nandGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            nandGate.setInput(o1, 2);
        } catch(IllegalArgumentException iae) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputOneNotSet() {
        boolean output = false;
        nandGate.setInput(o2, 1);
        try {
            nandGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputTwoNotSet() {
        boolean output = false;
        nandGate.setInput(o1, 0);
        try {
            nandGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void neitherInputSet() {
        boolean output = false;
        try {
            nandGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }
}
