package es.jacobocl.sport.daos.memory;

import java.util.HashMap;

import es.jacobocl.sport.daos.SportDao;
import es.jacobocl.sport.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {
    
    public SportDaoMemory() {
        this.setMap(new HashMap<Integer, Sport>());
    }

    @Override
    public Sport findSportByName(String sportName) {
        // TODO Auto-generated method stub
        return new Sport(sportName);
    }

    @Override
    protected Integer getId(Sport entity) {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    protected void setId(Sport entity, Integer id) {
        // TODO Auto-generated method stub

    }

}
