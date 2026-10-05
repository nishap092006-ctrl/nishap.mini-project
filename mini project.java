import java.util.Scanner;

class RideBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== RIDE BOOKING APPLICATION ===");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter pickup location: ");
        String pickup = sc.nextLine();

        System.out.print("Enter destination: ");
        String destination = sc.nextLine();

        System.out.println("\nSelect Ride:");
        System.out.println("1. Bike - Rs. 50");
        System.out.println("2. Auto - Rs. 80");
        System.out.println("3. Car - Rs. 150");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        int fare;

        switch (choice) {
            case 1:
                fare = 50;
                break;
            case 2:
                fare = 80;
                break;
            case 3:
                fare = 150;
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\n=== BOOKING CONFIRMED ===");
        System.out.println("Name: " + name);
        System.out.println("Pickup: " + pickup);
        System.out.println("Destination: " + destination);
        System.out.println("Fare: Rs. " + fare);
        System.out.println("Ride booked successfully!");

        sc.close();
    }
}