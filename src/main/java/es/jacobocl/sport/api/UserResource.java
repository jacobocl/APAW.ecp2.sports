package es.jacobocl.sport.api;

public class UserResource {

    public Object userList() {
        return "Lista de Usuarios";
    }

    public Object searchUsersInSport(String sportName) {
        return sportName;
    }

    public void createUser(String nick, String email) {
    }

    public String addSportToUser(String sportName) {
        return sportName;
    }

}
