package com.mei.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable{
	
	private Socket socket;
	
	public TimeServerHandler(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String currentTime = null;
			String body = null;
			while((body=in.readLine())!=null){
				System.out.println("The time server receive order : "+ body);
				currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
				out .println(currentTime);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
				socket.close();
				in = null;
				out = null;
				socket = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
