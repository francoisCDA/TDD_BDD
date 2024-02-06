package entity;

public class LivreDomaine {

    private long id;

    private String titre;

    private String isbn;


    public LivreDomaine() {
    }

    public LivreDomaine(String titre, String isbn) {
        this.titre = titre;
        this.isbn = isbn;
    }

    public LivreDomaine(long id, String titre, String isbn) {
        this.id = id;
        this.titre = titre;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
