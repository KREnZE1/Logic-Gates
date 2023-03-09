package src.Gates.ComplexGates.XNOR;

import src.Gates.ComplexGates.ComplexGate;
import src.Gates.ComplexGates.XOR.XOR_Gate;
import src.Gates.SimpleGates.NOT.NOT_Gate;

public class XNOR_Gate extends ComplexGate{

    private NOT_Gate not;
    private XOR_Gate xor;

    public XNOR_Gate() {
        super(2, new NOT_Gate());
        not = (NOT_Gate) finalGate;
        xor = new XOR_Gate();
    }

    @Override
    public void connect() {
        xor.setInput(this.inputs[0], 0);
        xor.setInput(this.inputs[1], 1);

        not.setInput(xor, 0);
    }

}
