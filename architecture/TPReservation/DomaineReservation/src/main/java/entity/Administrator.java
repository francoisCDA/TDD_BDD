package entity;

public class Administrator {

    private Long id;

    private String username;

    private String password;


    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
