package repository.impl;

import entity.Reservation;
import port.ReservationRepository;
import repository.ReservationOrmRepository;

import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {

    private final ReservationOrmRepository reservationOrmRepository;

    public ReservationRepositoryImpl(ReservationOrmRepository reservationOrmRepository) {
        this.reservationOrmRepository = reservationOrmRepository;
    }

    @Override
    public void save(Reservation reservation) {

    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public List<Reservation> getReservationByRoomMeetingId(Long id) {
        return reservationOrmRepository.getReservationByRoomMeetingId(id);
    }
}
