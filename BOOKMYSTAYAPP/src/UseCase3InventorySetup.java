// Version: 3.1

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Initialize Room Objects (Domain)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Initialize Inventory (Centralized State)
        RoomInventory inventory = new RoomInventory();

        // Display Room Details
        System.out.println("===== ROOM DETAILS =====\n");

        singleRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(singleRoom.getRoomType()));
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(doubleRoom.getRoomType()));
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(suiteRoom.getRoomType()));
        System.out.println();

        // Display Full Inventory
        inventory.displayInventory();

        // Update Example
        System.out.println("\nUpdating Suite Room availability...\n");
        inventory.updateAvailability("Suite Room", 1);

        // Display Updated Inventory
        inventory.displayInventory();

        System.out.println("===== END OF PROGRAM =====");
    }
}