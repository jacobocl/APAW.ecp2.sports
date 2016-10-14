package es.jacobocl.sport.daos.memory;

import es.jacobocl.sport.daos.DaoFactory;
import es.jacobocl.sport.daos.SportDao;

public class DaoFactoryMemory extends DaoFactory {
    
    private SportDao sportDao;

    public DaoFactoryMemory() {
    }

    @Override
    public SportDao getSportDao() {
        if (sportDao == null) {
            sportDao = new SportDaoMemory();
        }
        return sportDao;
    }

}
