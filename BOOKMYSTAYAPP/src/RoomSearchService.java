// Version: 4.0

class RoomSearchService {

    private RoomInventory inventory;

    // Constructor
    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Search available rooms (READ-ONLY)
    public void searchAvailableRooms(Room[] rooms) {

        System.out.println("===== AVAILABLE ROOMS =====\n");

        boolean found = false;

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            // Defensive check: show only available rooms
            if (available > 0) {
                room.displayRoomDetails();
                System.out.println("Available: " + available);
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms available at the moment.");
        }

        System.out.println("============================");
    }
}