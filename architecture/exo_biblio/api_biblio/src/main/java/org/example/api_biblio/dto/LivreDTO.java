package org.example.api_biblio.dto;


import entity.LivreDomaine;

public class LivreDTO {

    private Long id;
    private String titre;

    private String isbn;

    public LivreDomaine toLivreSQL(){
        return new LivreDomaine(id,titre,isbn);
    }

}
