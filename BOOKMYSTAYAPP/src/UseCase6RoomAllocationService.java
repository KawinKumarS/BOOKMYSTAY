// Version: 6.1

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Step 1: Initialize Inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Create Booking Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Step 3: Add Requests
        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Suite Room"));
        queue.addRequest(new Reservation("David", "Suite Room")); // might fail
        queue.addRequest(new Reservation("Eve", "Single Room"));

        // Step 4: Process Bookings
        RoomAllocationService allocationService =
                new RoomAllocationService(inventory);

        allocationService.processBookings(queue);

        // Step 5: Show Allocations
        allocationService.displayAllocations();

        // Step 6: Final Inventory
        System.out.println("\n===== FINAL INVENTORY =====");
        inventory.displayInventory();

        System.out.println("===== END OF PROGRAM =====");
    }
}