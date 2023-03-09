package src.OR;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Output;

public class OR_Truthtable {

    OR_Gate orGate;
    Output o1, o2;

    @Before
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
        assertFalse(orGate.calcOutput());
    }

    @Test
    public void inFalseTrue() {
        o1.setOutput(false);
        o2.setOutput(true);
        orGate.setInput(o1, 0);
        orGate.setInput(o2, 1);
        assertTrue(orGate.calcOutput());
    }

    @Test
    public void inTrueFalse() {
        o1.setOutput(true);
        o2.setOutput(false);
        orGate.setInput(o1, 0);
        orGate.setInput(o2, 1);
        assertTrue(orGate.calcOutput());
    }

    @Test
    public void inTrueTrue() {
        o1.setOutput(true);
        o2.setOutput(true);
        orGate.setInput(o1, 0);
        orGate.setInput(o2, 1);
        assertTrue(orGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            orGate.setInput(o1, 2);
        } catch(IllegalArgumentException iae) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputOneNotSet() {
        boolean output = false;
        orGate.setInput(o2, 1);
        try {
            orGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputTwoNotSet() {
        boolean output = false;
        orGate.setInput(o1, 0);
        try {
            orGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void neitherInputSet() {
        boolean output = false;
        try {
            orGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }
}
//TODO: Create tests for interconnected nets of logic gates
