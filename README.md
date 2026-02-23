<h1>Lab Assignment State Pattern</h1>
<h4>Problem:</br>
A vending machine needs to manage different states, including "Idle", "ItemSelected", "Dispensing", and "OutOfOrder". Each state has specific rules and restrictions regarding allowed operations, and the vending machine has associated attributes like item inventory and balance.</h4></br>
Requirements:</br>
Idle State:</br>
-Allow item selection.</br>
-Disallow dispensing items and inserting coins.</br>
ItemSelected State:</br>
-Allow inserting coins and dispensing items.</br>
-Disallow item selection.</br>
Dispensing State:</br>
-Allow no operations.</br>
-Automatically transition back to the "Idle" state after dispensing is complete.</br>
OutOfOrder State:</br>
-Disallow all operations. </br>

Current System: The system currently relies on conditional statements within the VendingMachine class to check the machine state and determine valid actions. This approach becomes cumbersome and error-prone as the number of states and their associated logic grows.
Implement the State Pattern to improve code maintainability and flexibility:

<b> Define VendingMachine States: </b></br>
-Create separate classes representing different machine states: IdleState, ItemSelectedState, DispensingState, and OutOfOrderState.</br>
<b> Implement State Interface: </b> </br>
-Define an interface VendingMachineState with methods for common actions like selectItem, insertCoin, dispenseItem, and setOutOfOrder.</br>
<b> Implement State Behaviors: </b> </br>
-Each concrete state class implements the VendingMachineState interface, providing specific behavior for its respective state. For example, the IdleState class would allow item selection, while the OutOfOrderState wouldn't allow any operations.</br>
<b> Update VendingMachine Class: </b> </br>
-Include attributes for item inventory and balance.</br>
-Remove state-specific logic from the VendingMachine class.</br>
-Introduce a reference to the current VendingMachineState object.</br>
-Delegate actions like selectItem, insertCoin, dispenseItem, and setOutOfOrder to the current state object through its corresponding methods.</br>


<h1> UML DIAGRAM </h1>
