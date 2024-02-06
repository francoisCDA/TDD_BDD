package spi.port;

import entity.LivreDomaine;

import java.util.List;

public interface LivreRepository {

   boolean create(LivreDomaine livreDomaine);

   boolean delete(Long id);

   LivreDomaine getById(Long id);

   List<LivreDomaine> getAll();

}
