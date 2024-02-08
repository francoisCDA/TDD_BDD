package service;

import entity.MeetingRoom;
import entity.Reservation;
import exception.ImpossibleReservationException;
import port.ReservationRepository;

import java.util.Date;
import java.util.List;

public class RerservationService {

    private final ReservationRepository reservationRepository;

    private final MeetingRoomService meetingRoomService;

    public RerservationService(ReservationRepository reservationRepository, MeetingRoomService meetingRoomService) {
        this.reservationRepository = reservationRepository;
        this.meetingRoomService = meetingRoomService;
    }

    public Reservation create(String userName, Long idSalle, Date begin, Date end, int numberGuest) throws ImpossibleReservationException {

        MeetingRoom room = meetingRoomService.get(idSalle);

        if (room == null) throw new ImpossibleReservationException("Meeting Room id");

        if (numberGuest> room.getCapacity()) throw new ImpossibleReservationException("insufficient capacity");

        if (begin.before(end) || begin.after(new Date()) ) throw new ImpossibleReservationException("invalide date");

        if (!room.getReservationList().isEmpty()) {
            for (Reservation reservation:room.getReservationList()) {
                if ((begin.after(reservation.getBegin()) && begin.before(reservation.getEnd())) || (end.after(reservation.getBegin()) && end.before(reservation.getEnd())) ){
                    throw new ImpossibleReservationException("Meeting Room "+ room.getName()  +" reserved");
                }
            }
        }

        Reservation reservation = new Reservation(userName, room, begin, end);

        reservationRepository.save(reservation);
        return reservation;
    }

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }


}
