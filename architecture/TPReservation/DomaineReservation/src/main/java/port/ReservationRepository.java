package port;

import entity.Reservation;

import java.util.List;

public interface ReservationRepository {


    void save(Reservation reservation);

    List<Reservation> getAll();
}
