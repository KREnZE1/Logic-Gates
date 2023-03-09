public class Output extends LogicUnit {

    public Output() {}

    public Output(boolean pVal) {
        this.setOutput(pVal);
    }

    public void setOutput(boolean pVal) {this.output = pVal;}

    @Override
    public boolean calcOutput() {return this.output;}
}
