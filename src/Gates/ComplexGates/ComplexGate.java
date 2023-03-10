package src.Gates.ComplexGates;

import src.Gates.Gate;

public abstract class ComplexGate extends Gate{

    protected Gate finalGate; //The gate which produces the final output of the combination

    /*
     * Creates an object of type ComplexGate
     * The array containing the inputs can be sized differently depending on which gate is being built
     * Thus, the constructor takes the number of inputs as a parameter.
     * Furthermore, complex gates rely on combining multiple gates to process a value.
     * However, one gate produces the final output, which can then be used to access the total result of the gate
     */
    public ComplexGate(int inputSize, Gate pFinal) {
        super(inputSize);
        finalGate = pFinal;
    }

    /*
     * @return: boolean: whether or not the final gate in the sequence returns true
     * First, all underlying gates in the more complex gate are connected
     * Then, the result of the final gate can be computed. It recursively asks for the results of all previous gates in the circuit
     */
    public boolean findOutput() {
        connect();
        return finalGate.calcOutput();
    }

    /*
     * All complex gates rely on a combination of other gates. They need to be connected before they can produce the correct result.
     * However, each gate combines its parts differently, therefore this method has to be implemented by all child classes
     */
    public abstract void connect();

}
