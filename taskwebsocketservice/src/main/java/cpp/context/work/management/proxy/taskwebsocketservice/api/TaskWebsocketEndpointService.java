package cpp.context.work.management.proxy.taskwebsocketservice.api;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author bu
 */
@Singleton
@Startup
@Path("taskwebsocket")
@ServerEndpoint(value = "/update")
public class TaskWebsocketEndpointService {

    private static final Set<Session> sessions
            = Collections.synchronizedSet(new HashSet<>());

    /*
    * Deal with On Open Events
     */
    @OnOpen
    public void onOpen(final Session session) {
        sessions.add(session);
        Logger.getLogger(TaskWebsocketEndpointService.class.getName()).log(Level.INFO, null, "Opened Session: " + session);
    }

    /*
    * Deal with On Close Events
     */
    @OnClose
    public void onClose(Session session) {
        try {
            sessions.remove(session);
            Logger.getLogger(TaskWebsocketEndpointService.class.getName()).log(Level.INFO, null, "Closed Session: " + session);
        } catch (Exception e) {
        }
    }

    /*
    * Recieve On Message Events
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        Logger.getLogger(TaskWebsocketEndpointService.class.getName()).log(Level.INFO, null, "Got UI Message: " + message);
    }

    /*
    * Update browser
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("")
    public Response update(@Suspended final AsyncResponse response, String payload) {
        System.out.println("recieved payload at Websocket endpoint: " + payload);

        final String text = payload;
        sessions.stream().forEach((session) -> {
            try {
                if (session.isOpen()) {
                    Logger.getLogger(TaskWebsocketEndpointService.class.getName()).log(Level.INFO, null, payload);
                    session.getBasicRemote().sendText(text);
                    Logger.getLogger(TaskWebsocketEndpointService.class.getName()).log(Level.INFO, null, "Updated Clients: " + payload);
                    System.out.println("Updated Clients: " + payload);
                }
            } catch (IOException ex) {
                Logger.getLogger(TaskWebsocketEndpointService.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return Response.ok().build();
    }
}
