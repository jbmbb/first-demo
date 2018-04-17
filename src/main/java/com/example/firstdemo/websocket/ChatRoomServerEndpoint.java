package com.example.firstdemo.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

/**
 *  * ServerEndpoint
 * <p>
 * 使用springboot的唯一区别是要@Component声明下，而使用独立容器是由容器自己管理websocket的，但在springboot中连容器都是spring管理的。
 * <p>
 * 虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
 *
 * @author xxlai
 *
 */
@ServerEndpoint("/xxlai/chatRoom/{userName}") //WebSocket客户端建立连接的地址
@Component
public class ChatRoomServerEndpoint {

	/** 存活的session集合 */
	private static Map<String, Session> livingsessions = new ConcurrentHashMap<String, Session>();
	
	/**
	 * 建立连接的回调方法
	 * @param session
	 * @param userName
	 */
	@OnOpen
	public void onOpen(Session session,@PathParam("userName") String userName){
		livingsessions.put(session.getId(), session);
		sendMessageToAll(userName+" 加入聊天室！");
	}
	
	/**
	 * 收到客户端消息的回调方法
	 * @param message
	 * @param session
	 * @param userName
	 */
	@OnMessage
	public void onMessage(String message,Session session,@PathParam("userName") String userName){
		sendMessageToAll(userName+" : "+message);
	}
	
	/**
	 * 发生错误的回调方法
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session,Throwable error){
		System.out.println("发生错误");
		error.printStackTrace();
	}
	
	/**
	 * 关闭连接的回调方法
	 * @param session
	 * @param userName
	 */
	@OnClose
	public void onClose(Session session,String userName){
		livingsessions.remove(session.getId());
		sendMessageToAll(userName+" 退出聊天室");
	}
	
	/**
	 * 单独发送消息
	 * @param session
	 * @param message
	 */
	public void sendMessage(Session session,String message){
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 群发消息
	 * @param message
	 */
	public void sendMessageToAll(String message){
		livingsessions.forEach((sessionId,session)->{
			sendMessage(session, message);
		});
	}
}
