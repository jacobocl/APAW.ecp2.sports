package es.jacobocl.sport.daos.memory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import es.jacobocl.sport.daos.UserDao;
import es.jacobocl.sport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

    public UserDaoMemory() {
        this.setMap(new HashMap<Integer, User>());
    }

    @Override
    protected Integer getId(User entity) {
        return entity.getId();
    }

    @Override
    protected void setId(User entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public List<User> findUsersInSport(String sportName) {
        List<User> users = this.findAll();
        List<User> usersInSport = new LinkedList<>();
        for (User user : users) {
            if (user.hasSport(sportName)) {
                usersInSport.add(user);
            }
        }
        return usersInSport;
    }

    @Override
    public User findUserByNick(String nick) {
        List<User> users = this.findAll();
        for (User user : users) {
            if (user.getNick().equals(nick)) {
                return user;
            }
        }
        return null;
    }

}
