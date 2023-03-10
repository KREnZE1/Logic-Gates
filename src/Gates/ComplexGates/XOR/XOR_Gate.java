package src.Gates.ComplexGates.XOR;

import src.Gates.ComplexGates.ComplexGate;
import src.Gates.SimpleGates.AND.AND_Gate;
import src.Gates.SimpleGates.NOT.NOT_Gate;
import src.Gates.SimpleGates.OR.OR_Gate;

public class XOR_Gate extends ComplexGate {

    private AND_Gate both, and;
    private NOT_Gate not;
    private OR_Gate or;

    /*
     * NAND-Gates combine two values into a single output value
     */
    public XOR_Gate() {
        super(2, new AND_Gate()); //The last gate in a XOR-Gate is the AND-Gate
        and = (AND_Gate) finalGate;
        not = new NOT_Gate();
        both = new AND_Gate();
        or = new OR_Gate();
    }

    /*
     * This method sets the inputs of an AND-Gate to be the inputs of the whole gate
     * The inputs of the OR-Gate are also set to be the inputs of the whole gate
     * The NOT-Gate takes the output of the AND-Gate as its input
     * The second AND-Gate takes the outputs of the OR-Gate and the NOT-Gate as its inputs
     */
    @Override
    public void connect() {
        both.setInput(this.inputs[0], 0);
        both.setInput(this.inputs[1], 1);

        not.setInput(both, 0);

        or.setInput(this.inputs[0], 0);
        or.setInput(this.inputs[1], 1);

        and.setInput(not, 0);
        and.setInput(or, 1);
    }

}
