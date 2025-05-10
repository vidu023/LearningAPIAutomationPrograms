package com.thetestingacademy.ex_07_Payload_Management.Class.Tools_jsonSchema2POJO;

import java.util.LinkedHashMap;
import java.util.Map;

public class Booking_usingTools {

    private String firstname;
private String lastname;
private Integer totalprice;
private Boolean depositpaid;
private BookingDates_usingTools bookingdates;
private String additionalneeds;
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

public String getFirstname() {
return firstname;
}

public void setFirstname(String firstname) {
this.firstname = firstname;
}

public String getLastname() {
return lastname;
}

public void setLastname(String lastname) {
this.lastname = lastname;
}

public Integer getTotalprice() {
return totalprice;
}

public void setTotalprice(Integer totalprice) {
this.totalprice = totalprice;
}

public Boolean getDepositpaid() {
return depositpaid;
}

public void setDepositpaid(Boolean depositpaid) {
this.depositpaid = depositpaid;
}

public BookingDates_usingTools getBookingDates_usingTools() {
return bookingdates;
}

public void setBookingdates(BookingDates_usingTools bookingdates) {
this.bookingdates = bookingdates;
}

public String getAdditionalneeds() {
return additionalneeds;
}

public void setAdditionalneeds(String additionalneeds) {
this.additionalneeds = additionalneeds;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}
}
