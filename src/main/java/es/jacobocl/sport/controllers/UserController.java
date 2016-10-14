package es.jacobocl.sport.controllers;

import java.util.List;

import es.jacobocl.sport.daos.DaoFactory;
import es.jacobocl.sport.entities.Sport;
import es.jacobocl.sport.entities.User;
import es.jacobocl.sport.wrappers.UserListWrapper;
import es.jacobocl.sport.wrappers.UserNickListWrapper;
import es.jacobocl.sport.wrappers.UserWrapper;

public class UserController {

    public UserListWrapper userList() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (User user : userList) {
            userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
        }
        return userListWrapper;
    }

    public UserNickListWrapper searchUsersInSport(String sportName) {
        List<User> userList = DaoFactory.getFactory().getUserDao().findUsersInSport(sportName);
        UserNickListWrapper userNickListWrapper = new UserNickListWrapper();
        for (User user : userList) {
            userNickListWrapper.addNick(user.getNick());
        }
        return userNickListWrapper;
    }

    public boolean createUser(String nick, String email) {
        if (findUserByNick(nick) == null) {
            DaoFactory.getFactory().getUserDao().create(new User(nick, email));
            return true;
        } else {
            return false;
        }
    }

    public User findUserByNick(String nick) {
        return DaoFactory.getFactory().getUserDao().findUserByNick(nick);
    }

    public boolean addSportToUser(String nick, String sportName) {
        User user = findUserByNick(nick);
        if (!user.hasSport(sportName)) {
            Sport sport = DaoFactory.getFactory().getSportDao().findSportByName(sportName);
            user.addSport(sport);
            return true;
        } else {
            return false;
        }
    }

}
