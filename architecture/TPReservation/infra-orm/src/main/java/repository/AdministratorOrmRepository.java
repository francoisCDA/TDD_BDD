package repository;

import entity.AdministratorOrm;

import java.util.List;

public class AdministratorOrmRepository extends Repository<AdministratorOrm> {
    @Override
    public AdministratorOrm findById(Long id) {
        return session.get(AdministratorOrm.class,id);
    }

    @Override
    public List<AdministratorOrm> findAll() {
        return session.createQuery("from AdministratorOrm ").list();
    }
}
