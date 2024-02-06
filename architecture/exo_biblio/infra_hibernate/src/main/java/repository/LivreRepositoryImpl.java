package repository;

import entity.LivreDomaine;
import entity.LivreSQL;
import spi.port.LivreRepository;
import util.HibernateSession;

import java.util.List;
import java.util.stream.Collectors;

public class LivreRepositoryImpl implements LivreRepository {

    private LivreSQLRepository livreSQLRepository;

    public LivreRepositoryImpl() {
        livreSQLRepository = new LivreSQLRepository();
    }


    @Override
    public boolean create(LivreDomaine livreDomaine) {
        try {
            livreSQLRepository.setSession(HibernateSession.getSessionFactory().openSession());
            livreSQLRepository.getSession().beginTransaction();
            LivreSQL livreSQL = LivreSQL.builder().titreLivre(livreDomaine.getTitre()).isbn(livreDomaine.getIsbn()).build();
            livreSQLRepository.create(livreSQL);
            livreSQLRepository.getSession().getTransaction().commit();
            livreDomaine.setId(livreSQL.getId());
            return true;
        } catch (Exception ex) {
            livreSQLRepository.getSession().getTransaction().rollback();
            return false;
        } finally {
            livreSQLRepository.getSession().close();
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            livreSQLRepository.setSession(HibernateSession.getSessionFactory().openSession());
            livreSQLRepository.getSession().beginTransaction();
            LivreSQL livreSQL = livreSQLRepository.findById(id);
            livreSQLRepository.delete(livreSQL);
            livreSQLRepository.getSession().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            livreSQLRepository.getSession().getTransaction().rollback();
            return false;
        } finally {
            livreSQLRepository.getSession().close();
        }
    }


    @Override
    public LivreDomaine getById(Long id) {
        try {
            livreSQLRepository.setSession(HibernateSession.getSessionFactory().openSession());
            LivreSQL livreSQL = livreSQLRepository.findById(id);
            return new LivreDomaine(livreSQL.getId(), livreSQL.getTitreLivre(), livreSQL.getIsbn());
        } catch (Exception ex) {
            return null;
        } finally {
            livreSQLRepository.getSession().close();
        }
    }



    @Override
    public List<LivreDomaine> getAll() {
        try {
            livreSQLRepository.setSession(HibernateSession.getSessionFactory().openSession());
            List<LivreSQL> livresSQL = livreSQLRepository.findAll();
            return livresSQL.stream().map(li -> new LivreDomaine(li.getId(), li.getTitreLivre(), li.getIsbn())).collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        } finally {
            livreSQLRepository.getSession().close();
        }
    }

}
