public class DispensingState implements VendingMachineState {
    private VendingMachineController machine;

    public DispensingState(VendingMachineController machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem() {
        System.out.println("Please wait, currently dispensing your item.");
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, currently dispensing your item.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Item dispensed successfully!");

        if (machine.getInventory() <= 0) {
            machine.setState(machine.getOutOfOrderState());
        } else {
            machine.setState(machine.getIdleState());
        }
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Mechanical failure during dispense. Machine is now out of order.");
        machine.setState(machine.getOutOfOrderState());
    }
}