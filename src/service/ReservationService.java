package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;
import java.util.stream.Collectors;

public class ReservationService {

    private static final int RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS = 7;

    private final Collection<IRoom> notAvailableRooms = new LinkedList<>();
    private static final ReservationService reservationService= new ReservationService();
    private static final Map<String,IRoom> rooms = new HashMap<>();
    private static final Map<String,Collection<Reservation>> reservations= new HashMap<>();
    private ReservationService(){}
    public static ReservationService getReservationService(){
        return reservationService;
    }
    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(),room);
    }
    public IRoom getARoom(String roomID){
        return rooms.get(roomID);
    }
    public Collection<IRoom> getAllRooms(){
        return rooms.values();
    }
    public Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation= new Reservation(customer,room,checkInDate,checkOutDate);
        Collection<Reservation> customerReservations= getCustomerReservation(customer);
        if (customerReservations == null){
            customerReservations = new LinkedList<>();
        }
        customerReservations.add(reservation);
        reservations.put(customer.getEmail(),customerReservations);
        return reservation;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer){
        return reservations.get(customer);
    }


    public Collection<IRoom> findAvailableRooms(Date checkInDate,Date checkOutDate){

        for (Reservation reservation:getAllReservations()){
            if (reservationOverLaps(reservation,checkInDate,checkOutDate)){
                notAvailableRooms.add(reservation.getRoom());
            }
        }
        return rooms.values().stream().filter(room -> notAvailableRooms.stream()
                .noneMatch(notAvailableRooms -> notAvailableRooms.equals(room)))
                .collect(Collectors.toList());
    }
    private boolean reservationOverLaps(Reservation reservation, Date checkIn, Date checkOut){
        return checkIn.before(reservation.getCheckInDate()) && checkIn.after(reservation.getCheckOutDate());
    }
    public void printAllReservation() {
        final Collection<Reservation> reservations1 = getAllReservations();
        if (reservations1.isEmpty()){
            System.out.println("There is no reservation.");
        }else {
            System.out.println(reservations1);
        }
    }
    public Collection<IRoom> findAlternativeRooms(final Date checkInDate, final Date checkOutDate) {
        return findAvailableRooms(addDefaultPlusDays(checkInDate), addDefaultPlusDays(checkOutDate));
    }
    public Date addDefaultPlusDays(Date date){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE,RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS);
        return calendar.getTime();
    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        return findAvailableRooms(checkInDate,checkOutDate);
    }

    public Collection<Reservation> getAllReservations(){
        Collection<Reservation> allReservations = new LinkedList<>();
        for (Collection<Reservation> reservation: reservations.values()){
            allReservations.addAll(reservation);
        }
        return allReservations;
    }

}

