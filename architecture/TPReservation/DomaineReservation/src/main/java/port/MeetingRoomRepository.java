package port;

import entity.MeetingRoom;

public interface MeetingRoomRepository {


    MeetingRoom get(Long idSalle);
}
