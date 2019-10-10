package site.syso.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;

@Controller
@ServerEndpoint("/ws")
public class WebSocketServer {

    private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("socket open .");
        sessions.add(session);
        this.broadcast("[用户" + session.getId() + "]加入聊天室.");
        System.out.println("size:" + sessions.size());
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        this.broadcast("[用户" + session.getId() + "]退出聊天室.");
        System.out.println("size:" + sessions.size());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println(session.getId() + " say " + message);
        this.broadcast("[用户" + session.getId() + "]说：" + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        sessions.remove(session);
        error.printStackTrace();
    }

    private void broadcast(String message) {
        sessions.forEach(session -> sendMessage(session, message));
    }

    private void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
