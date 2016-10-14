package es.jacobocl.sport.daos.memory;

import es.jacobocl.sport.daos.DaoFactory;
import es.jacobocl.sport.daos.SportDao;
import es.jacobocl.sport.daos.UserDao;

public class DaoFactoryMemory extends DaoFactory {
    
    private SportDao sportDao;
    
    private UserDao userDao;

    public DaoFactoryMemory() {
    }

    @Override
    public SportDao getSportDao() {
        if (sportDao == null) {
            sportDao = new SportDaoMemory();
        }
        return sportDao;
    }

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoMemory();
        }
        return userDao;
    }

}
