// Version: 4.1

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Step 1: Create Room Objects (Domain)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Step 2: Store in array (no complex DS yet)
        Room[] rooms = { singleRoom, doubleRoom, suiteRoom };

        // Step 3: Initialize Inventory (State)
        RoomInventory inventory = new RoomInventory();

        // Step 4: Create Search Service
        RoomSearchService searchService = new RoomSearchService(inventory);

        // Step 5: Perform Search (READ-ONLY)
        searchService.searchAvailableRooms(rooms);

        System.out.println("\n===== VERIFY INVENTORY UNCHANGED =====");
        inventory.displayInventory();

        System.out.println("===== END OF PROGRAM =====");
    }
}