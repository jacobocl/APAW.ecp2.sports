package es.jacobocl.sport.controllers;

import es.jacobocl.sport.daos.DaoFactory;
import es.jacobocl.sport.entities.Sport;

public class SportController {

    public boolean createSport(String sportName) {
        boolean existingSport = this.existingSport(sportName);
        if (!existingSport) {
            DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
            return true;
        } else {
            return false;
        }
    }

    public boolean existingSport(String sportName) {
        Sport sport = DaoFactory.getFactory().getSportDao().findSportByName(sportName);
        return sport != null;
    }

}
