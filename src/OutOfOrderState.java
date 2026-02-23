public class OutOfOrderState implements VendingMachineState {
    private VendingMachineController machine;

    public OutOfOrderState(VendingMachineController machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem() {
        System.out.println("Action denied: Machine is out of order.");
    }

    @Override
    public void insertCoin() {
        System.out.println("Action denied: Machine is out of order. Returning coin.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Action denied: Machine is out of order.");
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Machine is already marked as out of order.");
    }
}