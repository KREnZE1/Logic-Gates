public class NOT_Gate extends Gate {

    public NOT_Gate() {
        super.setInputSize(1);
    }

    @Override
    public void setInput(LogicUnit u, int index) {
        if (index != 0) {
            throw new IllegalArgumentException("Index " + index + " is an invalid argument");
        }
        this.inputs[index] = u;
    }

    @Override
    public boolean calcOutput() {
        if (this.inputs[0] != null) this.output = !this.inputs[0].calcOutput();
        else throw new NullPointerException("Input not yet assigned");
        return this.output;
    }



}
