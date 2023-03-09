package src.Gates.SimpleGates.NOT;

import src.Gates.Gate;

public class NOT_Gate extends Gate {

    public NOT_Gate() {
        super(1);
    }

    @Override
    public boolean findOutput() {
        return !this.inputs[0].calcOutput();
    }



}
