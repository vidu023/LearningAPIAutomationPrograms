package com.thetestingacademy.ex_07_Payload_Management.Class.Manual.responsePayload;

import com.thetestingacademy.ex_07_Payload_Management.Class.Manual.requestPayload.Booking;

public class Booking_Response {

    // Response what we get has bookingId & same as requestPayload
    // hence we can reuse the requestPayload Booking Class

    private Integer BookingId;
    private Booking booking; // Booking Class from requestPayload

    // generate getter setter
    public Integer getBookingId() {
        return BookingId;
    }

    public void setBookingId(Integer bookingId) {
        BookingId = bookingId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
