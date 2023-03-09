public abstract class Gate extends LogicUnit{
    protected LogicUnit[] inputs;

    public void setInput(LogicUnit u, int index) {
        if (index < 0 || index >= this.inputs.length) throw new IllegalArgumentException("Index " + index + " invalid");
        this.inputs[index] = u;
    }

    public boolean calcOutput() {
        if (inputsFull()) return findOutput();
        return false; //Should never be reached???
    }

    public boolean inputsFull() {
        for (int i = 0; i<this.inputs.length; i++) {
            if (this.inputs[i] == null) throw new NullPointerException("Input not yet assigned");
        }
        return true;
    }

    public abstract boolean findOutput();

    public void setInputSize(int size) {inputs = new LogicUnit[size];}
}