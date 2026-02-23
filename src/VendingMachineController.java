public class VendingMachineController {

    private VendingMachineState idleState;
    private VendingMachineState itemSelectedState;
    private VendingMachineState dispensingState;
    private VendingMachineState outOfOrderState;
    private VendingMachineState currentState;
    private int inventory;
    private double balance;

    public VendingMachineController(int initialInventory) {
        idleState = new IdleState(this);
        itemSelectedState = new ItemSelectedState(this);
        dispensingState = new DispensingState(this);
        outOfOrderState = new OutOfOrderState(this);

        this.inventory = initialInventory;
        this.balance = 0.0;

        if (initialInventory > 0) {
            currentState = idleState;
        } else {
            currentState = outOfOrderState;
        }
    }

    // --- DELEGATED ACTIONS ---
    // The machine simply passes the request down to the current state object.

    public void selectItem() {
        currentState.selectItem();
    }
    public void insertCoin() {
        currentState.insertCoin();
    }
    public void dispenseItem() {
        currentState.dispenseItem();
    }
    public void setOutOfOrder() {
        currentState.setOutOfOrder();
    }
    // --- STATE MANAGEMENT ---

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getState() {
        return currentState;
    }

    // Getters for the state instances so the state classes can trigger transitions
    public VendingMachineState getIdleState() { return idleState; }
    public VendingMachineState getItemSelectedState() { return itemSelectedState; }
    public VendingMachineState getDispensingState() { return dispensingState; }
    public VendingMachineState getOutOfOrderState() { return outOfOrderState; }

    // --- ATTRIBUTE MANAGEMENT ---

    public int getInventory() { return inventory; }

    public void decreaseInventory() {
        if (inventory > 0) {
            inventory--;
        }
    }
    public double getBalance() { return balance; }
    public void addBalance(double amount) { this.balance += amount; }
    public void resetBalance() { this.balance = 0.0; }
}