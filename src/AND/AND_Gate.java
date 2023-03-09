package src.AND;

import src.Gate;

public class AND_Gate extends Gate{

    public AND_Gate() {
        super(2);
    }

    @Override
    public boolean findOutput() {
        if (this.inputs[0] == null || this.inputs[1] == null) throw new NullPointerException("Input not yet assigned");
        return (this.inputs[0].calcOutput() && this.inputs[1].calcOutput());
    }

}
