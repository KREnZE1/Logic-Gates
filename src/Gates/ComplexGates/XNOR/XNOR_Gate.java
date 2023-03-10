package src.Gates.ComplexGates.XNOR;

import src.Gates.ComplexGates.ComplexGate;
import src.Gates.ComplexGates.XOR.XOR_Gate;
import src.Gates.SimpleGates.NOT.NOT_Gate;

public class XNOR_Gate extends ComplexGate {

    private NOT_Gate not;
    private XOR_Gate xor;

    /*
     * NAND-Gates combine two values into a single output value
     */
    public XNOR_Gate() {
        super(2, new NOT_Gate()); //The last gate in a XNOR-Gate is the NOT-Gate
        not = (NOT_Gate) finalGate;
        xor = new XOR_Gate();
    }

    /*
     * This method sets the inputs of the XOR-Gate to be the inputs of the whole gate
     * The output of the XOR-Gate is then fed into the NOT-Gate to negate it
     */
    @Override
    public void connect() {
        xor.setInput(this.inputs[0], 0);
        xor.setInput(this.inputs[1], 1);

        not.setInput(xor, 0);
    }

}
