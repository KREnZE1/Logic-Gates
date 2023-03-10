package src;

public class Output extends LogicUnit {

    private boolean output;

    /*
     * An Output consistently sends the same type of signal
     * It has no inputs
     */
    public Output() {
        this.setOutput(false);
    }

    public Output(boolean pVal) {
        this.setOutput(pVal);
    }

    public void setOutput(boolean pVal) {this.output = pVal;}

    @Override
    public boolean calcOutput() {
        return this.output;
    }
}
