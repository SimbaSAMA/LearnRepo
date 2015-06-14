package com.mei.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {
	
	public static void main(String[] args){
		
		int port=8080;
		ServerSocket server = null;
		try{
			server = new ServerSocket(port);
			System.out.println("The time server is start int port : "+ port);
			Socket socket = null;
			while(true){
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				server.close();
				server = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
