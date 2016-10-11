package es.jacobocl.sport.api;

import es.jacobocl.sport.controllers.SportController;
import es.jacobocl.sport.exceptions.ExistingSportException;
import es.jacobocl.sport.exceptions.InvalidSportNameException;

public class SportResource {

    // POST **/sports body="name"
    public void createSport(String name) throws InvalidSportNameException, ExistingSportException {
        if (name == null || name == "") {
            throw new InvalidSportNameException(name);
        }
        if (!new SportController().createSport(name)) {
            throw new ExistingSportException(name);
        }
    }

}
