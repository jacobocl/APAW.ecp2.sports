package es.jacobocl.sport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserNickListWrapper {
    List<String> userNickList;

    public UserNickListWrapper() {
        userNickList = new ArrayList<>();
    }

    public List<String> getUserNickList() {
        return userNickList;
    }

    public void addNick(String nick) {
        userNickList.add(nick);
    }

    @Override
    public String toString() {
        String result = "{\"userList\":[ ";
        for (String nick : userNickList) {
            result += nick + ",";
        }
        return result.substring(0, result.length() - 1) + "]}";
    }
}
