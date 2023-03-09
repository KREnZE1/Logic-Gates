import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

public class NOT_Truthtable {

    NOT_Gate notGate;
    Output startValue;

    @Before
    public void setup() {
        notGate = new NOT_Gate();
        startValue = new Output();
    }

    @Test
    public void inFalse() {
        startValue.setOutput(false);
        notGate.setInput(startValue, 0);
        assertTrue(notGate.calcOutput());
    }

    @Test
    public void inTrue() {
        startValue.setOutput(true);
        notGate.setInput(startValue, 0);
        assertFalse(notGate.calcOutput());
    }

    @Test
    public void tooManyInputs() {
        boolean output = false;
        try {
            notGate.setInput(startValue, 1);
        } catch (IllegalArgumentException iae) {
            output = true;
        }
        assertTrue(output);
    }

    @Test
    public void inputNotSet() {
        boolean output = false;
        try {
            notGate.calcOutput();
        } catch(NullPointerException npe) {
            output = true;
        }
        assertTrue(output);
    }
}
