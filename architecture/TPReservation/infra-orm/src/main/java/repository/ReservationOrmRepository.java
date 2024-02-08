package repository;

import entity.Reservation;

import java.util.List;

public class ReservationOrmRepository extends Repository<Reservation> {
    @Override
    public Reservation findById(Long id) {
        return session.get(Reservation.class,id);
    }

    @Override
    public List<Reservation> findAll() {
        return session.createQuery("from ReservationOrm ").list();
    }

    public List<Reservation> getReservationByRoomMeetingId(Long idMeetingRoom) {
       return  session.createQuery("from ReservationOrm where meetingRoomOrm = :id").setParameter("id",idMeetingRoom).list();
    }
}
