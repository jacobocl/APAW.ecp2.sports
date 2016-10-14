package es.jacobocl.sport.api;

import es.jacobocl.sport.controllers.SportController;
import es.jacobocl.sport.controllers.UserController;
import es.jacobocl.sport.exceptions.ExistingUserException;
import es.jacobocl.sport.exceptions.InvalidSportNameException;
import es.jacobocl.sport.exceptions.InvalidUserEmailException;
import es.jacobocl.sport.exceptions.InvalidUserNickException;
import es.jacobocl.sport.exceptions.NotFoundSportException;
import es.jacobocl.sport.exceptions.NotFoundUserException;
import es.jacobocl.sport.exceptions.ExistingSportInUserException;
import es.jacobocl.sport.wrappers.UserListWrapper;
import es.jacobocl.sport.wrappers.UserNickListWrapper;

public class UserResource {

    // GET **/users
    public UserListWrapper userList() {
        return new UserController().userList();
    }

    // GET **/users/search?sport=*
    public UserNickListWrapper searchUsersInSport(String sportName) throws InvalidSportNameException, NotFoundSportException {
        this.validateSport(sportName);
        return new UserController().searchUsersInSport(sportName);
    }

    private void validateSport(String sportName) throws InvalidSportNameException, NotFoundSportException {
        if (checkFieldEmptyOrNull(sportName)) {
            throw new InvalidSportNameException(sportName);
        }
        if (!new SportController().existSport(sportName)) {
            throw new NotFoundSportException(sportName);
        }
    }

    private boolean checkFieldEmptyOrNull(String field) {
        return field == null || field.isEmpty();
    }

    // POST **/users body="nick:email"
    public void createUser(String nick, String email) throws InvalidUserNickException, InvalidUserEmailException, ExistingUserException {
        if (checkFieldEmptyOrNull(nick)) {
            throw new InvalidUserNickException(nick);
        }
        if (checkFieldEmptyOrNull(email)) {
            throw new InvalidUserEmailException(email);
        }
        if (!new UserController().createUser(nick, email)) {
            throw new ExistingUserException(nick);
        }
    }

    // PUT **/users/{nick}/sport body="sportName"
    public void addSportToUser(String nick, String sportName) throws InvalidUserNickException, InvalidSportNameException,
            NotFoundSportException, NotFoundUserException, ExistingSportInUserException {
        if (checkFieldEmptyOrNull(nick)) {
            throw new InvalidUserNickException(nick);
        }
        if (checkFieldEmptyOrNull(sportName)) {
            throw new InvalidSportNameException(sportName);
        }
        if (new UserController().findUserByNick(nick) == null) {
            throw new NotFoundUserException(nick);
        }
        if (!new SportController().existSport(sportName)) {
            throw new NotFoundSportException(sportName);
        }
        if (!new UserController().addSportToUser(nick, sportName)) {
            throw new ExistingSportInUserException(sportName);
        }
    }

}
