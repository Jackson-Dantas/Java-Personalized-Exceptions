import Model.entities.Reservation;
import Model.exceptions.DomainExceptions;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();

            System.out.print("Check-in date (dd/mm/yyyy): ");
            Date checkIN = Reservation.sdf.parse(sc.next());

            System.out.print("Check-out date (dd/mm/yyyy): ");
            Date checkOut = Reservation.sdf.parse(sc.next());


            Reservation rv = new Reservation(roomNumber, checkIN, checkOut);
            System.out.println(rv);

            System.out.println("Enter dates to update the reservation: ");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIN = Reservation.sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = Reservation.sdf.parse(sc.next());


        } catch (ParseException parseException){

            System.out.println("Illegal argument");

        } catch (DomainExceptions domainExceptions){

            System.out.println(domainExceptions.getMessage());
        } catch (RuntimeException runtimeException){
            System.out.println("Unexpected error");
        }


        sc.close();

    }
}