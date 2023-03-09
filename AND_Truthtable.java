import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AND_Truthtable {

    AND_Gate andGate;
    Output o1;
    Output o2;

    @Before
    public void setup() {
        andGate = new AND_Gate();
        o1 = new Output();
        o2 = new Output();
    }

    @Test
    public void inFalseFalse() {
        o1.setOutput(false);
        o2.setOutput(false);
        andGate.setInput(o1, 0);
        andGate.setInput(o2, 1);
        assertFalse(andGate.calcOutput());
    }

    @Test
    public void inFalseTrue() {
        o1.setOutput(false);
        o2.setOutput(true);
        andGate.setInput(o1, 0);
        andGate.setInput(o2, 1);
        assertFalse(andGate.calcOutput());
    }

    @Test
    public void inTrueFalse() {
        o1.setOutput(true);
        o2.setOutput(false);
        andGate.setInput(o1, 0);
        andGate.setInput(o2, 1);
        assertFalse(andGate.calcOutput());
    }

    @Test
    public void inTrueTrue() {
        o1.setOutput(true);
        o2.setOutput(true);
        andGate.setInput(o1, 0);
        andGate.setInput(o2, 1);
        assertTrue(andGate.calcOutput());
    }

    @Test
    public void invalidIndex() {
        boolean output = false;
        try {
            andGate.setInput(o1, 2);
        } catch(IllegalArgumentException iae) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputOneNotSet() {
        boolean output = false;
        andGate.setInput(o2, 1);
        try {
            andGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputTwoNotSet() {
        boolean output = false;
        andGate.setInput(o1, 0);
        try {
            andGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void neitherInputSet() {
        boolean output = false;
        try {
            andGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }
}
//TODO: Create tests for interconnected nets of logic gates
