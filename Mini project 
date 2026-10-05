import java.util.*;

// 1. Ride Status
enum RideStatus {
    BOOKED, ONGOING, COMPLETED, CANCELLED
}

// 2. User Class
class User {
    private int userId;
    private String name;
    private String phone;

    public User(int userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }
    public String getName() { return name; }
    public int getUserId() { return userId; }
}

// 3. Driver Class
class Driver {
    private int driverId;
    private String name;
    private String carNumber;
    private boolean isAvailable;

    public Driver(int driverId, String name, String carNumber) {
        this.driverId = driverId;
        this.name = name;
        this.carNumber = carNumber;
        this.isAvailable = true;
    }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public String getName() { return name; }
    public String getCarNumber() { return carNumber; }
}

// 4. Ride Class
class Ride {
    private int rideId;
    private User user;
    private Driver driver;
    private String pickup;
    private String drop;
    private double distanceKm;
    private double fare;
    private RideStatus status;

    public Ride(int rideId, User user, Driver driver, String pickup, String drop, double distanceKm) {
        this.rideId = rideId;
        this.user = user;
        this.driver = driver;
        this.pickup = pickup;
        this.drop = drop;
        this.distanceKm = distanceKm;
        this.fare = distanceKm * 15; // Rs 15 per km
        this.status = RideStatus.BOOKED;
    }

    public void startRide() {
        status = RideStatus.ONGOING;
        System.out.println("Ride " + rideId + " Started...");
    }

    public void completeRide() {
        status = RideStatus.COMPLETED;
        driver.setAvailable(true);
        System.out.println("Ride Completed! Fare: Rs " + fare);
    }

    public void showRideDetails() {
        System.out.println("\n----- RIDE DETAILS -----");
        System.out.println("Ride ID: " + rideId);
        System.out.println("User: " + user.getName());
        System.out.println("Driver: " + driver.getName() + " [" + driver.getCarNumber() + "]");
        System.out.println("From: " + pickup + " To: " + drop);
        System.out.println("Distance: " + distanceKm + " km");
        System.out.println("Fare: Rs " + fare);
        System.out.println("Status: " + status);
        System.out.println("------------------------\n");
    }
}

// 5. Booking Service
class RideBookingService {
    private List<Driver> drivers = new ArrayList<>();
    private int rideCounter = 1;

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public Ride bookRide(User user, String pickup, String drop, double distance) {
        // Find available driver
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                d.setAvailable(false);
                Ride ride = new Ride(rideCounter++, user, d, pickup, drop, distance);
                System.out.println("Ride Booked Successfully for " + user.getName());
                return ride;
            }
        }
        System.out.println("No Drivers Available Right Now!");
        return null;
    }
}

// 6. Main Class
public class Main {
    public static void main(String[] args) {
        RideBookingService service = new RideBookingService();

        // Add Drivers
        service.addDriver(new Driver(101, "Ramesh", "KA-01 AB 1234"));
        service.addDriver(new Driver(102, "Suresh", "KA-02 CD 5678"));

        // Create User
        User user1 = new User(1, "Durga", "9876543210");

        // Book a Ride
        Ride ride1 = service.bookRide(user1, "BTM Layout", "Indiranagar", 12.5);

        if (ride1 != null) {
            ride1.showRideDetails();
            ride1.startRide();
            ride1.completeRide();
            ride1.showRideDetails();
        }
    }
}