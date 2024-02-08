package entity;

import java.util.Date;


public class Reservation {

    private long id;
    private long idSalle;
    private String userName;
    private Date begin;
    private Date end;

    public Reservation(long idSalle, String userName, Date begin, Date end) {
        this.idSalle = idSalle;
        this.userName = userName;
        this.begin = begin;
        this.end = end;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
