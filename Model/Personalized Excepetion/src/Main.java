import Model.entities.enums.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkIN = Reservation.sdf.parse(sc.next());

        System.out.print("Check-out date (dd/mm/yyyy): ");
        Date checkOut = Reservation.sdf.parse(sc.next());

        if(!checkOut.after(checkIN)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else{
            Reservation rv = new Reservation(roomNumber, checkIN, checkOut);
            System.out.println(rv);
        }

        sc.close();

    }
}