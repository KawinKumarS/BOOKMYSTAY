// Version: 5.0

import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add request (enqueue)
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Request added for " + reservation.getGuestName());
    }

    // View all requests
    public void displayQueue() {
        System.out.println("\n===== BOOKING REQUEST QUEUE =====");

        if (requestQueue.isEmpty()) {
            System.out.println("No booking requests.");
            return;
        }

        for (Reservation r : requestQueue) {
            r.displayReservation();
        }

        System.out.println("=================================");
    }

    // Peek next request (no removal)
    public Reservation peekNext() {
        return requestQueue.peek();
    }
}