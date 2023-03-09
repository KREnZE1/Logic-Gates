package src.Gates.ComplexGates.NAND;

import src.Gates.ComplexGates.ComplexGate;
import src.Gates.SimpleGates.AND.AND_Gate;
import src.Gates.SimpleGates.NOT.NOT_Gate;

public class NAND_Gate extends ComplexGate {

    private AND_Gate and;
    private NOT_Gate not;

    public NAND_Gate() {
        super(2, new NOT_Gate());
        not = (NOT_Gate) finalGate;
        and = new AND_Gate();
    }

    @Override
    public void connect() {
        and.setInput(this.inputs[0], 0);
        and.setInput(this.inputs[1], 1);

        not.setInput(and, 0);
    }
}
