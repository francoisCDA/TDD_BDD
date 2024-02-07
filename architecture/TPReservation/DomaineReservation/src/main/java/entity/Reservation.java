package entity;

import javax.print.MultiDocPrintService;
import java.util.Date;
import java.util.Locale;

public class Reservation {

    private long id;
    private String userName;
    private MeetingRoom meetingRoom;
    private Date begin;
    private Date end;

    public Reservation(String userName, MeetingRoom room, Date begin, Date end) {
        this.userName = userName;
        this.meetingRoom = room;
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

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
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
