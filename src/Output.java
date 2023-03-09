package src;
public class Output extends LogicUnit {

    private boolean output;

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
