package com.oracle.chatroom.control;

import java.io.IOException;
import java.net.ServerSocket;

import com.oracle.chatroom.config.SocketConfig;

public class Server {
	private ServerSocket  s;
	
	public boolean startServer() {
		try {
			s=new ServerSocket(SocketConfig.port);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
