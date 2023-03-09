package src.NOT;

import src.Gate;

public class NOT_Gate extends Gate {

    public NOT_Gate() {
        super(1);
    }

    @Override
    public boolean findOutput() {
        if (this.inputs[0] != null) this.output = !this.inputs[0].calcOutput();
        else throw new NullPointerException("Input not yet assigned");
        return this.output;
    }



}
