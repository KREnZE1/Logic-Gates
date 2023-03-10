package src.Gates.ComplexGates.NOR;

import src.Gates.ComplexGates.ComplexGate;
import src.Gates.SimpleGates.NOT.NOT_Gate;
import src.Gates.SimpleGates.OR.OR_Gate;

public class NOR_Gate extends ComplexGate{

    private OR_Gate or;
    private NOT_Gate not;

    /*
     * NAND-Gates combine two input values into a single output value
     */
    public NOR_Gate() {
        super(2, new NOT_Gate()); //The last gate in a NOR-Gate is the NOT-Gate
        not = (NOT_Gate) finalGate;
        or = new OR_Gate();
    }

    /*
     * This method sets the inputs of the OR-Gate to be the inputs of the whole gate
     * The output of the OR-Gate is then fed into the NOT-Gate to negate it
     */
    @Override
    public void connect() {
        or.setInput(inputs[0], 0);
        or.setInput(inputs[1], 1);

        not.setInput(or, 0);
    }

}
