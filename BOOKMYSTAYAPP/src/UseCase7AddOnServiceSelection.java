// Version: 7.1

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Step 1: Setup Inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Booking Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));

        // Step 3: Allocation
        RoomAllocationService allocationService =
                new RoomAllocationService(inventory);

        allocationService.processBookings(queue);

        // NOTE: For demo, we assume generated IDs manually
        String reservation1 = "SI101"; // Example ID
        String reservation2 = "DO202"; // Example ID

        // Step 4: Add-On Services
        AddOnService wifi = new AddOnService("WiFi", 200);
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1500);

        AddOnServiceManager manager = new AddOnServiceManager();

        // Attach services
        manager.addService(reservation1, wifi);
        manager.addService(reservation1, breakfast);

        manager.addService(reservation2, spa);

        // Step 5: Display Services
        manager.displayServices(reservation1);
        System.out.println("Total Cost: ₹" + manager.calculateTotalCost(reservation1));

        manager.displayServices(reservation2);
        System.out.println("Total Cost: ₹" + manager.calculateTotalCost(reservation2));

        System.out.println("\n===== END OF PROGRAM =====");
    }
}