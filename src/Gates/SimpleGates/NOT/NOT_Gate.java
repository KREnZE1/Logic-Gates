package src.Gates.SimpleGates.NOT;

import src.Gates.Gate;

public class NOT_Gate extends Gate {

    /*
     * NOT-Gates typically take one input and return a single value
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
