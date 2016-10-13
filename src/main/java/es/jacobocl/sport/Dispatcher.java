package es.jacobocl.sport;

import es.jacobocl.sport.api.SportResource;
import es.jacobocl.sport.api.UserResource;
import es.jacobocl.sport.exceptions.InvalidRequestException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

    private UserResource userResource = new UserResource();

    private SportResource sportResource = new SportResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        // GET **/users
        if ("users".equals(request.getPath())) {
            response.setBody(userResource.userList().toString());
        // GET **/users/search?sport=*
        } else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])) {
            try {
                response.setBody(userResource.searchUsersInSport(request.getParams().get("sport")).toString());
            } catch (Exception e) {
                responseError(response, e);
            }
        } else {
            responseError(response, new InvalidRequestException(request.getPath()));
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        // POST **/users body="nick:email"
        case "users":
            String nick = request.getBody().split(":")[0];
            String email = request.getBody().split(":")[1];
            try {
                userResource.createUser(nick, email);
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                this.responseError(response, e);
            }
            break;
        // POST **/sports body="name"
        case "sports":
            try {
                sportResource.createSport(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                responseError(response, e);
            }
            break;
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        // PUT **/users/{nick}/sport body="sportName"
        if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
            try {
                userResource.addSportToUser(request.paths()[1], request.getBody());
            } catch (Exception e) {
                responseError(response, e);
            }
        } else {
            responseError(response, new InvalidRequestException(request.getPath()));
        }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

}
