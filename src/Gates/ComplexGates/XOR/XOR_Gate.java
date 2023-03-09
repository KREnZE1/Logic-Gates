package src.Gates.ComplexGates.XOR;

import src.Gates.ComplexGates.ComplexGate;
import src.Gates.SimpleGates.AND.AND_Gate;
import src.Gates.SimpleGates.NOT.NOT_Gate;
import src.Gates.SimpleGates.OR.OR_Gate;

public class XOR_Gate extends ComplexGate{

    private AND_Gate both, and;
    private NOT_Gate not;
    private OR_Gate or;

    public XOR_Gate() {
        super(2);
        both = new AND_Gate();
        and = new AND_Gate();
        not = new NOT_Gate();
        or = new OR_Gate();
    }

    @Override
    public boolean findOutput() {
        connect();
        return and.calcOutput();
    }

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
