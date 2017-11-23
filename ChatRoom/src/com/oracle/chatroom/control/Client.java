package com.oracle.chatroom.control;

import java.net.Socket;

import com.oracle.chatroom.config.SocketConfig;

public class Client {
	private Socket  client;
	
	public boolean connectServer() {
		try {
			client=new Socket(SocketConfig.serverIP, SocketConfig.port);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

}
