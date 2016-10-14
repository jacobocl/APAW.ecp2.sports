package es.jacobocl.sport.daos;

import java.util.List;

import es.jacobocl.sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {

    List<User> findUsersInSport(String sportName);

    User findUserByNick(String nick);

}
