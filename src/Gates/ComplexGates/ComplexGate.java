package src.Gates.ComplexGates;

import src.Gates.Gate;

public abstract class ComplexGate extends Gate{

    public ComplexGate(int inputSize) {
        super(inputSize);
    }

    public abstract void connect();

}
