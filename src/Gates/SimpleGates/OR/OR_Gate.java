package src.Gates.SimpleGates.OR;

import src.Gates.Gate;

public class OR_Gate extends Gate{

    /*
     * OR-Gates typically take two inputs and return a single value
     */
    public OR_Gate() {
        super(2);
    }

    /*
     * @return: boolean: whether at least one input is true
     * An OR-Gate returns true if at least one of its inputs is also true
     */
    @Override
    public boolean findOutput() {
        return (inputs[0].calcOutput() || inputs[1].calcOutput());
    }

}
