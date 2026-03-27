// Version: 8.0

import java.util.ArrayList;
import java.util.List;

class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    // Get all reservations
    public List<Reservation> getAllReservations() {
        return history;
    }

    // Display history
    public void displayHistory() {

        System.out.println("\n===== BOOKING HISTORY =====");

        if (history.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : history) {
            r.displayReservation();
        }

        System.out.println("============================");
    }
}