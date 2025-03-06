import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a data de entrada: ");
        String checkIn = sc.next();
        System.out.print("Digite a data de saida: ");
        String checkOut = sc.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate checkInFormatter = LocalDate.parse(checkIn, formatter);
        LocalDate checkOutFormatter = LocalDate.parse(checkOut, formatter);


        Reservation reservation = new Reservation(10, checkInFormatter, checkOutFormatter);

        System.out.println(reservation.toString());
        sc.close();

    }
}
