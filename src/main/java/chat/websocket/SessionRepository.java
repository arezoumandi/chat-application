package chat.websocket;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

@ApplicationScoped
public class SessionRepository {
    Map<String, Session> activeSessions;
    Map<Session, String> usernames;

    public SessionRepository() {
        activeSessions = new Hashtable<String, Session>();
        usernames = new Hashtable<Session, String>();
    }

    public void addNewSession(String username, Session session) {
        activeSessions.put(username, session);
        usernames.put(session, username);
    }

    public Collection<Session> getAllSessions() {
        Collection<Session> values = activeSessions.values();
        return values;
    }


    public String getUsername(Session session) {
        return usernames.get(session);
    }
}
