public abstract class Gate extends LogicUnit{
    protected LogicUnit[] inputs;

    public abstract void setInput(LogicUnit u, int index);

    public void setInputSize(int size) {inputs = new LogicUnit[size];}
}