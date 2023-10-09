package Model.entities;

import Model.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIN ;
    private Date checkOut;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation(){ }
    public Reservation(Integer roomNumber, Date checkIN, Date checkOut) throws DomainExceptions {
        if(!checkOut.after(checkIN)){
            throw new DomainExceptions("Error in reservation: Check-out date must be after Check-in");
        }
        this.roomNumber = roomNumber;
        this.checkIN = checkIN;
        this.checkOut = checkOut;
    }

    public long duration(){

       long diff = checkOut.getTime() - checkIN.getTime();
       TimeUnit time = TimeUnit.DAYS;
       return time.convert(diff, TimeUnit.MILLISECONDS);

    }

    public void updateDates(Date checkIN, Date checkOut) throws DomainExceptions {
        Date now = new Date();

        if(checkIN.before(now) || checkOut.before(now)){
            throw new DomainExceptions("Error in reservation: Reservation dates for update must be future dates");
        }

        if(!checkOut.after(checkIN)){
            throw new DomainExceptions("Error in reservation: Check-out date must be after Check-in");
        }

        this.checkIN = checkIN;
        this.checkOut = checkOut;

    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckIN() {
        return checkIN;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    @Override
    public String toString() {
        return String.format("Reservation: Room %d, check-in: %s, check-out: %s, %d Nights.", this.getRoomNumber(),
                sdf.format(this.getCheckIN()),
                sdf.format(this.getCheckOut()),
                this.duration());
    }
}
