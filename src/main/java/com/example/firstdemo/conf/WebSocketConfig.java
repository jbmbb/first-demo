package com.example.firstdemo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 *  WebSocket配置
 * <p>
 * 自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
 * 要注意，如果使用独立的servlet容器，而不是直接使用springboot的内置容器，就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理。
 *
 * @author xxlai
 *
 */
@Configuration
public class WebSocketConfig {

	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}
}