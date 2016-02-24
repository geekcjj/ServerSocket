package com.serverSocket.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

//�������ڵȴ��ͷ�������
public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(23457); //�˿�
			while(true){
				//ÿ����һ���ͷ������Ӿ���һ��socket
				Socket socket =  serverSocket.accept();//����
				JOptionPane.showMessageDialog(null, "�пͷ������ӵ����ص�23457�˿�");	

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
	   
	            //5.�ر���Դ  
	            pw.close();  
	            os.close();  
//	            br.close();  
	            inputStream.close();  
	            socket.close();  
	            serverSocket.close();  
	               
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
