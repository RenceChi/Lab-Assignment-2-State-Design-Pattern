public class ItemSelectedState implements VendingMachineState {
    private VendingMachineController machine;

    public ItemSelectedState(VendingMachineController machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem() {
        System.out.println("Action denied: An item is already selected.");
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted. Updating balance...");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Payment accepted. Preparing to dispense...");
        machine.setState(machine.getDispensingState());
        machine.getState().dispenseItem();
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Error detected. Refunding inserted coins. Machine is now out of order.");
        // Logic to refund balance goes here
        machine.setState(machine.getOutOfOrderState());
    }
}