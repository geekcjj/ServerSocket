package com.serverSocket.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

//�������ڶ�ÿ��socke������в���
public class ChatSocket extends Thread {
	Socket socket;
	
	public ChatSocket(Socket s){
		this.socket = s;
	}

	//���
	public void print(String out)
	{
        //��������
        OutputStream os;
		try {
			os = socket.getOutputStream();
	        PrintWriter pw=new PrintWriter(os);      
            pw.write(out);  
            pw.flush(); 
            
		} catch (IOException e) {
			ChatManager.getChatManager().remove(this);; 
			e.printStackTrace();
		}  

	}
	
	@Override
	public void run() {
        print("wellcome"+"\n");
        try {
        	
        	BufferedReader br = new BufferedReader(
        			new InputStreamReader(
        					socket.getInputStream(),"UTF-8"));
        	String line =null ; //���������������
        	while((line = br.readLine())!=null) //��ȡһ�У�Ҳ����˵����ʱ���ĩ��Ҫ�ӻ��з�
        	{
        		ChatManager.getChatManager().publish(this, line+"\n");//���������ͷ���
        		System.err.println(line);
        	}
        	br.close();
        	ChatManager.getChatManager().remove(this);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}  
          	        

	}
	
}
