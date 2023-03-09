package src.OR;

import src.Gate;

public class OR_Gate extends Gate{

    public OR_Gate() {
        super(2);
    }

    @Override
    public boolean findOutput() {
        return (inputs[0].calcOutput() || inputs[1].calcOutput());
    }

}
