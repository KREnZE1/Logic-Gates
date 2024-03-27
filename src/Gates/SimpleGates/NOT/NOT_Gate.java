package src.Gates.SimpleGates.NOT;

import src.Gates.Gate;

public class NOT_Gate extends Gate {

    /*
     * NOT-Gates take one input value and return one output value
     */
    public NOT_Gate() {
        super(1);
    }

    /*
     * @return: boolean: the negation of the input value
     * A NOT-Gate returns the negated value of its input
     */
    @Override
    public boolean findOutput() {
        return !this.inputs[0].calcOutput();
    }



}
