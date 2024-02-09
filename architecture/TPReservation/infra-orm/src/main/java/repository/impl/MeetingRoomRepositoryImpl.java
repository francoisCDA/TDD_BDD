package repository.impl;

import entity.MeetingRoom;
import entity.MeetingRoomOrm;
import exception.MeetingRoomNotFoundException;
import org.hibernate.Session;
import port.MeetingRoomRepository;
import repository.MeetingRoomOrmRepository;
import repository.Repository;
import repository.ReservationOrmRepository;
import util.HibernateSession;

import java.time.LocalDateTime;
import java.util.List;

public class MeetingRoomRepositoryImpl implements MeetingRoomRepository {

    private final MeetingRoomOrmRepository meetingRoomOrmRepository;


    public MeetingRoomRepositoryImpl(MeetingRoomOrmRepository meetingRoomOrmRepository) {
        this.meetingRoomOrmRepository = meetingRoomOrmRepository;
    }


    @Override
    public MeetingRoom get(Long idSalle) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        meetingRoomOrmRepository.setSession(session);
        try (session) {
            MeetingRoomOrm meetingRoomOrm = meetingRoomOrmRepository.findById(idSalle);
            return meetingRoomOrm.toMeetingRoomdomaine();
        }
    }

    @Override
    public MeetingRoom save(MeetingRoom room) {
        MeetingRoomOrm meetingRoomOrm = MeetingRoomOrm.builder().name(room.getName()).capacity(room.getCapacity()).build();
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        meetingRoomOrmRepository.setSession(session);
        try {
            meetingRoomOrmRepository.create(meetingRoomOrm);
            session.getTransaction().commit();
            return meetingRoomOrm.toMeetingRoomdomaine();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }

    }

    @Override
    public boolean delete(MeetingRoom roomToRm) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        meetingRoomOrmRepository.setSession(session);
        try {
            MeetingRoomOrm meetingRoomOrm = meetingRoomOrmRepository.findById(roomToRm.getId());
            meetingRoomOrmRepository.delete(meetingRoomOrm);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<MeetingRoom> searchByDateTimeCapacity(LocalDateTime meetingDate, int guestNumber) {
        Session session = HibernateSession.getSessionFactory().openSession();



    }

    @Override
    public List<MeetingRoom> getAll() {
        return null;
    }
}
