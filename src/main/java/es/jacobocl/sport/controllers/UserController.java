package es.jacobocl.sport.controllers;

import es.jacobocl.sport.wrappers.UserListWrapper;
import es.jacobocl.sport.wrappers.UserNickListWrapper;

public class UserController {

    public UserListWrapper userList() {
        return new UserListWrapper();
    }

    public UserNickListWrapper searchUsersInSport(String sportName) {
        return new UserNickListWrapper();
    }

    public boolean createUser(String nick) {
        return false;
    }

    public boolean addSportToUser(String nick, String sportName) {
        return false;
    }

}
