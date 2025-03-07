package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;


public class Reservation {
  
  private Integer roomNumber;
  private LocalDate checkIn;
  private LocalDate checkOut;

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 


  public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
    if(!checkOut.isAfter(checkIn)){
      throw new DomainException("Check-out date mustbe after check-in date");
    }
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public Integer getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
  }

  public LocalDate getCheckIn() {
    return checkIn;
  }

  public LocalDate getCheckOut() {
    return checkOut;
  }

 public Long duration() {
    return ChronoUnit.DAYS.between(checkIn, checkOut);
}

  public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException{
    LocalDate now = LocalDate.now();
    if(checkIn.isBefore(now) || checkOut.isBefore(now)){
      throw new DomainException("Error in reservation: Resevation dates for update must be future dates");
    }
    if(!checkOut.isAfter(checkIn)){
      throw new DomainException("Check-out date mustbe after check-in date");
    }
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  @Override
  public String toString() {
    return "Reservation: "
          + getRoomNumber()
          + ", check-in: "
          + checkIn.format(formatter)
          + ", check-out: "
          + checkOut.format(formatter)
          + ", " + duration()
          + " nights";
  }
}
