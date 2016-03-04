package com.serverSocket.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;


public class ChatSocket extends Thread {
	Socket socket;
	
	public ChatSocket(Socket s){
		this.socket = s;
	}

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
        print("wellcome");
        try {
        	
        	BufferedReader br = new BufferedReader(
        			new InputStreamReader(
        					socket.getInputStream(),"UTF-8"));
        	String line =null ; //���������������
        	while((line = br.readLine())!=null) //��ȡһ�У�Ҳ����˵����ʱ���ĩ��Ҫ�ӻ��з�
        	{
        		ChatManager.getChatManager().publish(this, line);//���������ͷ���
        	}
        	br.close();
        	ChatManager.getChatManager().remove(this);
//        	while(true){
        	// ���������
//			InputStream inputStream = socket.getInputStream();
            //��ȡ�û���Ϣ
//            byte buffer[] = new byte[1024 * 4];  
//	        int temp = 0;  
	        // û���յ�һ�����ݽ�����ʾ�ڿ���̨�����ҷ���OK
//	        while ((temp = inputStream.read(buffer)) != -1) {  
//	            System.out.println(new String(buffer, 0, temp));
//	            pw.write("�㷢���ˣ�"+new String(buffer, 0, temp));  
//	            pw.flush(); 
	        	
//	        }   	   

//            inputStream.close();  
//            socket.close();  
//        	}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}  
          	        

	}
	
}
