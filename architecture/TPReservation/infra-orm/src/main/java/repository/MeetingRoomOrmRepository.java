package repository;

import entity.MeetingRoomOrm;

import java.util.List;

public class MeetingRoomOrmRepository extends Repository<MeetingRoomOrm> {
    @Override
    public MeetingRoomOrm findById(Long id) {
        return session.get(MeetingRoomOrm.class,id);
    }

    @Override
    public List<MeetingRoomOrm> findAll() {
        return session.createQuery("from AdministratorOrm ").list();
    }
}
