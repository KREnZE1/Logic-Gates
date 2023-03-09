public class AND_Gate extends Gate{

    public AND_Gate() {
        super.setInputSize(2);
    }

    @Override
    public void setInput(LogicUnit u, int index) {
        if (index > 1 || index < 0) {
            throw new IllegalArgumentException("Index " + index + " is an invalid argument");
        }
        this.inputs[index] = u;
    }

    @Override
    public boolean calcOutput() {
        if (this.inputs[0] == null || this.inputs[1] == null) throw new NullPointerException("Index not yet assigned");
        return (this.inputs[0].calcOutput() && this.inputs[1].calcOutput());
    }

}
