package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {

    private Reservation reservation;

    private Room room;
    private static final Map<String,IRoom> rooms = new HashMap<>();
    private static final List<Reservation> reservations= new ArrayList<>();

    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(),room);
    }
    public IRoom getARoom(String roomID){
        return rooms.get(roomID);
    }
    public Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation1= new Reservation(customer,room,checkInDate,checkOutDate);
        return reservation1;
    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        reservation
    }
    public Collection<Reservation> getCustomerReservation(Customer customer){
        reservation.setCustomer(customer);
    }

}

