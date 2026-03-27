

abstract class Room {
    private String roomType;
    private int numberOfBeds;
    private double size;
    private double price;

    // Constructor
    public Room(String roomType, int numberOfBeds, double size, double price) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.size = size;
        this.price = price;
    }

    // Getters
    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Display Method
    public void displayRoomDetails() {
        System.out.println("Room Type     : " + roomType);
        System.out.println("Beds          : " + numberOfBeds);
        System.out.println("Size (sq ft)  : " + size);
        System.out.println("Price (₹)     : " + price);
    }
}