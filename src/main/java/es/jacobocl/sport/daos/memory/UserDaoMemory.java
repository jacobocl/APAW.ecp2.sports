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
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    protected void setId(User entity, Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<User> findUsersInSport(String sportName) {
        // TODO Auto-generated method stub
        return new LinkedList<User>();
    }

    @Override
    public User findUserByNick(String nick) {
        // TODO Auto-generated method stub
        return new User(nick, "email");
    }

}
