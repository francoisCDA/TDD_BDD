package repository.impl;

import entity.MeetingRoom;
import port.MeetingRoomRepository;

import java.time.LocalDateTime;
import java.util.List;

public class MeetingRoomRepositoryImpl implements MeetingRoomRepository {


    @Override
    public MeetingRoom get(Long idSalle) {
        return null;
    }

    @Override
    public MeetingRoom save(MeetingRoom room) {
        return null;
    }

    @Override
    public boolean delete(MeetingRoom roomToRm) {
        return false;
    }

    @Override
    public List<MeetingRoom> searchByDateTimeCapacity(LocalDateTime meetingDate, int guestNumber) {
        return null;
    }

    @Override
    public List<MeetingRoom> getAll() {
        return null;
    }
}
