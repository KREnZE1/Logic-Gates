package src.Gates.ComplexGates;

import src.Gates.Gate;

public abstract class ComplexGate extends Gate{

    protected Gate finalGate;

    public ComplexGate(int inputSize, Gate pFinal) {
        super(inputSize);
        finalGate = pFinal;
    }

    public boolean findOutput() {
        connect();
        return finalGate.calcOutput();
    }

    public abstract void connect();

}
