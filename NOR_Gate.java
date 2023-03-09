public class NOR_Gate extends Gate{

    private OR_Gate or;
    private NOT_Gate not;

    public NOR_Gate() {
        super(2);
        or = new OR_Gate();
        not = new NOT_Gate();
    }

    @Override
    public boolean findOutput() {
        connect();
        return not.calcOutput();
    }

    public void connect() {
        or.setInput(inputs[0], 0);
        or.setInput(inputs[1], 1);
        not.setInput(or, 0);
    }

}
