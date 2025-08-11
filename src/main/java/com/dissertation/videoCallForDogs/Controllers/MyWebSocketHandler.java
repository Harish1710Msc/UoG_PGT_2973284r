package com.dissertation.videoCallForDogs.Controllers;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler{
	
	private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
	
	@Override
	public void handleTextMessage(WebSocketSession Sendersession, TextMessage message) throws Exception{
		
		
		System.out.println(message.getPayload());
		for(WebSocketSession session: sessions) {
			if( session.isOpen() && !session.getId().equals(Sendersession.getId())) {
		
		session.sendMessage(new TextMessage( message.getPayload()));
			}
		}
		
		
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		sessions.add(session);
		System.out.println("Connection started: " +session.getId() + session.getLocalAddress());
	}

	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		sessions.remove(session);
	}
}
