package golan.websocket.server;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * <pre>
 * <B>Copyright:</B>   Izik Golan
 * <B>Owner:</B>       <a href="mailto:golan2@hotmail.com">Izik Golan</a>
 * <B>Creation:</B>    12/10/2015 22:44
 * <B>Since:</B>       BSM 9.21
 * <B>Description:</B>
 *
 * </pre>
 */
@ServerEndpoint("/echo")
public class EchoServer {

  @OnOpen
  public void onOpen(Session session){
    System.out.println(session.getId() + " has opened a connection");
    try {
      session.getBasicRemote().sendText("Connection Established");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  @OnMessage
  public void onMessage(String message, Session session){
    System.out.println("Message from " + session.getId() + ": " + message);
    try {
      session.getBasicRemote().sendText(message);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * The user closes the connection.
   *
   * Note: you can't send messages to the client from this method
   */
  @OnClose
  public void onClose(Session session){
    System.out.println("Session " +session.getId()+" has ended");
  }
}
