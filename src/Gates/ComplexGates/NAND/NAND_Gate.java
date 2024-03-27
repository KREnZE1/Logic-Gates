package src.Gates.ComplexGates.NAND;

import src.Gates.ComplexGates.ComplexGate;
import src.Gates.SimpleGates.AND.AND_Gate;
import src.Gates.SimpleGates.NOT.NOT_Gate;

public class NAND_Gate extends ComplexGate {

    private AND_Gate and;
    private NOT_Gate not;

    /*
     * NAND-Gates combine two input values into a single output value
     */
    public NAND_Gate() {
        super(2, new NOT_Gate()); //The last gate in a NAND-Gate is the NOT-Gate
        not = (NOT_Gate) finalGate;
        and = new AND_Gate();
    }

    /*
     * This method sets the inputs of the AND-Gate to be the inputs of the whole gate
     * The output of the AND-Gate is then fed into the NOT-Gate to negate it
     */
    @Override
    public void connect() {
        and.setInput(this.inputs[0], 0);
        and.setInput(this.inputs[1], 1);

        not.setInput(and, 0);
    }
}
