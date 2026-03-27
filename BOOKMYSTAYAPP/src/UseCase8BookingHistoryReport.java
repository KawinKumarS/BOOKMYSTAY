// Version: 8.1

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        // Step 1: Initialize Inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Booking History
        BookingHistory history = new BookingHistory();

        // Step 3: Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Suite Room"));
        queue.addRequest(new Reservation("David", "Suite Room"));

        // Step 4: Allocation Service (with history)
        RoomAllocationService allocationService =
                new RoomAllocationService(inventory, history);

        allocationService.processBookings(queue);

        // Step 5: Display Booking History
        history.displayHistory();

        // Step 6: Generate Report
        BookingReportService reportService = new BookingReportService();
        reportService.generateSummaryReport(history.getAllReservations());

        System.out.println("\n===== END OF PROGRAM =====");
    }
}