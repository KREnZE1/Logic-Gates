package src.Gates.SimpleGates.AND;

import src.Gates.Gate;

public class AND_Gate extends Gate{

    /*
     * AND-Gates typically take two inputs and return a single value
     */
    public AND_Gate() {
        super(2);
    }

    /*
     * @return: boolean: whether both inputs are true
     * An AND-Gate returns true only if both of its inputs are also true
     */
    @Override
    public boolean findOutput() {
        return (this.inputs[0].calcOutput() && this.inputs[1].calcOutput());
    }

}
