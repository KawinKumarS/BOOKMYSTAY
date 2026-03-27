// Version: 2.1

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        // Polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static Availability
        int singleRoomAvailable = 10;
        int doubleRoomAvailable = 5;
        int suiteRoomAvailable = 2;

        System.out.println("===== HOTEL ROOM DETAILS =====\n");

        System.out.println("---- Single Room ----");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + singleRoomAvailable);
        System.out.println();

        System.out.println("---- Double Room ----");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleRoomAvailable);
        System.out.println();

        System.out.println("---- Suite Room ----");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteRoomAvailable);
        System.out.println();

        System.out.println("===== END OF PROGRAM =====");
    }
}