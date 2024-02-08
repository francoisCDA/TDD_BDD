package entity;

import java.util.List;

public class MeetingRoom {

    private long id;

    private String name;

    private int capacity;


    public MeetingRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public MeetingRoom(long id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
