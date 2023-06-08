import java.sql.SQLException;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) throws SQLException {
        BusDAO busDAO = new BusDAO();
        try {
            busDAO.displayBusInfo();

            int choice = 1;
            Scanner sc = new Scanner(System.in);

            while (choice == 1) {
                System.out.println("Enter Your Choice...");
                System.out.println("1.Booking");
                System.out.println("2.Exit");
                choice = sc.nextInt();
                if (choice == 1) {
                    Booking booking = new Booking(sc);
                    if (booking.isAvaliable()) {
                        BookingDAO bookingDAO = new BookingDAO();
                        bookingDAO.addBooking(booking);
                        System.out.println("!!! Your Booking is Booking Confirmed !!!");
                    } else {
                        System.out.println("!!!OOPS.. Sorry..Bus is Full...Try Another Bus");
                    }
                }
            }
            sc.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
