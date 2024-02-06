package repository;

import entity.LivreSQL;

import java.util.List;

public class LivreSQLRepository extends BaseEntityRepository<LivreSQL> {

    @Override
    LivreSQL findById(Long id) {
        return session.get(LivreSQL.class,id);
    }

    @Override
    List<LivreSQL> findAll() {
        return session.createQuery("from LivreSQL").list();
    }
}
