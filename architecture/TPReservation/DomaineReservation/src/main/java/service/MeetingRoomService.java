package service;

import entity.MeetingRoom;
import exception.ImpossibleRoomCreation;
import port.MeetingRoomRepository;

public class MeetingRoomService {

    private final MeetingRoomRepository meetingRoomRepository;

    private final AdministratorService administratorService;


    public MeetingRoomService(MeetingRoomRepository meetingRoomRepository, AdministratorService administratorService) {
        this.meetingRoomRepository = meetingRoomRepository;
        this.administratorService = administratorService;
    }

    public MeetingRoom create(String name,int capacity) throws ImpossibleRoomCreation {

        if (name.isEmpty() || name.isBlank() || capacity < 0) throw new ImpossibleRoomCreation();

    }


    public MeetingRoom get(Long idSalle) {
        return meetingRoomRepository.get(idSalle);
    }



}
