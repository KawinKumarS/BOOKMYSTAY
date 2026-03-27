// Version: 6.0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class RoomAllocationService {

    private RoomInventory inventory;
    private BookingHistory history;

    // Track allocated room IDs per type
    private Map<String, Set<String>> allocatedRooms;

    // Track ALL allocated IDs (global uniqueness)
    private Set<String> allAllocatedRoomIds;

    public RoomAllocationService(RoomInventory inventory) {
        this.inventory = inventory;
        this.allocatedRooms = new HashMap<>();
        this.allAllocatedRoomIds = new HashSet<>();
    }

    // Process booking requests (FIFO)
    public void processBookings(BookingRequestQueue queue) {

        System.out.println("\n===== PROCESSING BOOKINGS =====");

        Reservation reservation;

        // Process until queue is empty
        while ((reservation = queue.pollRequest()) != null) {

            String roomType = reservation.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Store allocation
                allocatedRooms
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                allAllocatedRoomIds.add(roomId);

                // Update inventory immediately
                inventory.updateAvailability(roomType, available - 1);

                // Confirm booking
                System.out.println("CONFIRMED: " + reservation.getGuestName()
                        + " -> " + roomType + " | Room ID: " + roomId);

            } else {
                System.out.println("FAILED: " + reservation.getGuestName()
                        + " -> No " + roomType + " available");
            }
        }
        // Add this line after generating roomId
        String reservationId = roomId; // treat roomId as reservation ID
        System.out.println("================================");
        history.addReservation(reservation);   // ✅ ADD THIS LINE
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {

        String prefix = roomType.replace(" ", "").substring(0, 2).toUpperCase();
        String roomId;

        do {
            int randomNum = (int) (Math.random() * 1000);
            roomId = prefix + randomNum;
        } while (allAllocatedRoomIds.contains(roomId));

        return roomId;
    }

    // Display allocated rooms
    public void displayAllocations() {
        System.out.println("\n===== ROOM ALLOCATIONS =====");

        for (Map.Entry<String, Set<String>> entry : allocatedRooms.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("=============================");
    }
}