package com.mei.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
	
	public static void main(String[] args){
		
		int port = 8080;
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			socket = new Socket("127.0.0.1",port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			out.println("QUERY TIME ORDER");
			System.out.println("Send order 2 server succeed");
			String resp = in.readLine();
			System.out.println("Now is : "+resp);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				in.close();
				out.close();
				socket.close();
				
				socket = null;
				in = null;
				out = null;
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
}
