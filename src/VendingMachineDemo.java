public class VendingMachineDemo {
    public static void main(String[] args) {
        // Create a new vending machine with an initial inventory of 2 items
        VendingMachineController machine = new VendingMachineController(2);

        System.out.println("=== SCENARIO 1: A perfect transaction ===");
        // Current State: Idle
        machine.insertCoin(); // Fails: Can't insert coin before selecting
        machine.selectItem(); // Success: Transitions to ItemSelected

        // Current State: ItemSelected
        machine.selectItem(); // Fails: Already selected
        machine.insertCoin(); // Success: Accepts coin
        machine.dispenseItem(); // Success: Transitions to Dispensing, then back to Idle

        System.out.println("\n=== SCENARIO 2: Buying the last item ===");
        // Current State: Idle (Inventory is now 1)
        machine.selectItem();
        machine.insertCoin();
        machine.dispenseItem(); // Dispenses last item, inventory hits 0, transitions to OutOfOrder

        System.out.println("\n=== SCENARIO 3: Trying to use an empty machine ===");
        // Current State: OutOfOrder
        machine.selectItem(); // Fails: Machine is empty/out of order
        machine.insertCoin(); // Fails: Rejects coin
    }
}