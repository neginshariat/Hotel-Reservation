package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class HotelResource {
    private HotelResource(){
    }
    private static HotelResource hotelResource= new HotelResource();

    private final CustomerService customerService = CustomerService.getCustomerService();
    private final ReservationService reservationService= ReservationService.getReservationService();

    public static HotelResource getHotelResource() {
        return hotelResource;
    }
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }
    public void createCustomer(String email, String firstName, String lastName){
        customerService.addCustomer(firstName,lastName,email);
    }
    public IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }
    public Reservation bookRoom(String email, IRoom room, Date checkIn, Date checkOut){
        return reservationService.reserveRoom(getCustomer(email),room,checkIn,checkOut);
    }
    public Collection<Reservation> getCustomerReservations(String customerEmail){
        final Customer customer = getCustomer(customerEmail);

        if (customer == null) {
            return Collections.emptyList();
        }

        return reservationService.getCustomerReservation(getCustomer(customerEmail));
    }
    public Collection<IRoom> findRoom(Date checkIn, Date checkOut){
        return reservationService.findRooms(checkIn,checkOut);
    }
    public Collection<IRoom> findAlternativeRoom(Date checkIn, Date checkOut){
        return reservationService.findAlternativeRooms(checkIn,checkOut);
    }
    public Date addDefaultPlusDays(Date date){
        return reservationService.addDefaultPlusDays(date);
    }
}
