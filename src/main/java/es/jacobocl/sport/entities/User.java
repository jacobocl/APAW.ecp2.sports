package es.jacobocl.sport.entities;

import java.util.LinkedList;
import java.util.List;

public class User {

    private int id;

    private String nick;

    private String email;

    private List<Sport> sports;

    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
        sports = new LinkedList<Sport>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public void addSport(Sport sport) {
        sports.add(sport);
    }
    
    public boolean hasSport(String sportName) {
        for (Sport sport : sports) {
            if (sport.getName().equals(sportName)) {
                return true;
            }
        }
        return false;
    }

}
