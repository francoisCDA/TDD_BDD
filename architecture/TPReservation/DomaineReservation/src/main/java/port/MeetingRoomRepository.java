package port;

import entity.MeetingRoom;

import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRoomRepository {


    MeetingRoom get(Long idSalle);

    MeetingRoom save(MeetingRoom room);

    boolean delete(MeetingRoom roomToRm);

    List<MeetingRoom> searchByDateTimeCapacity(LocalDateTime meetingDate, int guestNumber);

    List<MeetingRoom> getAll();
}
