package src.Gates;

import src.LogicUnit;

public abstract class Gate extends LogicUnit{
    protected LogicUnit[] inputs; //Different gates take a different amount of inputs to calculate their results

    /*
     * Creates an object of type Gate
     * The array containing all inputs is sized differently depending on the underlying logic gate.
     * Thus, the constructor needs the number of inputs passed to it to create a correctly sized array
     */
    public Gate(int inputSize) {
        setInputSize(inputSize);
    }

    /*
     * @param: int size: how many inputs the current gate takes
     * Sets the size of the input array to the passed parameter
     */
    public void setInputSize(int size) {inputs = new LogicUnit[size];}

    /*
     * @param: LogicUnit u: the LogicUnit which feeds into one of the inputs of the current object
     * @param: int index: the index at which the LogicUnit should feed its input
     * This method inserts the passed LogicUnit into the inputs of the current LogicUnit
     * If the index is invalid, an IllegalArgumentException is thrown
     */
    public void setInput(LogicUnit u, int index) {
        //Checks the validity of the given index
        if (index < 0 || index >= this.inputs.length) throw new IllegalArgumentException("Index " + index + " invalid");
        this.inputs[index] = u;
    }

    /*
     * @return: boolean: whether the connected logic gates deliver true or false
     * If all inputs are connected to an Output (or other object of type LogicUnit) the method returns the output of the current gate
     * If not all inputs have a LogicUnit connected an exception is thrown to break out of the method
     * The return statement should never be reachable, as the exception halts execution.
     */
    public boolean calcOutput() {
        if (inputsFull()) return findOutput();
        return false; //Should never be reachable, as inputFull will throw an (uncaught) exception
    }

    /*
     * @return: boolean: whether all slots of the input array are filled
     * Loops through the inputs array. If any of the inputs is not set (meaning it is null) a NullPointerException is thrown
     * Otherwise, true is returned
     */
    public boolean inputsFull() {
        for (int i = 0; i<this.inputs.length; i++) {
            if (this.inputs[i] == null) throw new NullPointerException("Input not yet assigned");
        }
        return true;
    }

    /*
     * @return: boolean: method to actually calculate the value of the gate
     * This method has to be implemented by all child classes, because each gate works in their own way
     */
    public abstract boolean findOutput();

}