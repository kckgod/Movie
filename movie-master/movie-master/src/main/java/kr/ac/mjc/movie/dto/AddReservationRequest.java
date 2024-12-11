package kr.ac.mjc.movie.dto;

public class AddReservationRequest {

    private String reservationDate;
    private String reservationSeat;
    private String reservationTime;
    private String reservationRowNum;

    public String getReservationDate() {
        return reservationDate;
    }

    public String getReservationSeat() {
        return reservationSeat;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public String getReservationRowNum() {
        return reservationRowNum;
    }

}