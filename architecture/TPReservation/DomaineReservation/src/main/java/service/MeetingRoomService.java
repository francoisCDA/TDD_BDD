package service;

import entity.MeetingRoom;
import exception.ImpossibleRoomCreation;
import exception.InvalidIdRoomException;
import exception.InvalidSearchException;
import port.MeetingRoomRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

public class MeetingRoomService {

    private final MeetingRoomRepository meetingRoomRepository;


    public MeetingRoomService(MeetingRoomRepository meetingRoomRepository, AdministratorService administratorService) {
        this.meetingRoomRepository = meetingRoomRepository;
    }

    public MeetingRoom create(String name,int capacity) throws ImpossibleRoomCreation {
        if (name.isEmpty() || name.isBlank() || capacity < 0) throw new ImpossibleRoomCreation();
        MeetingRoom room = new MeetingRoom(name,capacity);
        return meetingRoomRepository.save(room);
    }


    public MeetingRoom get(Long idSalle) {
        return meetingRoomRepository.get(idSalle);
    }

    public boolean delete(Long idSalle) throws InvalidIdRoomException {
        MeetingRoom roomToRm = get(idSalle);
        if (roomToRm == null) {
            throw new InvalidIdRoomException();
        }
        return meetingRoomRepository.delete(roomToRm);
    }

    public List<MeetingRoom> getAll() {
        return meetingRoomRepository.getAll();
    }

    public List<MeetingRoom> search(LocalDate date, LocalTime hour, int guestNumber) throws InvalidSearchException {

        if (LocalDate.now().isAfter(date) || guestNumber < 2 ) throw new InvalidSearchException();

        LocalDateTime meetingDate = LocalDateTime.of(date,hour);

        return meetingRoomRepository.searchByDateTimeCapacity(meetingDate,guestNumber);
    }






}
