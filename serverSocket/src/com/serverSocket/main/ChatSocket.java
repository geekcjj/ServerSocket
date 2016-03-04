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
	@Override
	public void run() {

        try {
        	while(true){
   			// ���������
			InputStream inputStream = socket.getInputStream();
	        //��������
	        OutputStream os=socket.getOutputStream();  
	        PrintWriter pw=new PrintWriter(os);  
	        
            //����ʱ������ʾwelcome
            String reply="welcome";  
            pw.write(reply);  
            pw.flush(); 
            
            //��ȡ�û���Ϣ
            byte buffer[] = new byte[1024 * 4];  
	        int temp = 0;  
	        // û���յ�һ�����ݽ�����ʾ�ڿ���̨�����ҷ���OK
	        while ((temp = inputStream.read(buffer)) != -1) {  
	            System.out.println(new String(buffer, 0, temp));
	            pw.write("OK!");  
	            pw.flush(); 
	        }   	   
            pw.close();  
            os.close();  
            inputStream.close();  
            socket.close();  
        	}
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
          	        

	}
	
}
