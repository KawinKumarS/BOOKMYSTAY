// Version: 8.0

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookingReportService {

    // Generate summary report
    public void generateSummaryReport(List<Reservation> reservations) {

        System.out.println("\n===== BOOKING SUMMARY REPORT =====");

        if (reservations.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        Map<String, Integer> roomCount = new HashMap<>();

        for (Reservation r : reservations) {
            String roomType = r.getRoomType();
            roomCount.put(roomType, roomCount.getOrDefault(roomType, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : roomCount.entrySet()) {
            System.out.println(entry.getKey() + " Bookings: " + entry.getValue());
        }

        System.out.println("Total Bookings: " + reservations.size());

        System.out.println("==================================");
    }
}