public class IdleState implements VendingMachineState {
    private VendingMachineController machine;

    public IdleState(VendingMachineController machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem() {
        System.out.println("Item selected successfully.");
        machine.setState(machine.getItemSelectedState());
    }
    @Override
    public void insertCoin() {
        System.out.println("Action denied: Please select an item first before inserting coins.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Action denied: Cannot dispense. No item selected.");
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Maintenance alert: Machine is now out of order.");
        machine.setState(machine.getOutOfOrderState());
    }
}