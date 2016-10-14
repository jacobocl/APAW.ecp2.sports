package es.jacobocl.sport.daos;

import es.jacobocl.sport.entities.Sport;

public interface SportDao extends GenericDao<Sport, Integer> {

    Sport findSportByName(String sportName);

}
