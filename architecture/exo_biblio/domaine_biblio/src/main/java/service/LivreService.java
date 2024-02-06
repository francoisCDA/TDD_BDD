package service;

import entity.LivreDomaine;
import exception.RepositoryException;
import spi.port.LivreRepository;

public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public LivreDomaine createLivre(String titre, String isbn) throws RepositoryException {
        LivreDomaine livre = new LivreDomaine(titre,isbn);

        if (livreRepository.create(livre)) {
            return livre;
        }

        throw new RepositoryException("create(Livre) fail");
    }


    public LivreDomaine getLivre(Long id) throws RepositoryException {
        LivreDomaine livre = livreRepository.getById(id);

        if (livre != null) {
            return livre;
        }

        throw new RepositoryException("getLivre(id) fail");
    }

    public boolean delete(Long id) {
        return livreRepository.delete(id);
    }




}
