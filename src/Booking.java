import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Booking {
    String passengerName;
    int busNo;
    Date date;

    public Booking(Scanner sc){
        System.out.println("Enter the Passenger Name");
        passengerName = sc.next();
        System.out.println("Enter the Bus Number");
        busNo = sc.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try{
            date = dateFormat.parse(dateInput);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public boolean isAvaliable() throws SQLException {
        BusDAO busDAO = new BusDAO();
        BookingDAO bookingDAO = new BookingDAO();
        int capacity = BusDAO.getCapacity(busNo);
        int booked = bookingDAO.getBookedCount(busNo,date);
//        System.out.println(capacity+"    "+booked);
        return booked < capacity;
    }
}
