import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check-in Date (dd/MM/yyyy): ");
            String checkIn = sc.next();
            System.out.println("Check-out Date (dd/MM/yyyy): ");
            String checkOut = sc.next();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate checkInFormatter = LocalDate.parse(checkIn, formatter);
            LocalDate checkOutFormatter = LocalDate.parse(checkOut, formatter);
            Reservation reservation = new Reservation(number, checkInFormatter, checkOutFormatter);
            System.out.println(reservation.toString());

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            checkIn = sc.next();
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            checkOut = sc.next();
            checkInFormatter = LocalDate.parse(checkIn, formatter);
            checkOutFormatter = LocalDate.parse(checkOut, formatter);
           
            reservation.updateDates(checkInFormatter, checkOutFormatter);
            System.out.println(reservation.toString());
        }
        catch(DomainException e){
            System.out.println("Error in reservation: " + e);
        } 
        catch(RuntimeException e){
            System.out.println("Unexpected error.");
        }
        
        sc.close();
    }
}
