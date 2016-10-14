package es.jacobocl.sport.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.jacobocl.sport.daos.SportDao;
import es.jacobocl.sport.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {
    
    public SportDaoMemory() {
        this.setMap(new HashMap<Integer, Sport>());
    }

    @Override
    public Sport findSportByName(String sportName) {
        List<Sport> allSports = this.findAll();
        for (Sport sport : allSports) {
            if (sport.getName().equals(sportName)) {
                return sport;
            }
        }
        return null;
    }

    @Override
    protected Integer getId(Sport entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Sport entity, Integer id) {
        entity.setId(id);
    }

}
